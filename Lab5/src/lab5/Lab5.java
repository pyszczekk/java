/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author pyszczekk
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String in ="gravity.txt";
        String out = "delayed.txt";
        int del = 6000;
        int fps=60;
        String path ="/Users/pyszczekk/Desktop/wszystko/zabawa w studia/semestr III/java-git/java/Lab5/src/lab5/";
        MicroDVD microDVD = new MicroDVD();
        try{
            //microDVD.delay(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            microDVD.delay(path+in, path+out, del, fps);
        }
        catch (NumberFormatException e){
            System.out.println("Wrong value in frames");
        }
        catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }
    
}
