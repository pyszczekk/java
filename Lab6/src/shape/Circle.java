/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author pyszczekk
 */
public class Circle extends Shape{
    double r; // promień
    public Circle(){
        name = "kółko";
    }
    public Circle(String name){
        this.name = name;
    }

    
    public void setRad(double r){
        this.r=r;
    }
    public double getRad(){
        return r;
    }
   

    @Override
    public void draw(Graphics g) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(this.r==0) throw new UnsupportedOperationException("You didn't enter a radius, I can't draw it");
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, 2*(int)this.r, 2*(int)this.r);
        
        //g.drawOval(x, y, (int)this.r, (int)this.r);

    }

    @Override
    public void setX(int x) {
        this.x=x;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(int y) {
        this.y=y;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contain(int x, int y) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return ((x-(int)(this.x+this.r))*(x-(int)(this.x+this.r))+((y-(int)(this.y+this.r)))*((y-(int)(this.y+this.r)))<=this.r*this.r);
    }
    
}
