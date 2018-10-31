/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author pyszczekk
 */
public class Polibiusz implements Algorithm{
   // char upp[][]=new char[][] {{'A','B','C','D','E'},{'F','G','H','I','K'}, {'L','M','N','O','P'},{'Q','R','S','T','U'},{'V','W','X','Y','Z'}};
    char low[][]=new char[][] {{'a','b','c','d','e'},{'f','g','h','i','k'}, {'l','m','n','o','p'},{'q','r','s','t','u'},{'v','w','x','y','z'}};
   
    @Override
    public String crypt(String toCrypt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String crypted="";
        toCrypt=toCrypt.toLowerCase();
        for(int i=0; i<toCrypt.length();i++){
            String x="";
             char ch = toCrypt.charAt(i);
             if(ch=='j'){
                 x="24 ";
             }else{
                for(int j =0;j<5;j++){
                    for(int k =0; k<5;k++){
                        if(ch==low[j][k]){
                            x=""+(j+1)+""+(k+1)+" ";
                        }
                    }
                }
             } 
             crypted+=x;
        }
        return crypted;
    }

    @Override
    public String decrypt(String toDecrypt) {
        String decrypted;
        int x =toDecrypt.charAt(0)-49;
        int y =toDecrypt.charAt(1)-49;
        decrypted=Character.toString(low[x][y]);
        return decrypted;
    }
    
}
