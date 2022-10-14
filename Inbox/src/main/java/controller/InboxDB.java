/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class contains one method.
 * It will connect to the database
 * @author Solly Vinson
 */
public class InboxDB {
    //private Connection connection;
    
            static Connection con;
            static String url="jdbc:sqlserver://LIBERTIES90\\SQLEXPRESS;"
                +"Database=Messages;"
                + "encrypt=true;trustServerCertificate=true;"
                +"IntegratedSecurity=true";
   
        
        public static Connection getConnection() throws Exception
        {
        try{
            con= DriverManager.getConnection(url);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con ;
        }
        
        
        
    
}
