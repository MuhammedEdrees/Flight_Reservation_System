package view;

import flightproject.flightProject;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import swing.DataSearch;
import swing.EventClick;
import swing.PanelSearch;
import util.DbUtil;
import util.Constants;
import model.Flight;
import model.Reservation;
import model.Payment;
import controller.PassengerController;

public class PassengerView extends javax.swing.JFrame {

    private PanelSearch fromSearch;
    private PanelSearch toSearch;
    private JPopupMenu fromMenu;
    private JPopupMenu toMenu;
    private ArrayList<Flight> matchingFlightsList;
    private int flightID, reservationNumberOfSeats,flightAvailableSeats, reservationId, paymentId;
    private double flightBasePrice, paymentAmount;
    private String firstName, surname, nationality, reservationClass, passportNumber, cardType, cardNumber, cardHolderName, cardCVV;
    private java.util.Date passportExpiryDate, cardExpiryDate;
    private String dataStory[] = {"Cairo", "Alexandria", "Paris", "London", "New York"};
    private PassengerController controller;
   
    public PassengerView() {
        this.matchingFlightsList = new ArrayList<>();
        this.controller = new PassengerController(this);
        initComponents();
        CountriesField.setModel(new DefaultComboBoxModel<>(Constants.countries));
        //show flights as default and hide other panels
        FlightSearchingPanel.setVisible(true);
        BookingsPanel.setVisible(false);
        ReservationDetailsPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        ContinueToReservationPanelButton.setVisible(false);
        resultLabel.setVisible(false);
        searchPanel.setVisible(false);
       //highlight home tab button and set other tab buttons to normal colors
        flightsTab.setBackground(new Color (94, 170, 211));
        bookingsTab.setBackground(new Color (53, 146, 196));
        fromSearch = new PanelSearch();
        toSearch = new PanelSearch();
        toMenu = new JPopupMenu();
        fromMenu = new JPopupMenu();
        fromMenu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        fromMenu.add(fromSearch);
        fromMenu.setFocusable(false);
        fromSearch.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                fromMenu.setVisible(false);
                fromSearchTxt.setText(data.getText());
                
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                fromSearch.remove(com);
                removeHistory(data.getText());
                fromMenu.setPopupSize(fromMenu.getWidth(), (fromSearch.getItemSize()));
                if (fromSearch.getItemSize() == 0) {
                    fromMenu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
            
        });
        toMenu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        toMenu.add(toSearch);
        toMenu.setFocusable(false);
        toSearch.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                toMenu.setVisible(false);
                toSearchTxt.setText(data.getText());
                
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                toSearch.remove(com);
                removeHistory(data.getText());
                toMenu.setPopupSize(toMenu.getWidth(), (toSearch.getItemSize() * 35) + 2);
                if (toSearch.getItemSize() == 0) {
                    toMenu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
        reservationTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD , 12));
        reservationTable.getTableHeader().setOpaque(false);
        reservationTable.getTableHeader().setBackground(new Color(53, 146, 196));
        reservationTable.getTableHeader().setForeground(new Color(51,51,51));
        reservationTable.setRowHeight(25);
        searchTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD , 12));
        searchTable.getTableHeader().setOpaque(false);
        searchTable.getTableHeader().setBackground(new Color(53, 146, 196));
        searchTable.getTableHeader().setForeground(new Color(51,51,51));
        searchTable.setRowHeight(25);
        showReservationError(0);
        showPaymentError(0);
    }
    
    
    private void clearPaymentFields(){
        cardNumberField.setText("");
        cardHolderNameField.setText("");
        cardCVVField.setText("");
        cardExpiryDateChooser.setDate(null);
    }
    
    private void clearReservationFields(){
        surNameField.setText("");
        firstNameField.setText("");
        numberOfSeatsField.setText("");
        passportNumberField.setText("");
        passportExpiryDateField.setDate(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClassButtonGroup = new javax.swing.ButtonGroup();
        CardTypeButtonGroup = new javax.swing.ButtonGroup();
        menuPanel = new javax.swing.JPanel();
        flightsTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bookingsTab = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        PaymentPanel = new javax.swing.JPanel();
        backButton2 = new javax.swing.JButton();
        cardNumberLabel = new javax.swing.JLabel();
        cardHolderNameLabel = new javax.swing.JLabel();
        CVVLabel = new javax.swing.JLabel();
        expirationDateLabel = new javax.swing.JLabel();
        cardNumberField = new javax.swing.JTextField();
        cardHolderNameField = new javax.swing.JTextField();
        cardCVVField = new javax.swing.JTextField();
        submitReservationButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        cardExpiryDateChooser = new com.toedter.calendar.JDateChooser();
        invalidNo = new javax.swing.JLabel();
        invalidcvv = new javax.swing.JLabel();
        headerLabel1 = new javax.swing.JLabel();
        visaButton = new javax.swing.JRadioButton();
        mastercardButton = new javax.swing.JRadioButton();
        visaLabel = new javax.swing.JLabel();
        mastercardLabel = new javax.swing.JLabel();
        cardTypeLabel = new javax.swing.JLabel();
        invalidCardName = new javax.swing.JLabel();
        invalidCardExpiryDate = new javax.swing.JLabel();
        FlightSearchingPanel = new javax.swing.JPanel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        fromSearchTxt = new swing.MyTextField();
        toSearchTxt = new swing.MyTextField();
        departDateLabel = new javax.swing.JLabel();
        HeaderLabel = new javax.swing.JLabel();
        Header2Label = new javax.swing.JLabel();
        SearchFlightsButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        ContinueToReservationPanelButton = new javax.swing.JButton();
        flightDate = new com.toedter.calendar.JDateChooser();
        resultLabel = new javax.swing.JLabel();
        ReservationDetailsPanel = new javax.swing.JPanel();
        firstNameField = new javax.swing.JTextField();
        numberOfSeatsLabel = new javax.swing.JLabel();
        surNameField = new javax.swing.JTextField();
        submitPassengerInfo = new javax.swing.JButton();
        firstNameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        nationalityLabel = new javax.swing.JLabel();
        CountriesField = new javax.swing.JComboBox<>();
        passportNumberField = new javax.swing.JTextField();
        passportExpiryDateField = new com.toedter.calendar.JDateChooser();
        passportNumberLabel = new javax.swing.JLabel();
        passprotExpiryDateLabel = new javax.swing.JLabel();
        numberOfSeatsField = new javax.swing.JTextField();
        headerLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        firstClassButton = new javax.swing.JRadioButton();
        bussinessClassButton = new javax.swing.JRadioButton();
        economyClassButton = new javax.swing.JRadioButton();
        backButton1 = new javax.swing.JButton();
        invalidFirstName = new javax.swing.JLabel();
        invalidSurname = new javax.swing.JLabel();
        invalidNationality = new javax.swing.JLabel();
        invalidNumOfSeats = new javax.swing.JLabel();
        invalidResClass = new javax.swing.JLabel();
        invalidPassExpiryDate = new javax.swing.JLabel();
        invalidPassportNum = new javax.swing.JLabel();
        BookingsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        reservationIdRemoveTxt = new javax.swing.JTextField();
        cancelReservationButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        menuPanel.setBackground(new java.awt.Color(53, 146, 196));

        flightsTab.setBackground(new java.awt.Color(53, 146, 196));
        flightsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flightsTabMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Flights");

        javax.swing.GroupLayout flightsTabLayout = new javax.swing.GroupLayout(flightsTab);
        flightsTab.setLayout(flightsTabLayout);
        flightsTabLayout.setHorizontalGroup(
            flightsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightsTabLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        flightsTabLayout.setVerticalGroup(
            flightsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, flightsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        bookingsTab.setBackground(new java.awt.Color(53, 146, 196));
        bookingsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingsTabMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Bookings");

        javax.swing.GroupLayout bookingsTabLayout = new javax.swing.GroupLayout(bookingsTab);
        bookingsTab.setLayout(bookingsTabLayout);
        bookingsTabLayout.setHorizontalGroup(
            bookingsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingsTabLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        bookingsTabLayout.setVerticalGroup(
            bookingsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookingsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(flightsTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bookingsTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(flightsTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookingsTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );

        PaymentPanel.setBackground(new java.awt.Color(231, 231, 231));

        backButton2.setBackground(new java.awt.Color(255, 255, 255));
        backButton2.setFont(new java.awt.Font("Hacen Vanilla", 1, 12)); // NOI18N
        backButton2.setForeground(new java.awt.Color(255, 255, 255));
        backButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backButtonImage4025.png"))); // NOI18N
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

        cardNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cardNumberLabel.setForeground(new java.awt.Color(51, 51, 51));
        cardNumberLabel.setText("Card Number");

        cardHolderNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cardHolderNameLabel.setForeground(new java.awt.Color(51, 51, 51));
        cardHolderNameLabel.setText("Card Holder Name");

        CVVLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CVVLabel.setForeground(new java.awt.Color(51, 51, 51));
        CVVLabel.setText("CVV");

        expirationDateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        expirationDateLabel.setForeground(new java.awt.Color(51, 51, 51));
        expirationDateLabel.setText("Expiration Date");

        cardNumberField.setBackground(new java.awt.Color(254, 254, 254));
        cardNumberField.setForeground(new java.awt.Color(51, 51, 51));

        cardHolderNameField.setBackground(new java.awt.Color(254, 254, 254));
        cardHolderNameField.setForeground(new java.awt.Color(51, 51, 51));

        cardCVVField.setBackground(new java.awt.Color(254, 254, 254));
        cardCVVField.setForeground(new java.awt.Color(51, 51, 51));

        submitReservationButton.setBackground(new java.awt.Color(34, 34, 34));
        submitReservationButton.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        submitReservationButton.setForeground(new java.awt.Color(254, 254, 254));
        submitReservationButton.setText("Pay and Book");
        submitReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitReservationButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(153, 0, 0));
        cancelButton.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        cancelButton.setText("Cancel Reservation");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        cardExpiryDateChooser.setForeground(new java.awt.Color(51, 51, 51));

        invalidNo.setForeground(new java.awt.Color(255, 0, 0));
        invalidNo.setText("Invalid Number");

        invalidcvv.setForeground(new java.awt.Color(250, 0, 0));
        invalidcvv.setText("Invalid value");

        headerLabel1.setFont(new java.awt.Font("Roboto", 1, 64)); // NOI18N
        headerLabel1.setForeground(new java.awt.Color(51, 51, 51));
        headerLabel1.setText("Payment Method");

        visaButton.setBackground(new java.awt.Color(231, 231, 231));
        CardTypeButtonGroup.add(visaButton);

        mastercardButton.setBackground(new java.awt.Color(231, 231, 231));
        CardTypeButtonGroup.add(mastercardButton);

        visaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VisaLogoImg100_40.png"))); // NOI18N

        mastercardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MasterCardLogoImg65_40.png"))); // NOI18N

        cardTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cardTypeLabel.setForeground(new java.awt.Color(51, 51, 51));
        cardTypeLabel.setText("Card Type");

        invalidCardName.setForeground(new java.awt.Color(255, 0, 0));
        invalidCardName.setText("Invalid Name");

        invalidCardExpiryDate.setForeground(new java.awt.Color(255, 0, 0));
        invalidCardExpiryDate.setText("Invalid Date");

        javax.swing.GroupLayout PaymentPanelLayout = new javax.swing.GroupLayout(PaymentPanel);
        PaymentPanel.setLayout(PaymentPanelLayout);
        PaymentPanelLayout.setHorizontalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentPanelLayout.createSequentialGroup()
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaymentPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(headerLabel1))
                    .addGroup(PaymentPanelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expirationDateLabel)
                            .addComponent(CVVLabel)
                            .addGroup(PaymentPanelLayout.createSequentialGroup()
                                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cardHolderNameLabel)
                                    .addComponent(cardNumberLabel)
                                    .addComponent(cardTypeLabel))
                                .addGap(37, 37, 37)
                                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(PaymentPanelLayout.createSequentialGroup()
                                            .addGap(27, 27, 27)
                                            .addComponent(visaButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(visaLabel)
                                            .addGap(27, 27, 27)
                                            .addComponent(mastercardButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(mastercardLabel))
                                        .addComponent(cardHolderNameField)
                                        .addComponent(cardCVVField)
                                        .addComponent(cardExpiryDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                        .addComponent(cardNumberField)
                                        .addComponent(invalidNo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(invalidcvv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(invalidCardName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invalidCardExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PaymentPanelLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(submitReservationButton)
                        .addGap(74, 74, 74)
                        .addComponent(cancelButton)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        PaymentPanelLayout.setVerticalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cardTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mastercardLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentPanelLayout.createSequentialGroup()
                            .addComponent(mastercardButton)
                            .addGap(10, 10, 10)))
                    .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(visaLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentPanelLayout.createSequentialGroup()
                            .addComponent(visaButton)
                            .addGap(9, 9, 9))))
                .addGap(18, 18, 18)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumberLabel)
                    .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardHolderNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardHolderNameLabel))
                .addGap(3, 3, 3)
                .addComponent(invalidCardName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CVVLabel)
                    .addComponent(cardCVVField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidcvv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardExpiryDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expirationDateLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(2, 2, 2)
                .addComponent(invalidCardExpiryDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        FlightSearchingPanel.setBackground(new java.awt.Color(231, 231, 231));

        fromLabel.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        fromLabel.setForeground(new java.awt.Color(53, 146, 196));
        fromLabel.setText("From");

        toLabel.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        toLabel.setForeground(new java.awt.Color(53, 146, 196));
        toLabel.setText("To");

        fromSearchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromSearchTxtMouseClicked(evt);
            }
        });
        fromSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fromSearchTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromSearchTxtKeyReleased(evt);
            }
        });

        toSearchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toSearchTxtMouseClicked(evt);
            }
        });
        toSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                toSearchTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toSearchTxtKeyReleased(evt);
            }
        });

        departDateLabel.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        departDateLabel.setForeground(new java.awt.Color(53, 146, 196));
        departDateLabel.setText("Depart Date ");

        HeaderLabel.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        HeaderLabel.setForeground(new java.awt.Color(53, 146, 196));
        HeaderLabel.setText("Fill the form below to see the best flight tickets.");

        Header2Label.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        Header2Label.setForeground(new java.awt.Color(53, 146, 196));
        Header2Label.setText("Where Do You Want To Travel?");

        SearchFlightsButton.setBackground(new java.awt.Color(56, 146, 196));
        SearchFlightsButton.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        SearchFlightsButton.setText("Search");
        SearchFlightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFlightsButtonActionPerformed(evt);
            }
        });

        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "Airline", "Departure Airport", "Arrival Airport", "Flight date", "Departure Time", "Flight Duration"
            }
        ));
        searchPanel.setViewportView(searchTable);

        ContinueToReservationPanelButton.setBackground(new java.awt.Color(53, 146, 196));
        ContinueToReservationPanelButton.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        ContinueToReservationPanelButton.setText("Continue");
        ContinueToReservationPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueToReservationPanelButtonActionPerformed(evt);
            }
        });

        resultLabel.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(53, 146, 196));
        resultLabel.setText("Pick a Flight and Press Continue:");

        javax.swing.GroupLayout FlightSearchingPanelLayout = new javax.swing.GroupLayout(FlightSearchingPanel);
        FlightSearchingPanel.setLayout(FlightSearchingPanelLayout);
        FlightSearchingPanelLayout.setHorizontalGroup(
            FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightSearchingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPanel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightSearchingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightSearchingPanelLayout.createSequentialGroup()
                        .addComponent(SearchFlightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightSearchingPanelLayout.createSequentialGroup()
                        .addComponent(ContinueToReservationPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(321, 321, 321))))
            .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                            .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                                    .addComponent(departDateLabel)
                                    .addGap(8, 8, 8))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FlightSearchingPanelLayout.createSequentialGroup()
                                    .addComponent(toLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(toSearchTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                .addComponent(flightDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                            .addComponent(fromLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                            .addComponent(fromSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        FlightSearchingPanelLayout.setVerticalGroup(
            FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(Header2Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(departDateLabel))
                    .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(flightDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addComponent(SearchFlightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ContinueToReservationPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        ReservationDetailsPanel.setBackground(new java.awt.Color(231, 231, 231));

        firstNameField.setBackground(new java.awt.Color(252, 255, 255));
        firstNameField.setForeground(new java.awt.Color(0, 0, 0));

        numberOfSeatsLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        numberOfSeatsLabel.setForeground(new java.awt.Color(51, 51, 51));
        numberOfSeatsLabel.setText("Number of seats");

        surNameField.setBackground(new java.awt.Color(252, 255, 255));
        surNameField.setForeground(new java.awt.Color(0, 0, 0));

        submitPassengerInfo.setBackground(new java.awt.Color(53, 146, 196));
        submitPassengerInfo.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        submitPassengerInfo.setForeground(new java.awt.Color(241, 241, 241));
        submitPassengerInfo.setText("Continue");
        submitPassengerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPassengerInfoActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(51, 51, 51));
        firstNameLabel.setText("First Name");

        surnameLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(51, 51, 51));
        surnameLabel.setText("Surname");

        nationalityLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        nationalityLabel.setForeground(new java.awt.Color(51, 51, 51));
        nationalityLabel.setText("Nationality");

        CountriesField.setBackground(new java.awt.Color(252, 255, 255));
        CountriesField.setForeground(new java.awt.Color(0, 0, 0));

        passportNumberField.setBackground(new java.awt.Color(252, 255, 255));
        passportNumberField.setForeground(new java.awt.Color(0, 0, 0));

        passportExpiryDateField.setBackground(new java.awt.Color(252, 255, 255));
        passportExpiryDateField.setForeground(new java.awt.Color(0, 0, 0));

        passportNumberLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        passportNumberLabel.setForeground(new java.awt.Color(51, 51, 51));
        passportNumberLabel.setText("Passport Number");

        passprotExpiryDateLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        passprotExpiryDateLabel.setForeground(new java.awt.Color(51, 51, 51));
        passprotExpiryDateLabel.setText("Passport Expiry date");

        numberOfSeatsField.setBackground(new java.awt.Color(252, 255, 255));
        numberOfSeatsField.setForeground(new java.awt.Color(0, 0, 0));

        headerLabel.setFont(new java.awt.Font("Roboto", 1, 56)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(51, 51, 51));
        headerLabel.setText("Passenger Information");

        classLabel.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        classLabel.setForeground(new java.awt.Color(51, 51, 51));
        classLabel.setText("Class");

        firstClassButton.setBackground(new java.awt.Color(231, 231, 231));
        ClassButtonGroup.add(firstClassButton);
        firstClassButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        firstClassButton.setForeground(new java.awt.Color(51, 51, 51));
        firstClassButton.setText("First ");

        bussinessClassButton.setBackground(new java.awt.Color(231, 231, 231));
        ClassButtonGroup.add(bussinessClassButton);
        bussinessClassButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        bussinessClassButton.setForeground(new java.awt.Color(51, 51, 51));
        bussinessClassButton.setText("Business");

        economyClassButton.setBackground(new java.awt.Color(231, 231, 231));
        ClassButtonGroup.add(economyClassButton);
        economyClassButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        economyClassButton.setForeground(new java.awt.Color(51, 51, 51));
        economyClassButton.setText("Economy");

        backButton1.setBackground(new java.awt.Color(255, 255, 255));
        backButton1.setFont(new java.awt.Font("Hacen Vanilla", 1, 12)); // NOI18N
        backButton1.setForeground(new java.awt.Color(255, 255, 255));
        backButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backButtonImage4025.png"))); // NOI18N
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        invalidFirstName.setForeground(new java.awt.Color(255, 0, 0));
        invalidFirstName.setText("Invalid Name");

        invalidSurname.setForeground(new java.awt.Color(255, 0, 0));
        invalidSurname.setText("Invalid Name");

        invalidNationality.setForeground(new java.awt.Color(255, 0, 0));
        invalidNationality.setText("Invalid Nationality");

        invalidNumOfSeats.setForeground(new java.awt.Color(255, 0, 0));
        invalidNumOfSeats.setText("Invalid Number");

        invalidResClass.setForeground(new java.awt.Color(255, 0, 0));
        invalidResClass.setText("Invalid Class");

        invalidPassExpiryDate.setForeground(new java.awt.Color(255, 0, 0));
        invalidPassExpiryDate.setText("Invalid Date");

        invalidPassportNum.setForeground(new java.awt.Color(255, 0, 0));
        invalidPassportNum.setText("Invalid Number");

        javax.swing.GroupLayout ReservationDetailsPanelLayout = new javax.swing.GroupLayout(ReservationDetailsPanel);
        ReservationDetailsPanel.setLayout(ReservationDetailsPanelLayout);
        ReservationDetailsPanelLayout.setHorizontalGroup(
            ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(headerLabel)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationDetailsPanelLayout.createSequentialGroup()
                        .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(surnameLabel)
                                    .addGap(116, 116, 116)
                                    .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(surNameField)
                                        .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                            .addComponent(invalidSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(nationalityLabel)
                                    .addGap(101, 101, 101)
                                    .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CountriesField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                            .addComponent(invalidNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(classLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstClassButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bussinessClassButton)
                                    .addGap(16, 16, 16)
                                    .addComponent(economyClassButton))
                                .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(passprotExpiryDateLabel)
                                    .addGap(30, 30, 30)
                                    .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passportExpiryDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(invalidPassExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(invalidPassportNum, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(passportNumberLabel)
                                    .addGap(54, 54, 54)
                                    .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passportNumberField)
                                        .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                            .addComponent(invalidResClass, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(numberOfSeatsLabel)
                                    .addGap(61, 61, 61)
                                    .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numberOfSeatsField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(invalidNumOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                                .addComponent(firstNameLabel)
                                .addGap(102, 102, 102)
                                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invalidFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationDetailsPanelLayout.createSequentialGroup()
                        .addComponent(submitPassengerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299))))
        );
        ReservationDetailsPanelLayout.setVerticalGroup(
            ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationDetailsPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(firstNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel))
                .addGap(3, 3, 3)
                .addComponent(invalidSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CountriesField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nationalityLabel))
                .addGap(1, 1, 1)
                .addComponent(invalidNationality)
                .addGap(2, 2, 2)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfSeatsField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfSeatsLabel))
                .addGap(4, 4, 4)
                .addComponent(invalidNumOfSeats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bussinessClassButton)
                    .addComponent(economyClassButton)
                    .addComponent(classLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidResClass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passportNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passportNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidPassportNum)
                .addGap(3, 3, 3)
                .addGroup(ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passportExpiryDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passprotExpiryDateLabel))
                .addGap(5, 5, 5)
                .addComponent(invalidPassExpiryDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitPassengerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        BookingsPanel.setBackground(new java.awt.Color(231, 231, 231));

        reservationTable.setBackground(new java.awt.Color(231, 231, 231));
        reservationTable.setForeground(new java.awt.Color(51, 51, 51));
        reservationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "Airline", "From", "To", "Flight Date", "Departure Time", "Flight Duration", "No. of Seats", "Class", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reservationTable.setFocusable(false);
        reservationTable.setRowHeight(25);
        reservationTable.setSelectionBackground(new java.awt.Color(86, 173, 219));
        reservationTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        reservationTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(reservationTable);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Reservation ID  : ");

        reservationIdRemoveTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        reservationIdRemoveTxt.setForeground(new java.awt.Color(51, 51, 51));

        cancelReservationButton.setBackground(new java.awt.Color(153, 0, 0));
        cancelReservationButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cancelReservationButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelReservationButton.setText("Cancel Reservation");
        cancelReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BookingsPanelLayout = new javax.swing.GroupLayout(BookingsPanel);
        BookingsPanel.setLayout(BookingsPanelLayout);
        BookingsPanelLayout.setHorizontalGroup(
            BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookingsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservationIdRemoveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        BookingsPanelLayout.setVerticalGroup(
            BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookingsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reservationIdRemoveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FlightSearchingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BookingsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ReservationDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PaymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FlightSearchingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BookingsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ReservationDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PaymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showPaymentPanel(){
        ReservationDetailsPanel.setVisible(false);
        FlightSearchingPanel.setVisible(false);
        BookingsPanel.setVisible(false);
        PaymentPanel.setVisible(true);
        invalidNo.setVisible(false);
        invalidcvv.setVisible(false);
    }
    private void resetReservation(){
        clearPaymentFields();
        clearReservationFields();
        FlightSearchingPanel.setVisible(true);
        BookingsPanel.setVisible(false);
        ReservationDetailsPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        fromSearchTxt.setText("");
        toSearchTxt.setText("");
        flightDate.setDate(null);
        DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
        model.setRowCount(0);
    }
    private void showReservationError(int status) {
        invalidFirstName.setVisible(status == 1);
        invalidSurname.setVisible(status == 2);
        invalidNationality.setVisible(status == 3);
        invalidNumOfSeats.setVisible(status == 4);
        invalidResClass.setVisible(status == 5);
        invalidPassportNum.setVisible(status == 6);
        invalidPassExpiryDate.setVisible(status == 7);
        
    }
    private void showPaymentError(int status) {
        invalidNo.setVisible(status == 2);
        invalidCardName.setVisible(status == 3);
        invalidcvv.setVisible(status == 4);
        invalidCardExpiryDate.setVisible(status == 5);
        
    }
    /*  Controller Input Methods  */
    public List<Object> getFlightSearchInput(){
        List<Object> list = List.of(fromSearchTxt.getText(), toSearchTxt.getText(), flightDate.getDate(), searchTable.getModel());
        return list;
    }
    public Object[] getReservationInput(){
        String reservationClass="";
        if(firstClassButton.isSelected()){
            reservationClass = "First";
        } else if (bussinessClassButton.isSelected()){
            reservationClass = "Business";
        } else if (economyClassButton.isSelected()){
            reservationClass ="Economy";
        }
        Flight flight = new Flight(flightID);
        Object[] list = {firstNameField.getText(), surNameField.getText(), (String)CountriesField.getSelectedItem(),
                        numberOfSeatsField.getText(), reservationClass, passportNumberField.getText(), passportExpiryDateField.getDate(), flightID};
        return list;
    }
    public Object[] getPaymentInput(){
        if(visaButton.isSelected()) {
            cardType = "Visa";
        } else if(mastercardButton.isSelected()){
            cardType = "Mastercard";
        }
        Object[] list = {cardType, cardNumberField.getText(), cardHolderNameField.getText(), cardCVVField.getText(), cardExpiryDateChooser.getDate()};
        return list;
    }
    public Object[] getCancelledReservationInput(){
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel reservation?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        Object[] list = {reservationIdRemoveTxt.getText(), reservationTable.getModel(), response};
        return list;
    }
    /*  Output Methods  */
    public void updateSearchPanel(int status){
        if(status == 0){
            searchPanel.setVisible(true);
            resultLabel.setText("Pick a Flight and Press Continue:");
            resultLabel.setForeground(new Color(53, 146, 196));
            resultLabel.setVisible(true);
            ContinueToReservationPanelButton.setVisible(true);
        } else if (status == 1) {
            DefaultTableModel model = (DefaultTableModel)searchTable.getModel();
            model.setRowCount(0);
            resultLabel.setVisible(true);
            resultLabel.setForeground(Color.red);
            resultLabel.setText("No matches Found");
            searchPanel.setVisible(false);
            ContinueToReservationPanelButton.setVisible(false);
        } else if (status == 2){
            JOptionPane.showMessageDialog(this, "The departure airport name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (status == 3){
            JOptionPane.showMessageDialog(this, "The destination airport name entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (status == 4) {
            JOptionPane.showMessageDialog(this, "The flight date entered is invalid!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateReservationDetailsPanel(int status){
        switch(status){
            case 0 -> {
                showReservationError(0);
                showPaymentPanel();
                break;
            }
            default -> showReservationError(status);
        }
    }
    public void updatePaymentDetailsPanel(int status){
        switch(status){
            case 0 -> {
                showPaymentError(0);
                JOptionPane.showMessageDialog(null, "Your Reservation is placed successfully!", "Booking Successfull", JOptionPane.INFORMATION_MESSAGE);
                resetReservation();
                break;
            }
            default -> showPaymentError(status);
        }
    }
    
    public void updateBookingsPanel(int status) {
        switch(status){
            case 0 -> {
                JOptionPane.showMessageDialog(this, "The Reservation was cancelled successfully!", "", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            case 1 ->{
                JOptionPane.showMessageDialog(this, "The ID entered is invalid", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }
            default -> {
                break;
            }
        }
    }
    
    private void flightsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flightsTabMouseClicked
        //show flights tab and hide other tabs
        FlightSearchingPanel.setVisible(true);
        BookingsPanel.setVisible(false);
        ReservationDetailsPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        //highlight flights tab button and set other tab buttons to normal color
        flightsTab.setBackground(new Color (94, 170, 211));
        bookingsTab.setBackground(new Color (53, 146, 196));
    }//GEN-LAST:event_flightsTabMouseClicked

    private void bookingsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingsTabMouseClicked
        //show bookings tab and hide other panels
        FlightSearchingPanel.setVisible(false);
        BookingsPanel.setVisible(true);
        PaymentPanel.setVisible(false);
        ReservationDetailsPanel.setVisible(false);
       //highlight bookings tab button and set other tab buttons to normal colors
        flightsTab.setBackground(new Color (53, 146, 196));
        bookingsTab.setBackground(new Color (94, 170, 211));
        controller.updateReservationTableModel((DefaultTableModel)reservationTable.getModel());
    }//GEN-LAST:event_bookingsTabMouseClicked

    private void fromSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromSearchTxtKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER){
            String text = fromSearchTxt.getText().trim().toLowerCase();
            fromSearch.setData(search(text));
            if (fromSearch.getItemSize() > 0) {
                //  * 2 top and bot border
                fromMenu.show(fromSearchTxt, 0, fromSearchTxt.getHeight());
                fromMenu.setPopupSize(fromMenu.getWidth(), (fromSearch.getItemSize() * 35) + 2);
            } else {
                fromMenu.setVisible(false);
        }}
    }//GEN-LAST:event_fromSearchTxtKeyReleased

    private void toSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toSearchTxtKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER){
            String text = toSearchTxt.getText().trim().toLowerCase();
            toSearch.setData(search(text));
            if (toSearch.getItemSize() > 0) {
                //  * 2 top and bot border
                toMenu.show(toSearchTxt, 0, toSearchTxt.getHeight());
                toMenu.setPopupSize(toMenu.getWidth(), (toSearch.getItemSize() * 35) + 2);
            } else {
                toMenu.setVisible(false);
        }}
    }//GEN-LAST:event_toSearchTxtKeyReleased

    private void fromSearchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromSearchTxtMouseClicked
        if (fromSearch.getItemSize() > 0) {
            fromMenu.show(fromSearchTxt, 0, fromSearchTxt.getHeight());
        }
    }//GEN-LAST:event_fromSearchTxtMouseClicked

    private void toSearchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toSearchTxtMouseClicked
        if (toSearch.getItemSize() > 0) {
            toMenu.show(toSearchTxt, 0, toSearchTxt.getHeight());
        }
    }//GEN-LAST:event_toSearchTxtMouseClicked

    private void fromSearchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromSearchTxtKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            fromSearch.keyUp();
        }else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            fromSearch.keyDown();
        }else if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            String fromText = fromSearch.getSelectedText();
            fromSearchTxt.setText(fromText);
            fromMenu.setVisible(false);
        }
    }//GEN-LAST:event_fromSearchTxtKeyPressed

    private void toSearchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toSearchTxtKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            toSearch.keyUp();
        }else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            toSearch.keyDown();
        }else if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            String toText = toSearch.getSelectedText();
            toSearchTxt.setText(toText);
            toMenu.setVisible(false);
        }
    }//GEN-LAST:event_toSearchTxtKeyPressed

    private void SearchFlightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFlightsButtonActionPerformed
        controller.handleSearchFlightButtonClick();
    }//GEN-LAST:event_SearchFlightsButtonActionPerformed

    private void cancelReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservationButtonActionPerformed
        controller.handleCancelReservationButtonClick();
    }//GEN-LAST:event_cancelReservationButtonActionPerformed

    private void submitPassengerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPassengerInfoActionPerformed
        controller.handleSubmitPassengerInfoButtonClick();
    }//GEN-LAST:event_submitPassengerInfoActionPerformed

    private void ContinueToReservationPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueToReservationPanelButtonActionPerformed
        if(searchTable.getSelectedRow()!= -1){
            flightID = (int) searchTable.getModel().getValueAt(searchTable.getSelectedRow(), 0);
            ReservationDetailsPanel.setVisible(true);
            FlightSearchingPanel.setVisible(false);
            BookingsPanel.setVisible(false);
            PaymentPanel.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please, Select a flight from the table to proceed!", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ContinueToReservationPanelButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        FlightSearchingPanel.setVisible(true);
        BookingsPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        ReservationDetailsPanel.setVisible(false);
    }//GEN-LAST:event_backButton1ActionPerformed

    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
        FlightSearchingPanel.setVisible(false);
        BookingsPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        ReservationDetailsPanel.setVisible(true);
    }//GEN-LAST:event_backButton2ActionPerformed

    private void submitReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitReservationButtonActionPerformed
        controller.handleSubmitReservationButtonClick();
    }//GEN-LAST:event_submitReservationButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your reservation?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Reservation has been cancelled successfully!");
            clearPaymentFields();
            clearReservationFields();
            FlightSearchingPanel.setVisible(true);
            BookingsPanel.setVisible(false);
            ReservationDetailsPanel.setVisible(false);
            PaymentPanel.setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private List<DataSearch> search(String search) {
        int limitData = 7;
        List<DataSearch> list = new ArrayList<>();
        String dataTesting[] = Constants.airports;
        for (String d : dataTesting) {
            if (d.toLowerCase().contains(search)) {
                boolean story = isStory(d);
                if (story) {
                    list.add(0, new DataSearch(d, story));
                    //  add or insert to first record
                } else {
                    list.add(new DataSearch(d, story));
                    //  add to last record
                }
                if (list.size() == limitData) {
                    break;
                }
            }
        }
        return list;
    }
    
    private void removeHistory(String text) {
        for (int i = 0; i < dataStory.length; i++) {
            String d = dataStory[i];
            if (d.toLowerCase().equals(text.toLowerCase())) {
                dataStory[i] = "";
            }
        }
    }
    
    private boolean isStory(String text) {
        for (String d : dataStory) {
            if (d.toLowerCase().equals(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
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
            java.util.logging.Logger.getLogger(PassengerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassengerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BookingsPanel;
    private javax.swing.JLabel CVVLabel;
    private javax.swing.ButtonGroup CardTypeButtonGroup;
    private javax.swing.ButtonGroup ClassButtonGroup;
    private javax.swing.JButton ContinueToReservationPanelButton;
    private javax.swing.JComboBox<String> CountriesField;
    private javax.swing.JPanel FlightSearchingPanel;
    private javax.swing.JLabel Header2Label;
    private javax.swing.JLabel HeaderLabel;
    private javax.swing.JPanel PaymentPanel;
    private javax.swing.JPanel ReservationDetailsPanel;
    private javax.swing.JButton SearchFlightsButton;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton backButton2;
    private javax.swing.JPanel bookingsTab;
    private javax.swing.JRadioButton bussinessClassButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelReservationButton;
    private javax.swing.JTextField cardCVVField;
    private com.toedter.calendar.JDateChooser cardExpiryDateChooser;
    private javax.swing.JTextField cardHolderNameField;
    private javax.swing.JLabel cardHolderNameLabel;
    private javax.swing.JTextField cardNumberField;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JLabel cardTypeLabel;
    private javax.swing.JLabel classLabel;
    private javax.swing.JLabel departDateLabel;
    private javax.swing.JRadioButton economyClassButton;
    private javax.swing.JLabel expirationDateLabel;
    private javax.swing.JRadioButton firstClassButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private com.toedter.calendar.JDateChooser flightDate;
    private javax.swing.JPanel flightsTab;
    private javax.swing.JLabel fromLabel;
    private swing.MyTextField fromSearchTxt;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel headerLabel1;
    private javax.swing.JLabel invalidCardExpiryDate;
    private javax.swing.JLabel invalidCardName;
    private javax.swing.JLabel invalidFirstName;
    private javax.swing.JLabel invalidNationality;
    private javax.swing.JLabel invalidNo;
    private javax.swing.JLabel invalidNumOfSeats;
    private javax.swing.JLabel invalidPassExpiryDate;
    private javax.swing.JLabel invalidPassportNum;
    private javax.swing.JLabel invalidResClass;
    private javax.swing.JLabel invalidSurname;
    private javax.swing.JLabel invalidcvv;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton mastercardButton;
    private javax.swing.JLabel mastercardLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel nationalityLabel;
    private javax.swing.JTextField numberOfSeatsField;
    private javax.swing.JLabel numberOfSeatsLabel;
    private com.toedter.calendar.JDateChooser passportExpiryDateField;
    private javax.swing.JTextField passportNumberField;
    private javax.swing.JLabel passportNumberLabel;
    private javax.swing.JLabel passprotExpiryDateLabel;
    private javax.swing.JTextField reservationIdRemoveTxt;
    private javax.swing.JTable reservationTable;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JScrollPane searchPanel;
    private javax.swing.JTable searchTable;
    private javax.swing.JButton submitPassengerInfo;
    private javax.swing.JButton submitReservationButton;
    private javax.swing.JTextField surNameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel toLabel;
    private swing.MyTextField toSearchTxt;
    private javax.swing.JRadioButton visaButton;
    private javax.swing.JLabel visaLabel;
    // End of variables declaration//GEN-END:variables
}
