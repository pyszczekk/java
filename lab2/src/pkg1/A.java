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
public class A {
    protected int number;
    String name;
    public A(int number, String name){
        this.number=number;
        this.name=name;
    }
    public void callDecrement(){
        decrement();
        System.out.println(this.number);
    }
    public void callChangeName(){
        changeName();
         System.out.println(this.name);
    }
    public void callIncrement(){
        increment();
        System.out.println(this.number);
    }
    private void increment(){
        this.number+=1;
    }
    protected void decrement(){
        this.number-=1;
    }
    void changeName(){
        this.name="package name klasaA";
    }
    
    
}
