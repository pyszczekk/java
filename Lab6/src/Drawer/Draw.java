/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import shape.*;

/**
 *
 * @author pyszczekk
 */
public class Draw extends JFrame{
  
    public static void main(String [] argv){
        try{
        Draw dp = new Draw();
        MyPanel d = new MyPanel();
        Circle c = new Circle();
        c.setX(20);
        c.setY(70);
        c.setRad(40);
        Rectangle r = new Rectangle();
        r.setSize(206,113);
        r.setX(230);
        r.setY(300);
        Square s = new Square();
        s.setA(100);
        s.setY(300);
        s.setX(10);
        Triangle t = new Triangle();
        t.setA(100);
        t.setH(150);
        t.setX(300);
        t.setY(200);
        Shape [] sh = new Shape [] {c,r,s,t};
        d.setShapes(sh);
        dp.getContentPane().add(d);
        dp.setSize(500, 450);
        dp.setVisible(true);
        dp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
               System.exit(0);
            }
        });
       }
       catch(UnsupportedOperationException e ){
           System.out.println("you've got some errors ;p ");
       }    
    }
    
}
