/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author pyszczekk
 */
public class Square extends Shape{
    double a;
    public Square(){
        name="kwadrat";
    }
    public void setA(double a){
        this.a = a;
    }
    public double getA(){
        return a;
    }
    @Override
    public void draw(Graphics g) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(this.a==0)  throw new UnsupportedOperationException("You didn't enter a size, I can't draw it");
       g.setColor(Color.CYAN);
       g.fillRect(x,y, (int)this.a, (int)this.a);
     //  g.drawRect(x,y, (int)this.a, (int)this.a);
    }

    @Override
    public void setX(int x) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.x=x;
    }

    @Override
    public void setY(int y) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.y=y;
    }
    
}
