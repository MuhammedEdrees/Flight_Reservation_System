package model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.lang.Exception;
import static util.DbUtil.*;


public class Admin extends User {
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    public Admin(int id) {
        super(id);
    }
    public Admin(String username)
    {
        String query = "select * from ROOT.ADMINS WHERE USERNAME=?";
        myconObj = connectDB();
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, username);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                id= myresObj.getInt(1);
            }
        }catch(SQLException e){
        }
    }
    public Admin(String fullname, String username, String password, String email) {
        super(fullname, username, password, email);
    }
    private void createAdmin() {
        String createQuery = "INSERT INTO ROOT.ADMINS VALUES (?,?,?,?,?)";
        myconObj = connectDB();
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, id);
            mystatObj.setString(2, username);
            mystatObj.setString(3, password);
            mystatObj.setString(4, fullname);
            mystatObj.setString(5, email);
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }
    public void create(){
        this.id = generateID("ADMINS");
        createAdmin();
    }
    public void update(){
        String updateQuery = "Update ROOT.ADMINS Set Username = ?, Password = ?, Fullname = ?, Email = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, username);
            mystatObj.setString(2, password);
            mystatObj.setString(3, fullname);
            mystatObj.setString(4, email);
            mystatObj.setInt(5, id);
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }
    public void read() throws Exception{
        myconObj = connectDB();
        String readQuery = "select * from ROOT.ADMINS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(readQuery);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                this.username = myresObj.getString(2);
                this.password = myresObj.getString(3);
                this.fullname = myresObj.getString(4);
                this.email = myresObj.getString(5);
            } else{
                throw new Exception("No entry with matching id was found in the database");
            }
        }catch(SQLException e){
        }
    }
    public void delete() {
        String deleteQuery = "Delete from ROOT.ADMINS where id = " + String.valueOf(this.id);
        myconObj = connectDB();
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }
}
