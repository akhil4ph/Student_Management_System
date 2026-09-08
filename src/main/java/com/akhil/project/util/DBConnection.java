package com.akhil.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public static Connection getConnection(){
        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/SMSDB";
        String user = "root";
        String password = "@Wzkeaknn";
        try{
            // Connection connection = DriverManager.getConnection(url, user, password);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successful!");
        }
        catch (SQLException e){
            System.out.println("Unable to connect to database: " + e);
        }
        return connection;
        
    }
}
