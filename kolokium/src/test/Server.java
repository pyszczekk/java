/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
/**
 *
 * @author pyszczekk
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Server {
	static Game game;
	public static void main(String[] args) {
		boolean isDone=false;
		int m=3;
		try{
			m=Integer.parseInt(args[0]);
		}catch(Exception e){

		}
		game = new Game(10,m);
		try{
			ServerSocket serverSocket= new ServerSocket(6666);
			System.out.println("Serwer start: "+serverSocket.getLocalSocketAddress());
			Socket incoming;
			while(!isDone){
				incoming = serverSocket.accept();
				System.out.println("Nowy klient!"+incoming.toString());
                                
                               
				new Thread(new ServerThread(incoming,game)).start();
			}	
			serverSocket.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void createNewGame(){
		game = new Game(10,3);
	}
}

class ServerThread implements Runnable, Observer{
	
	private Socket clientSocket;
	private ClientRequester clientRequester;
	private ClientListener clientListener;
	private BlockingQueue<Request> queueRequest;
	private static ArrayList<ServerThread> clientsList= new ArrayList<ServerThread>();
	private Game game;
	private String symbol;
	ServerThread(Socket clientSocket, Game game){
		this.game=game;
		this.clientSocket=clientSocket;
		clientsList.add(this);
		queueRequest=new ArrayBlockingQueue<Request>(100);
        }
	@Override
	public void run() {
		clientRequester = new ClientRequester();
		new Thread(clientRequester).start();
		clientListener = new ClientListener();	
		clientListener.addObserver(this);
		new Thread(clientListener).start();
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		Request request = (Request) arg1;
		if(request.getRequestType()==Request.TYPE_NAME){
			System.out.println("Gracz przesyla nam swoje imie: "+request.getName());
			onNameReceived(request.getName());
                         DataBase db = new DataBase();
                        try {
                            db.connection();
                            Statement stmt=db.getConnection().createStatement();
                            stmt.executeUpdate("INSERT INTO tictac (name, point) VALUES ('"+request.getName()+"', '0');");
                            db.getConnection().close();
                        } catch (SQLException ex) {
                           System.out.println(ex);
                        }
		}
		else if(request.getRequestType()==Request.TYPE_GAME_TAB_TO_SERVER){
			System.out.println("Gracz przesyla plansze z : "+request.getSymbol());
			onChoiceReceived(request.getChoice(),request.getSymbol());
		}
		else if(request.getRequestType()==Request.TYPE_EXIT){
			System.out.println("Gracz chce opuscic gre");
			onPlayerExit();
		}
		
	}
	
	//dostajemy imie i nadajemy symbol
	public void onNameReceived(String name){
		symbol=game.addPlayerAndGetSymbol(name);
		sendSymbolAndGameState(symbol);
	}
	
	/**
	 * 
	 * @param symbol
	 */
	public void sendSymbolAndGameState(String symbol){
		String[][] gameTab=game.getGameTab();
		boolean isYourTurn = isYourTurn();
		ArrayList<Player> playersList = game.getPlayersList();
		int currentPlayerIndex = game.getCurrentPlayerIndex();
		
		Request request = new Request(Request.TYPE_SYMBOL,symbol,gameTab,playersList,currentPlayerIndex,isYourTurn);
		sendRequest(request);
	}
	
	public void sendGameState(){
		String[][] gameTab=game.getGameTab(); 
		boolean isYourTurn = isYourTurn(); 
		ArrayList<Player> playersList = game.getPlayersList(); 
		int currentPlayerIndex = game.getCurrentPlayerIndex(); //nr gracza ktorego jest kolej
		Request request = new Request(Request.TYPE_GAME_TAB_TO_CLINET,gameTab,playersList,currentPlayerIndex,isYourTurn);
		sendRequest(request);
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isYourTurn(){ // czyja kolej
		boolean b;
		try{
			b= symbol.equals(game.getPlayersList().get(game.getCurrentPlayerIndex()).getSymbol());
		}
		catch(Exception e){
			return true;
		}
		return b;
	}

	
	public void onChoiceReceived(int[] choice, String symbol){
		game.updateGameTab(choice, symbol); 
		int points = game.checkPoints(choice, symbol); 
		if(points>0){ //jesli zdobyl pkt
			game.removeAllSymols(symbol); //usun wszystkie symbole z planszy
			Player p = game.addPointsToPlayer(symbol, points); //dodaj graczowi punkty
                         DataBase db = new DataBase();
                        try {
                            db.connection();
                            Statement stmt=db.getConnection().createStatement();
                            stmt.executeUpdate("UPDATE tictac SET point ="+p.getPoints()+" WHERE name = '"+p.getName()+"'");
                            db.getConnection().close();
                        } catch (SQLException ex) {
                           System.out.println(ex);
                        }
                }
		ServerThread.sendGameStateToAllClients(); //wyslij info do innych graczy
	}
	
	/**
	 * 
	 * @param winnerSymbol
	 */
	public void sendDrawInfo(){
		sendRequest(new Request(Request.TYPE_DRAW_INFO));
	}
	
	/**
	 * 
	 * @param winnerSymbol
	 */
	public static void sendDrawInfoToAllPlayers(){
		Iterator<ServerThread> it = clientsList.iterator();
		while(it.hasNext()){
			it.next().sendDrawInfo();
		}
	}
	
	/**
	 * Wywoluje metode sendGameState dla wszystkich podlaczonych klientow do wszystkich podlaczonych klientow
	 */
	public static void sendGameStateToAllClients(){
		Iterator<ServerThread> it = clientsList.iterator();
		while(it.hasNext()){
			it.next().sendGameState();
		}

	}
	
	public synchronized void onPlayerExit(){
		System.out.println("onPlayerExit");
		
		if(symbol.equals(game.getPlayersList().get(game.getCurrentPlayerIndex()).getSymbol())){ //sprawdza czy gracz ktory odchodzi ma teraz ruch
			System.out.println("OSZEDL TEN CO MA TERAZ!");
			
		}
		
		game.removePlayer(symbol);
		game.toLowerCase(symbol);

		try{
			clientRequester.close();
			clientListener.close();
			clientSocket.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		clientsList.remove(this); //usuwanie z listy klientow
		
		sendGameStateToAllClients();

	}
	
	private void sendRequest(Request request){
		try{
			queueRequest.put(request);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private class ClientRequester implements Runnable{
		private ObjectOutputStream output;
		private boolean isDone=false;
		private Request request;
		
		ClientRequester(){
			try {
				System.out.println("Stworzony clientRequester");
				output = new ObjectOutputStream(clientSocket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			while(!isDone){
				try{
					request=queueRequest.take();
					output.writeObject(request);
					System.out.println("Wysylam request do klienta");
				}
				catch(Exception e){
					e.printStackTrace();
					isDone=true;
				}
			}	
		}
		
		public void close(){
			try{
				isDone=true;
				output.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

//nasluchiwanie
	private class ClientListener extends Observable implements Runnable {
		private ObjectInputStream input;
		private boolean isDone=false;
		private Request request;
		
		ClientListener(){
			try {
				System.out.println("Stworzony clientListener");
				input = new ObjectInputStream(clientSocket.getInputStream());
			} catch (IOException e) {
				onPlayerExit();
			}
		}
		
		
		@Override
		public void run() {
			Object inputObject;
			while(!isDone){
				try{
					inputObject=input.readObject();
					request=(Request) inputObject;
					System.out.println("Nowy request od klienta.");
					this.setChanged();
					this.notifyObservers(request);
				}
				catch(Exception e){
					isDone=true;
//					e.printStackTrace();
					onPlayerExit();
				}

			}
			
		}
		
		public void close(){
			try{
				isDone=true;
				input.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}


