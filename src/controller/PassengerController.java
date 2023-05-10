package controller;

import flightproject.flightProject;
import view.PassengerView;
import util.Validation;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repository.FlightRepository;
import model.Flight;
import model.Payment;
import model.Reservation;
import repository.PaymentRepository;
import repository.ReservationRepository;

public class PassengerController {
    private PassengerView view;
    private Validation validator = new Validation();
    private FlightRepository flightRepo = new FlightRepository();
    private PaymentRepository paymentRepo = new PaymentRepository();
    private ReservationRepository reservationRepo = new ReservationRepository();
    
    public PassengerController(PassengerView view){
        this.view = view;
    }
    
    public void handleSearchFlightButtonClick() {
        /*  Input Extracting  */
        Object[] input = view.getFlightSearchInput();
        String departureAirport = input[0].toString();
        String arrivalAirport = input[1].toString();
        Date flightDate = (Date) input[2];
        /*  Input Validation*/
        if(!validator.validateAirport(departureAirport)){
            JOptionPane.showMessageDialog(view, "The departure airport name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (!validator.validateAirport(arrivalAirport)) {
            JOptionPane.showMessageDialog(view, "The destination airport name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (!validator.validateDepartureDate(flightDate)){
            JOptionPane.showMessageDialog(view, "The flight date entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            FlightRepository flightRepo = new FlightRepository();
            ArrayList<Flight> matchingFlights = flightRepo.findByDepartureAirport_ArrivalAirportAndFlightDate(departureAirport, arrivalAirport, flightDate);
            DefaultTableModel tableModel = (DefaultTableModel) input[3];
            view.updateSearchPanel(matchingFlights.isEmpty());
            updateSearchTableModel(tableModel, matchingFlights);
        }
    }
    public void handleSubmitPassengerInfoButtonClick(){
        Object[] input = view.getReservationInput();
        Flight flight = new Flight((int)input[7]);
        flightRepo.read(flight);
        if(!validator.validateFirstname((String)input[0])){
            view.updateReservationDetailsPanel(1);
        } else if (!validator.validateSurname((String)input[1])) {
            view.updateReservationDetailsPanel(2);
        } else if (!validator.validateNationality((String)input[2])) {
            view.updateReservationDetailsPanel(3);
        } else if (!validator.validateNumberOfSeats((String)input[3]) || flight.getAvailableSeats() < Integer.parseInt((String)input[3])) {
            view.updateReservationDetailsPanel(4);
        } else if (!validator.validateClass((String)input[4])) {
            view.updateReservationDetailsPanel(5);
        } else if (!validator.validatePassportNumber((String)input[5])) {
            view.updateReservationDetailsPanel(6);
        } else if (!validator.validateExpiryDate((Date)input[6])) {
            view.updateReservationDetailsPanel(7);
        } else {
            view.updateReservationDetailsPanel(0);
        }
    }
    public void handleSubmitReservationButtonClick(){
        Object[] reservationInput = view.getReservationInput();
        Object[] paymentInput = view.getPaymentInput();
        Flight flight = new Flight((int)reservationInput[7]);
        flightRepo.read(flight);
        if(!validator.validateCardType((String)paymentInput[0])){
            view.updatePaymentDetailsPanel(1);
        } else if (!validator.validateCardNumber((String)paymentInput[1])) {
            view.updatePaymentDetailsPanel(2);
        } else if (!validator.validateCardHolderName((String)paymentInput[2])) {
            view.updatePaymentDetailsPanel(3);
        } else if (!validator.validateCvv((String)paymentInput[3])) {
            view.updatePaymentDetailsPanel(4);
        } else if (!validator.validateExpiryDate((Date)paymentInput[4])) {
            view.updatePaymentDetailsPanel(5);
        } else {
            System.out.println("Valid Input");
            int flightId = (int)reservationInput[7];
            String fName = (String) reservationInput[0];
            String sName = (String) reservationInput[1];
            String nationality = (String) reservationInput[2];
            String pNum = (String) reservationInput[5];
            Date pExpiry = (Date) reservationInput[6];
            int noSeats = Integer.parseInt((String) reservationInput[3]);
            String resClass = (String) reservationInput[4];
            String cType = (String) paymentInput[0];
            String cNum = (String) paymentInput[1];
            String cName = (String) paymentInput[2];
            double pAmount = computePaymentAmount(resClass, noSeats, flight.getBasePrice());
            String cvv = (String) paymentInput[3];
            Date cExpiry = (Date) paymentInput[4];
            System.out.println("Valid Extraction");
            submitReservation(flightId, fName, sName, nationality, pNum, pExpiry, noSeats, resClass, cType, cName, cNum, pAmount, cvv, cExpiry);
            System.out.println("Valid Submition");
            view.updatePaymentDetailsPanel(0);
        }
    }
    public void handleCancelReservationButtonClick(){
        int response = JOptionPane.showConfirmDialog(view, "Are you sure you want to cancel reservation?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        Object[] input = view.getCancelledReservationInput();
        if(response == JOptionPane.YES_OPTION && validator.validateId((String)input[0])){
            int cancelledReservationId = Integer.parseInt((String) input[0]);
            Reservation cancelledReservation = new Reservation(cancelledReservationId);
            reservationRepo.read(cancelledReservation);
            Flight flight = new Flight(cancelledReservation.getFlightID());
            flightRepo.read(flight);
            Payment cancelledPayment = new Payment(cancelledReservationId);
            flight.setAvailableSeats(cancelledReservation.getNumOfseats() + flight.getAvailableSeats());
            paymentRepo.delete(cancelledPayment);
            reservationRepo.delete(cancelledReservation);
            DefaultTableModel model = (DefaultTableModel) input[1];
            updateReservationTableModel(model);
        } else if(response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION){
        } else {
            JOptionPane.showMessageDialog(view, "The ID entered is invalid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private DefaultTableModel updateSearchTableModel(DefaultTableModel model, ArrayList<Flight> matchingFlights) {
        for (int i = 0; i<matchingFlights.size();i++) {
            Object[] o = new Object[7];
            Flight flight = matchingFlights.get(i);
            if(flight.getAvailableSeats() == 0)
                continue;
            o[0] = flight.getId();
            o[1] = flight.getAirline();
            o[2] = flight.getDepartureAirport();
            o[3] = flight.getArrivalAirport();
            o[4] = flight.getFlightDate();
            o[5] = flight.getDepartureTime();
            o[6] = flight.getFlightDuration();
            model.addRow(o);
    }
        return model;
}
    private double computePaymentAmount(String Class, int numOfSeats, double basePrice){
        double multiplier = 0, amount;
        switch (Class){
            case "First" :
                multiplier = 2;
                break;
            case "Business":
                multiplier = 1.5;
                break;
            case "Economy":
                multiplier = 1;
                break;
        }
        amount = numOfSeats*multiplier*basePrice;
        return amount;
    }
    private void submitReservation(int flightID, String firstName,String surname,String nationality,String passportNumber,Date passportExpiryDate,int reservationNumberOfSeats,String reservationClass, String cardType, String cardHolderName, String cardNumber, double paymentAmount, String cardCVV, Date cardExpiryDate) {
        Reservation newReservation = new Reservation(flightProject.currentUserID, flightID, firstName, surname, nationality, passportNumber, passportExpiryDate, reservationNumberOfSeats, reservationClass);
        reservationRepo.create(newReservation);
        Flight passengerFlight = new Flight(flightID);
        flightRepo.read(passengerFlight);
        passengerFlight.setAvailableSeats(passengerFlight.getAvailableSeats() - newReservation.getNumOfseats());
        flightRepo.update(passengerFlight);
        Payment reservationPayment = new Payment(newReservation.getId(), cardType, cardHolderName, cardNumber, paymentAmount, cardCVV, cardExpiryDate);
        paymentRepo.create(reservationPayment);
    }
    public DefaultTableModel updateReservationTableModel(DefaultTableModel model){
        ArrayList<Reservation> reservationList = reservationRepo.findByPassengerId(flightProject.currentUserID);
        model.setRowCount(0);
        for(int i = 0; i < reservationList.size(); i++){
            Reservation reservation = reservationList.get(i);
            int reservId = reservation.getId();
            int numOfseats = reservation.getNumOfseats();
            int flightId = reservation.getFlightID();
            Flight flight = new Flight(flightId);
            flightRepo.read(flight);
            String resClass = reservation.getResClass();
            String from = flight.getDepartureAirport();
            String to = flight.getArrivalAirport();
            Date flightDate = flight.getFlightDate();
            String departureTime = flight.getDepartureTime();
            String airLine = flight.getAirline();
            String flightDuration = flight.getFlightDuration();
            Payment payment =  paymentRepo.findByReservationId(reservId);
            double price = payment.getPaymentAmount();
            String tbData[] = {String.valueOf(reservId), airLine, from, to, String.valueOf(flightDate), departureTime, flightDuration, String.valueOf(numOfseats), resClass, String.valueOf(price)};
            model.addRow(tbData);
        }
        return model;
    }
}