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
public class ROT11 implements Algorithm {

    @Override
    public String crypt(String toCrypt) {
        String crypted="";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    for(int i=0; i<toCrypt.length();i++){
       char ch = toCrypt.charAt(i);
          if (ch >= 'A' && ch <= 'Z') {
        if (ch + 11 <= 'Z') {
            ch+=11;
        } else {
            ch-=15;
        }

    } else if (ch >= 'a' && ch <= 'z') {
        if (ch + 11 <= 'z') {
           ch+=11;
        } else {
           ch-=15;
        }
    }
          crypted+=ch;
    }
    return crypted;
    }

    @Override
    public String decrypt(String toDecrypt) {
        String decrypted="";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    for(int i=0; i<toDecrypt.length();i++){
          char ch = toDecrypt.charAt(i);
          if (ch >= 'A' && ch <= 'Z') {
        if (ch + 15 <= 'Z') {
            ch+=15;
        } else {
            ch-=11;
        }

    } else if (ch >= 'a' && ch <= 'z') {
        if (ch + 15 <= 'z') {
           ch+=15;
        } else {
           ch-=11;
        }
    }

          decrypted+=ch;
    }
    return decrypted;
    }
    
}
