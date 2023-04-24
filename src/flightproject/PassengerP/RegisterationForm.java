
package flightproject.PassengerP;
import flightproject.LoginpGUI;
import java.util.Date;
import javax.swing.JOptionPane;
import data.Passenger;

public class RegisterationForm extends javax.swing.JFrame {
    private String fullName, username, password, rePassword, email, phoneNumber;
    private Date dateofBirth;
    private int id;
    public RegisterationForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        rePasswordLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        dateofBirthLabel = new javax.swing.JLabel();
        FullNameField = new javax.swing.JTextField();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        RePasswordField = new javax.swing.JPasswordField();
        EmailField = new javax.swing.JTextField();
        PhoneNumberField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        sideIconLabel = new javax.swing.JLabel();
        bottomLabel = new javax.swing.JLabel();
        signInLabel = new javax.swing.JLabel();
        BirthDateField = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        headerPanel.setBackground(new java.awt.Color(53, 146, 196));

        headerLabel.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setText("Create your account");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        nameLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 51, 51));
        nameLabel.setText("Full Name");

        usernameLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(51, 51, 51));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(51, 51, 51));
        passwordLabel.setText("Password");

        rePasswordLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        rePasswordLabel.setForeground(new java.awt.Color(51, 51, 51));
        rePasswordLabel.setText("Re-type Password");

        emailLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(51, 51, 51));
        emailLabel.setText("E-mail");

        phoneNumberLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(51, 51, 51));
        phoneNumberLabel.setText("Phone Number");

        dateofBirthLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        dateofBirthLabel.setForeground(new java.awt.Color(51, 51, 51));
        dateofBirthLabel.setText("Date of Birth");

        FullNameField.setBackground(new java.awt.Color(254, 254, 254));
        FullNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FullNameField.setForeground(new java.awt.Color(51, 51, 51));

        UsernameField.setBackground(new java.awt.Color(254, 254, 254));
        UsernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(51, 51, 51));

        PasswordField.setBackground(new java.awt.Color(254, 254, 254));
        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(51, 51, 51));

        RePasswordField.setBackground(new java.awt.Color(254, 254, 254));
        RePasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RePasswordField.setForeground(new java.awt.Color(51, 51, 51));

        EmailField.setBackground(new java.awt.Color(254, 254, 254));
        EmailField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EmailField.setForeground(new java.awt.Color(51, 51, 51));

        PhoneNumberField.setBackground(new java.awt.Color(254, 254, 254));
        PhoneNumberField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PhoneNumberField.setForeground(new java.awt.Color(51, 51, 51));

        registerButton.setBackground(new java.awt.Color(53, 146, 196));
        registerButton.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        registerButton.setForeground(new java.awt.Color(241, 241, 241));
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        sideIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePanel2.png"))); // NOI18N

        bottomLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        bottomLabel.setForeground(new java.awt.Color(51, 51, 51));
        bottomLabel.setText("Already have an account?");

        signInLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        signInLabel.setForeground(new java.awt.Color(53, 146, 196));
        signInLabel.setText("Sign In");
        signInLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInLabelMouseClicked(evt);
            }
        });

        BirthDateField.setBackground(new java.awt.Color(254, 254, 254));
        BirthDateField.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(sideIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addGap(106, 106, 106)
                                .addComponent(UsernameField))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(106, 106, 106)
                                .addComponent(FullNameField))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordLabel)
                                    .addComponent(rePasswordLabel)
                                    .addComponent(emailLabel)
                                    .addComponent(phoneNumberLabel)
                                    .addComponent(dateofBirthLabel))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PasswordField)
                                    .addComponent(RePasswordField)
                                    .addComponent(EmailField)
                                    .addComponent(PhoneNumberField)
                                    .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(bottomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(BirthDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(nameLabel)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(usernameLabel)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(UsernameField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rePasswordLabel)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(RePasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNumberLabel)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(PhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateofBirthLabel)
                    .addComponent(BirthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottomLabel)
                    .addComponent(signInLabel))
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(sideIconLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        //assign each data field to a corrosponding variable
        fullName = FullNameField.getText().trim();
        username = UsernameField.getText().trim();
        password = PasswordField.getText();
        rePassword = RePasswordField.getText();
        email = EmailField.getText().trim();
        phoneNumber = PhoneNumberField.getText().trim();
        dateofBirth = BirthDateField.getDate();
        //Check if all data fields are filled with data.
        if (fullName.equals("") || username.equals("") || password.equals("") || rePassword.equals("") || email.equals("") || phoneNumber.equals("")){
            JOptionPane.showMessageDialog(null, "Please Complete missing data fields!");
        }else{
            //Check if passwords are matched
            if(password.equals(rePassword)){
                    //add entry to the USERS database and go back to Login UI
                    Passenger pass1 = new Passenger(fullName, username, password, dateofBirth, phoneNumber, email);
                    JOptionPane.showMessageDialog(null, "Registeration was successfull!");
                    dispose();
                    new LoginpGUI().setVisible(true);
            } else{
                JOptionPane.showMessageDialog(null, "Passwords doesn't Match!");
            }
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void signInLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInLabelMouseClicked
        dispose();
        new LoginpGUI().setVisible(true);
    }//GEN-LAST:event_signInLabelMouseClicked
          
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser BirthDateField;
    private javax.swing.JTextField EmailField;
    private javax.swing.JTextField FullNameField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField PhoneNumberField;
    private javax.swing.JPasswordField RePasswordField;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel bottomLabel;
    private javax.swing.JLabel dateofBirthLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel rePasswordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel sideIconLabel;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
