package model;

import java.util.Date;

public class Passenger extends User {

    private Date dateOfBirth;
    private String phoneNumber;

    public Passenger() {
    }

    public Passenger(int id) {
        super(id);
    }

    public Passenger(String fullname, String username, String password, Date dateOfBirth, String phonenumber, String email) {
        super();
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phonenumber;
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
