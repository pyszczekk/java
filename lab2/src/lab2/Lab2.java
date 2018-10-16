/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import pkg1.*;
import pkg2.*;

/**
 *
 * @author pyszczekk
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        A objA = new A(24, "Karolina");
        B objB = new B(12, "Ala");
        C objC= new C(6, "Olek");
        objA.callDecrement();
        objA.callIncrement();
        objA.callChangeName();
        objB.callDecrement();
        objB.callIncrement();
        objB.callChangeName();
        objC.callDecrement();
        objC.callIncrement();
        objC.callChangeName();
        
    }
    
}
