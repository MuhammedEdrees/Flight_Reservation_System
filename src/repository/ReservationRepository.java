package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Reservation;

public class ReservationRepository implements Repository<Reservation> {
    
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    
    public ReservationRepository() {
        myconObj = util.DbUtil.connectDB();
    }
    @Override
    public void create(Reservation reservation){
        java.sql.Date sqlDate = new java.sql.Date(reservation.getPassExpiry().getTime());
        try{
            mystatObj = myconObj.prepareStatement("Insert Into ROOT.RESERVATIONS values (?,?,?,?,?,?,?,?,?,?)");
            mystatObj.setInt(1, reservation.getId());
            mystatObj.setString(2, reservation.getFirstName());
            mystatObj.setString(3, reservation.getSurname());
            mystatObj.setString(4, reservation.getNationality());
            mystatObj.setString(5, reservation.getPassNum());
            mystatObj.setDate(6, sqlDate);
            mystatObj.setInt(7, reservation.getNumOfseats());
            mystatObj.setInt(8, reservation.getFlightID());
            mystatObj.setInt(9, reservation.getPassengerId());
            mystatObj.setString(10, reservation.getResClass());
            mystatObj.executeUpdate();
        } catch (SQLException e){
        }
    }
    @Override
    public void read(Reservation reservation){
        String loadQuery = "select * from ROOT.RESERVATIONS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, reservation.getId());
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                reservation.setFirstName( myresObj.getString(2));
                reservation.setSurname(myresObj.getString(3));
                reservation.setNationality( myresObj.getString(4));
                reservation.setPassNum(myresObj.getString(5));
                reservation.setPassExpiry(new Date(myresObj.getDate(6).getTime())) ;
                reservation.setNumOfseats(myresObj.getInt(7));
                reservation.setFlightID(myresObj.getInt(8));
                reservation.setPassengerId(myresObj.getInt(9)) ;
                reservation.setResClass(myresObj.getString(10));
            }
        }catch(SQLException e){
        }
    }

    @Override
    public void delete(Reservation reservation){
        String deleteQuery = "Delete from ROOT.RESERVATIONS where id = " + String.valueOf(reservation.getId());
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }
    @Override
    public void update(Reservation reservation) {
        java.sql.Date sqlDate = new java.sql.Date(reservation.getPassExpiry().getTime());
        String updateQuery = "Update ROOT.RESERVATION Set FirstName = ?, Surname = ?, Nationality = ?, PassNum = ?, PassExpiry = ?, NumOfseats = ?, FlightID = ?, PassengerId = ?, ResClass = ? where ID = ?";
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, reservation.getFirstName());
            mystatObj.setString(2, reservation.getSurname());
            mystatObj.setString(3, reservation.getNationality());
            mystatObj.setString(4, reservation.getPassNum());
            mystatObj.setDate(5, sqlDate);
            mystatObj.setInt(6, reservation.getNumOfseats());
            mystatObj.setInt(7, reservation.getFlightID());
            mystatObj.setInt(8,reservation.getPassengerId());
            mystatObj.setString(9,reservation.getResClass());  
            mystatObj.setInt(10,reservation.getId());
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }
@Override
    public ArrayList<Reservation> getAll() {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        String fetchQuery = "select * from ROOT.FLIGHTAGENTS";
        try {
            mystatObj= myconObj.prepareStatement(fetchQuery);
            myresObj = mystatObj.executeQuery();
            while (myresObj.next()){
                Reservation reservation = new Reservation();
                reservation.setId(myresObj.getInt(1));
                reservation.setFirstName( myresObj.getString(2));
                reservation.setSurname(myresObj.getString(3));
                reservation.setNationality( myresObj.getString(4));
                reservation.setPassNum(myresObj.getString(5));
                reservation.setPassExpiry(new Date(myresObj.getDate(6).getTime())) ;
                reservation.setNumOfseats(myresObj.getInt(7));
                reservation.setFlightID(myresObj.getInt(8));
                reservation.setPassengerId(myresObj.getInt(9)) ;
                reservation.setResClass(myresObj.getString(10));
            }
        } catch(SQLException e) {
        } 
        return reservationList;
    }

}
