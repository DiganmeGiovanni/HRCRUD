/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hrcrud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author giovanni
 */
public class DBConnection {
    
    public static Connection getConnection() {
        try {
            String IPDBServer = CONS.DB_SERVER_ADDRESS;
            String CONN_STRING = "jdbc:oracle:thin:@" + IPDBServer + ":1521:ORCL";
            
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            return DriverManager.getConnection(CONN_STRING, "HR", "HR");
        } 
        catch (SQLException | ClassNotFoundException | InstantiationException |
                IllegalAccessException ex) {
            System.err.println("ERROR: Failed to stablish connection to DB");
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
