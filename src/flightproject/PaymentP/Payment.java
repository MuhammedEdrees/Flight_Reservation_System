package flightproject.PaymentP;

import flightproject.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Payment {
    private static Connection myconObj = DBConnection.connectDB();
    private static PreparedStatement mystatObj = null;
    private static ResultSet myresObj = null;
    
    public static double getPaymentAmount (int id){
        String query = "select * from ROOT.PAYMENTS WHERE RESERVATIONID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getDouble("PAYMENTAMOUNT");
            }
            return 0;
        }catch(SQLException e){
            return 0;
        }
    }
    
    public static void deletePayment(int id){
        String query = "DELETE FROM ROOT.PAYMENTS  WHERE RESERVATIONID ="+id;
        try{
           mystatObj= myconObj.prepareStatement(query);
           mystatObj.executeUpdate();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public static void createNewPayment(int paymentId,String cardType, String cardno, String name, String cvv, java.util.Date date, int resId, double amount){
        String query = "INSERT INTO ROOT.PAYMENTS VALUES (?,?,?,?,?,?,?,?)";
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        try{
            mystatObj = myconObj.prepareStatement(query);
            mystatObj.setInt(1, paymentId);
            mystatObj.setString(2, cardType);
            mystatObj.setString(3, cardno);
            mystatObj.setString(4, name);
            mystatObj.setString(8, cvv);
            mystatObj.setDate(5, sqldate);
            mystatObj.setInt(6, resId);
            mystatObj.setDouble(7, amount);
            mystatObj.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
