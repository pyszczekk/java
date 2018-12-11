/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *
 * @author pyszczekk
 */
public class EchoServer {
public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
       
        ExecutorService executorService = Executors.newFixedThreadPool(10);
      while (true){
           
     final Socket socket = serverSocket.accept(); 
       Runnable connection = new Runnable() {
      
                @Override
                public void run() {
                     try {
                       
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        bufferedWriter.flush();
                        String line = bufferedReader.readLine();
                        while (line!= null){
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
}
