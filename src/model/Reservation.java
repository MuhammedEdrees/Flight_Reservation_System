package model;

import java.util.Date;

public class Reservation {

    private int id, flightID,passengerId,numOfseats;
    private Date passExpiry;
    private String firstName, surname, nationality, passNum,resClass;
    
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

}
