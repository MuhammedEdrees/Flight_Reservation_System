package util;

import java.util.Date;


public class Validation {
    public boolean validateId(int id){
        return id >= 1;
    }
    public boolean validateId(String id){
        return (id != null && id.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(id) > 0);
    }
    /*  User attributes  */
    public boolean validateUsername(String uname){
        return !(uname == null || !uname.matches("[a-zA-Z0-9_]{6,24}"));
    }
    
    public boolean validateFullname(String fullname) {
        return !(fullname == null || !fullname.matches("[a-zA-Z ]{12,64}"));
    }
    public boolean validateFirstname(String name) {
        return !(name == null || !name.matches("[a-zA-Z ]{1,64}"));
    }
    public boolean validateSurname(String name) {
        return !(name == null || !name.matches("[a-zA-Z ]{1,64}"));
    }
    public boolean validatePassword(String password) {
        return !(password == null || !password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#\\$&*~]).{8,64}$"));
    }
    public boolean validateEmail(String email){
        return !(email == null || !email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"));
    }
    public boolean validatePhoneNumber(String pnumber) {
        return !(pnumber == null || !pnumber.matches("^(?:[+0]9)?[0-9]{10,12}$"));
    }
    public boolean validateDateOfBirth(Date bdate){
        return !(bdate == null || bdate.before(new Date()));
    }
    /*  Flight Attributes  */
    public boolean validateAirport(String airport){
        return !(airport == null || !airport.matches("[a-zA-z ]{1,}"));
    }
    public boolean validateDepartureDate (Date date) {
        return !(date == null || date.before(new Date()));
    }
    public boolean validateTime(String time) {
        return !(time == null || !time.matches("2[0123]:[0-9]{2}") || !time.matches("[01][0-9]:[0-9]{2}"));
    }
    public boolean validateDuration(String duration) {
        return !(duration == null || !duration.matches("[0-9]{2}:[0-9]{2}") || "00:00".equals(duration));
    }
    public boolean validatePayment (double price) {
        return price > 0;
    }
    public boolean validateAirline(String airline) {
        return !(airline == null || !airline.matches("[a-zA-z ]{1,}"));
    }
    public boolean validateNationality(String nationality) {
        return !(nationality == null || !nationality.matches("[a-zA-z ]{1,}"));
    }
    public boolean validateSeatCapacity(int noOfSeats) {
        return noOfSeats > 0;
    }
    public boolean validateAvailableSeats(int seats) {
        return seats >= 0;
    }
    /*  Payment Attributes*/
    public boolean validateCardNumber(String cardNum) {
        return !(cardNum == null || !cardNum.matches("[0-9]{16}"));
    }
    public boolean validateCardType(String cardType){
        return (cardType != null && (cardType.equals("Mastercard") || cardType.equals("Visa")));
    }
    public boolean validateCardHolderName(String name) {
        return !(name == null || !name.matches("[a-zA-Z ]{12,64}"));
    }
    public boolean validateExpiryDate(Date date) {
        return !(date == null || date.before(new Date()));
    }
    public boolean validateCvv(String cvv) {
        return !(cvv == null ||!cvv.matches("[0-9]{3}"));
    }
    /*  Reservation Attributes  */
    public boolean validatePassportNumber(String passportNum) {
        return !(passportNum == null || !passportNum.matches("[0-9A-Z]{1,20}"));
    }
    public boolean validateClass(String resClass) {
        return (resClass != null &&(resClass.equals("First") || resClass.equals("Economy") || resClass.equals("Business")));
    }
    public boolean validateNumberOfSeats(String seats) {
        return (seats != null && seats.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(seats) > 0);
    }
    
}
