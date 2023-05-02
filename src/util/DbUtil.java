package util;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DbUtil {
    private static Connection myconObj = connectDB();
    private static Statement mystatObj = null;
    private static ResultSet myresObj = null;
    //creata a connection with the database
    public static Connection connectDB(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/flight project DB", "root", "root");
            return con;
        } catch (SQLException e){
        }
        return null;
    }
    //generate an id for the given table based on the number of entries in the table
    public static int generateID(String tableName){
        try{
            //Creating the Statement object
            mystatObj = myconObj.createStatement();
            //Query to get the number of rows in a table
            String idquery = "select max(id) from ROOT."+tableName;
            //Executing the query
            myresObj = mystatObj.executeQuery(idquery);
            //Retrieving the result
            myresObj.next();
            int max = myresObj.getInt(1);
            return max + 1;
            }catch(SQLException e){
                return -1;
            }
    }
}
