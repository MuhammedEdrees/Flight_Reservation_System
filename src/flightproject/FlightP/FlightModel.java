package flightproject.FlightP;

public class FlightModel {
 public int id;
 public String departureAirport;
 public String flightDate;
 public String departureTime;
 public String arrivalAirport;
 public double basePrice;
 public String flightDuration;
 public String airline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getFlightDuratio() {
        return flightDuration;
    }

    public void setFlightDuratio(String flightDuratio) {
        this.flightDuration = flightDuratio;
    }

    public FlightModel(int id, String airline, String departureAirport, String flightDate, String departureTime, String arrivalAirport, double basePrice, String flightDuratio) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.arrivalAirport = arrivalAirport;
        this.basePrice = basePrice;
        this.flightDuration = flightDuratio;
        this.airline = airline;
    }
}
