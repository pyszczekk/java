/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pyszczekk
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
         String slowo ="test";
        ROT11 al = new ROT11();
        String wyn = al.crypt(slowo);
        System.out.println(wyn + " ---- zakodowane : " +slowo);
        slowo = al.decrypt(wyn);
         System.out.println(wyn + " ---- odkodowane : " +slowo);
         
         
        File file = new File("/Users/pyszczekk/NetBeansProjects/JavaApplication1/src/javaapplication1/test.txt"); // cala sciezka ??  inne nie chce dzialac xd
        Cryptographer c = new Cryptographer();
        String in = "/Users/pyszczekk/Desktop/wszystko/zabawa w studia/semestr III/java-git/java/Lab4/src/lab4/test.txt";
        String out = "/Users/pyszczekk/Desktop/wszystko/zabawa w studia/semestr III/java-git/java/Lab4/src/lab4/test2.txt";
        c.cryptfile(in,out,al);
        String in2 = "/Users/pyszczekk/Desktop/wszystko/zabawa w studia/semestr III/java-git/java/Lab4/src/lab4/test3.txt";
        c.decryptfile(out,in2,al);
    }
    
}
