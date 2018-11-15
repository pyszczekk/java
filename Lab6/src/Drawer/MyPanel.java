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
    boolean moving=false;
    boolean clicked=false;
    int cX, cY;
    Shape moved;
    public MyPanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
                
	}
     Shape [] shapes;
     public void setShapes(Shape [] sh){
         shapes=sh;
     }
    public void paintComponents(Graphics g){
        
        for (int i=0; i<shapes.length;i++) {
            if(clicked){
               moving=shapes[i].contain(cX,cY);
            }
            if(moving){
                if(moved==null){
                    moved=shapes[i];
                    shapes[i]=shapes[shapes.length-1];
                    shapes[shapes.length-1]=moved;
                }
            }
        }
         for (Shape shape : shapes) {
             shape.draw(g);
         }
         if(moving){
                
                moved.setX(moved.getX()-mouseX);
                moved.setY(moved.getY()-mouseY);
               
            }
        mouseX=0; mouseY=0;
       
    }
    public void paint(Graphics g){
        this.paintComponents(g);
        repaint();
    }

     @Override
    public void mouseClicked(MouseEvent e) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked=true;
        mX=e.getX();
        mY=e.getY();
        cX=e.getX();
        cY=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         moving = false;
         moved=null;
         clicked=false;
         cX=0;
         cY=0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public void mouseExited(MouseEvent e) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       mouseX=mX-e.getX();
       mouseY=mY-e.getY();
       mX=e.getX();
       mY=e.getY();
       cX=e.getX();
       cY=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }
  
    
}
