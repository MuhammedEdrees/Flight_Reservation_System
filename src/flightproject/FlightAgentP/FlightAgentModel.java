package flightproject.FlightAgentP;

import flightproject.DBConnection;
import java.sql.*;

public class FlightAgentModel {
private String id;
private String name;
private String username;
private String password;
private String email;

    public FlightAgentModel(String id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static int generateID(){
        try{
            Connection myconObj = DBConnection.connectDB();
            Statement mystatObj = null;
            ResultSet myresObj = null;
            //Creating the Statement object
            mystatObj = myconObj.createStatement();
            //Query to get the number of rows in a table
            String idquery = "select count(*) from ROOT.FLIGHTAGENTS";
            //Executing the query
            myresObj = mystatObj.executeQuery(idquery);
            //Retrieving the result
            myresObj.next();
            int count = myresObj.getInt(1);
            return 1000+count+1;
            }catch(SQLException e){
                return -1;
            }
    }
}

