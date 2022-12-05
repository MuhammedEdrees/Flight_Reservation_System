package flightproject;

import java.sql.*;

public class flightProject {

    //currentUserID is a static variable that represents the current user who is logged in to the system
    public static Integer currentUserID;
    public static void main(String[] args) throws SQLException {
        new LoginpGUI().setVisible(true);
    }
   public static int generateID(String tableName){
        try{
            Connection myconObj = DBConnection.connectDB();
            Statement mystatObj = null;
            ResultSet myresObj = null;
            //Creating the Statement object
            mystatObj = myconObj.createStatement();
            //Query to get the number of rows in a table
            String idquery = "select count(*) from ROOT."+tableName;
            //Executing the query
            myresObj = mystatObj.executeQuery(idquery);
            //Retrieving the result
            myresObj.next();
            int count = myresObj.getInt(1);
            return count+1;
            }catch(SQLException e){
                return -1;
            }
    }
}
