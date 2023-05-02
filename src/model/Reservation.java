package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import static util.DbUtil.*;

public class Reservation {

    private int id, flightID,passengerId,numOfseats;
    private Date passExpiry;
    private String firstName, surname, nationality, passNum,resClass;
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    
    public Reservation(int id) {
        this.id = id;
    }
    public Reservation(){
    }
    public Reservation(int passengerId,int flightID,String firstName, String surname, String nationality, String passNum, Date passExpiry, int numOfseats, String resClass) {
        this.flightID=flightID;
        this.passengerId=passengerId;
        this.firstName = firstName;
        this.surname = surname;
        this.nationality = nationality;
        this.passNum = passNum;
        this.passExpiry = passExpiry;
        this.numOfseats = numOfseats;
        this.resClass = resClass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setNumOfseats(int numOfseats) {
        this.numOfseats = numOfseats;
    }

    public void setPassExpiry(Date passExpiry) {
        this.passExpiry = passExpiry;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPassNum(String passNum) {
        this.passNum = passNum;
    }

    public void setResClass(String resClass) {
        this.resClass = resClass;
    }
    
    public int getId() {
        return id;
    }
    
    public int getFlightID() {
        return flightID;
    }

    public int getPassengerId() {
        return passengerId;
    }

    

    public String getFirstName() {
        return firstName;
    }

    

    public String getSurname() {
        return surname;
    }

  

    public String getNationality() {
        return nationality;
    }

  
    public String getPassNum() {
        return passNum;
    }


    public Date getPassExpiry() {
        return passExpiry;
    }

   
    public int getNumOfseats() {
        return numOfseats;
    }

    
    public String getResClass() {
        return resClass;
    }

  
//    public void createNewReservation(){
//        java.sql.Date sqlDate = new java.sql.Date(passExpiry.getTime());
//         myconObj = connectDB();
//        try{
//            mystatObj =myconObj.prepareStatement("Insert Into ROOT.RESERVATIONS values (?,?,?,?,?,?,?,?,?,?)");
//            mystatObj.setInt(1, id);
//            mystatObj.setString(2, firstName);
//            mystatObj.setString(3, surname);
//            mystatObj.setString(4, nationality);
//            mystatObj.setString(5, passNum);
//            mystatObj.setDate(6, sqlDate);
//            mystatObj.setInt(7, numOfseats);
//            mystatObj.setInt(8, flightID);
//            mystatObj.setInt(9, passengerId);
//            mystatObj.setString(10, resClass);
//            mystatObj.executeUpdate();
//        } catch (SQLException e){
//        }
//    }
//    @Override
//    public void create(){
//        this.id = generateID("RESERVATIONS");
//        createNewReservation();
//    }
//    @Override
//    public void read(){
//        String loadQuery = "select * from ROOT.RESERVATIONS WHERE ID=?";
//        myconObj = connectDB();
//        try{
//            mystatObj= myconObj.prepareStatement(loadQuery);
//            mystatObj.setInt(1, id);
//            myresObj = mystatObj.executeQuery();
//            if (myresObj.next()){
//                this.firstName = myresObj.getString(2);
//                this.surname = myresObj.getString(3);
//                this.nationality = myresObj.getString(4);
//                this.passNum = myresObj.getString(5);
//                this.passExpiry = new Date(myresObj.getDate(6).getTime());
//                this.numOfseats = myresObj.getInt(7);
//                this.flightID = myresObj.getInt(8);
//                this.passengerId = myresObj.getInt(9);
//                this.resClass = myresObj.getString(10);
//            }
//        }catch(SQLException e){
//        }
//    }
//    @Override
//    public void delete(){
//        String deleteQuery = "Delete from ROOT.RESERVATIONS where id = " + String.valueOf(this.id);
//        myconObj = connectDB();
//        try {
//            Statement deleteStat = myconObj.createStatement();
//            deleteStat.executeUpdate(deleteQuery);
//        } catch (SQLException e){}
//    }
//
//    @Override
//    public void update() {
//    }
}
