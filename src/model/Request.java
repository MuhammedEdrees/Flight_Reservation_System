package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import static util.DbUtil.connectDB;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import static util.DbUtil.generateID;

public class Request implements DataEntity{  
    private String phoneNumber,username, fullname, email;
    private int id;
    
    Connection myconObj = connectDB();
    PreparedStatement mystatObj;
    ResultSet myresObj;
    
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
    private void createRequest(){
        String createQuery = "INSERT INTO ROOT.REQUESTS VALUES (?,?,?,?,?)";
        myconObj = connectDB();
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, id);
            mystatObj.setString(2, fullname);
            mystatObj.setString(3, username);
            mystatObj.setString(4, email);
            mystatObj.setString(5, phoneNumber);
            mystatObj.executeUpdate();
        }catch(SQLException e){}
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
    public int getId() {
        return id;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void create(){
        this.id = generateID("REQUESTS");
        createRequest();
    }
    @Override
    public void update(){
        String updateQuery = "Update ROOT.REQUESTS Set Fullname = ?, Username = ?, Email = ?, PhoneNumber = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, fullname);
            mystatObj.setString(2, username);
            mystatObj.setString(3, email);
            mystatObj.setString(4, phoneNumber);
            mystatObj.setInt(5, id);
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }
    @Override
    public void read() throws Exception {
        String loadQuery = "select * from ROOT.REQUESTS WHERE ID=?";
        myconObj = connectDB();
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                this.fullname = myresObj.getString(2);
                this.username = myresObj.getString(3);
                this.email = myresObj.getString(4);
                this.phoneNumber = myresObj.getString(5);
            } else {
                throw new Exception("No matching entry was found in the database.");
            }
        }catch(SQLException e){
        }
    }
    @Override
    public void delete() {
        String deleteQuery = "Delete from ROOT.REQUESTS where id = " + String.valueOf(this.id);
        myconObj = connectDB();
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
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
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.myconObj, other.myconObj)) {
            return false;
        }
        if (!Objects.equals(this.mystatObj, other.mystatObj)) {
            return false;
        }
        return Objects.equals(this.myresObj, other.myresObj);
    }
    
    
    
}
