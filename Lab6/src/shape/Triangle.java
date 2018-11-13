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
public class Triangle extends Shape {
    double a,h;
    public Triangle(){
        name="trojkat";
    }
    public Triangle(String name){
        this.name=name;
    }
    public void setA(double a){
        this.a =a;
    }
    public void setH(double h){
        this.h=h;
    }
    public double getA(){
        return a;
    }
    public double getH(){
        return h;
    }
    
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(int x) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.x=x;
    }

    @Override
    public void setY(int y) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      this.y=y;
    }


    
}
