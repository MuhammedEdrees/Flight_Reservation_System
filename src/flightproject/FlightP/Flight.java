package flightproject.FlightP;

import flightproject.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public static String getDepartureAirport(int id){
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString("DEPARTUREAIRPORT");
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    
    public static String getArrivalAirport(int id){
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString("ARRIVALAIRPORT");
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    
    public static java.sql.Date getFlightDate(int id){
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getDate("FLIGHTDATE");
            }
            return java.sql.Date.valueOf(LocalDate.MAX);
        }catch(SQLException e){
            return java.sql.Date.valueOf(LocalDate.MAX);
        }
    }
    
    public static String getDepartureTime(int id){
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString("DEPARTURETIME");
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    
    public static String getAirline(int id){
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString("AIRLINE");
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    
    public static int getNumofSeats(int id){
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getInt("AVAILABLESEATS");
            }
            return -1;
        }catch(SQLException e){
            return -1;
        }
    }
    
    public static String getFlightDuration(int id){
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString("FLIGHTDURATION");
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }
    
    public static void setAvailableNumberOfSeats(int id, int numOfSeats){
        try{
        String seatQuery= "UPDATE ROOT.FLIGHTS SET AVAILABLESEATS= ? WHERE ID = ?";
        mystatObj = myconObj.prepareStatement(seatQuery);
        mystatObj.setInt(1, numOfSeats);
        mystatObj.setInt(2, id);
        mystatObj.executeUpdate();
        } catch(SQLException e){}
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
    public static ArrayList<FlightModel> search(java.util.Date date,String departureAirport,String arrivalAirport){
        String query = "select * FROM ROOT.FLIGHTS WHERE departureairport=? AND arrivalairport=? AND flightdate=?";
        java.sql.Date flightDate = new java.sql.Date(date.getTime());
        try{
            Connection myConObj = DriverManager.getConnection("jdbc:derby://localhost:1527/flight project DB", "root", "root");
            mystatObj= myConObj.prepareStatement(query);
            mystatObj.setString(1, departureAirport);
            mystatObj.setString(2, arrivalAirport);
            mystatObj.setDate(3, flightDate);
            myresObj = mystatObj.executeQuery();
            ArrayList<FlightModel> agentsList = new ArrayList<FlightModel>();
            while(myresObj.next()){
                System.out.println(myresObj.toString());
                FlightModel flightagent;
                flightagent = new FlightModel(myresObj.getInt(1), myresObj.getString(8), myresObj.getString(2), flightDate.toString(), myresObj.getString(5), myresObj.getString(3),myresObj.getDouble(7),myresObj.getString(6));
                agentsList.add(flightagent);
            }
            return agentsList;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
        
    }
}
