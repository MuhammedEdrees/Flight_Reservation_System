/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightproject.PaymentP;

import flightproject.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moham
 */
public class Payment {
    private static Connection myconObj = DBConnection.connectDB();
    private static PreparedStatement mystatObj = null;
    private static ResultSet myresObj = null;
    public static void deletePayment(int id){
        String query = "DELETE FROM ROOT.PAYMENTS  WHERE RESERVATIONID ="+id;
        try{
           mystatObj= myconObj.prepareStatement(query);
           mystatObj.executeUpdate();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
}
