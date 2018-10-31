/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        // TODO code application logic here
         String slowo ="test";
        ROT11 al = new ROT11();
        String wyn = al.crypt(slowo);
        System.out.println(wyn + " ---- zakodowane : " +slowo);
        slowo = al.decrypt(wyn);
         System.out.println(wyn + " ---- odkodowane : " +slowo);
         
        String path = new java.io.File(".").getCanonicalPath();
        Cryptographer c = new Cryptographer();
        String in = path+"/src/lab4/test.txt";
        String out =path+"/src/lab4/test2.txt";
        c.cryptfile(in,out,al);
        String in2 = path+"/src/lab4/test3.txt";
        c.decryptfile(out,in2,al);
    }
    
}
