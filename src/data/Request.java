package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static utils.DbUtils.connectDB;
import java.sql.SQLException;
import java.sql.Statement;
import static utils.DbUtils.generateID;

public class Request implements DataEntity{  
    private String phoneNumber,username, fullname, email;
    private int id;
    
    Connection myconObj = connectDB();
    PreparedStatement mystatObj;
    ResultSet myresObj;
    
    public Request (String fullname, String username, String email, String phonenumber)
    {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phonenumber;
        store();
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
        load();
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        update();
    }
    public String getFullname() {
        load();
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
        update();
    }
    public String getEmail() {
        load();
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
        update();
    }
    public int getId() {
        load();
        return id;
    }
    public String getPhoneNumber() {
        load();
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        update();
    }
    
    @Override
    public void store(){
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
    public void load() {
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
    
    
    
}
