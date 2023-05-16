package controller;

import javax.swing.JOptionPane;
import model.Request;
import repository.RequestRepository;
import view.ForgottenPasswordView;
import view.LoginView;

/**
 *
 * @author Moaaz
 */
public class ForgottenPasswordController {
    ForgottenPasswordView view;
    String name ;
    String username ;
    String email ;
    String phoneNumber;
    public ForgottenPasswordController(ForgottenPasswordView view)
    {
        this.view=view;
    }
    public void handleSubmitButtonClicked()
    {
        name = view.getFullName();
        username = view.getUsername();
        email = view.getEmail();
        phoneNumber = view.getPhoneNumber();
        if (name.equals("") || username.equals("") || email.equals("") || phoneNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Complete missing data fields!");
        } else {
            Request req1=new Request(name, username, email, phoneNumber);
            RequestRepository reqRepo = new RequestRepository();
            reqRepo.create(req1);
            JOptionPane.showMessageDialog(null, "Submit sent successfully!");
        }
    }
    public void handleReturnToLoginButtonClicked()
    {
        new LoginView().setVisible(true);
        view.dispose();
    }
}
