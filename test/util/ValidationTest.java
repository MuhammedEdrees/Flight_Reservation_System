/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package util;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moham
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
        int id = 1;
        Validation instance = new Validation();
        assertTrue(instance.validateId(id));
    }

    /**
     * Test of validateId method, of class Validation.
     */
    @Test
    public void testValidateId_String() {
        System.out.println("validateId");
        String id = "5";
        Validation instance = new Validation();
        assertTrue(instance.validateId(id));
    }

    /**
     * Test of validateUsername method, of class Validation.
     */
    @Test
    public void testValidateUsername() {
        System.out.println("validateUsername");
        String uname = "Edrees123";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateUsername(uname);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateFullname method, of class Validation.
     */
    @Test
    public void testValidateFullname() {
        System.out.println("validateFullname");
        String fullname = "John Doe";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateFullname(fullname);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateFirstname method, of class Validation.
     */
    @Test
    public void testValidateFirstname() {
        System.out.println("validateFirstname");
        String name = "John";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateFirstname(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateSurname method, of class Validation.
     */
    @Test
    public void testValidateSurname() {
        System.out.println("validateSurname");
        String name = "Doe";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateSurname(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassword method, of class Validation.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String password = "John123@doe";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmail method, of class Validation.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        String email = "JohnDoe@test.com";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePhoneNumber method, of class Validation.
     */
    @Test
    public void testValidatePhoneNumber() {
        System.out.println("validatePhoneNumber");
        String pnumber = "01011111111";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validatePhoneNumber(pnumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDateOfBirth method, of class Validation.
     */
    @Test
    public void testValidateDateOfBirth() {
        System.out.println("validateDateOfBirth");
        Date bdate = new Date(2000, 1, 1);
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateDateOfBirth(bdate);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAirport method, of class Validation.
     */
    @Test
    public void testValidateAirport() {
        System.out.println("validateAirport");
        String airport = "Cairo";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateAirport(airport);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDepartureDate method, of class Validation.
     */
    @Test
    public void testValidateDepartureDate() {
        System.out.println("validateDepartureDate");
        Date date = new Date (2024, 5, 5);
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateDepartureDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateTime method, of class Validation.
     */
    @Test
    public void testValidateTime() {
        System.out.println("validateTime");
        String time = "10:00";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateTime(time);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDuration method, of class Validation.
     */
    @Test
    public void testValidateDuration() {
        System.out.println("validateDuration");
        String duration = "10:00";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateDuration(duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePayment method, of class Validation.
     */
    @Test
    public void testValidatePayment() {
        System.out.println("validatePayment");
        double price = 1000;
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validatePayment(price);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAirline method, of class Validation.
     */
    @Test
    public void testValidateAirline() {
        System.out.println("validateAirline");
        String airline = "Qatar Airways";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateAirline(airline);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNationality method, of class Validation.
     */
    @Test
    public void testValidateNationality() {
        System.out.println("validateNationality");
        String nationality = "Egypt";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateNationality(nationality);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateSeatCapacity method, of class Validation.
     */
    @Test
    public void testValidateSeatCapacity() {
        System.out.println("validateSeatCapacity");
        int noOfSeats = 60;
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateSeatCapacity(noOfSeats);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAvailableSeats method, of class Validation.
     */
    @Test
    public void testValidateAvailableSeats() {
        System.out.println("validateAvailableSeats");
        int seats = 5;
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateAvailableSeats(seats);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateWantedNumOfSeats method, of class Validation.
     */
//    @Test
//    public void testValidateWantedNumOfSeats() {
//        System.out.println("validateWantedNumOfSeats");
//        int flightId = 1;
//        int numOfSeats = 2;
//        Validation instance = new Validation();
//        boolean expResult = true;
//        boolean result = instance.validateWantedNumOfSeats(flightId, numOfSeats);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of validateCardNumber method, of class Validation.
     */
    @Test
    public void testValidateCardNumber() {
        System.out.println("validateCardNumber");
        String cardNum = "1234567891234567";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateCardNumber(cardNum);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCardType method, of class Validation.
     */
    @Test
    public void testValidateCardType() {
        System.out.println("validateCardType");
        String cardType = "Visa";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateCardType(cardType);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCardHolderName method, of class Validation.
     */
    @Test
    public void testValidateCardHolderName() {
        System.out.println("validateCardHolderName");
        String name = "John Doe";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateCardHolderName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateExpiryDate method, of class Validation.
     */
    @Test
    public void testValidateExpiryDate() {
        System.out.println("validateExpiryDate");
        Date date = new Date(2025, 4, 1);
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateExpiryDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCvv method, of class Validation.
     */
    @Test
    public void testValidateCvv() {
        System.out.println("validateCvv");
        String cvv = "541";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateCvv(cvv);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassportNumber method, of class Validation.
     */
    @Test
    public void testValidatePassportNumber() {
        System.out.println("validatePassportNumber");
        String passportNum = "1234567891234";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validatePassportNumber(passportNum);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateClass method, of class Validation.
     */
    @Test
    public void testValidateClass() {
        System.out.println("validateClass");
        String resClass = "Economy";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateClass(resClass);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNumberOfSeats method, of class Validation.
     */
    @Test
    public void testValidateNumberOfSeats() {
        System.out.println("validateNumberOfSeats");
        String seats = "3";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.validateNumberOfSeats(seats);
        assertEquals(expResult, result);
    }
}
