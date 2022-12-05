package flightproject;

import java.sql.*;

public class flightProject {

    //currentUserID is a static variable that represents the current user who is logged in to the system
    public static Integer currentUserID;
    public static void main(String[] args) throws SQLException {
        new LoginpGUI().setVisible(true);
    }
}
