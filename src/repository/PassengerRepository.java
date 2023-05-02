package repository;

import model.Passenger;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import static util.DbUtil.connectDB;

public class PassengerRepository implements Repository<Passenger> {
    
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    
    public PassengerRepository() {
        myconObj = util.DbUtil.connectDB();
    }

    @Override
    public void create(Passenger passenger) {
        String createQuery = "INSERT INTO ROOT.PASSENGERS VALUES (?,?,?,?,?,?,?)";
        passenger.setId(util.DbUtil.generateID("passengers"));
        java.sql.Date sqlDate = new java.sql.Date(passenger.getDateOfBirth().getTime());
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, passenger.getId());
            mystatObj.setString(2, passenger.getFullname());
            mystatObj.setString(3, passenger.getUsername());
            mystatObj.setString(4, passenger.getPassword());
            mystatObj.setDate(5, sqlDate);
            mystatObj.setString(6, passenger.getPhoneNumber());
            mystatObj.setString(7, passenger.getEmail());
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public void read(Passenger passenger) {
        String loadQuery = "select * from ROOT.PASSENGERS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, passenger.getId());
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                passenger.setFullname(myresObj.getString(2));
                passenger.setUsername(myresObj.getString(3));
                passenger.setPassword(myresObj.getString(4));
                passenger.setDateOfBirth(new Date(myresObj.getDate(5).getTime()));
                passenger.setPhoneNumber(myresObj.getString(6));
                passenger.setEmail(myresObj.getString(7));
            }
        }catch(SQLException e){}
    }

    @Override
    public void update(Passenger passenger) {
        String updateQuery = "Update ROOT.PASSENGERS Set Fullname = ?, Username = ?, Password = ?, DateOfBirth = ?, PhoneNumber = ?, Email = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, passenger.getFullname());
            mystatObj.setString(2, passenger.getUsername());
            mystatObj.setString(3, passenger.getPassword());
            mystatObj.setDate(4, new java.sql.Date(passenger.getDateOfBirth().getTime()));
            mystatObj.setString(5, passenger.getPhoneNumber());
            mystatObj.setString(6, passenger.getEmail());
            mystatObj.setInt(7, passenger.getId());
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }

    @Override
    public void delete(Passenger passenger) {
       String deleteQuery = "Delete from ROOT.PASSENGERS where id = " + String.valueOf(passenger.getId());
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }

    @Override
    public ArrayList<Passenger> getAll() {
        ArrayList<Passenger> passengerList = new ArrayList<>();
        String fetchQuery = "select * from ROOT.PASSENGERS";
        try {
            mystatObj= myconObj.prepareStatement(fetchQuery);
            myresObj = mystatObj.executeQuery();
            while (myresObj.next()){
                Passenger passenger = new Passenger();
                passenger.setId(myresObj.getInt(1));
                passenger.setFullname(myresObj.getString(2));
                passenger.setUsername(myresObj.getString(3));
                passenger.setPassword(myresObj.getString(4));
                passenger.setDateOfBirth(new Date(myresObj.getDate(5).getTime()));
                passenger.setPhoneNumber(myresObj.getString(6));
                passenger.setEmail(myresObj.getString(7));
            }
        } catch(SQLException e) {
        } 
        return passengerList;
    }
    public Passenger findByUsername (String username) {
        String query = "select * from ROOT.PASSENGERS WHERE USERNAME=?";
        try{
            Passenger passenger = new Passenger();
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, username);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                passenger.setId(myresObj.getInt(1));
                passenger.setFullname(myresObj.getString(2));
                passenger.setUsername(myresObj.getString(3));
                passenger.setPassword(myresObj.getString(4));
                passenger.setDateOfBirth(new Date(myresObj.getDate(5).getTime()));
                passenger.setPhoneNumber(myresObj.getString(6));
                passenger.setEmail(myresObj.getString(7));
                return passenger;
            } 
        }catch(SQLException e){
        }
        return null;
    }
}
