/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightproject.AdminP;

import flightproject.DBConnection;
import java.sql.*;

/**
 *
 * @author moham
 */
public class Admin {
    private static Connection myconObj = DBConnection.connectDB();
    private static PreparedStatement mystatObj = null;
    private static ResultSet myresObj = null;
    public static int getID(String username){
    String query = "select * from ROOT.ADMINS WHERE USERNAME=?";
    try{
        mystatObj= myconObj.prepareStatement(query);
        mystatObj.setString(1, username);
        myresObj = mystatObj.executeQuery();
        if (myresObj.next()){
            return myresObj.getInt(1);
        }
        return -1;
    }catch(SQLException e){
        return -1;
    }
    }
    public static String getPassword(int id){
        String query = "select * from ROOT.ADMINS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString(3);
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    
}
