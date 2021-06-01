/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Syed Areeb
 */
import java.sql.*;

public class mysql_connection extends Thread {

    private mysql_connection() {
    }

    final static String url = "jdbc:mysql://localhost:3306/sms";
    final static String username = "root";
    final static String password = "Alihamza";
    static Connection con = null;
   
      
     
  

    public static Connection getConnection() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        return con;
    }

}
