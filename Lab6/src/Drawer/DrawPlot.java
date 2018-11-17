/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        try{
        DrawPlot d = new DrawPlot();
        Plot plotPanel = new Plot();
        JPanel main = new JPanel();
        //panel z labelami do textfieldow
        JLabel l1 = new JLabel("<html>W(x) =a<sub>5</sub>x<sup>5</sup>+a<sub>4</sub>x<sup>4</sup>+a<sub>3</sub>x<sup>3</sup>+a<sub>2</sub>x<sup>2</sup>+a<sub>1</sub>x+a<sub>0</sub></html>", JLabel.CENTER);
        Font labelFont = l1.getFont();
        l1.setFont(new Font(labelFont.getName(), Font.PLAIN, 18));
        l1.setLocation(300,50);
        JLabel al5=new JLabel("<html>a<sub>5</sub>=</html>",JLabel.LEFT);
        JLabel al4=new JLabel("<html>a<sub>4</sub>=</html>",JLabel.LEFT);
        JLabel al3=new JLabel("<html>a<sub>3</sub>=</html>",JLabel.LEFT);
        JLabel al2=new JLabel("<html>a<sub>2</sub>=</html>",JLabel.LEFT);
        JLabel al1=new JLabel("<html>a<sub>1</sub>=</html>",JLabel.LEFT);
        JLabel al0=new JLabel("<html>a<sub>0</sub>=</html>",JLabel.LEFT);
        JLabel labelList []={al5,al4,al3,al2,al1,al0};
        JPanel aPanel=new JPanel();
        JPanel aData = new JPanel();
        //panel na przedzial X
        JPanel limPanel = new JPanel();
        JLabel limlabel = new JLabel("enter the boundaries of x-axis",JLabel.LEFT);
        limlabel.setLocation(0,0);
        limPanel.add(limlabel);
        JTextField lim1=new JTextField();
        lim1.setPreferredSize(new Dimension(40,30));
        JTextField lim2=new JTextField();
        lim2.setPreferredSize(new Dimension(40,30));
        lim1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                //System.out.println(caracter);
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '-')) {
                    e.consume();
                }
            }
        });
        lim2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '-')) {
                    e.consume();
                }
            }
        });
        limPanel.add(lim1);
        limPanel.add(lim2);
        //panel z wspolczynnikami a
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
            aFields[i].addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '-')) {
                    e.consume();
                }
            }
        });
      
            aData.add(aFields[i]);
            
        }
        //button + rysowanie;
        JPanel save = new JPanel();
        JButton btn = new JButton("draw");
        btn.setPreferredSize(new Dimension(200,30));
        btn.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            int a[]=new int[6];
             for(int i =0; i<aFields.length;i++){
                
                 String text = aFields[i].getText();
                 a[i]=this.getNumber(text, a[i]);
             }
            int x1 = 0;
            int x2 = 0;
            x1 = this.getNumber(lim1.getText(), x1);
            x2 = this.getNumber(lim2.getText(), x1);
            plotPanel.setA(a[0],a[1],a[2],a[3],a[4],a[5]);
            plotPanel.setLim(x1,x2);
            
          };

            private int getNumber(String text, int x) {
                boolean minus=false;
                    if(text.charAt(0)=='-'){
                                text=text.replace("-", "");
                                minus=true;
                            }
                             x=Integer.parseInt(text);
                             if(minus){
                                 x*=-1;
                             }
                    return x;  
            }
             
        });
        save.add(btn);
        save.setBounds(0,0,200,30);
        save.setLocation(20,320);
        main.setBounds(0, 0, 800, 100);
        aPanel.setBounds(0,0,50,800);
        aPanel.setLocation(20,80);
        aData.setBounds(0,0,48,800);
        aData.setLocation(70,80);
        main.add(l1);
        limPanel.setBounds(0,0,320,50);
        limPanel.setLocation(20,260);
        d.add(limPanel);
        plotPanel.setBounds(0,0,800,400);
        plotPanel.setLocation(0,400);
        d.add(plotPanel);
        d.add(aData);
        d.add(aPanel);
        d.add(main);
        d.add(save);
        d.setLayout(null);
        d.setSize(600, 800);
        d.setVisible(true);
        d.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
               System.exit(0);
            }
        });
        }
        catch(UnsupportedOperationException e ){
           System.out.println("you've got some errors ;p ");
       }    
    }

    
}
