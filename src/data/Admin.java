package data;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import static utils.DbUtils.*;


public class Admin extends User {
    Connection myconObj;
    PreparedStatement mystatObj;
    ResultSet myresObj;
    public Admin(int id) {
        super(id);
    }
    public Admin(String fullname, String username, String password, String email) {
        super(fullname, username, password, email);
    }
    private void createFlightAgent() {
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
    @Override
    public void store(){
        this.id = generateID("ADMINS");
        createFlightAgent();
    }
    @Override
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
        } catch (SQLException ex){}
    }
    @Override
    public void load() {
        myconObj = connectDB();
        String loadQuery = "select * from ROOT.ADMINS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                this.username = myresObj.getString(2);
                this.password = myresObj.getString(3);
                this.fullname = myresObj.getString(4);
                this.email = myresObj.getString(5);
            }
        }catch(SQLException e){
        }
    }
    @Override
    public void delete() {
        String deleteQuery = "Delete from ROOT.ADMINS where id = " + String.valueOf(this.id);
        myconObj = connectDB();
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }
}
