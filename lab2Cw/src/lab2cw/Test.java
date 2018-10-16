/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2cw;

import java.util.*;

/**
 *
 * @author pyszczekk
 */
public class Test {
     public static void main(String[] args) {
         boolean work = true;
         LinkedList<Prostokat>figury;
         figury = new LinkedList<>();
         Scanner odczyt;
         odczyt = new Scanner(System.in);
         int menu; 
         while(work){
         System.out.print("\n Wczytaj prostokat - 1 \n Wyswietl wszystkie prostokaty - 2 \n oblicz sume pol wszystkich prostokatow - 3 \n zakoncz - 4\n");
         menu=odczyt.nextInt();
         switch(menu){
             case 1:
                 double a,b;
                 a=odczyt.nextDouble();
                 b=odczyt.nextDouble();
                 Prostokat P = new Prostokat(a,b);
                 figury.add(P);
                 break;
             case 2:
                  for(int i =0 ; i<figury.size();++i){
                      System.out.println("prostokat: "+ figury.get(i).getA()+" x "+figury.get(i).getB());
                  }
                 break;
             case 3:
                 double area =0;
                  for(int i =0 ; i<figury.size();++i){
                      area+=figury.get(i).area();
                  }
                  System.out.println("Suma pol :" + area);
                  break;
             case 4:
                 work=false;
                 break;
             default:
                 System.out.println("nie rozpoznano komendy");
                 break;
         }
         }
     
    }

}
