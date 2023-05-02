package model;

import java.sql.Connection;

public class FlightAgent extends User {
    private Connection myconObj;
    
    public FlightAgent(int id) {
        super(id);
    }
    public FlightAgent(){
    }
    public FlightAgent(String fullname, String username, String password, String email) {
        super(fullname, username, password, email);
    }
    
//    private void createFlightAgent() {
//        String createQuery = "INSERT INTO ROOT.FLIGHTAGENTS VALUES (?,?,?,?,?)";
//        myconObj = connectDB();
//        try{
//            mystatObj = myconObj.prepareStatement(createQuery);
//            mystatObj.setInt(1, id);
//            mystatObj.setString(2, fullname);
//            mystatObj.setString(3, email);
//            mystatObj.setString(4, username);
//            mystatObj.setString(5, password);
//            mystatObj.executeUpdate();
//        }catch(SQLException e){}
//    }
//    public void create(){
//        this.id = generateID("FLIGHTAGENTS");
//        createFlightAgent();
//    }
//    public void update(){
//        String updateQuery = "Update ROOT.FLIGHTAGENTS Set Fullname = ?, Email = ?, Username = ?, Password = ? where ID = ?";
//        myconObj = connectDB();
//        try {
//            mystatObj = myconObj.prepareStatement(updateQuery);
//            mystatObj.setString(1, fullname);
//            mystatObj.setString(2, email);
//            mystatObj.setString(3, username);
//            mystatObj.setString(4, password);
//            mystatObj.setInt(5, id);
//            mystatObj.executeUpdate();
//        } catch (SQLException ex){}
//    }
//    public void read() {
//        String loadQuery = "select * from ROOT.FLIGHTAGENTS WHERE ID=?";
//        myconObj = connectDB();
//        try{
//            mystatObj= myconObj.prepareStatement(loadQuery);
//            mystatObj.setInt(1, id);
//            myresObj = mystatObj.executeQuery();
//            if (myresObj.next()){
//                this.fullname = myresObj.getString(2);
//                this.email = myresObj.getString(3);
//                this.username = myresObj.getString(4);
//                this.password = myresObj.getString(5);
//            }
//        }catch(SQLException e){
//        }
//    }
//    public void delete() {
//        String deleteQuery = "Delete from ROOT.FLIGHTAGENTS where id = " + String.valueOf(this.id);
//        myconObj = connectDB();
//        try {
//            Statement deleteStat = myconObj.createStatement();
//            deleteStat.executeUpdate(deleteQuery);
//        } catch (SQLException e){}
//    }
//}
}
    
