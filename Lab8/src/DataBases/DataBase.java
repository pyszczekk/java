/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

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
 /*rs = stmt.executeQuery("SELECT * FROM books;");
System.out.println("jest supi: -----> "+rs);
while(rs.next()){
String name = rs.getString(1); System.out.println("Książka: "+name);
         }
if (rs != null) {
           try {
             rs.close();
           } catch (SQLException sqlEx) { } // ignore
rs = null;
}
 if (stmt != null) {
           try {
              stmt.close();
} catch (SQLException sqlEx) { } // ignore
           stmt = null;
}*/
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