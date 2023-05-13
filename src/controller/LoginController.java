package controller;

import flightproject.flightProject;
import javax.swing.JOptionPane;
import view.LoginView;
import repository.PassengerRepository;
import repository.FlightAgentRepository;
import repository.AdminRepository;
import model.Passenger;
import model.Admin;
import model.FlightAgent;
import view.AdminView;
import view.FlightAgentView;
import view.WelcomeScreen;
/**
 *
 * @author Moaaz
 */
public class LoginController {
    
    LoginView view=new LoginView();
    
    public void handleSignInButtonClick()
    {
        String username=view.getLogUsername();
        String password=view.getLogPassword();
        
       PassengerRepository passRepo =new PassengerRepository();
       FlightAgentRepository agentRepo=new FlightAgentRepository();
       AdminRepository adminRepo=new AdminRepository();
       Passenger pass1=new Passenger();
       FlightAgent agent1=new FlightAgent();
       Admin admin1=new Admin();
       pass1= passRepo.findByUsername(username);
       agent1 = agentRepo.findByUsername(username);
       admin1= adminRepo.findByUsername(username);
        
       if(pass1.getId()!= -1)
       {
           flightProject.currentUserID = pass1.getId();
            if(password.equals(pass1.getPassword())){
                new WelcomeScreen().setVisible(true);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Password!");
            }
       }
       else if(agent1.getId()!= -1){
            flightProject.currentUserID = agent1.getId();
            if(password.equals(agent1.getPassword())){
                new FlightAgentView().setVisible(true);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Password!");
            }
        }
       else if(admin1.getId() != -1){
            flightProject.currentUserID = admin1.getId();
            if(password.equals(admin1.getPassword())){
                new AdminView().setVisible(true);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Password!");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Username doesn't exist!");
        }
    }
    
}
