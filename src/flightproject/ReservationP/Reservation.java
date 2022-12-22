/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightproject.ReservationP;

import java.sql.Connection;
import flightproject.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moham
 */
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
}
