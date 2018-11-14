/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawer;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import shape.*;

/**
 *
 * @author pyszczekk
 */
public class MyPanel extends JPanel implements MouseListener, MouseMotionListener{
    int mouseX, mX;
    int mouseY, mY;
    public MyPanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
                
	}
     Shape [] shapes;
     public void setShapes(Shape [] sh){
         shapes=sh;
     }
    public void paintComponents(Graphics g){
       
        for (Shape shape : shapes) {
            shape.setX(shape.getX()-mouseX);
            shape.setY(shape.getY()-mouseY);
            shape.draw(g);
        }
        mouseX=0; mouseY=0;
       
    }
    public void paint(Graphics g){
        this.paintComponents(g);
        repaint();
    }

     @Override
    public void mouseClicked(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      System.out.println("mouseClicked");
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mX=e.getX();
        mY=e.getY();
       // repaint();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("mouseReleased");
        
       // System.out.println("x: "+mouseX+" y: "+mouseY);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      // System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // System.out.println("mouseExited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // System.out.println("mouseDragged");
     
       mouseX=mX-e.getX();
       mouseY=mY-e.getY();
       mX=e.getX();
       mY=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // System.out.println("mouseMoved");
         
    }
  
    
}
