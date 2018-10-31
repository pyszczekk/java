/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author pyszczekk
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ROT11 al = new ROT11();  
        Polibiusz al2 = new Polibiusz();
        Cryptographer c = new Cryptographer();
        
        if(args.length==0){    // kod na wypadek braku podania parametrow przy wywolaniu, zeby pokazac ze i tak dziala xd 
            String path = new java.io.File(".").getCanonicalPath();
            String in = path+"/src/test.txt";
            String out =path+"/src/lab4/test2.txt";
            c.cryptfile(in,out,al);
            String in2 = path+"/src/lab4/test3.txt";
            c.decryptfile(out,in2,al);
            String out2 = path+"/src/lab4/test4.txt";
            String pol = path+"/src/lab4/test5.txt";
            c.cryptfile(in,out2, al2);
            c.decryptfile(out2,pol,al2);
        }else{ // kod przy podaniu sciezek pliku wejsciowego i wyjsciowego przy wywolaniu xd 
           String in = args[0];     //sciezka pliku wejsciowego
           String out = args[1];    //sciezka pliku wyjsciowego
           System.out.print("Wybierz: \n 1 - szyfrowanie \n 2 - deszyfrowanie \n");
           Scanner odczyt;
           odczyt = new Scanner(System.in);
           int x = odczyt.nextInt();
           File file = new File(in); 
           Scanner inFile = new Scanner(file);
           Algorithm alg;
           if(x==1){
               System.out.println("wybierz: \n 1 - ROT11 \n 2 - Polibiusz");
               int y = odczyt.nextInt();
               if(y==1)alg=al;
               else if(y==2) alg=al2;
               else {
                   System.out.println("nie rozumiem polecenia :) ");
                   throw new java.lang.Error("blad");
               }
               c.cryptfile(in,out,alg);
           }else if(x==2){
               if(inFile.hasNextInt()) alg=al2;
                else alg=al;
               c.decryptfile(in,out,alg);
           }else{
               System.out.println("nie rozumiem polecenia :) ");
           }
        }
         
    }
    
}
