/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peselzadanie;

/**
 *
 * @author pyszczekk
 */
public class Pesel {
   
    public static boolean check(String PESEL){
        if(PESEL.length()==11) {
            //data urodzonka 
            Integer year = 10*(PESEL.charAt(0)-48)+(PESEL.charAt(1)-48);
            Integer month = 10*(PESEL.charAt(2)-48)+(PESEL.charAt(3)-48);
            if(month > 80 && month < 93){
                year+=1800;
                month-=80;
            }
            else if (month > 0 && month < 13){
                year+=1900;
            }
            else if (month > 20 && month < 33){
                year+=2000;
                month-=20;
            }
            else if (month > 40 && month < 53){
                year+=2100;
                month-=40;
            }else if (month > 60 && month < 73){
                year+=2200;
                month-=60;
            }else{
                return false;
            }
            Integer day = 10*(PESEL.charAt(4)-48) + (PESEL.charAt(5)-48);
            if(day > 31 ){
                return false;
            }
            if ( month == 4 || month == 6 || month == 9 || month == 11 ){
                if (day >30){
                    return false;
                }
            }else if (month == 2){
               if( year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ){//rok przestepny
                   if( day > 29){
                       return false;
                   }
               }else if (day > 28) return false;
            }
            //liczba kontrolna
            Integer control = PESEL.charAt(10)-48;
            Integer sum = 1* (PESEL.charAt(0)-48)+3*(PESEL.charAt(1)-48)+7*(PESEL.charAt(2)-48)+9*(PESEL.charAt(3)-48)+1*(PESEL.charAt(4)-48)+3*(PESEL.charAt(5)-48)+7*(PESEL.charAt(6)-48)+9*(PESEL.charAt(7)-48)+1*(PESEL.charAt(8)-48)+3*(PESEL.charAt(9)-48);
            Integer c = (10 -(sum%10))%10;
           
            if(c==control) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
