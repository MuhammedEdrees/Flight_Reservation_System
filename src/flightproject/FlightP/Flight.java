/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightproject.FlightP;

import flightproject.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author moham
 */
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

}
