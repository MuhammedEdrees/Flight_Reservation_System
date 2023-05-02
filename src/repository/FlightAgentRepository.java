package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FlightAgent;
import static util.DbUtil.connectDB;

public class FlightAgentRepository implements Repository<FlightAgent>{
    
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    
    public FlightAgentRepository() {
        myconObj = util.DbUtil.connectDB();
    }
    @Override
    public void create(FlightAgent flightAgent)
    {
        String createQuery = "INSERT INTO ROOT.FLIGHTAGENTS VALUES (?,?,?,?,?)";
        flightAgent.setId(util.DbUtil.generateID("FlightAgents"));
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, flightAgent.getId());
            mystatObj.setString(2, flightAgent.getFullname());
            mystatObj.setString(3, flightAgent.getEmail());
            mystatObj.setString(4, flightAgent.getUsername());
            mystatObj.setString(5, flightAgent.getPassword());
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }
    @Override
    public void read(FlightAgent flightAgent) {
        String loadQuery = "select * from ROOT.FLIGHTAGENTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, flightAgent.getId());
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                flightAgent.setFullname(myresObj.getString(2));
                flightAgent.setEmail(myresObj.getString(3)) ;
                flightAgent.setUsername(myresObj.getString(4)) ;
                flightAgent.setPassword(myresObj.getString(5));
            }
        }catch(SQLException e){
        }
    }
    @Override
    public void update(FlightAgent flightAgent){
        String updateQuery = "Update ROOT.FLIGHTAGENTS Set Fullname = ?, Email = ?, Username = ?, Password = ? where ID = ?";
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, flightAgent.getFullname());
            mystatObj.setString(2, flightAgent.getEmail());
            mystatObj.setString(3, flightAgent.getUsername());
            mystatObj.setString(4, flightAgent.getPassword());
            mystatObj.setInt(5, flightAgent.getId());
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }
    @Override
    public void delete(FlightAgent flightAgent) {
        String deleteQuery = "Delete from ROOT.FLIGHTAGENTS where id = " + String.valueOf(flightAgent.getId());
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }
    public FlightAgent findByUsername (String username) {
        String query = "select * from ROOT.FLIGHTAGENTS WHERE USERNAME=?";
        try{
            FlightAgent flightAgent = new FlightAgent();
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, username);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                flightAgent.setId(myresObj.getInt(1));
                flightAgent.setFullname(myresObj.getString(2));
                flightAgent.setEmail(myresObj.getString(3));
                flightAgent.setUsername(myresObj.getString(4));
                flightAgent.setPassword(myresObj.getString(5));
                return flightAgent;
            } 
        }catch(SQLException e){
        }
        return null;
    }
    @Override
    public ArrayList<FlightAgent> getAll() {
        ArrayList<FlightAgent> flightAgentList = new ArrayList<>();
        String fetchQuery = "select * from ROOT.FLIGHTAGENTS";
        try {
            mystatObj= myconObj.prepareStatement(fetchQuery);
            myresObj = mystatObj.executeQuery();
            while (myresObj.next()){
                FlightAgent flightAgent = new FlightAgent();
                flightAgent.setId(myresObj.getInt(1));
                flightAgent.setFullname(myresObj.getString(2));
                flightAgent.setEmail(myresObj.getString(3));
                flightAgent.setUsername(myresObj.getString(4));
                flightAgent.setPassword(myresObj.getString(5));
                flightAgentList.add(flightAgent);
            }
        } catch(SQLException e) {
        } 
        return flightAgentList;
    }
}
