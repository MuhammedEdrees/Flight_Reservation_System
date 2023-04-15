package data;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import static utils.DbUtils.*;

public class FlightAgent extends User {
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    public FlightAgent(int id) {
        super(id);
    }
    public FlightAgent(String fullname, String username, String password, String email) {
        super(fullname, username, password, email);
    }
    public static int getID(String username){
        String query = "select * from ROOT.FLIGHTAGENTS WHERE USERNAME=?";
        Connection myconObj = connectDB();
        PreparedStatement mystatObj;
        ResultSet myresObj;
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, username);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getInt(1);
            }
        }catch(SQLException e){
        }
        return -1;
    }
    private void createFlightAgent() {
        String createQuery = "INSERT INTO ROOT.FLIGHTAGENTS VALUES (?,?,?,?,?)";
        myconObj = connectDB();
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, id);
            mystatObj.setString(2, fullname);
            mystatObj.setString(3, email);
            mystatObj.setString(4, username);
            mystatObj.setString(5, password);
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }
    @Override
    public void store(){
        this.id = generateID("FLIGHTAGENTS");
        createFlightAgent();
    }
    @Override
    public void update(){
        String updateQuery = "Update ROOT.FLIGHTAGENTS Set Fullname = ?, Email = ?, Username = ?, Password = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, fullname);
            mystatObj.setString(2, email);
            mystatObj.setString(3, username);
            mystatObj.setString(4, password);
            mystatObj.setInt(5, id);
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }
    @Override
    public void load() {
        String loadQuery = "select * from ROOT.FLIGHTAGENTS WHERE ID=?";
        myconObj = connectDB();
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                this.fullname = myresObj.getString(2);
                this.email = myresObj.getString(3);
                this.username = myresObj.getString(4);
                this.password = myresObj.getString(5);
            }
        }catch(SQLException e){
        }
    }
    @Override
    public void delete() {
        String deleteQuery = "Delete from ROOT.FLIGHTAGENTS where id = " + String.valueOf(this.id);
        myconObj = connectDB();
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }
}
