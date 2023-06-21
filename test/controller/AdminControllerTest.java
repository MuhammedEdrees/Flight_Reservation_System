/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import model.FlightAgent;
import model.Passenger;
import model.Request;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.FlightAgentRepository;
import repository.PassengerRepository;
import repository.RequestRepository;
import util.Validation;
import view.AdminView;

/**
 *
 * @author Mahmoud Rabea
 */
public class AdminControllerTest {
    static AdminView view = mock(AdminView.class);
    static Validation validator = mock(Validation.class);
    static FlightAgentRepository flightAgentRepo = mock(FlightAgentRepository.class);
    static PassengerRepository passengerRepo = mock(PassengerRepository.class);
    static RequestRepository requestRepo = mock(RequestRepository.class);
    @InjectMocks
    static AdminController controller;
    public AdminControllerTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//        System.out.println("started before class");
//        controller = new AdminController(view);
//        controller.setFlightAgentRepo(flightAgentRepo);
//        controller.setPassengerRepo(passengerRepo);
//        controller.setRequestRepo(requestRepo);
//        controller.setValidator(validator);
//        System.out.println("finished before class");
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//        controller = new AdminController(view);
//        controller.setFlightAgentRepo(flightAgentRepo);
//        controller.setPassengerRepo(passengerRepo);
//        controller.setRequestRepo(requestRepo);
//        controller.setValidator(validator);
//    }
//    
//    @Before
//    public void setUp() {
//        controller = new AdminController(view);
//        controller.setFlightAgentRepo(flightAgentRepo);
//        controller.setPassengerRepo(passengerRepo);
//        controller.setRequestRepo(requestRepo);
//        controller.setValidator(validator);
//    }
//    
//    @After
//    public void tearDown() {
//        Mockito.reset(view);
//        Mockito.reset(validator);
//        Mockito.reset(flightAgentRepo);
//        Mockito.reset(requestRepo);
//    }
 @BeforeClass
    public static void beforeClass() {
       System.out.println("started before class");
       controller = new AdminController(view);
        controller.setFlightAgentRepo(flightAgentRepo);
        controller.setPassengerRepo(passengerRepo);
       controller.setRequestRepo(requestRepo);
       controller.setValidator(validator);
       System.out.println("finished before class");
    }
    
