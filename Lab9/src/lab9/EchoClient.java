/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pyszczekk
 */
public class EchoClient{
    String nick;
    String password;
  
   
    public void connect() throws IOException{
          
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
        echoSocket = new Socket("localhost", 6666);
        out = new PrintWriter(echoSocket.getOutputStream(), true); in = new BufferedReader(new InputStreamReader( echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
        System.err.println("Don't know about host: localhost."); System.exit(1);
        } catch (IOException e) { System.err.println("Couldn't get I/O for " + "the connection to: localhost."); System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
        String userInput;
        System.out.println("Type a message: ");

        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
        System.out.println("echo: " + in.readLine()); }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();    
    
    }

    

    
 
}
