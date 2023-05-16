package controller;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Passenger;
import repository.PassengerRepository;
import view.LoginView;
import view.RegisterationView;
import util.Validation;
/**
 *
 * @author Moaaz
 */
public class RegisterationController {
    Validation valid1=new Validation();
    RegisterationView view;
    String fullname;
    String username;
    String password ;
    String rePassword ;
    String email;
    String phoneNumber;
    Date dateofBirth;
    public RegisterationController(RegisterationView view)
    {
        this.view=view;
    }
    public void handleRegisterButtonClicked ()
    {
        fullname = view.getFullName();
        username = view.getUsername();
        password = view.getPassword();
        rePassword = view.getRePassword();
        email = view.getEmail();
        phoneNumber = view.getPhoneNumber();
        dateofBirth = view.getBirthDate();
        if (fullname.equals("") || username.equals("") || password.equals("") || rePassword.equals("") || email.equals("") || phoneNumber.equals("")){
            JOptionPane.showMessageDialog(null, "Please Complete missing data fields!");
        }else if(!valid1.validateFullname(fullname))
        {
            JOptionPane.showMessageDialog(view, "Fullname is invalid! Please enter your fullname correctly.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(!valid1.validateUsername(username))
        {
            JOptionPane.showMessageDialog(view, "Username is invalid! Please enter a correct username.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(!valid1.validatePassword(password))
        {
            JOptionPane.showMessageDialog(view, "Password is invalid! Please enter a correct password (password has to include: -special character -number -capital letter -more that 8 characters).", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(!password.equals(rePassword))
        {
            JOptionPane.showMessageDialog(view, "Password is invalid! The repassword has to match the password field.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(!valid1.validateEmail(email))
        {
            JOptionPane.showMessageDialog(view, "Email is invalid! Please enter your email correctly!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(!valid1.validatePhoneNumber(phoneNumber))
        {
            JOptionPane.showMessageDialog(view, "Phonenumber is invalid! Please enter your phonenumber correctly.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(!valid1.validateDateOfBirth(dateofBirth))
        {
            JOptionPane.showMessageDialog(view, "Date of birth is invalid! Users have to be at least 18 years old.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Passenger pass1 = new Passenger(fullname, username, password, dateofBirth, phoneNumber, email);
            PassengerRepository passRepo = new PassengerRepository();
            passRepo.create(pass1);
            JOptionPane.showMessageDialog(null, "Registeration was successfull!");
            view.dispose();
            new LoginView().setVisible(true);  
        }
    }
}
