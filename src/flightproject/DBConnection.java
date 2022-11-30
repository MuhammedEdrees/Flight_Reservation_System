/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightproject;

import java.sql.*;

/**
 *
 * @author moham
 */
public class DBConnection {
    public static Connection connectDB(){
        Connection con = null;
        try{
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/flight project DB", "root", "root");
        return con;
        } catch (SQLException e){
        }
        return null;
    }
    
}
