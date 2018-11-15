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
public abstract class Shape {
    public String name;
    int x, y;
    public abstract void setX(int x);
    public abstract void setY(int y);
    public int getX(){return x;};
    public int getY(){return y;};
    public abstract void draw(Graphics g);
    public abstract boolean contain(int x, int y);
}
