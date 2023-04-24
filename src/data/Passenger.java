package data;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import static util.DbUtil.*;
public class Passenger extends User {
    private Date dateOfBirth;
    private String phoneNumber;
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    public Passenger(int id) {
        super(id);
    }
    public Passenger(String username)
    {
        String query = "select * from ROOT.PASSENGERS WHERE USERNAME=?";
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
    public Passenger(String fullname, String username, String password, Date dateOfBirth, String phonenumber, String email) {
        super();
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phonenumber;
        this.email = email;
        store();
    }
    public Date getDateOfBirth() {
        load();
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        update();
    }
    public String getPhoneNumber() {
        load();
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        update();
    }
    
    public int getID(){
        load();
        return id;
//        String query = "select * from ROOT.PASSENGERS WHERE USERNAME=?";
//        Connection myconObj = connectDB();
//        PreparedStatement mystatObj;
//        ResultSet myresObj;
//        try{
//            mystatObj= myconObj.prepareStatement(query);
//            mystatObj.setString(1, username);
//            myresObj = mystatObj.executeQuery();
//            if (myresObj.next()){
//                return myresObj.getInt(1);
//            }
//        }catch(SQLException e){
//        }
//        return -1;
    }
    //insert new entry to the passengers table
    private void createPassenger(){
        String createQuery = "INSERT INTO ROOT.PASSENGERS VALUES (?,?,?,?,?,?,?)";
        myconObj = connectDB();
        java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, id);
            mystatObj.setString(2, fullname);
            mystatObj.setString(3, username);
            mystatObj.setString(4, password);
            mystatObj.setDate(5, sqlDate);
            mystatObj.setString(6, phoneNumber);
            mystatObj.setString(7, email);
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }
    @Override
    public void store() {
        this.id = generateID("PASSENGERS");
        createPassenger();
    }
    @Override
    public void load() {
        String loadQuery = "select * from ROOT.PASSENGERS WHERE ID=?";
        myconObj = connectDB();
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                this.fullname = myresObj.getString(2);
                this.username = myresObj.getString(3);
                this.password = myresObj.getString(4);
                this.dateOfBirth = new Date(myresObj.getDate(5).getTime());
                this.phoneNumber = myresObj.getString(6);
                this.email = myresObj.getString(7);
            }
        }catch(SQLException e){
        }
    }
    @Override
    public void update() {
        String updateQuery = "Update ROOT.PASSENGERS Set Fullname = ?, Username = ?, Password = ?, DateOfBirth = ?, PhoneNumber = ?, Email = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, fullname);
            mystatObj.setString(2, username);
            mystatObj.setString(3, password);
            mystatObj.setDate(4, new java.sql.Date(dateOfBirth.getTime()));
            mystatObj.setString(5, phoneNumber);
            mystatObj.setString(6, email);
            mystatObj.setInt(7, id);
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }   
    @Override
    public void delete(){
        String deleteQuery = "Delete from ROOT.PASSENGERS where id = " + String.valueOf(this.id);
        myconObj = connectDB();
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }
}
