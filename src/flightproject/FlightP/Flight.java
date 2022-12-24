package flightproject.FlightP;

import flightproject.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Flight {

    private static Connection myconObj = DBConnection.connectDB();
    private static PreparedStatement mystatObj = null;
    private static ResultSet myresObj = null;
    public static String[] airports;

    public Flight() {
        this.airports = new String[]{"Dubai", "Abu Dhabi", "Veinna", "Sydney", "Melbourne", "Antwerp", "Brussels", "Sao Paulo",
            "Rio de Janeiro", "Manama", "Shanghai", "Beijing", "Copnheagne", "Alexandria", "Cairo",
            "Sharm El Sheikh", "Luxor", "Aswan", "Hurgada", "Berlin", "Munich", "Cologne", "Frankfurt",
            "Mumbai", "Delhi", "Rome", "Milan", "Tokyo", "Beirut", "Casablanca", "Marrakesh", "Amsterdam",
            "Oslo", "Doha", "Makkah", "Madinah", "Riyadh", "Jeddah", "Cape Town", "Madrid", "Barcelona",
            "Stockholm", "Basel", "Zurich", "Geneva", "Tunis", "Istanbul", "London", "Manchester", "Liverpool",
            "New York", "Los Angeles", "Chicago"};
    }

    public static String[] getAirports() {
            airports = new String[]{"Dubai", "Abu Dhabi", "Veinna", "Sydney", "Melbourne", "Antwerp", "Brussels", "Sao Paulo",
            "Rio de Janeiro", "Manama", "Shanghai", "Beijing", "Copenhagen", "Alexandria", "Cairo",
            "Sharm El Sheikh", "Luxor", "Aswan", "Hurgada", "Berlin", "Munich", "Cologne", "Frankfurt",
            "Mumbai", "Delhi", "Rome", "Milan", "Tokyo", "Beirut", "Casablanca", "Marrakesh", "Amsterdam",
            "Oslo", "Doha", "Makkah", "Madinah", "Riyadh", "Jeddah", "Cape Town", "Madrid", "Barcelona",
            "Stockholm", "Basel", "Zurich", "Geneva", "Tunis", "Istanbul", "London", "Manchester", "Liverpool",
            "New York", "Los Angeles", "Chicago"};
        return airports;
    }
    public static void createNewFlight(String departureAirport, String arrivalAirport, String departureTime, String flightDuration, java.util.Date flightDate, double basePrice, String airline, int SeatCapacity){
        java.sql.Date sqlDate = new java.sql.Date(flightDate.getTime());
        try{
                PreparedStatement add =myconObj.prepareStatement("Insert Into ROOT.FLIGHTS values (?,?,?,?,?,?,?,?,?,?)");
                add.setInt(1, flightproject.flightProject.generateID("FLIGHTS"));
                add.setString(2, departureAirport);
                add.setString(3, arrivalAirport);
                add.setDate(4, sqlDate);
                add.setString(5, departureTime);
                add.setString(6, flightDuration);
                add.setDouble(7, basePrice);
                add.setString(8, airline);
                add.setInt(9,SeatCapacity);
                add.setInt(10,SeatCapacity);
                int row=add.executeUpdate();
            } catch(SQLException e){
            }
    }
    public static void updateFlight(int id, String departureAirport, String arrivalAirport, String departureTime, String flightDuration, java.util.Date flightDate, double basePrice, String airline, int SeatCapacity){
        java.sql.Date sqlDate = new java.sql.Date(flightDate.getTime());
        try{
                String sql="Update ROOT.FLIGHTS Set DepartureAirport = ?, ArrivalAirport = ?, FlightDate = ? , DepartureTime = ? , FlightDuration = ? , BasePrice = ? , Airline = ? , SeatCapacity = ? where ID = ?";
                mystatObj= myconObj.prepareStatement(sql);
                mystatObj.setString(1, departureAirport);
                mystatObj.setString(2, arrivalAirport);
                mystatObj.setDate(3, sqlDate);
                mystatObj.setString(4, departureTime);
                mystatObj.setString(5, flightDuration);
                mystatObj.setDouble(6, basePrice);
                mystatObj.setString(7, airline);
                mystatObj.setInt(8, SeatCapacity);
                mystatObj.setInt(9, id);
                mystatObj.executeUpdate();
            } catch(SQLException e){
            }
    }
    public static void deleteFlight(int flightId){
        try{
            String sql="Delete FROM ROOT.FLIGHTS where id ="+String.valueOf(flightId);
            Statement add=myconObj.createStatement();
            add.executeUpdate(sql);
        } catch(SQLException e){
        }
    }
}