    @After
    public void clean(){
       Mockito.reset(view);
       Mockito.reset(validator);
       Mockito.reset(flightAgentRepo);
       Mockito.reset(requestRepo);
        Mockito.reset(passengerRepo);
    }
    /**
     * Test of handleAddFlightAgentButtonClick method, of class AdminController.
     */
    @Test
    public void testHandleAddFlightAgentButtonClick() {
        System.out.println("handleAddFlightAgentButtonClick");
        String fullname = "John";
        String email = "mahmoudrabea508@gmail.com";
        String uname = "mahmoudrabea@508";
        String pass = "mahmoudrabea@508";

     //   int flightagentId = 1;
       
        when(view.getFlightAgentFullname()).thenReturn(fullname);
         when(view.getFlightAgentEmail()).thenReturn(email);
        when(view.getFlightAgentUsername()).thenReturn(uname);
        when(view.getFlightAgentPassword()).thenReturn(pass);
        
        when(validator.validateFullname(fullname)).thenReturn(true);
        when(validator.validateEmail(email)).thenReturn(true);
        when(validator.validateUsername(uname)).thenReturn(true);
        when(validator.validatePassword( pass)).thenReturn(true);
        when(view.getFlightAgentModel()).thenReturn(new DefaultTableModel());
//        ArrayList<FlightAgent> matches = new ArrayList<>();
//        FlightAgent agent = new FlightAgent(0, fullname, uname, pass, email);
//        matches.add(agent);
        doNothing().when(flightAgentRepo).create(isA(FlightAgent.class));
        controller.handleAddFlightAgentButtonClick();
        verify(view,times(2)).getFlightAgentEmail();
        verify(view,times(2)).getFlightAgentFullname();
        verify(view,times(2)).getFlightAgentPassword();
        verify(view,times(2)).getFlightAgentUsername();
        verify(view).getFlightAgentModel();
        verify(view,times(2)).getFlightAgentEmail();
        verify(validator).validateFullname(fullname);
        verify(validator).validateEmail(email);
        verify(validator).validateUsername(uname);
        verify(validator).validatePassword(pass);
        
        verify(flightAgentRepo).getAll();
        
        
      //  verify(controller).updateAddFlightAgentTableModel(any(DefaultTableModel.class), matches);
    }
      @Test
      public void testUpdateFlightAgentTable() {
        String fullname = "John";
        String email = "mahmoudrabea508@gmail.com";
        String uname = "mahmoudrabea@508";
        String pass = "mahmoudrabea@508";
        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(5);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<FlightAgent> matches = new ArrayList<>();
        FlightAgent agent = new FlightAgent(0, fullname, uname, pass, email);
        matches.add(agent);
        when(flightAgentRepo.getAll()).thenReturn(matches);
        when(view.getFlightAgentModel()).thenReturn(actualModel);
        controller.updateAddFlightAgentTableModel(actualModel);
        Object[] row = {agent.getId(), agent.getFullname(),agent.getUsername(),agent.getPassword(),agent.getEmail()};
        expectedModel.setColumnCount(5);
        expectedModel.addRow(row);
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());

          
      }
       
    /**
     * Test of handleUpdateFlightAgentButtonClick method, of class AdminController.
     */
    @Test
    public void testHandleUpdateFlightAgentButtonClick() {
        System.out.println("handleUpdateFlightAgentButtonClick");
        String fullname = "John";
        String email = "mahmoudrabea508@gmail.com";
        String uname = "mahmoudrabea@508";
        String pass = "mahmoudrabea@508";
        String flightagentId = "2";
       when(view.getFlightAgentFullname()).thenReturn(fullname);
       when(view.getFlightAgentEmail()).thenReturn(email);
       when(view.getFlightAgentUsername()).thenReturn(uname);
       when(view.getFlightAgentPassword()).thenReturn(pass);
       when(view.getFlightAgentId()).thenReturn(flightagentId);
       when(validator.validateFullname(fullname)).thenReturn(true);
       when(validator.validateEmail(email)).thenReturn(true);
       when(validator.validateUsername(uname)).thenReturn(true);
       when(validator.validatePassword( pass)).thenReturn(true);
       when(validator.validateId(flightagentId)).thenReturn(true);
       when(view.getFlightAgentModel()).thenReturn(new DefaultTableModel());
       doNothing().when(flightAgentRepo).update(isA(FlightAgent.class));
       controller.handleUpdateFlightAgentButtonClick();
       verify(view,times(2)).getFlightAgentEmail();
       verify(view,times(2)).getFlightAgentFullname();
       verify(view,times(2)).getFlightAgentPassword();
       verify(view,times(2)).getFlightAgentUsername();
       verify(view,times(2)).getFlightAgentId();
       verify(view).getFlightAgentModel();
       verify(view,times(2)).getFlightAgentEmail();
       verify(validator).validateFullname(fullname);
       verify(validator).validateEmail(email);  
       verify(validator).validateUsername(uname);
       verify(validator).validatePassword(pass);
       verify(validator).validateId(flightagentId);
       verify(flightAgentRepo).getAll();
    }

    /**
     * Test of handleDeleteFlightAgentButtonClick method, of class AdminController.
     */
    @Test
    public void testHandleDeleteFlightAgentButtonClick() {
        System.out.println("handleDeleteFlightAgentButtonClick");
        String flightagentId = "1";
        when(view.getFlightAgentModel()).thenReturn(new DefaultTableModel());
        when(view.getFlightAgentId()).thenReturn(flightagentId);
        when(validator.validateId(flightagentId)).thenReturn(true);
        doNothing().when(flightAgentRepo).delete(isA(FlightAgent.class));
        controller.handleDeleteFlightAgentButtonClick();
        verify(view,times(2)).getFlightAgentId();
        verify(view).getFlightAgentModel();
        verify(validator).validateId(flightagentId);
        verify(flightAgentRepo).getAll();
    }

    /**
     * Test of handleAddPassengerButtonClick method, of class AdminController.
     */
    @Test
    public void testHandleAddPassengerButtonClick() {
        System.out.println("handleAddPassengerButtonClick");
        String fullname = "John";
        String email = "mahmoudrabea508@gmail.com";
        String uname = "mahmoudrabea@508";
        String pass = "mahmoudrabea@508";
        String id = "1";
        String phonenumber = "01205473195";
        Date dateofbirth = new Date(2024, 6, 6);
  
       
        when(view.getPassengerFullname()).thenReturn(fullname);
         when(view.getPassengerEmail()).thenReturn(email);
        when(view.getPassengerUsername()).thenReturn(uname);
        when(view.getPassengerPassword()).thenReturn(pass);
        when(view.getPassengerDateOFBirth()).thenReturn(dateofbirth);
        when(view.getPassengerId()).thenReturn(id);
        when(view.getPassengerPhonenumber()).thenReturn(phonenumber);

        when(validator.validateFullname(fullname)).thenReturn(true);
        when(validator.validateEmail(email)).thenReturn(true);
        when(validator.validateUsername(uname)).thenReturn(true);
        when(validator.validatePassword( pass)).thenReturn(true);
        when(validator.validateDateOfBirth(dateofbirth)).thenReturn(true);
        when(validator.validateId(id)).thenReturn(true);
        when(validator.validatePhoneNumber(phonenumber)).thenReturn(true);
        when(view.getPassengerModel()).thenReturn(new DefaultTableModel());
        
//        ArrayList<FlightAgent> matches = new ArrayList<>();
//        FlightAgent agent = new FlightAgent(0, fullname, uname, pass, email);
//        matches.add(agent);
        doNothing().when(passengerRepo).create(isA(Passenger.class));
        controller.handleAddPassengerButtonClick();
        verify(view,times(2)).getPassengerEmail();
        verify(view,times(2)).getPassengerFullname();
        verify(view,times(2)).getPassengerPassword();
        verify(view,times(2)).getPassengerUsername();
        verify(view,times(2)).getPassengerPhonenumber();
        verify(view).getPassengerId();
        verify(view,times(2)).getPassengerDateOFBirth();

        verify(view).getPassengerModel();
        verify(validator).validateFullname(fullname);
        verify(validator).validateEmail(email);
        verify(validator).validateUsername(uname);
        verify(validator).validatePassword(pass);
        verify(validator).validateDateOfBirth(dateofbirth);
        verify(validator).validateId(id);
        verify(validator).validatePhoneNumber(phonenumber);

        verify(passengerRepo).getAll();
    }
      @Test
      public void testUpdatePassengerTable() {
         String fullname = "John";
        String email = "mahmoudrabea508@gmail.com";
        String uname = "mahmoudrabea@508";
        String pass = "mahmoudrabea@508";
        String id = "1";
        String phonenumber = "01205473195";
        Date dateofbirth = new Date(2024, 6, 6);
        
        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(7);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<Passenger> matches = new ArrayList<>();
        Passenger passen = new Passenger(fullname, uname, pass, dateofbirth, phonenumber, email);
        matches.add(passen);
        when(passengerRepo.getAll()).thenReturn(matches);
        when(view.getPassengerModel()).thenReturn(actualModel);
        controller.updateAddPassengerTableModel(actualModel);
        Object[] row = {passen.getId(), passen.getFullname(),passen.getUsername(),passen.getEmail(),passen.getPassword(),passen.getDateOfBirth(),passen.getPhoneNumber()};
        expectedModel.setColumnCount(7);
        expectedModel.addRow(row);
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());
      }
    /**
     * Test of handleUpdatePassengerButtonClick method, of class AdminController.
     */
    @Test
    public void testHandleUpdatePassengerButtonClick() {
        System.out.println("handleUpdatePassengerButtonClick");
        String fullname = "John";
        String email = "mahmoudrabea508@gmail.com";
        String uname = "mahmoudrabea@508";
        String pass = "mahmoudrabea@508";
        String id = "1";
        String phonenumber = "01205473195";
        Date dateofbirth = new Date(2024, 6, 6);
  
       
        when(view.getPassengerFullname()).thenReturn(fullname);
         when(view.getPassengerEmail()).thenReturn(email);
        when(view.getPassengerUsername()).thenReturn(uname);
        when(view.getPassengerPassword()).thenReturn(pass);
        when(view.getPassengerDateOFBirth()).thenReturn(dateofbirth);
        when(view.getPassengerId()).thenReturn(id);
        when(view.getPassengerPhonenumber()).thenReturn(phonenumber);
        when(validator.validateFullname(fullname)).thenReturn(true);
        when(validator.validateEmail(email)).thenReturn(true);
        when(validator.validateUsername(uname)).thenReturn(true);
        when(validator.validatePassword( pass)).thenReturn(true);
        when(validator.validateDateOfBirth(dateofbirth)).thenReturn(true);
        when(validator.validateId(id)).thenReturn(true);
        when(validator.validatePhoneNumber(phonenumber)).thenReturn(true);
        when(view.getPassengerModel()).thenReturn(new DefaultTableModel());
        
//        ArrayList<FlightAgent> matches = new ArrayList<>();
//        FlightAgent agent = new FlightAgent(0, fullname, uname, pass, email);
//        matches.add(agent);
        doNothing().when(passengerRepo).update(isA(Passenger.class));
        controller.handleUpdatePassengerButtonClick();
        verify(view,times(2)).getPassengerEmail();
        verify(view,times(2)).getPassengerFullname();
        verify(view,times(2)).getPassengerPassword();
        verify(view,times(2)).getPassengerUsername();
        verify(view,times(2)).getPassengerPhonenumber();
        verify(view,times(2)).getPassengerId();
        verify(view,times(2)).getPassengerDateOFBirth();

        verify(view).getPassengerModel();
        verify(validator).validateFullname(fullname);
        verify(validator).validateEmail(email);
        verify(validator).validateUsername(uname);
        verify(validator).validatePassword(pass);
        verify(validator).validateDateOfBirth(dateofbirth);
        verify(validator).validateId(id);
        verify(validator).validatePhoneNumber(phonenumber);

        verify(passengerRepo).getAll();
    }

    /**
     * Test of handleDeletePassengerButtonClick method, of class AdminController.
     */
    @Test
    public void testHandleDeletePassengerButtonClick() {
        System.out.println("handleDeletePassengerButtonClick");
        String Id = "1";
        when(view.getPassengerModel()).thenReturn(new DefaultTableModel());
        when(view.getPassengerId()).thenReturn(Id);
        when(validator.validateId(Id)).thenReturn(true);
        doNothing().when(passengerRepo).delete(isA(Passenger.class));
        controller.handleDeletePassengerButtonClick();
        verify(view,times(2)).getPassengerId();
        verify(view).getPassengerModel();
        verify(validator).validateId(Id);
        verify(passengerRepo).getAll();
    }
    @Test
      public void testUpdateRequestTable() {
         String fullname = "John";
        String email = "mahmoudrabea508@gmail.com";
        String uname = "mahmoudrabea@508";
        String id = "1";
        String phonenumber = "01205473195";
        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(5);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<Request> matches = new ArrayList<>();
        Request req = new Request(fullname, uname, email, phonenumber);
        matches.add(req);
        when(requestRepo.getAll()).thenReturn(matches);
        when(view.getPassengerModel()).thenReturn(actualModel);
        controller.updateRequestsTableModel(actualModel);
        Object[] row = {req.getId(), req.getFullname(),req.getUsername(),req.getEmail(),req.getPhoneNumber()};
        expectedModel.setColumnCount(5);
        expectedModel.addRow(row);
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());
      }
    /**
     * Test of handleDeleteRequestButtonClick method, of class AdminController.
     */
    @Test
    public void testHandleDeleteRequestButtonClick() {
        System.out.println("handleDeleteRequestButtonClick");
        String Id = "1";
        when(view.getRequesModel()).thenReturn(new DefaultTableModel());
        when(view.getRequestId()).thenReturn(Id);
        when(validator.validateId(Id)).thenReturn(true);
        doNothing().when(requestRepo).delete(isA(Request.class));
        controller.handleDeleteRequestButtonClick();
        verify(view,times(2)).getRequestId();
        verify(view).getRequesModel();
        verify(validator).validateId(Id);
        verify(requestRepo).getAll();
    }
}
