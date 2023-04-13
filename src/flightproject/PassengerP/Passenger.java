package flightproject.PassengerP;
import flightproject.DBConnection;
import java.sql.*;
import java.time.LocalDate;

public class Passenger {
    private static Connection myconObj = DBConnection.connectDB();
    private static PreparedStatement mystatObj = null;
    private static ResultSet myresObj = null;
    public static int getID(String username){
        String query = "select * from ROOT.PASSENGERS WHERE USERNAME=?";
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
    public static int generateID(){
        try{
            Statement statObj = null;
            //Creating the Statement object
            statObj = myconObj.createStatement();
            //Query to get the number of rows in a table
            String passengerIdQuery = "select count(*) from ROOT.PASSENGERS";
            //Executing the query
            myresObj = statObj.executeQuery(passengerIdQuery);
            //Retrieving the result
            myresObj.next();
            int count = myresObj.getInt(1);
            return 2000+count+1;
            }catch(SQLException e){
                return -1;
            }
    }
    
    public static String getFullName(int id){
        String query = "select * from ROOT.PASSENGERS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString(2);
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    public static void setFullName(int id, String fullName){
        String query = "update root.passengers set fullname = ? where id = ?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, fullName);
            mystatObj.setInt(2, id);
            mystatObj.executeUpdate();
        }catch(SQLException e){
        }
    }
    public static String getUsername(int id){
        String query = "select * from ROOT.PASSENGERS WHERE ID=?";
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
    public static void setUsername(int id, String username){
        String query = "update root.passengers set username = ? where id = ?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, username);
            mystatObj.setInt(2, id);
            mystatObj.executeUpdate();
        }catch(SQLException e){
        }
    }
    public static String getPassword(int id){
        String query = "select * from ROOT.PASSENGERS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString(4);
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    public static void setPassword(int id, String password){
        String query = "update root.passengers set password = ? where id = ?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, password);
            mystatObj.setInt(2, id);
            mystatObj.executeUpdate();
        }catch(SQLException e){
        }
    }
    public static java.sql.Date getDateOfBirth(int id){
        String query = "select * from ROOT.PASSENGERS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getDate(6);
            }
            return java.sql.Date.valueOf(LocalDate.MAX);
        }catch(SQLException e){
            return java.sql.Date.valueOf(LocalDate.MAX);
        }
    }
    public static void setDateOfBirth(int id, java.sql.Date dateOfBirth){
        String query = "update root.passengers set dateofbirth = ? where id = ?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setDate(1, dateOfBirth);
            mystatObj.setInt(2, id);
            mystatObj.executeUpdate();
        }catch(SQLException e){
        }
    }
    public static String getPhoneNumber(int id){
        String query = "select * from ROOT.PASSENGERS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString(7);
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    public static void setPhoneNumber(int id, String phoneNumber){
        String query = "update root.passengers set phonenumber = ? where id = ?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, phoneNumber);
            mystatObj.setInt(2, id);
            mystatObj.executeUpdate();
        }catch(SQLException e){
        }
    }
    public static String getEmail(int id){
        String query = "select * from ROOT.PASSENGERS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString(8);
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    public static void setEmail(int id, String email){
        String query = "update root.passengers set email = ? where id = ?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, email);
            mystatObj.setInt(2, id);
            mystatObj.executeUpdate();
        }catch(SQLException e){
        }
    }
    public static void createNewUser(int id, String fullname, String username, String password, java.sql.Date dateofbirth, String phonenumber, String email){
        String query = "INSERT INTO ROOT.PASSENGERS VALUES (?,?,?,?,?,?,?)";
        try{
            mystatObj = myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            mystatObj.setString(2, fullname);
            mystatObj.setString(3, username);
            mystatObj.setString(4, password);
            mystatObj.setDate(5, dateofbirth);
            mystatObj.setString(6, phonenumber);
            mystatObj.setString(7, email);
            mystatObj.executeUpdate();
        }catch(SQLException e){}
        
    }
}
