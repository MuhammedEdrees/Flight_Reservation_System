/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Flight;
import model.Reservation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isA;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.FlightRepository;
import repository.ReservationRepository;
import util.Validation;
import view.FlightAgentView;

/**
 *
 * @author top
 */
public class FlightAgentControllerTest {

    static FlightAgentView FlightAgentViewMock = mock(FlightAgentView.class);
    static Validation validateMock = mock(Validation.class);
    static FlightRepository flightRepoMock = mock(FlightRepository.class);
    static ReservationRepository reservationRepoMock= mock(ReservationRepository.class);
    static private FlightAgentController controller;

    public FlightAgentControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("started before class");
        controller = new FlightAgentController(FlightAgentViewMock);
        controller.setValidator(validateMock);
        controller.setFlightRepo(flightRepoMock);
        controller.setReservationRepo(reservationRepoMock);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clean() {
        Mockito.reset(FlightAgentViewMock);
        Mockito.reset(validateMock);
        Mockito.reset(flightRepoMock);
        Mockito.reset(reservationRepoMock);
    }

    /**
     * Test of handleAddFlightButtonClick method, of class
     * FlightAgentController.
     */
    @Test
    public void testHandleAddFlightButtonClick() {
        System.out.println("handleAddFlightButtonClick");

        int flightId = 9;
        Date flightDate = new Date(2024, 5, 5);
        String departureAirport = "London";
        String arrivalAirport = "Cairo";
        String departureTime = "10:30";
        String flightDuration = "02:50";
        double basePrice = 3000;
        String airline = "Egyptaiport";
        int seatCapacity = 300;

        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(7);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<Flight> matches = new ArrayList<>();
        Flight flight = new Flight(departureAirport, arrivalAirport, flightDate, departureTime, flightDuration, basePrice, airline, seatCapacity, seatCapacity);
        matches.add(flight);
        Object[] row = {flight.getId(), flight.getDepartureAirport(), flight.getArrivalAirport(), flight.getFlightDate(), flight.getDepartureTime(), flight.getFlightDuration(), flight.getBasePrice()};
        expectedModel.setColumnCount(7);
        expectedModel.addRow(row);

        when(FlightAgentViewMock.getFlightId()).thenReturn(flightId);
        when(validateMock.validateId(flightId)).thenReturn(true);
        when(FlightAgentViewMock.getFlightDate()).thenReturn(flightDate);
        when(validateMock.validateDepartureDate(flightDate)).thenReturn(true);
        when(FlightAgentViewMock.getSeatCapacity()).thenReturn(seatCapacity);
        when(validateMock.validateSeatCapacity(seatCapacity)).thenReturn(true);
        when(FlightAgentViewMock.getDepartureAirport()).thenReturn(departureAirport);
        when(validateMock.validateAirport(departureAirport)).thenReturn(true);
        when(FlightAgentViewMock.getArrivalAirport()).thenReturn(arrivalAirport);
        when(validateMock.validateAirport(arrivalAirport)).thenReturn(true);
        when(FlightAgentViewMock.getDepartureTime()).thenReturn(departureTime);
        when(validateMock.validateTime(departureTime)).thenReturn(true);
        when(FlightAgentViewMock.getFlightDuration()).thenReturn(flightDuration);
        when(validateMock.validateDuration(flightDuration)).thenReturn(true);
        when(FlightAgentViewMock.getAirline()).thenReturn(airline);
        when(validateMock.validateAirline(airline)).thenReturn(true);
        when(FlightAgentViewMock.getBasePrice()).thenReturn(basePrice);
        when(validateMock.validatePayment(basePrice)).thenReturn(true);

        when(FlightAgentViewMock.getFlightTableModel()).thenReturn(actualModel);
        when(flightRepoMock.getAll()).thenReturn(matches);

        controller.handleAddFlightButtonClick();

        doNothing().when(flightRepoMock).create(isA(Flight.class));

        //verify(FlightAgentViewMock).getFlightId();
        //verify(validateMock).validateId(flightId);
        verify(FlightAgentViewMock, times(2)).getFlightDate();
        verify(validateMock).validateDepartureDate(flightDate);
        verify(FlightAgentViewMock).getFlightTableModel();
        verify(flightRepoMock).getAll();
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());

    }

    /**
     * Test of handleUpdateFlightButtonClick method, of class
     * FlightAgentController.
     */
    @Test
    public void testHandleUpdateFlightButtonClick() {
        System.out.println("handleUpdateFlightButtonClick");

        int flightId = 9;
        Date flightDate = new Date(2024, 5, 5);
        String departureAirport = "London";
        String arrivalAirport = "Cairo";
        String departureTime = "10:30";
        String flightDuration = "2.5";
        double basePrice = 3000;
        String airline = "Egyptaiport";
        int seatCapacity = 300;

        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(7);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<Flight> matches = new ArrayList<>();
        Flight flight = new Flight(departureAirport, arrivalAirport, flightDate, departureTime, flightDuration, basePrice, airline, seatCapacity, seatCapacity);
        matches.add(flight);
        Object[] row = {flight.getId(), flight.getDepartureAirport(), flight.getArrivalAirport(), flight.getFlightDate(), flight.getDepartureTime(), flight.getFlightDuration(), flight.getBasePrice()};
        expectedModel.setColumnCount(7);
        expectedModel.addRow(row);

        when(FlightAgentViewMock.getFlightId()).thenReturn(flightId);
        when(validateMock.validateId(flightId)).thenReturn(true);
        when(FlightAgentViewMock.getFlightDate()).thenReturn(flightDate);
        when(validateMock.validateDepartureDate(flightDate)).thenReturn(true);
        when(FlightAgentViewMock.getSeatCapacity()).thenReturn(seatCapacity);
        when(validateMock.validateSeatCapacity(seatCapacity)).thenReturn(true);
        when(FlightAgentViewMock.getDepartureAirport()).thenReturn(departureAirport);
        when(validateMock.validateAirport(departureAirport)).thenReturn(true);
        when(FlightAgentViewMock.getArrivalAirport()).thenReturn(arrivalAirport);
        when(validateMock.validateAirport(arrivalAirport)).thenReturn(true);
        when(FlightAgentViewMock.getDepartureTime()).thenReturn(departureTime);
        when(validateMock.validateTime(departureTime)).thenReturn(true);
        when(FlightAgentViewMock.getFlightDuration()).thenReturn(flightDuration);
        when(validateMock.validateDuration(flightDuration)).thenReturn(true);
        when(FlightAgentViewMock.getAirline()).thenReturn(airline);
        when(validateMock.validateAirline(airline)).thenReturn(true);
        when(FlightAgentViewMock.getBasePrice()).thenReturn(basePrice);
        when(validateMock.validatePayment(basePrice)).thenReturn(true);

        when(FlightAgentViewMock.getFlightTableModel()).thenReturn(actualModel);
        when(flightRepoMock.getAll()).thenReturn(matches);

        controller.handleUpdateFlightButtonClick();

        doNothing().when(flightRepoMock).create(isA(Flight.class));

        verify(FlightAgentViewMock,times(2)).getFlightId();
        verify(validateMock).validateId(flightId);
        verify(FlightAgentViewMock, times(2)).getFlightDate();
        verify(validateMock).validateDepartureDate(flightDate);
        verify(FlightAgentViewMock).getFlightTableModel();
        verify(flightRepoMock).getAll();
        //optional?
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of handleDeleteFlightButtonClick method, of class
     * FlightAgentController.
     */
    @Test
    public void testHandleDeleteFlightButtonClick() {
        System.out.println("handleDeleteFlightButtonClick");

        int flightId = 9;

        when(FlightAgentViewMock.getFlightId()).thenReturn(flightId);
        when(validateMock.validateId(flightId)).thenReturn(true);
        when(FlightAgentViewMock.getFlightTableModel()).thenReturn(new DefaultTableModel());
        doNothing().when(flightRepoMock).create(isA(Flight.class));

        controller.handleDeleteFlightButtonClick();

        verify(FlightAgentViewMock, times(2)).getFlightId();
        verify(validateMock).validateId(flightId);
        verify(flightRepoMock).getAll();

    }

    /**
     * Test of updateFlightsTableModel method, of class FlightAgentController.
     */
    @Test
    public void testUpdateFlightsTableModel() {
        System.out.println("updateFlightsTableModel");

        int flightId = 9;
        Date flightDate = new Date(2024, 5, 5);
        String departureAirport = "London";
        String arrivalAirport = "Cairo";
        String departureTime = "10:30";
        String flightDuration = "2.5";
        double basePrice = 3000;
        String airline = "Egyptaiport";
        int seatCapacity = 300;

        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(7);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<Flight> matches = new ArrayList<>();
        Flight flight = new Flight(departureAirport, arrivalAirport, flightDate, departureTime, flightDuration, basePrice, airline, seatCapacity, seatCapacity);
        matches.add(flight);
        Object[] row = {flight.getId(), flight.getDepartureAirport(), flight.getArrivalAirport(), flight.getFlightDate(), flight.getDepartureTime(), flight.getFlightDuration(), flight.getBasePrice()};
        expectedModel.setColumnCount(7);
        expectedModel.addRow(row);
        
        
        when(flightRepoMock.getAll()).thenReturn(matches);
        
        controller.updateFlightsTableModel(actualModel);
        
        verify(flightRepoMock).getAll();
        
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());
        
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateReservationsTableModel method, of class
     * FlightAgentController.
     */
    @Test
    public void testUpdateReservationsTableModel() {
        System.out.println("updateReservationsTableModel");
        
        int reservationId = 2;
        String firstName = "Mahmoud";
        String surname = "Hamada";
        String nationality = "Egyptian";
        String passNum = "123456789";
        String resClass = "economy";
        Date passExpiry = new Date(2025, 5, 5);
        int flightID = 12;
        int passengerId = 33;
        int numOfseats = 2;

        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(8);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<Reservation> matches = new ArrayList<>();
        Reservation reservation = new Reservation(passengerId,flightID,firstName,surname,nationality,passNum,passExpiry,numOfseats,resClass);
        matches.add(reservation);
        Object[] row = {reservation.getId(),reservation.getFirstName(),reservation.getNationality(),reservation.getPassNum(),reservation.getPassExpiry(),reservation.getNumOfseats(),reservation.getFlightID(),reservation.getPassengerId()};
        expectedModel.setColumnCount(8);
        expectedModel.addRow(row);
        
        
        when(reservationRepoMock.getAll()).thenReturn(matches);
        
        controller.updateReservationsTableModel(actualModel);
        
        verify(reservationRepoMock).getAll();
        
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());
        
        //fail("The test case is a prototype.");
    }

}
