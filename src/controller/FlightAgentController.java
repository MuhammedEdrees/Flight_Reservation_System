package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Flight;
import model.Reservation;
import repository.FlightRepository;
import repository.ReservationRepository;
import util.Validation;
import view.FlightAgentView;

public class FlightAgentController {

    private FlightAgentView view;
    private Validation validator = new Validation();
    private FlightRepository flightRepo = new FlightRepository();
    private ReservationRepository reservationRepo = new ReservationRepository();

    public FlightAgentController(FlightAgentView view) {
        this.view = view;
    }

    public void setValidator(Validation validator) {
        this.validator = validator;
    }

    public void setFlightRepo(FlightRepository flightRepo) {
        this.flightRepo = flightRepo;
    }

    public void setReservationRepo(ReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
    }
    
    public void handleAddFlightButtonClick() {
        if (validator.validateDepartureDate(view.getFlightDate()) == false) {
            JOptionPane.showMessageDialog(view, "The Date entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateSeatCapacity(view.getSeatCapacity()) == false) {
            JOptionPane.showMessageDialog(view, "The seat capacity entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateAirport(view.getDepartureAirport()) == false) {
            JOptionPane.showMessageDialog(view, "The departure airport entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateAirport(view.getArrivalAirport()) == false) {
            JOptionPane.showMessageDialog(view, "The arrival airport entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateTime(view.getDepartureTime()) == false) {
            JOptionPane.showMessageDialog(view, "The departure time entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateDuration(view.getFlightDuration()) == false) {
            JOptionPane.showMessageDialog(view, "The flight duration entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateAirline(view.getAirline()) == false) {
            JOptionPane.showMessageDialog(view, "The airline entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePayment(view.getBasePrice()) == false) {
            JOptionPane.showMessageDialog(view, "The base price entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            Flight flight = new Flight(view.getDepartureAirport(), view.getArrivalAirport(), view.getFlightDate(), view.getDepartureTime(), view.getFlightDuration(), view.getBasePrice(), view.getAirline(), view.getSeatCapacity(), view.getSeatCapacity());
            flightRepo.create(flight);
            DefaultTableModel model = view.getFlightTableModel();
            updateFlightsTableModel(model);

        }

    }

    public void handleUpdateFlightButtonClick() {
        if (validator.validateId(view.getFlightId()) == false) {
            JOptionPane.showMessageDialog(view, "The flight id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateDepartureDate(view.getFlightDate()) == false) {
            JOptionPane.showMessageDialog(view, "The Date entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateSeatCapacity(view.getSeatCapacity()) == false) {
            JOptionPane.showMessageDialog(view, "The seat capacity entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateAirport(view.getDepartureAirport()) == false) {
            JOptionPane.showMessageDialog(view, "The departure airport entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateAirport(view.getArrivalAirport()) == false) {
            JOptionPane.showMessageDialog(view, "The arrival airport entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateTime(view.getDepartureTime()) == false) {
            JOptionPane.showMessageDialog(view, "The departure time entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateDuration(view.getFlightDuration()) == false) {
            JOptionPane.showMessageDialog(view, "The flight duration entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateAirline(view.getAirline()) == false) {
            JOptionPane.showMessageDialog(view, "The airline entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePayment(view.getBasePrice()) == false) {
            JOptionPane.showMessageDialog(view, "The base price entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            Flight flight = new Flight(view.getFlightId(), view.getDepartureAirport(), view.getArrivalAirport(), view.getFlightDate(), view.getDepartureTime(), view.getFlightDuration(), view.getBasePrice(), view.getAirline(), view.getSeatCapacity(), view.getSeatCapacity());
            flightRepo.update(flight);
            DefaultTableModel model = view.getFlightTableModel();
            updateFlightsTableModel(model);

        }

    }

    public void handleDeleteFlightButtonClick() {
        if (validator.validateId(view.getFlightId()) == false) {
            JOptionPane.showMessageDialog(view, "The flight id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            Flight flight = new Flight(view.getFlightId());
            flightRepo.delete(flight);
            DefaultTableModel model = view.getFlightTableModel();
            updateFlightsTableModel(model);
        }
    }

    public void updateFlightsTableModel(DefaultTableModel model) {
        ArrayList<Flight> flightsList = flightRepo.getAll();
        model.setRowCount(0);
        for (int i = 0; i < flightsList.size(); i++) {
            Object[] flight = {flightsList.get(i).getId(), flightsList.get(i).getDepartureAirport(), flightsList.get(i).getArrivalAirport(), flightsList.get(i).getFlightDate(), flightsList.get(i).getDepartureTime(), flightsList.get(i).getFlightDuration(), flightsList.get(i).getBasePrice()};
            model.addRow(flight);
        }
    }

    public void updateReservationsTableModel(DefaultTableModel model) {
        ArrayList<Reservation> reservationList = reservationRepo.getAll();
        model.setRowCount(0);
        for (int i = 0; i < reservationList.size(); i++) {
            Object[] reservation = {reservationList.get(i).getId(), reservationList.get(i).getFirstName(), reservationList.get(i).getNationality(), reservationList.get(i).getPassNum(), reservationList.get(i).getPassExpiry(), reservationList.get(i).getNumOfseats(), reservationList.get(i).getFlightID(), reservationList.get(i).getPassengerId()};
            model.addRow(reservation);
        }

    }
}
