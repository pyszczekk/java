/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Graphics;

/**
 *
 * @author pyszczekk
 */
public class Rectangle extends Shape {
    double a,b;
    public Rectangle(){
        name = "prostokat";
    }
    public Rectangle(String name){
        this.name = name;
    }
    public void setA(double a){
        this.a=a;
    }
    public void setB(double b){
        this.b=b;
    }
    public void setSize(double a, double b){
        this.a=a;
        this.b=b;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }

    @Override
    public void draw(Graphics g) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(this.a==0 && this.b==0) throw new UnsupportedOperationException("You didn't enter a size, I can't draw it");
       g.drawRect(x,y, (int)this.a, (int)this.b);
       
    }

    @Override
    public void setX(int x) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     this.x=x;
    }

    @Override
    public void setY(int y) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.y=y;
    }
   
    
}
