/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.QuadCurve2D;
import static java.lang.Math.sqrt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pyszczekk
 */
public class Plot extends JPanel {
    int data[][]=new int[1000][2];
    final int PAD = 10;
    int a5=0,a4=0,a3=0,a2=0,a1=0,a0=0;
    int xStart, xEnd;
    double xScale;
    double yScale;
   
    int w=600;
    int h=380;
    int x0 = w/2;
    int y0 = h/2;
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
       
        g2.setColor(Color.WHITE);
        //g2.fillRect(PAD, PAD, w-2*PAD, h-2*PAD);
        g2.fillRect(0, 0, w, h);
        g2.setColor(Color.BLACK);
        g2.drawLine(w/2, PAD-10, w/2, h);
        
        g2.drawLine(w/2, PAD-10, w/2-5, PAD);
        g2.drawLine(w/2, PAD-10, w/2+5, PAD);
        
        g2.drawLine(0, h/2, w, h/2);
        g2.drawLine(w-PAD+10, h/2, w-PAD, h/2-5);
        g2.drawLine(w-PAD+10, h/2, w-PAD, h/2+5);
        xScale = (w - 2*PAD)/300;
        double maxValue = 100.0;
        yScale = (h - 2*PAD)/300;
        // The origin location.
        int x0 = PAD;
        int y0 = h-PAD;
        g2.setPaint(Color.red);
        //System.out.println(xScale+" "+yScale);
        if(a5!=0 || a4!=0 || a3!=0 || a2!=0 || a1!=0 || a0!=0)paintPlot(g2);
        //g2.scale(2.0,2.0);
    }
    @Override
    public void paint(Graphics g){
        this.paintComponent(g);
        //System.out.println("maluje sie");
        repaint();
    }
    public void setA(int b5,int b4, int b3, int b2, int b1, int b0){
        a5=b5;
        a4=b4;
        a3=b3;
        a2=b2;
        a1=b1;
        a0=b0;
    }
    public void setLim(int x, int x1){
        if(x<x1){
            xStart=x;
            xEnd=x1;
        }else if(x>x1){
            xStart=x1;
            xEnd=x;
        }else{
            throw new UnsupportedOperationException("Wrong boundies");
        }
       
    }
    public void paintPlot(Graphics2D g2){
        xScale = (780)/Math.abs(xEnd-xStart);
        int max=(int)(function(xStart));
        for(int j = xStart; j < xEnd+1; j++) {
            
            int x = j;
            int y = (int)(function(j));
            
            data[j-xStart][0]=x;
            data[j-xStart][1]=y;
            
            if(y>max)max=y;
            
        }
        yScale=(h/2 - 20)/max;
        if(yScale==0)yScale=1;
        if(xScale==0)xScale=1;
       // System.out.println(xScale+ " " + yScale + " max: "+max);
         for(int j = 1; j < xEnd-xStart+1; j++) {
             int _x=x0 + (int)xScale*data[j-1][0];
             int _y=y0 -data[j-1][1]*(int)yScale;
             int x_=x0 + (int)xScale*data[j][0];
             int y_=y0 -data[j][1]*(int)yScale;
             g2.setColor(Color.RED);
             g2.drawLine(_x,_y, x_,y_);
             g2.setColor(Color.BLACK);
             g2.drawLine(_x,h/2+2,_x,h/2-2);
             g2.drawLine(x_,h/2+2,x_,h/2-2);
             g2.drawLine(w/2+2,_y,w/2-2,_y);
              g2.drawLine(w/2+2,y_,w/2-2,y_);
         }
    }
    public double function(int x){
        return(a5*Math.pow(x,5)+a4*Math.pow(x,4)+a3*Math.pow(x,3)+a2*Math.pow(x,2)+a1*x+a0);
    }
 
}