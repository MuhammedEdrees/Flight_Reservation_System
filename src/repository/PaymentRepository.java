package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Payment;
import static util.DbUtil.connectDB;

public class PaymentRepository implements Repository<Payment> {

    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;

    public PaymentRepository() {
        myconObj = util.DbUtil.connectDB();
    }

    @Override
    public void create(Payment payment) {
        String createQuery = "INSERT INTO ROOT.PAYMENTS VALUES (?,?,?,?,?,?,?,?)";
        payment.setPaymentId(util.DbUtil.generateID("payments"));

        try {
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, payment.getPaymentId());
            mystatObj.setString(2, payment.getCardType());
            mystatObj.setString(3, payment.getCardNumber());
            mystatObj.setString(4, payment.getCardHolderName());
            mystatObj.setDate(5, new java.sql.Date(payment.getExpirationDate().getTime()));
            mystatObj.setInt(6, payment.getReservationId());
            mystatObj.setDouble(7, payment.getPaymentAmount());
            mystatObj.setString(8, payment.getCardCVV());
            mystatObj.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void read(Payment payment) {
        String loadQuery = "select * from ROOT.PAYMNETS WHERE ID=?";
        try {
            mystatObj = myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, payment.getPaymentId());
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()) {
                payment.setCardType(myresObj.getString(2));
                payment.setCardNumber(myresObj.getString(3));
                payment.setCardHolderName(myresObj.getString(4));
                payment.setExpirationDate(new Date(myresObj.getDate(5).getTime()));
                payment.setReservationId(myresObj.getInt(6));
                payment.setPaymentAmount(myresObj.getDouble(7));
                payment.setCardCVV(myresObj.getString(8));
            }
        } catch (SQLException e) {
        }
    }

    public void update(Payment payment) {
        String updateQuery = "Update ROOT.PAYMENTS Set CARDTYPE = ?, CARDNUMBER = ?, CARDHOLDERNAME = ?, EXPIRATIONDATE = ?, RESERVATIONID = ?, PAYMENTAMOUNT = ?, CVV = ? where ID= ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, payment.getCardType());
            mystatObj.setString(2, payment.getCardNumber());
            mystatObj.setString(3, payment.getCardHolderName());
            mystatObj.setDate(4, new java.sql.Date(payment.getExpirationDate().getTime()));
            mystatObj.setInt(5, payment.getReservationId());
            mystatObj.setDouble(6, payment.getPaymentAmount());
            mystatObj.setString(7, payment.getCardCVV());
            mystatObj.setInt(8, payment.getPaymentId());
            mystatObj.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void delete(Payment payment) {
        String deleteQuery = "Delete from ROOT.PAYMENTS where ID = " + String.valueOf(payment.getPaymentId());
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e) {
        }
    }

    @Override
    public ArrayList<Payment> getAll() {
        ArrayList<Payment> paymentList = new ArrayList<>();
        String fetchQuery = "select * from ROOT.PAYMNETS";
        try {
            mystatObj = myconObj.prepareStatement(fetchQuery);
            myresObj = mystatObj.executeQuery();
            while (myresObj.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(myresObj.getInt(1));
                payment.setCardType(myresObj.getString(2));
                payment.setCardNumber(myresObj.getString(3));
                payment.setCardHolderName(myresObj.getString(4));
                payment.setExpirationDate(new Date(myresObj.getDate(5).getTime()));
                payment.setReservationId(myresObj.getInt(6));
                payment.setPaymentAmount(myresObj.getDouble(7));
                payment.setCardCVV(myresObj.getString(8));
                paymentList.add(payment);
            }
        } catch (SQLException e) {
        }
        return paymentList;
    }
    
    public Payment findByReservationId(int id) {
        String query = "select * from ROOT.PAYMENTS WHERE RESERVATIONID=?";
        try {
            Payment payment = new Payment();
            mystatObj = myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()) {
                payment.setPaymentId(myresObj.getInt(1));
                payment.setCardType(myresObj.getString(2));
                payment.setCardNumber(myresObj.getString(3));
                payment.setCardHolderName(myresObj.getString(4));
                payment.setExpirationDate(new Date(myresObj.getDate(5).getTime()));
                payment.setReservationId(myresObj.getInt(6));
                payment.setPaymentAmount(myresObj.getDouble(7));
                payment.setCardCVV(myresObj.getString(8));
                return payment;
            }
        } catch (SQLException e) {
        }
        return null;
    }

}
