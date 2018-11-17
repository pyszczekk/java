/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author pyszczekk
 */
public class DrawPlot extends JFrame {
    
    public static void main(String [] argv){
        DrawPlot d = new DrawPlot();
        JPanel main = new JPanel();
       
        JLabel l1 = new JLabel("<html>W(x) =a<sub>5</sub>x<sup>5</sup>+a<sub>4</sub>x<sup>4</sup>+a<sub>3</sub>x<sup>3</sup>+a<sub>2</sub>x<sup>2</sup>+a<sub>1</sub>x+a<sub>0</sub></html>", JLabel.CENTER);
        Font labelFont = l1.getFont();
        l1.setFont(new Font(labelFont.getName(), Font.PLAIN, 18));
        l1.setLocation(300,50);
        JLabel a5=new JLabel("<html>a<sub>5</sub>=</html>",JLabel.LEFT);
        JLabel a4=new JLabel("<html>a<sub>4</sub>=</html>",JLabel.LEFT);
        JLabel a3=new JLabel("<html>a<sub>3</sub>=</html>",JLabel.LEFT);
        JLabel a2=new JLabel("<html>a<sub>2</sub>=</html>",JLabel.LEFT);
        JLabel a1=new JLabel("<html>a<sub>1</sub>=</html>",JLabel.LEFT);
        JLabel a0=new JLabel("<html>a<sub>0</sub>=</html>",JLabel.LEFT);
        JLabel labelList []={a5,a4,a3,a2,a1,a0};
        JPanel aPanel=new JPanel();
        JPanel aData = new JPanel();
        
        JTextField ad5=new JTextField();
        JTextField ad4=new JTextField();
        JTextField ad3=new JTextField();
        JTextField ad2=new JTextField();
        JTextField ad1=new JTextField();
        JTextField ad0=new JTextField();
        JTextField aFields[] = {ad5,ad4,ad3,ad2,ad1,ad0};
        for(int i =0; i<labelList.length;i++){
           
            aPanel.add(labelList[i]);
            labelList[i].setPreferredSize(new Dimension(25,25));
            aFields[i].setPreferredSize( new Dimension( 50, 24 ) );
            aData.add(aFields[i]);
            
        }
       
        main.setBounds(0, 0, 800, 100);
        aPanel.setBounds(0,0,50,800);
        aPanel.setLocation(20,80);
        aData.setBounds(0,0,48,800);
        aData.setLocation(70,80);
        main.add(l1);
        d.add(aData);
        d.add(aPanel);
        d.add(main);
        d.setLayout(null);
        d.setSize(800, 800);
        d.setVisible(true);
        d.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
               System.exit(0);
            }
        });
    }
    
}
