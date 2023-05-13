package model;

import java.sql.Connection;

public class FlightAgent extends User {
    private Connection myconObj;
    
    public FlightAgent(int id) {
        super(id);
    }
   public FlightAgent(int id,String fullname, String username, String password, String email) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public FlightAgent(String fullname, String username, String password, String email) {
        super(fullname, username, password, email);
    }

    public FlightAgent() {
    }

}
    
