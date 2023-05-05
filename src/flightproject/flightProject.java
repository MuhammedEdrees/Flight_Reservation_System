package flightproject;

import view.LoginpGUI;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class flightProject {
    private static Connection myconObj;
    private static Statement mystatObj = null;
    private static ResultSet myresObj = null;
    public static Integer currentUserID = 2001;
    public static void main(String[] args) throws SQLException {
        new LoginpGUI().setVisible(true);
    }
}
