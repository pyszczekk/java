/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

/**
 *
 * @author pyszczekk
 */
public class NewBook {
    String ibsn,title,author,year;
    public NewBook(String i, String t, String a, String y){
        ibsn=i;
        title=t;
        author=a;
        year=y;
    }
   
    public String getIBSN(){
        return ibsn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getYear(){
        return year;
    }
    
}
