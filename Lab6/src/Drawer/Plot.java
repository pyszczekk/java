/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pyszczekk
 */
public class Plot extends JPanel {
    int data[][]=new int[300][2];
    final int PAD = 10;
  
    @Override
    @SuppressWarnings("empty-statement")
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g2.setColor(Color.WHITE);
        //g2.fillRect(PAD, PAD, w-2*PAD, h-2*PAD);
        g2.fillRect(0, 0, w, h);
        g2.setColor(Color.BLACK);
        g2.drawLine(PAD, PAD-10, PAD, h);
        
        g2.drawLine(PAD, PAD-10, PAD-5, PAD);
        g2.drawLine(PAD, PAD-10, PAD+5, PAD);
        
        g2.drawLine(0, h-PAD, w, h-PAD);
        g2.drawLine(w-PAD+10, h-PAD, w-PAD, h-PAD-5);
        g2.drawLine(w-PAD+10, h-PAD, w-PAD, h-PAD+5);
        double xScale = (w - 2*PAD)/300;
        double maxValue = 500.0;
        double yScale = (h - 2*PAD)/300;
        // The origin location.
        int x0 = PAD;
        int y0 = h-PAD;
        g2.setPaint(Color.red);
        System.out.println(xScale+" "+yScale);
        for(int j = 0; j < data.length; j++) {
            int XX = (int)xScale*j;
            int x = x0 + XX;
            int y = y0 - (int)yScale  *((XX*XX*XX)/3000 -(XX*XX)/2000 - 4*XX);
            System.out.println("x: "+x+" y: "+y);
            
            data[j][0]=x;
            data[j][1]=y;
            
        }
         for(int j = 1; j < data.length; j++) {
             g2.drawLine(data[j-1][0],data[j-1][1], data[j][0],data[j][1]);
         }
        //g2.scale(2.0,2.0);
    }
  
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new Plot());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}