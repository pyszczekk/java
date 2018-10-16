/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2cw;

/**
 *
 * @author pyszczekk
 */
public class Kwadrat {
    double a;
    public Kwadrat(double a){
        this.a=a;
    }
    public double getA(){
        return this.a;
    }
    public void setA(double a){
        this.a=a;
    }
    public double area(){
        return this.a*this.a;
    }
    public boolean isBigger(Kwadrat K2){
        return K2.area()>this.area();
    }
}
