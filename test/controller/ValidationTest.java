/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import model.Flight;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import repository.FlightRepository;

/**
 *
 * @author top
 */
public class ValidationTest {
    
    public ValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateId method, of class Validation.
     */
    @Test
    public void testValidateId_int() {
        System.out.println("validateId");
        int id1 = 45;
        int id2 = -45;
        Validation instance = new Validation();
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result1 = instance.validateId(id1);
        boolean result2 = instance.validateId(id2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateId method, of class Validation.
     */
    @Test
    public void testValidateId_String() {
        System.out.println("validateId");
        String id1 = null;
        String id2 = "23";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateId(id1);
        boolean result2 = instance.validateId(id2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateUsername method, of class Validation.
     */
    @Test
    public void testValidateUsername() {
        System.out.println("validateUsername");
        String uname1 = null ;
        String uname2 = "afrdq4242524" ;
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateUsername(uname1);
        boolean result2 = instance.validateUsername(uname2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateFullname method, of class Validation.
     */
    @Test
    public void testValidateFullname() {
        System.out.println("validateFullname");
        String fullname1 = null ;
        String fullname2 = "arfaraera rerrfyh" ;
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateFullname(fullname1);
        boolean result2 = instance.validateFullname(fullname2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateFirstname method, of class Validation.
     */
    @Test
    public void testValidateFirstname() {
        System.out.println("validateFirstname");
        String name1 = null;
        String name2 = "afgagAGA";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateFirstname(name1);
        boolean result2 = instance.validateFirstname(name2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateSurname method, of class Validation.
     */
    @Test
    public void testValidateSurname() {
        System.out.println("validateSurname");
        String name1 = "";
        String name2 = "rwageERHEH";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateSurname(name1);
        boolean result2 = instance.validateSurname(name2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validatePassword method, of class Validation.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String password1 = "";
        String password2 = "^de24rfgtr43erfgr4";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validatePassword(password1);
        boolean result2 = instance.validatePassword(password2);
        assertEquals(expResult1, result1);
        //assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateEmail method, of class Validation.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        String email1 = null;
        String email2 = "afasf@gmail.com";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateEmail(email1);
        boolean result2 = instance.validateEmail(email2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validatePhoneNumber method, of class Validation.
     */
    @Test
    public void testValidatePhoneNumber() {
        System.out.println("validatePhoneNumber");
        String pnumber1 = "asdf";
        String pnumber2 = "01113631553";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validatePhoneNumber(pnumber1);
        boolean result2 = instance.validatePhoneNumber(pnumber2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateDateOfBirth method, of class Validation.
     */
    @Test
    public void testValidateDateOfBirth() {
        System.out.println("validateDateOfBirth");
        java.util.Date bdate = new java.util.Date(25,05,2000);
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateDateOfBirth(bdate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateAirport method, of class Validation.
     */
    @Test
    public void testValidateAirport() {
        System.out.println("validateAirport");
        String airport1 = null;
        String airport2 = "Cairo";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateAirport(airport1);
        boolean result2 = instance.validateAirport(airport2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateDepartureDate method, of class Validation.
     */
    @Test
    public void testValidateDepartureDate() {
        System.out.println("validateDepartureDate");
        java.util.Date date = new java.util.Date(25,05,2024);
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateDepartureDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateTime method, of class Validation.
     */
    @Test
    public void testValidateTime() {
        System.out.println("validateTime");
        String time1 = null;
        String time2 = "20:20";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateTime(time1);
        boolean result2 = instance.validateTime(time2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of validateDuration method, of class Validation.
     */
    @Test
    public void testValidateDuration() {
        System.out.println("validateDuration");
        String duration1 = null;
        String duration2 = "05:20";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateDuration(duration1);
        boolean result2 = instance.validateDuration(duration2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validatePayment method, of class Validation.
     */
    @Test
    public void testValidatePayment() {
        System.out.println("validatePayment");
        double price1 = 0.0;
        double price2 = 2345;
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validatePayment(price1);
         boolean result2 = instance.validatePayment(price2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateAirline method, of class Validation.
     */
    @Test
    public void testValidateAirline() {
        System.out.println("validateAirline");
        String airline1 = null;
        String airline2 = "Qatar";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateAirline(airline1);
        boolean result2 = instance.validateAirline(airline2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateNationality method, of class Validation.
     */
    @Test
    public void testValidateNationality() {
        System.out.println("validateNationality");
        String nationality1 = null;
        String nationality2 = "Egyptian";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateNationality(nationality1);
        boolean result2 = instance.validateNationality(nationality2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateSeatCapacity method, of class Validation.
     */
    @Test
    public void testValidateSeatCapacity() {
        System.out.println("validateSeatCapacity");
        int noOfSeats1 = 0;
        int noOfSeats2 = 2;
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateSeatCapacity(noOfSeats1);
        boolean result2 = instance.validateSeatCapacity(noOfSeats2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateAvailableSeats method, of class Validation.
     */
    @Test
    public void testValidateAvailableSeats() {
        System.out.println("validateAvailableSeats");
        int seats1 = -1;
        int seats2 = 10;
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateAvailableSeats(seats1);
        boolean result2 = instance.validateAvailableSeats(seats2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateWantedNumOfSeats method, of class Validation.
     */
    //@Test
    public void testValidateWantedNumOfSeats() {
        System.out.println("validateWantedNumOfSeats");
        
        Flight flightMock = mock(Flight.class);
        FlightRepository flightRepoMock = mock(FlightRepository.class);
        Validation validation = new Validation(flightMock);
        int flightId = 1;
        int numOfSeats = 5;
        when(flightMock.getAvailableSeats()).thenReturn(7);
        doNothing().when(flightRepoMock).read(isA(Flight.class));
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = validation.validateWantedNumOfSeats(flightId, numOfSeats);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateCardNumber method, of class Validation.
     */
    @Test
    public void testValidateCardNumber() {
        System.out.println("validateCardNumber");
        String cardNum1 = "13312";
        String cardNum2 = "1234567891234567";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateCardNumber(cardNum1);
        boolean result2 = instance.validateCardNumber(cardNum2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateCardType method, of class Validation.
     */
    @Test
    public void testValidateCardType() {
        System.out.println("validateCardType");
        String cardType1 = null;
        String cardType2 = "Mastercard";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateCardType(cardType1);
        boolean result2 = instance.validateCardType(cardType2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateCardHolderName method, of class Validation.
     */
    @Test
    public void testValidateCardHolderName() {
        System.out.println("validateCardHolderName");
        String name1 = null;
        String name2 = "KHaled Gamal Taha";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateCardHolderName(name1);
        boolean result2 = instance.validateCardHolderName(name2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateExpiryDate method, of class Validation.
     */
    @Test
    public void testValidateExpiryDate() {
        System.out.println("validateExpiryDate");
        java.util.Date date = new java.util.Date(25,05,2000);
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean result1 = instance.validateExpiryDate(date);
        assertEquals(expResult1, result1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateCvv method, of class Validation.
     */
    @Test
    public void testValidateCvv() {
        System.out.println("validateCvv");
        String cvv1 = "1244";
        String cvv2 = "123";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateCvv(cvv1);
        boolean result2 = instance.validateCvv(cvv2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validatePassportNumber method, of class Validation.
     */
    @Test
    public void testValidatePassportNumber() {
        System.out.println("validatePassportNumber");
        String passportNum1 = null;
        String passportNum2 = "SAGSG78SAGS6AG";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validatePassportNumber(passportNum1);
        boolean result2 = instance.validatePassportNumber(passportNum2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateClass method, of class Validation.
     */
    @Test
    public void testValidateClass() {
        System.out.println("validateClass");
        String resClass1 = null;
        String resClass2 = "First";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateClass(resClass1);
        boolean result2 = instance.validateClass(resClass2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateNumberOfSeats method, of class Validation.
     */
    @Test
    public void testValidateNumberOfSeats() {
        System.out.println("validateNumberOfSeats");
        String seats1 = null;
        String seats2 = "23";
        Validation instance = new Validation();
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.validateNumberOfSeats(seats1);
        boolean result2 = instance.validateNumberOfSeats(seats2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
