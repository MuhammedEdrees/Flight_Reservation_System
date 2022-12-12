/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightproject.FlightAgentP;
import flightproject.FlightAgentP.FlightAgentModel;
import flightproject.DBConnection;
import flightproject.flightProject;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Mahmoud Rabea
 */
public class FlightAgent {
    private static final Connection myconObj = (Connection) DBConnection.connectDB();
    private static PreparedStatement mystatObj = null;
    private static ResultSet myresObj = null;
   

public  static ArrayList<FlightAgentModel> getFlightAgents (){

 String query = "select * from ROOT.FLIGHTAGENTS";
        try{
            mystatObj= myconObj.prepareStatement(query);
            myresObj = mystatObj.executeQuery();
           /* if (myresObj.next()){
               System.out.println(myresObj.first());
            }*/
            ArrayList<FlightAgentModel> agentsList = new ArrayList<>();
            while(myresObj.next()){
                        FlightAgentModel flightagent;
                flightagent = new FlightAgentModel(
                        myresObj.getString(1),
                        myresObj.getString(2),
                        myresObj.getString(4),
                        myresObj.getString(3)
                );
                         agentsList.add(flightagent);
            }
            return agentsList;
        }catch(SQLException e){
            System.out.print(e);
        }
        return null;
       
}
public static void deleteFlightAgent(String id){

 String query = "DELETE FROM ROOT.FLIGHTAGENTS  WHERE ID ="+id;
        try{
            mystatObj= myconObj.prepareStatement(query);
           mystatObj.executeUpdate();
        }catch(SQLException e){
            System.out.print(e);
        }
      
       
}

public static void addNewFlightAgent(String name,String email ,String username,String password){
    int id = FlightAgentModel.generateID();
    
String query = "INSERT INTO ROOT.FLIGHTAGENTS (id,full_name, email, username,password) VALUES ("+id+",'"+name+"','"+email+"','"+username+"','"+password+"')";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.executeUpdate();
        }catch(SQLException e){
            System.out.print(e);
        }
      
       
}

public static void updateFlightAgent(String id,String name,String email ,String username,String password){
    

 String query = "UPDATE ROOT.FLIGHTAGENTS SET full_name='"+name+"',email='"+email+"',username='"+username+"'"+"',password='"+password+"'"+" WHERE ID ="+id;
           System.out.println(query);
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.executeUpdate();
        }catch(SQLException e){
            System.out.print(e);
        }
      
       
}
public static int getID(String username){
        String query = "select * from ROOT.FLIGHTAGENTS WHERE USERNAME=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setString(1, username);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getInt(1);
            }
            return -1;
        }catch(SQLException e){
            return -1;
        }
    }
public static String getPassword(int id){
        String query = "select * from ROOT.FLIGHTAGENTS WHERE ID=?";
        try{
            mystatObj= myconObj.prepareStatement(query);
            mystatObj.setInt(1, id);
            myresObj = mystatObj.executeQuery();
            if (myresObj.next()){
                return myresObj.getString(5);
            }
            return "notFound";
        }catch(SQLException e){
            return "notFound";
        }
    }

}

