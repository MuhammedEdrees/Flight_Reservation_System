/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Flight;
import model.FlightAgent;
import model.Passenger;
import model.Request;
import repository.AdminRepository;
import repository.FlightAgentRepository;
import repository.PassengerRepository;
import repository.RequestRepository;
import util.Validation;
import view.AdminView;

/**
 *
 * @author Mahmoud Rabea
 */
public class AdminController {

    private AdminView view;
    private Validation validator = new Validation();
    FlightAgentRepository flightAgentRepository = new FlightAgentRepository();
    PassengerRepository passengerRepository = new PassengerRepository();
    RequestRepository requestRepository=new RequestRepository();

    public AdminController(AdminView view) {
        this.view = view;
    }
    public void setValidator(Validation validator) {
        this.validator = validator;
    }

    public void setFlightAgentRepo(FlightAgentRepository flightAgentRepository) {
        this.flightAgentRepository = flightAgentRepository;
    }

    public void setPassengerRepo(PassengerRepository passengerRepo) {
        this.passengerRepository = passengerRepo;
    }

    public void setRequestRepo(RequestRepository requestRepo) {
        this.requestRepository = requestRepo;
    }
    
    
    public void handleAddFlightAgentButtonClick() {
        if (validator.validateFullname(view.getFlightAgentFullname()) == false) {
            JOptionPane.showMessageDialog(view, "The Full name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateUsername(view.getFlightAgentUsername()) == false) {
            JOptionPane.showMessageDialog(view, "The Username entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateEmail(view.getFlightAgentEmail()) == false) {
            JOptionPane.showMessageDialog(view, "The Email entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePassword(view.getFlightAgentPassword()) == false) {
            JOptionPane.showMessageDialog(view, "The Password entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            FlightAgent flightAgent = new FlightAgent(view.getFlightAgentFullname(), view.getFlightAgentUsername(), view.getFlightAgentPassword(), view.getFlightAgentEmail());
            flightAgentRepository.create(flightAgent);
            updateAddFlightAgentTableModel(view.getFlightAgentModel());

        }
    }

    public void handleUpdateFlightAgentButtonClick() {
        if (validator.validateFullname(view.getFlightAgentFullname()) == false) {
            JOptionPane.showMessageDialog(view, "The Full name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateUsername(view.getFlightAgentUsername()) == false) {
            JOptionPane.showMessageDialog(view, "The Username entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateEmail(view.getFlightAgentEmail()) == false) {
            JOptionPane.showMessageDialog(view, "The Email entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePassword(view.getFlightAgentPassword()) == false) {
            JOptionPane.showMessageDialog(view, "The Password entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateId(view.getFlightAgentId()) == false) {
            JOptionPane.showMessageDialog(view, "The Id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);

        } else {
            FlightAgent flightAgent = new FlightAgent(Integer.parseInt(view.getFlightAgentId()), view.getFlightAgentFullname(), view.getFlightAgentUsername(), view.getFlightAgentPassword(), view.getFlightAgentEmail());
            flightAgentRepository.update(flightAgent);
            updateAddFlightAgentTableModel(view.getFlightAgentModel());

        }
    }
      public void handleDeleteFlightAgentButtonClick() {
        if (validator.validateId(view.getFlightAgentId()) == false) {
            JOptionPane.showMessageDialog(view, "The Id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }  else {
            FlightAgent flightAgent = new FlightAgent(Integer.parseInt(view.getFlightAgentId()));
            flightAgentRepository.delete(flightAgent);
            updateAddFlightAgentTableModel(view.getFlightAgentModel());

        }
    }

    public DefaultTableModel updateAddFlightAgentTableModel(DefaultTableModel model ) {//actual
        ArrayList<FlightAgent> flightAgents = flightAgentRepository.getAll();//matches
        model.setRowCount(0);
        for (int i = 0; i < flightAgents.size(); i++) {
            Object[] o = new Object[7];
            FlightAgent flightAgent = flightAgents.get(i);
            o[0] = flightAgent.getId();
            o[1] = flightAgent.getFullname();
            o[2] = flightAgent.getUsername();
            o[3] = flightAgent.getPassword();
            o[4] = flightAgent.getEmail();
            model.addRow(o);
        }
        return model;
    }

    public void handleAddPassengerButtonClick() {
        if (validator.validateFullname(view.getPassengerFullname()) == false) {
            JOptionPane.showMessageDialog(view, "The Full name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateUsername(view.getPassengerUsername()) == false) {
            JOptionPane.showMessageDialog(view, "The Username entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateEmail(view.getPassengerEmail()) == false) {
            JOptionPane.showMessageDialog(view, "The Email entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePhoneNumber(view.getPassengerPhonenumber()) == false) {
            JOptionPane.showMessageDialog(view, "The Phonenumber entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePassword(view.getPassengerPassword()) == false) {
            JOptionPane.showMessageDialog(view, "The Password entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);

        } else if (validator.validateDateOfBirth(view.getPassengerDateOFBirth()) == false) {
            JOptionPane.showMessageDialog(view, "The Date entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);

        }else if (validator.validateId(view.getPassengerId()) == false) {
            JOptionPane.showMessageDialog(view, "The Id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);

        }
        else {
            Passenger passenger = new Passenger(view.getPassengerFullname(), view.getPassengerUsername(), view.getPassengerPassword(), view.getPassengerDateOFBirth(), view.getPassengerPhonenumber(), view.getPassengerEmail());
            passengerRepository.create(passenger);
            updateAddPassengerTableModel(view.getPassengerModel());

        }
    }

    public void handleUpdatePassengerButtonClick() {
        if (validator.validateFullname(view.getPassengerFullname()) == false) {
            JOptionPane.showMessageDialog(view, "The Full name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateUsername(view.getPassengerUsername()) == false) {
            JOptionPane.showMessageDialog(view, "The Username entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validateEmail(view.getPassengerEmail()) == false) {
            JOptionPane.showMessageDialog(view, "The Email entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePhoneNumber(view.getPassengerPhonenumber()) == false) {
            JOptionPane.showMessageDialog(view, "The Phonenumber entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (validator.validatePassword(view.getPassengerPassword()) == false) {
            JOptionPane.showMessageDialog(view, "The Password entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);

        } else if (validator.validateId(view.getPassengerId()) == false) {
            JOptionPane.showMessageDialog(view, "The Id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);

        }else if (validator.validateDateOfBirth(view.getPassengerDateOFBirth()) == false) {
            JOptionPane.showMessageDialog(view, "The Date entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);

        } else {
            Passenger passenger = new Passenger(Integer.parseInt(view.getPassengerId()), view.getPassengerFullname(), view.getPassengerUsername(), view.getPassengerPassword(), view.getPassengerDateOFBirth(), view.getPassengerPhonenumber(), view.getPassengerEmail());
            passengerRepository.update(passenger);
            updateAddPassengerTableModel(view.getPassengerModel());

        }
    }
 public void handleDeletePassengerButtonClick() {
        if (validator.validateId(view.getPassengerId()) == false) {
            JOptionPane.showMessageDialog(view, "The Id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }  else {
            Passenger passenger = new Passenger(Integer.parseInt(view.getPassengerId()));
            passengerRepository.delete(passenger);
            updateAddPassengerTableModel(view.getPassengerModel());

        }
    }
    public DefaultTableModel updateAddPassengerTableModel(DefaultTableModel model ) {
        model.setRowCount(0);
          ArrayList<Passenger> passengers = passengerRepository.getAll();
        for (int i = 0; i < passengers.size(); i++) {
            Object[] o = new Object[7];
            Passenger pass = passengers.get(i);
            o[0] = pass.getId();
            o[1] = pass.getFullname();
            o[2] = pass.getUsername();
            o[4] = pass.getPassword();
            o[3] = pass.getEmail();
            o[5] = pass.getDateOfBirth();
            o[6] = pass.getPhoneNumber();
            model.addRow(o);
        }
        return model;
    }
    
     public void handleDeleteRequestButtonClick() {
        if (validator.validateId(view.getRequestId()) == false) {
            JOptionPane.showMessageDialog(view, "The Id entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }  else {
            Request request = new Request(Integer.parseInt(view.getRequestId()));
            requestRepository.delete(request);
            updateRequestsTableModel(view.getRequesModel());

        }
    }
   
      public DefaultTableModel updateRequestsTableModel(DefaultTableModel model) {
           model.setRowCount(0);
           ArrayList<Request> requests = requestRepository.getAll();
        for (int i = 0; i < requests.size(); i++) {
            Object[] o = new Object[5];
            Request request = requests.get(i);
            o[0] = request.getId();
            o[3] = request.getEmail();
            o[2] = request.getUsername();
            o[4] = request.getPhoneNumber();
            o[1] = request.getFullname();
            model.addRow(o);
        }
        return model;
    }
}
