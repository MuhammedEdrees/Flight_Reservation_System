package data;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import static util.DbUtil.*;


public class Flight implements DataEntity {
    private int id, seatCapacity, availableSeats;
    private double basePrice;
    private Date flightDate;
    private String departureAirport, arrivalAirport, departureTime, flightDuration, airline;
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    public Flight(int id) {
        this.id = id;
        load();
    }
    public Flight(String departureAirport, String arrivalAirport, Date flightDate, String departureTime, String flightDuration, double basePrice, String airline, int seatCapacity, int availableSeats) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
        this.basePrice = basePrice;
        this.airline = airline;
        this.seatCapacity = seatCapacity;
        this.availableSeats = availableSeats;
        store();
    }
    
    
    public int getId() {
        load();
        return id;
    }

    public void setId(int id) {
        this.id = id;
        update();
    }

    public int getSeatCapacity() {
        load();
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
        update();
    }

    public int getAvailableSeats() {
        load();
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
        update();
    }

    public double getBasePrice() {
        load();
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
        update();
    }

    public Date getFlightDate() {
        load();
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
        update();
    }

    public String getDepartureAirport() {
        load();
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
        update();
    }

    public String getArrivalAirport() {
        load();
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        update();
    }

    public String getDepartureTime() {
        load();
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        update();
    }

    public String getFlightDuration() {
        load();
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
        update();
    }

    public String getAirline() {
        load();
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
        update();
    }
    
    public void setAll(String departureAirport, String arrivalAirport, Date flightDate, String departureTime, String flightDuration, double basePrice, String airline, int seatCapacity, int availableSeats) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
        this.basePrice = basePrice;
        this.airline = airline;
        this.seatCapacity = seatCapacity;
        this.availableSeats = availableSeats;
        update();
    }
    
    public static String[] getAirports() {
        return new String[]{"Dubai", "Abu Dhabi", "Veinna", "Sydney", "Melbourne", "Antwerp", "Brussels", "Sao Paulo",
            "Rio de Janeiro", "Manama", "Shanghai", "Beijing", "Copnheagne", "Alexandria", "Cairo",
            "Sharm El Sheikh", "Luxor", "Aswan", "Hurgada", "Berlin", "Munich", "Cologne", "Frankfurt",
            "Mumbai", "Delhi", "Rome", "Milan", "Tokyo", "Beirut", "Casablanca", "Marrakesh", "Amsterdam",
            "Oslo", "Doha", "Makkah", "Madinah", "Riyadh", "Jeddah", "Cape Town", "Madrid", "Barcelona",
            "Stockholm", "Basel", "Zurich", "Geneva", "Tunis", "Istanbul", "London", "Manchester", "Liverpool",
            "New York", "Los Angeles", "Chicago"};
    }
    private void createFlight() {
        String createQuery = "INSERT INTO ROOT.FLIGHTS VALUES (?,?,?,?,?,?,?,?,?,?)";
        myconObj = connectDB();
        java.sql.Date sqlDate = new java.sql.Date(flightDate.getTime());
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, id);
            mystatObj.setString(2, departureAirport);
            mystatObj.setString(3, arrivalAirport);
            mystatObj.setDate(4,  sqlDate);
            mystatObj.setString(5, departureTime);
            mystatObj.setString(6, flightDuration);
            mystatObj.setDouble(7, basePrice);
            mystatObj.setString(8, airline);
            mystatObj.setInt(9, seatCapacity);
            mystatObj.setInt(10, availableSeats);
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }
    @Override
    public void store(){
        this.id = generateID("FLIGHTS");
        createFlight();
    }
    @Override
    public void update(){
        String updateQuery = "Update ROOT.FLIGHTS Set DepartureAirport = ?, ArrivalAirport = ?, FlightDate = ?, DepartureTime = ?, FlightDuration = ?, BasePrice = ?, Airline = ?, SeatCapacity = ?, AvailableSeats = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, departureAirport);
            mystatObj.setString(2, arrivalAirport);
            mystatObj.setDate(3, new java.sql.Date(flightDate.getTime()));
            mystatObj.setString(4, departureTime);
            mystatObj.setString(5, flightDuration);
            mystatObj.setDouble(6, basePrice);
            mystatObj.setString(7 ,airline);
            mystatObj.setInt(8, seatCapacity);
            mystatObj.setInt(9, availableSeats);
            mystatObj.setInt(10, id);
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }
    @Override
    public void load(){
        String loadQuery = "select * from ROOT.FLIGHTS WHERE ID=?";
        myconObj = connectDB();
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                this.departureAirport = myresObj.getString(2);
                this.arrivalAirport = myresObj.getString(3);
                this.flightDate = new Date(myresObj.getDate(4).getTime());
                this.departureTime = myresObj.getString(5);
                this.flightDuration = myresObj.getString(6);
                this.basePrice = myresObj.getDouble(7);
                this.airline = myresObj.getString(8);
                this.seatCapacity = myresObj.getInt(9);
                this.availableSeats = myresObj.getInt(10);
            }
        }catch(SQLException e){
        }
    }
    @Override
    public void delete(){
        String deleteQuery = "Delete from ROOT.FLIGHTS where id = " + String.valueOf(this.id);
        myconObj = connectDB();
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }

}
