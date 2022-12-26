package flightproject.ReservationP;

import java.sql.Connection;
import flightproject.DBConnection;
import flightproject.flightProject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Reservation{ 
    private static Connection myconObj = DBConnection.connectDB();
    private static PreparedStatement mystatObj = null;
    private static ResultSet myresObj = null;
    public static void deleteReservation(int id){
        String query = "DELETE FROM ROOT.RESERVATIONS  WHERE ID ="+id;
        try{
           mystatObj= myconObj.prepareStatement(query);
           mystatObj.executeUpdate();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public static void createNewReservation(int id, String firstName, String surname, String nationality, String passNum, Date passExpiry, int numOfseats, int flightId, int passengerId, String resClass){
        java.sql.Date sqlDate = new java.sql.Date(passExpiry.getTime());
        try{
        mystatObj =myconObj.prepareStatement("Insert Into ROOT.RESERVATIONS values (?,?,?,?,?,?,?,?,?,?)");
        mystatObj.setInt(1, id);
        mystatObj.setString(2, firstName);
        mystatObj.setString(3, surname);
        mystatObj.setString(4, nationality);
        mystatObj.setString(5, passNum);
        mystatObj.setDate(6, sqlDate);
        mystatObj.setInt(7, numOfseats);
        mystatObj.setInt(8, flightId);
        mystatObj.setInt(9, passengerId);
        mystatObj.setString(10, resClass);
        mystatObj.executeUpdate();
        } catch (SQLException e){
        }
    }
}
