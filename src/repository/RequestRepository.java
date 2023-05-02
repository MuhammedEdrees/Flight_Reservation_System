package repository;

import java.util.ArrayList;
import model.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RequestRepository implements Repository<Request> {
    private Connection myconObj;
    private PreparedStatement mystatObj;
    private ResultSet myresObj;
    public RequestRepository(){
        myconObj = util.DbUtil.connectDB();
    }
    @Override
    public void create(Request request) {
        String createQuery = "INSERT INTO ROOT.REQUESTS VALUES (?,?,?,?,?)";
        request.setId(util.DbUtil.generateID("REQUESTS"));
        try{
            mystatObj = myconObj.prepareStatement(createQuery);
            mystatObj.setInt(1, request.getId());
            mystatObj.setString(2, request.getFullname());
            mystatObj.setString(3, request.getUsername());
            mystatObj.setString(4, request.getEmail());
            mystatObj.setString(5, request.getPhoneNumber());
            mystatObj.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public void read(Request request) {
        String loadQuery = "select * from ROOT.REQUESTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(loadQuery);
            mystatObj.setInt(1, request.getId());
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                request.setFullname(myresObj.getString(2));
                request.setUsername(myresObj.getString(3));
                request.setEmail(myresObj.getString(4));
                request.setPhoneNumber(myresObj.getString(5));
            }
        }catch(SQLException e){
        }
    }

    @Override
    public void update(Request request) {
        String updateQuery = "Update ROOT.REQUESTS Set Fullname = ?, Username = ?, Email = ?, PhoneNumber = ? where ID = ?";
        try {
            mystatObj = myconObj.prepareStatement(updateQuery);
            mystatObj.setString(1, request.getFullname());
            mystatObj.setString(2, request.getUsername());
            mystatObj.setString(3, request.getEmail());
            mystatObj.setString(4, request.getPhoneNumber());
            mystatObj.setInt(5, request.getId());
            mystatObj.executeUpdate();
        } catch (SQLException ex){}
    }

    @Override
    public void delete(Request request) {
        String deleteQuery = "Delete from ROOT.REQUESTS where id = " + String.valueOf(request.getId());
        try {
            Statement deleteStat = myconObj.createStatement();
            deleteStat.executeUpdate(deleteQuery);
        } catch (SQLException e){}
    }

    @Override
    public List<Request> getAll() {
        ArrayList<Request> list = new ArrayList<>();
        String fetchQuery = "select * from ROOT.REQUESTS";
        try {
            mystatObj= myconObj.prepareStatement(fetchQuery);
            myresObj = mystatObj.executeQuery();
            while (myresObj.next()){
                Request request = new Request();
                request.setId(myresObj.getInt(1));
                request.setFullname(myresObj.getString(2));
                request.setUsername(myresObj.getString(3));
                request.setEmail(myresObj.getString(4));
                request.setPhoneNumber(myresObj.getString(5));
                list.add(request);
            }
        } catch(SQLException e) {
        } 
        return list;
    }
    
}
