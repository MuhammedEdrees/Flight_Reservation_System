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
    ForgottenPasswordView view = new ForgottenPasswordView();
    String name = view.getFullName();
    String username = view.getUsername();
    String email = view.getEmail();
    String phoneNumber = view.getPhoneNumber();
    public void handleSubmitButtonClicked()
    {
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
