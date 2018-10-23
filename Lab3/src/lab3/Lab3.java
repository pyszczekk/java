/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.*;
import lab3.EmailMessage.EmailBuilder;

/**
 *
 * @author pyszczekk
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String>to=new LinkedList<String>();
        to.add("karolina.pieszczekk@gmail.com");
        to.add("karolina.pieszczekk@gmail.com");
        to.add("karolina.pieszczekk@gmail.com");
       // to.add("karolina.pieszczekk");        // zakomentowane zeby nie wywalilo bledu, ale sprawdza czy mail ma mailowa konstrukcje
        to.add("karolina.pieszczekk@gmail.com");
        //to.add("karolina.pieszczekk");
        EmailBuilder text = new EmailBuilder("karo2@amorki.pl",to);
        text.setSubject("URGENT");
        text.setContent("Witaj serdecznie<br><br><h1>pozdrawiam cieplutko ^^ </h1>");
        EmailMessage a = text.build();
        a.send();
       
    }
    
}
