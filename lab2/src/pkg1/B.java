/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author pyszczekk
 */
public class B extends A {
    public B(int number, String name){
        super(number, name);
    }
    protected void decrement(){
        this.number -= 5;
    }
    void changeName(){
        this.name="package name klasa B";
    }
    private void increment(){
        this.number+=5;
    }
    
}
