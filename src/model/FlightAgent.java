package model;

import java.sql.Connection;

public class FlightAgent extends User {
    private Connection myconObj;
    
    public FlightAgent(int id) {
        super(id);
    }
    public FlightAgent(){
    }
    public FlightAgent(String fullname, String username, String password, String email) {
        super(fullname, username, password, email);
    }

}
    
