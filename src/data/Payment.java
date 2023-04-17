package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import static utils.DbUtils.*;

public class Payment implements DataEntity {

    private int paymentId, reservationId;
    private String cardType, cardHolderName;
    private long cardNumber;
    private double paymentAmount;
    private short cardCVV;
    private Date expirationDate;
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;

    public Payment(int paymentId) {
        this.paymentId = paymentId;
        load();
    }

    public Payment(int paymentId, int reservationId, String cardType, String cardHolderName, long cardNumber, double paymentAmount, short cardCVV, Date expirationDate) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.cardType = cardType;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.paymentAmount = paymentAmount;
        this.cardCVV = cardCVV;
        this.expirationDate = expirationDate;
        store();
    }

    public int getPaymentId() {
        load();
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
        update();
    }

    public int getReservationId() {
        load();
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
        update();
    }

    public String getCardType() {
        load();
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
        update();
    }

    public String getCardHolderName() {
        load();
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        update();
    }

    public long getCardNumber() {
        load();
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
        update();
    }

    public double getPaymentAmount() {
        load();
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
        update();
    }

    public short getCardCVV() {
        load();
        return cardCVV;
    }

    public void setCardCVV(short cardCVV) {
        this.cardCVV = cardCVV;
        update();
    }

    public Date getExpirationDate() {
        load();
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        update();
    }

    //insert new entry to the Payments table
    public void createPayment() {
        String createQuery = "INSERT INTO ROOT.PAYMENTS VALUES (?,?,?,?,?,?,?,?)";
        myconObj = connectDB();
        
        try {
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, paymentId);
            mystatObj.setString(2, cardType);
            mystatObj.setLong(3, cardNumber);
            mystatObj.setString(4, cardHolderName);
            mystatObj.setDate(5, (java.sql.Date) expirationDate);
            mystatObj.setInt(6, reservationId);
            mystatObj.setDouble(7, paymentAmount);
            mystatObj.setShort(8, cardCVV);
            mystatObj.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void store() {
        this.paymentId = generateID("PAYMENTS");
        createPayment();
    }

    @Override
    public void update() {
        String updateQuery = "Update ROOT.PAYMENTS Set paymentId = ?, cardType = ?, cardNumber = ?, cardHolderName = ?, expirationDate = ?, reservationId = ?, paymentAmount = ?, cardCVV = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setInt(1, paymentId);
            mystatObj.setString(2, cardType);
            mystatObj.setLong(3, cardNumber);
            mystatObj.setString(4, cardHolderName);
            mystatObj.setDate(5, (java.sql.Date) expirationDate);
            mystatObj.setInt(6, reservationId);
            mystatObj.setDouble(7, paymentAmount);
            mystatObj.setShort(8, cardCVV);
            mystatObj.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void load() {
        String loadQuery = "select * from ROOT.PAYMNETS WHERE ID=?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, paymentId);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()) {
                this.cardType = myresObj.getString(2);
                this.cardNumber = myresObj.getLong(3);
                this.cardHolderName = myresObj.getString(4);
                this.expirationDate = myresObj.getDate(5);
                this.reservationId = myresObj.getInt(6);
                this.paymentAmount = myresObj.getDouble(7);
                this.cardCVV = myresObj.getShort(8);      
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void delete() {
        String deleteQuery = "Delete from ROOT.PAYMENTS where ID= " + String.valueOf(this.paymentId);
        myconObj = connectDB();
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e) {
        }
    }
}
