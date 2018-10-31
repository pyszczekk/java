/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author pyszczekk
 */
public class Cryptographer {
    public static void cryptfile(String fileIn, String fileOut, Algorithm al ) throws FileNotFoundException{
       File file = new File(fileIn); 
       Scanner in = new Scanner(file);
        try (PrintWriter out = new PrintWriter(fileOut)) {
           while(in.hasNextLine()){
            String lineS = in.nextLine();
            Scanner line = new Scanner(lineS);
            while (line.hasNext()){
                String word = line.next();
                out.print(al.crypt(word)+" ");
            }
            out.println();
           }
            out.close();
        
        }
    }
public static void decryptfile(String fileIn, String fileOut, Algorithm al ) throws FileNotFoundException{
       File file = new File(fileIn); 
       Scanner in = new Scanner(file);
        try (PrintWriter out = new PrintWriter(fileOut)) {
         while(in.hasNextLine()){
            String lineS = in.nextLine();
            Scanner line = new Scanner(lineS);
            while (line.hasNext()){
                String word = line.next();
                out.print(al.decrypt(word)+" ");
          
            }
            out.println();
           }
            out.close();
        }
    }
}
