package repository;

import model.Admin;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static util.DbUtil.connectDB;

public class AdminRepository implements Repository<Admin> {
    
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    
    public AdminRepository() {
        myconObj = util.DbUtil.connectDB();
    }

    @Override
    public void create(Admin admin) {
       String createQuery = "INSERT INTO ROOT.ADMINS VALUES (?,?,?,?,?)";
        admin.setId(util.DbUtil.generateID("admins"));
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, admin.getId());
            mystatObj.setString(2, admin.getUsername());
            mystatObj.setString(3, admin.getPassword());
            mystatObj.setString(4, admin.getFullname());
            mystatObj.setString(5, admin.getEmail());
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public void read(Admin admin) {
        String loadQuery = "select * from ROOT.ADMINS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, admin.getId());
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                admin.setUsername(myresObj.getString(2));
                admin.setPassword(myresObj.getString(3));
                admin.setFullname(myresObj.getString(4));
                admin.setEmail(myresObj.getString(5));
            }
        }catch(SQLException e){}
    }

    @Override
    public void update(Admin admin) {
        String updateQuery = "Update ROOT.ADMINS Set Username = ?, Password = ?, Fullname = ?, Email = ? where ID = ?";
        myconObj = connectDB();
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, admin.getUsername());
            mystatObj.setString(2, admin.getPassword());
            mystatObj.setString(3, admin.getFullname());
            mystatObj.setString(4, admin.getEmail());
            mystatObj.setInt(5, admin.getId());
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }

    @Override
    public void delete(Admin admin) {
     String deleteQuery = "Delete from ROOT.ADMINS where id = " + String.valueOf(admin.getId());
         try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }

    @Override
    public ArrayList<Admin> getAll() {
        ArrayList<Admin> adminsList = new ArrayList<>();
        return adminsList;
    }
   
}
