package flightproject.AdminP;

import flightproject.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
