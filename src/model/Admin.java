package model;



public class Admin extends User {
    
    public Admin () {    
    }
    
    public Admin (int id) {
        super(id);
    }
    
    public Admin (String fullname, String username, String password, String email) {
        super(fullname, username, password, email);
    }
}
