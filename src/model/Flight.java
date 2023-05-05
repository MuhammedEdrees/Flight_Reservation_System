package model;

import java.util.Date;

public class Flight {

    private int id, seatCapacity, availableSeats;
    private double basePrice;
    private Date flightDate;
    private String departureAirport, arrivalAirport, departureTime, flightDuration, airline;

    public Flight() {
    }

    public Flight(int id) {
        this.id = id;
    }

    public Flight(String departureAirport, String arrivalAirport, Date flightDate, String departureTime, String flightDuration, double basePrice, String airline, int seatCapacity, int availableSeats) {
        
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
        this.basePrice = basePrice;
        this.airline = airline;
        this.seatCapacity = seatCapacity;
        this.availableSeats = availableSeats;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
