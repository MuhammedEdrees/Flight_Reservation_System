package model;

import java.util.Objects;

public class Request {  
    private String phoneNumber,username, fullname, email;
    private int id;
    
    public Request() {
    }
    
    public Request(int id){
        this.id = id;
    }
    public Request (String fullname, String username, String email, String phonenumber)
    {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phonenumber;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Request other = (Request) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.fullname, other.fullname)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }
}
