/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.sql.*;

/**
 *
 * @author pyszczekk
 */
public class DataBase {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null; 
    private boolean connection=false;
    public void connection(){
    try { Class.forName("com.mysql.jdbc.Driver").newInstance();  conn =
        DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl:3306/kpieszcz", "kpieszcz","1ZWDT7t7V2YpxDeU");
      stmt = conn.createStatement();

connection=true;

    } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage()); System.out.println("SQLState: " + ex.getSQLState()); System.out.println("VendorError: " + ex.getErrorCode());
    }catch(Exception e){
        e.printStackTrace();  
        System.out.println("blad");
        connection=false;
    }

    }
    public boolean isConnected(){
       return connection;
    }
    public Connection getConnection(){
        return conn;
    }
}
 /*

 
*/