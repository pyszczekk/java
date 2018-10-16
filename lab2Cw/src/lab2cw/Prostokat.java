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
public class Prostokat extends Kwadrat{
    double b;
    public Prostokat(double a, double b) {
        super(a);
        this.b=b;
    }
    public void setB(double b){
        this.b=b;
    }
    public double getB(){
        return this.b;
    }
    public double area(){
        return this.a*this.b;
    }
    public boolean isBigger(Prostokat P2){
        return P2.area()>this.area();
    }
}
