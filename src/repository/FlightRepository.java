package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Flight;
import static util.DbUtil.*;

public class FlightRepository implements Repository<Flight> {

    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;

    public FlightRepository() {
        myconObj = util.DbUtil.connectDB();
    }

    @Override
    public void create(Flight flight) {
        String createQuery = "INSERT INTO ROOT.FLIGHTS VALUES (?,?,?,?,?,?,?,?,?,?)";
        flight.setId(util.DbUtil.generateID("flights"));
        try {
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, flight.getId());
            mystatObj.setString(2, flight.getDepartureAirport());
            mystatObj.setString(3, flight.getArrivalAirport());
            mystatObj.setDate(4, new java.sql.Date(flight.getFlightDate().getTime()));
            mystatObj.setString(5, flight.getDepartureTime());
            mystatObj.setString(6, flight.getFlightDuration());
            mystatObj.setDouble(7, flight.getBasePrice());
            mystatObj.setString(8, flight.getAirline());
            mystatObj.setInt(9, flight.getSeatCapacity());
            mystatObj.setInt(10, flight.getAvailableSeats());
            mystatObj.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void read(Flight flight) {
        String loadQuery = "select * from ROOT.FLIGHTS WHERE ID=?";
        try {
            mystatObj = myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, flight.getId());
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()) {
                flight.setDepartureAirport(myresObj.getString(2));
                flight.setArrivalAirport(myresObj.getString(3));
                flight.setFlightDate(new Date(myresObj.getDate(4).getTime()));
                flight.setDepartureTime(myresObj.getString(5));
                flight.setFlightDuration(myresObj.getString(6));
                flight.setBasePrice(myresObj.getDouble(7));
                flight.setAirline(myresObj.getString(8));
                flight.setSeatCapacity(myresObj.getInt(9));
                flight.setAvailableSeats(myresObj.getInt(10));
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void update(Flight flight) {
        String updateQuery = "Update ROOT.FLIGHTS Set DEPARTUREAIRPORT = ?, ARRIVALAIRPORT = ?, FLIGHTDATE = ?, DEPARTURETIME = ?, FLIGHTDURATION = ?, BASEPRICE = ?, AIRLINE = ?, SEATCAPACITY = ?, AVAILABLESEATS = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, flight.getDepartureAirport());
            mystatObj.setString(2, flight.getArrivalAirport());
            mystatObj.setDate(3, new java.sql.Date(flight.getFlightDate().getTime()));
            mystatObj.setString(4, flight.getDepartureTime());
            mystatObj.setString(5, flight.getFlightDuration());
            mystatObj.setDouble(6, flight.getBasePrice());
            mystatObj.setString(7, flight.getAirline());
            mystatObj.setInt(8, flight.getSeatCapacity());
            mystatObj.setInt(9, flight.getAvailableSeats());
            mystatObj.setInt(10, flight.getId());
            mystatObj.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void delete(Flight flight) {
        String deleteQuery = "Delete from ROOT.FLIGHTS where ID = " + String.valueOf(flight.getId());
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e) {
        }
    }

    @Override
    public ArrayList<Flight> getAll() {
        ArrayList<Flight> flightList = new ArrayList<>();
        String fetchQuery = "select * from ROOT.FLIGHTS";
        try {
            mystatObj = myconObj.prepareStatement(fetchQuery);
            myresObj = mystatObj.executeQuery();
            while (myresObj.next()) {
                Flight flight = new Flight();
                flight.setId(myresObj.getInt(1));
                flight.setDepartureAirport(myresObj.getString(2));
                flight.setArrivalAirport(myresObj.getString(3));
                flight.setFlightDate(new Date(myresObj.getDate(4).getTime()));
                flight.setDepartureTime(myresObj.getString(5));
                flight.setFlightDuration(myresObj.getString(6));
                flight.setBasePrice(myresObj.getDouble(7));
                flight.setAirline(myresObj.getString(8));
                flight.setSeatCapacity(myresObj.getInt(9));
                flight.setAvailableSeats(myresObj.getInt(10));
                flightList.add(flight);
            }
        } catch (SQLException e) {
        }
        return flightList;
    }

    public Flight findById(int id) {
        String query = "select * from ROOT.FLIGHTS WHERE ID=?";
        try {
            Flight flight = new Flight();
            mystatObj = myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()) {
                flight.setId(myresObj.getInt(1));
                flight.setDepartureAirport(myresObj.getString(2));
                flight.setArrivalAirport(myresObj.getString(3));
                flight.setFlightDate(new Date(myresObj.getDate(4).getTime()));
                flight.setDepartureTime(myresObj.getString(5));
                flight.setFlightDuration(myresObj.getString(6));
                flight.setBasePrice(myresObj.getDouble(7));
                flight.setAirline(myresObj.getString(8));
                flight.setSeatCapacity(myresObj.getInt(9));
                flight.setAvailableSeats(myresObj.getInt(10));
                return flight;
            }
        } catch (SQLException e) {
        }
        return null;
    }

}
