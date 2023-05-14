package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Flight;
import model.Payment;
import model.Reservation;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.mockito.ArgumentMatchers.isA;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.FlightRepository;
import repository.PaymentRepository;
import repository.ReservationRepository;
import util.Validation;
import view.PassengerView;

public class PassengerControllerTest {
    static PassengerView view = mock(PassengerView.class);
    static Validation validator = mock(Validation.class);
    static FlightRepository flightRepo = mock(FlightRepository.class);
    static PaymentRepository paymentRepo = mock(PaymentRepository.class);
    static ReservationRepository reservationRepo = mock(ReservationRepository.class);
    @InjectMocks
    static PassengerController controller;
    public PassengerControllerTest() {
    }
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("started before class");
        controller = new PassengerController(view);
        controller.setFlightRepo(flightRepo);
        controller.setPaymentRepo(paymentRepo);
        controller.setReservationRepo(reservationRepo);
        controller.setValidator(validator);
        System.out.println("finished before class");
    }
    
    @After
    public void clean(){
        Mockito.reset(view);
        Mockito.reset(validator);
        Mockito.reset(flightRepo);
        Mockito.reset(paymentRepo);
        Mockito.reset(reservationRepo);
    }
    
    @Test
    public void testHandleSearchFlightButtonClick() {
        System.out.println("handleSearchFlightButtonClick");
        String departureAirport = "Cairo";
        String arrivalAirport = "Luxor";
        Date flightDate = new Date(2023, 6, 30);
        String departureTime = "10:00";
        String flightDuration = "03:00";
        double basePrice = 100;
        String airline = "Cairo Airlines";
        int seatCapacity = 60;
        int availableSeats = 60;
        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(7);
        DefaultTableModel expectedModel = new DefaultTableModel();
        ArrayList<Flight> matches = new ArrayList<>();
        Flight flight = new Flight(1, departureAirport, arrivalAirport, flightDate, departureTime, flightDuration, basePrice, airline, seatCapacity,availableSeats);
        matches.add(flight);
        Object[] row = {flight.getId(), flight.getAirline(), flight.getDepartureAirport(), flight.getArrivalAirport(), flight.getFlightDate(), flight.getDepartureTime(), flight.getFlightDuration()};
        expectedModel.setColumnCount(7);
        expectedModel.addRow(row);
        when(view.getFlightSearchInput()).thenReturn(List.of(departureAirport, arrivalAirport, flightDate, actualModel));
        when(validator.validateAirport(departureAirport)).thenReturn(true);
        when(validator.validateAirport(arrivalAirport)).thenReturn(true);
        when(validator.validateDepartureDate(flightDate)).thenReturn(true);
        when(flightRepo.findByDepartureAirport_ArrivalAirportAndFlightDate(departureAirport, arrivalAirport, flightDate))
                .thenReturn(matches);
        controller.handleSearchFlightButtonClick();
        verify(view).getFlightSearchInput();
        verify(validator).validateAirport(departureAirport);
        verify(validator).validateAirport(arrivalAirport);
        verify(validator).validateDepartureDate(flightDate);
        verify(view).updateSearchPanel(0);
        //optional?
        assertEquals(expectedModel.getDataVector(), actualModel.getDataVector());
    }
    /*
     * Test of handleSubmitPassengerInfoButtonClick method, of class PassengerController.
     */
    @Test
    public void testHandleSubmitPassengerInfoButtonClick() {
        String fname = "John";
        String sname = "Doe";
        String nationality = "Egypt";
        int numOfSeats = 3;
        String resClass = "First";
        String passNum = "123456789123456";
        Date expiryDate = new Date(2024, 1, 1);
        String departureAirport = "Cairo";
        String arrivalAirport = "Luxor";
        Date flightDate = new Date(2023, 6, 30);
        String departureTime = "10:00";
        String flightDuration = "03:00";
        double basePrice = 100;
        String airline = "Cairo Airlines";
        int seatCapacity = 60;
        int availableSeats = 60;
        int flightId = 1;
        Object[] input = {fname, sname, nationality, String.valueOf(numOfSeats), resClass, passNum, expiryDate, flightId};
        when(view.getReservationInput()).thenReturn(input);
        when(validator.validateFirstname(fname)).thenReturn(true);
        when(validator.validateSurname(sname)).thenReturn(true);
        when(validator.validateNationality(nationality)).thenReturn(true);
        when(validator.validateWantedNumOfSeats(flightId, numOfSeats)).thenReturn(true);
        when(validator.validateClass(resClass)).thenReturn(true);
        when(validator.validatePassportNumber(passNum)).thenReturn(true);
        when(validator.validateExpiryDate(expiryDate)).thenReturn(true);
        doNothing().when(flightRepo).read(isA(Flight.class));
        controller.handleSubmitPassengerInfoButtonClick();
        verify(view).getReservationInput();
        verify(validator).validateFirstname(fname);
        verify(validator).validateSurname(sname);
        verify(validator).validateNationality(nationality);
        verify(validator).validateWantedNumOfSeats(flightId, numOfSeats);
        verify(validator).validateClass(resClass);
        verify(validator).validatePassportNumber(passNum);
        verify(validator).validateExpiryDate(expiryDate);
        verify(view).updateReservationDetailsPanel(0);
    }

    /**
     * Test of handleSubmitReservationButtonClick method, of class PassengerController.
     */
    @Test
    public void testHandleSubmitReservationButtonClick() {
        int flightId = 1;
        String fName = "John";
        String sName = "Doe";
        String nationality = "Egypt";
        String pNum = "12345678912346";
        Date pExpiry = new Date(2024, 5, 5);
        int noSeats = 3;
        String resClass = "First";
        String cType = "Visa";
        String cNum = "1234567891234567";
        String cName = "John Doe";
        String cvv = "123";
        Date cExpiry = new Date(2024, 6, 6);
        double pAmount = 1200;
        Object[] resInput = {fName, sName, nationality,String.valueOf(noSeats), resClass, pNum, pExpiry, flightId};
        Object[] paymentInput = {cType, cNum, cName, cvv, cExpiry};
        when(view.getReservationInput()).thenReturn(resInput);
        when(view.getPaymentInput()).thenReturn(paymentInput);
        when(validator.validateCardType(cType)).thenReturn(true);
        when(validator.validateCardNumber(cNum)).thenReturn(true);
        when(validator.validateCardHolderName(cName)).thenReturn(true);
        when(validator.validateCvv(cvv)).thenReturn(true);
        when(validator.validateExpiryDate(cExpiry)).thenReturn(true);
        doNothing().when(flightRepo).read(isA(Flight.class));
        doNothing().when(flightRepo).update(isA(Flight.class));
        doNothing().when(reservationRepo).create(isA(Reservation.class));
        doNothing().when(paymentRepo).create(isA(Payment.class));
        controller.handleSubmitReservationButtonClick();
        verify(view).getReservationInput();
        verify(view).getPaymentInput();
        verify(validator).validateCardType(cType);
        verify(validator).validateCardNumber(cNum);
        verify(validator).validateCardHolderName(cName);
        verify(validator).validateCvv(cvv);
        verify(validator).validateExpiryDate(cExpiry);
        verify(view).updatePaymentDetailsPanel(0);
    }

    /**
     * Test of handleCancelReservationButtonClick method, of class PassengerController.
     */
    @Test
    public void testHandleCancelReservationButtonClick() {
        int resId = 1;
        int response = 0;
        DefaultTableModel actualModel = new DefaultTableModel();
        actualModel.setColumnCount(10);
        Object[] input = {String.valueOf(resId), actualModel, response};
        when(view.getCancelledReservationInput()).thenReturn(input);
        when(validator.validateId(String.valueOf(resId))).thenReturn(true);
        doNothing().when(flightRepo).read(isA(Flight.class));
        doNothing().when(reservationRepo).delete(isA(Reservation.class));
        doNothing().when(reservationRepo).read(isA(Reservation.class));
        doNothing().when(paymentRepo).delete(isA(Payment.class));
        controller.handleCancelReservationButtonClick();
        verify(view).updateBookingsPanel(0);
    }

    /**
    * Test of updateSearchTableModel method, of class PassengerController.
    */
    @Test
    public void testUpdateSearchTableModel() {
        System.out.println("updateSearchTableModel");
        DefaultTableModel actualModel = new DefaultTableModel();
        DefaultTableModel expModel = new DefaultTableModel();
        actualModel.setColumnCount(7);
        expModel.setColumnCount(7);
        int flightId1 = 1;
        int flightId2 = 2;
        String departureAirport1 = "Cairo";
        String departureAirport2 = "Alexandria";
        String arrivalAirport1 = "Luxor";
        String arrivalAirport2 = "Sharm El Shiekh";
        Date flightDate1 = new Date(2023, 9, 15);
        Date flightDate2 = new Date(2024, 5, 9);
        String departTime1 = "10:00";
        String departTime2 = "17:30";
        String flightDuration1 = "03:00";
        String flightDuration2 = "04:30";
        double price1 = 1200;
        double price2 = 2350;
        String airline = "Cairo Airlines";
        int seatCapacity1 = 100;
        int seatCapacity2 = 80;
        int availableSeats1 = 65;
        int availableSeats2 = 53;
        Flight flight1 = new Flight(flightId1,departureAirport1, arrivalAirport1, flightDate1, departTime1, flightDuration1, price1, airline, seatCapacity1, availableSeats1);
        Flight flight2 = new Flight(flightId2,departureAirport2, arrivalAirport2, flightDate2, departTime2, flightDuration2, price2, airline, seatCapacity2, availableSeats2);
        ArrayList<Flight> matches = new ArrayList<>();
        matches.add(flight1);
        matches.add(flight2);
        controller.updateSearchTableModel(actualModel, matches);
        Object[] row1 = {flight1.getId(),
                flight1.getAirline(),
                flight1.getDepartureAirport(),
                flight1.getArrivalAirport(),
                flight1.getFlightDate(),
                flight1.getDepartureTime(),
                flight1.getFlightDuration()};
        Object[] row2 = {flight2.getId(),
                flight2.getAirline(),
                flight2.getDepartureAirport(),
                flight2.getArrivalAirport(),
                flight2.getFlightDate(),
                flight2.getDepartureTime(),
                flight2.getFlightDuration()};
        expModel.addRow(row1);
        expModel.addRow(row2);
        assertEquals(expModel.getDataVector(), actualModel.getDataVector());
    }
}
