/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pyszczekk
 */
public class EchoServer {
    public static  Socket [] clients = new Socket[10];
    public static Socket writeTo=null;
    ServerSocket serverSocket=null;
    public static int i=0;
  


public void run() throws IOException{
    if(serverSocket==null)
     serverSocket = new ServerSocket(6666);
    
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        
        while (true){
            final Socket socket = serverSocket.accept();
            //tutaj sprawdzanie autoryzacja
            Runnable connection = new Runnable() {
                
                @Override
                public void run() {
                    clients[i]=socket;
                   
                    System.out.println(socket+"  "+clients[i].getPort()+" "+i );
                     i++;
                    if(i>=2){
                        writeTo=clients[i-2];
                    }
                     
                     
                    try {
                       
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(writeTo.getOutputStream()));
                        bufferedWriter.write("Napisz: \"END\" by zakończyć połączenie.");
                        bufferedWriter.flush();
                        String line = bufferedReader.readLine();
                        while (!line.contains("END")){
                            bufferedWriter.write("Sever says: ");
                            bufferedWriter.write(line);
                            bufferedWriter.write("\n");
                            bufferedWriter.flush();
                            line = bufferedReader.readLine();
                        }
                        socket.close();
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                        
                    }

                }
            };
            executorService.submit(connection);
        }

}
public Socket[] getClients(){
    return clients;
}
}
