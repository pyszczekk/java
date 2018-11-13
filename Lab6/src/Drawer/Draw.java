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
        c.setRad(150);
        Rectangle r = new Rectangle();
        r.setSize(206,113);
        r.setX(200);
        r.setY(200);
        Square s = new Square();
        s.setA(100);
        Shape [] sh = new Shape [] {c,r,s};
        d.setShapes(sh);
        dp.getContentPane().add(d);
        dp.setSize(500, 450);
        dp.setVisible(true);
        //dp.add(new MouseEvents());
       // dp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//dp.setVisible(true);
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
