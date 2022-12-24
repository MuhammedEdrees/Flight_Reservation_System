package flightproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con = null;
    public static Connection connectDB(){
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/flight project DB", "root", "root");
            return con;
        } catch (SQLException e){
        }
        return null;
    }
}
