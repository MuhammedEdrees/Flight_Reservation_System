
package flightproject.FlightAgentP;

import flightproject.DBConnection;
import java.awt.Color;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import javax.swing.JOptionPane;

public class FlightAgentUI extends javax.swing.JFrame {

    Connection MyconObj=null;
    Statement MystaObj=null;
    ResultSet MyresObj=null;
    Date flightDate;
    int flightId;
    String departureAirport, arrivalAirport, departureTime, flightDuration, airline;
    double basePrice;
    public FlightAgentUI() {
        initComponents();
        DBConnection.connectDB();
        departureAirportBox.setModel(new DefaultComboBoxModel<>(flightproject.FlightP.Flight.getAirports()));
        arrivalAirportBox.setModel(new DefaultComboBoxModel<>(flightproject.FlightP.Flight.getAirports()));
        updateFlightsTable();
        ReservationsPanal.setVisible(false);
        FlightManagementPanel.setVisible(true);
        FlightManagementTabPanel.setBackground(new Color(94, 170, 211));
        ReservationsTabPanel.setBackground(new Color (53, 146, 196));
    }

    public final void updateFlightsTable(){
        try{
        MyconObj=DriverManager.getConnection("jdbc:derby://localhost:1527/flight project DB", "root", "root");
        MystaObj=MyconObj.createStatement();
        MyresObj=MystaObj.executeQuery("SELECT * FROM ROOT.FLIGHTS");
        Table_1.setModel(DbUtils.resultSetToTableModel(MyresObj));
       } catch(SQLException e){   
        }
    }
    public void updateReservationsTable(){
        try{
        MyconObj=DriverManager.getConnection("jdbc:derby://localhost:1527/flight project DB", "root", "root");
        MystaObj=MyconObj.createStatement();
        MyresObj=MystaObj.executeQuery("SELECT * FROM ROOT.RESERVATIONS");
        jTable1.setModel(DbUtils.resultSetToTableModel(MyresObj));
       } catch(SQLException e){
       }
    }
    public void getFlightFields(){
        departureAirport = (String)departureAirportBox.getSelectedItem();
        arrivalAirport = (String) arrivalAirportBox.getSelectedItem();
        departureTime = departureTimeTxt.getText();
        flightDuration = durationTxt.getText();
        airline = airlineTxt.getText();
        basePrice = Double.parseDouble(priceTxt.getText());
    }
    public void clearFlightFields(){
        idTxt.setText("");
        airlineTxt.setText("");
        durationTxt.setText("");
        departureTimeTxt.setText("");
        priceTxt.setText("");
    }
    public boolean emptyField(){
        if(idTxt.getText().equals("") || airlineTxt.getText().equals("") || durationTxt.getText().equals("") || departureTimeTxt.getText().equals("") || priceTxt.getText().equals("")){
            return true;
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SidePanel = new javax.swing.JPanel();
        ReservationsTabPanel = new javax.swing.JPanel();
        showReservPanal = new javax.swing.JLabel();
        FlightManagementTabPanel = new javax.swing.JPanel();
        showFlightsPanal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        FlightManagementPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_1 = new javax.swing.JTable();
        idTxt = new javax.swing.JTextField();
        durationTxt = new javax.swing.JTextField();
        departureTimeTxt = new javax.swing.JTextField();
        priceTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        airlineTxt = new javax.swing.JTextField();
        flightDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        departureAirportBox = new javax.swing.JComboBox<>();
        arrivalAirportBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        ReservationsPanal = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(53, 146, 196));

        ReservationsTabPanel.setBackground(new java.awt.Color(53, 146, 196));
        ReservationsTabPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReservationsTabPanelMouseClicked(evt);
            }
        });

        showReservPanal.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        showReservPanal.setForeground(new java.awt.Color(51, 51, 51));
        showReservPanal.setText("Reservations");

        javax.swing.GroupLayout ReservationsTabPanelLayout = new javax.swing.GroupLayout(ReservationsTabPanel);
        ReservationsTabPanel.setLayout(ReservationsTabPanelLayout);
        ReservationsTabPanelLayout.setHorizontalGroup(
            ReservationsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsTabPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(showReservPanal)
                .addGap(47, 47, 47))
        );
        ReservationsTabPanelLayout.setVerticalGroup(
            ReservationsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationsTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showReservPanal, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        FlightManagementTabPanel.setBackground(new java.awt.Color(53, 146, 196));
        FlightManagementTabPanel.setForeground(new java.awt.Color(53, 156, 196));
        FlightManagementTabPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightManagementTabPanelMouseClicked(evt);
            }
        });

        showFlightsPanal.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        showFlightsPanal.setForeground(new java.awt.Color(51, 51, 51));
        showFlightsPanal.setText("Flights");

        javax.swing.GroupLayout FlightManagementTabPanelLayout = new javax.swing.GroupLayout(FlightManagementTabPanel);
        FlightManagementTabPanel.setLayout(FlightManagementTabPanelLayout);
        FlightManagementTabPanelLayout.setHorizontalGroup(
            FlightManagementTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightManagementTabPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(showFlightsPanal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FlightManagementTabPanelLayout.setVerticalGroup(
            FlightManagementTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightManagementTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showFlightsPanal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FlightManagementTabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ReservationsTabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(FlightManagementTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReservationsTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(231, 231, 231));

        FlightManagementPanel.setBackground(new java.awt.Color(231, 231, 231));

        Table_1.setBackground(new java.awt.Color(204, 204, 204));
        Table_1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        Table_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DepartureAirport", "ArrivalAirport", "FlightDate", "DepartureTime", "FlightDuration", "BasePrice"
            }
        ));
        jScrollPane1.setViewportView(Table_1);

        idTxt.setBackground(new java.awt.Color(255, 255, 255));
        idTxt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        idTxt.setForeground(new java.awt.Color(51, 51, 51));

        durationTxt.setBackground(new java.awt.Color(255, 255, 255));
        durationTxt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        durationTxt.setForeground(new java.awt.Color(51, 51, 51));

        departureTimeTxt.setBackground(new java.awt.Color(255, 255, 255));
        departureTimeTxt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        departureTimeTxt.setForeground(new java.awt.Color(51, 51, 51));

        priceTxt.setBackground(new java.awt.Color(255, 255, 255));
        priceTxt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        priceTxt.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID                                     :");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Departure Airport   :");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Arrival Airport         :");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Flight Date                  :");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Departure Time      :");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Flight Duration        :");

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Base Price                 :");

        airlineTxt.setBackground(new java.awt.Color(255, 255, 255));
        airlineTxt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        airlineTxt.setForeground(new java.awt.Color(51, 51, 51));

        flightDateChooser.setBackground(new java.awt.Color(255, 255, 255));
        flightDateChooser.setForeground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Airline                           :");

        departureAirportBox.setBackground(new java.awt.Color(255, 255, 255));
        departureAirportBox.setForeground(new java.awt.Color(51, 51, 51));
        departureAirportBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        arrivalAirportBox.setBackground(new java.awt.Color(255, 255, 255));
        arrivalAirportBox.setForeground(new java.awt.Color(51, 51, 51));
        arrivalAirportBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 56)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Flight Management");

        UpdateButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(153, 0, 0));
        DeleteButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FlightManagementPanelLayout = new javax.swing.GroupLayout(FlightManagementPanel);
        FlightManagementPanel.setLayout(FlightManagementPanelLayout);
        FlightManagementPanelLayout.setHorizontalGroup(
            FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(durationTxt))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(flightDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(departureAirportBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(115, 115, 115)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(14, 14, 14)
                                .addComponent(airlineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(arrivalAirportBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(departureTimeTxt))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceTxt))))
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        FlightManagementPanelLayout.setVerticalGroup(
            FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(departureAirportBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(flightDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(durationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(airlineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(arrivalAirportBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(departureTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddButton)
                    .addComponent(UpdateButton)
                    .addComponent(DeleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        ReservationsPanal.setBackground(new java.awt.Color(231, 231, 231));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 56)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Reservations");

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "First name", "Nationality", "Passport number", "Passport Exp", "Number Of Seats", "Flight ID", "Passenger ID"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout ReservationsPanalLayout = new javax.swing.GroupLayout(ReservationsPanal);
        ReservationsPanal.setLayout(ReservationsPanalLayout);
        ReservationsPanalLayout.setHorizontalGroup(
            ReservationsPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsPanalLayout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
        );
        ReservationsPanalLayout.setVerticalGroup(
            ReservationsPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationsPanalLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReservationsPanal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FlightManagementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(ReservationsPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(FlightManagementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        if(!emptyField()){
            flightDate = flightDateChooser.getDate();
            java.sql.Date sqlDate = new java.sql.Date(flightDate.getTime());
            getFlightFields();
            flightId = Integer.parseInt(idTxt.getText());
            try{
                String sql="Update ROOT.FLIGHTS Set DepartureAirport = ?, ArrivalAirport = ?, FlightDate = ? , DepartureTime = ? , FlightDuration = ? , BasePrice = ? , Airline = ? where ID = ?";
                PreparedStatement mystatObj= MyconObj.prepareStatement(sql);
                mystatObj.setString(1, departureAirport);
                mystatObj.setString(2, arrivalAirport);
                mystatObj.setDate(3, sqlDate);
                mystatObj.setString(4, departureTime);
                mystatObj.setString(5, flightDuration);
                mystatObj.setDouble(6, basePrice);
                mystatObj.setString(7, airline);
                mystatObj.setInt(8, flightId);
                mystatObj.executeUpdate();
            } catch(SQLException e){
            }
            updateFlightsTable();
            clearFlightFields();
        } else {
            JOptionPane.showMessageDialog(null, "Complete Missing Data Fields!");
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        try{
            String sql="Delete FROM ROOT.FLIGHTS where id ="+idTxt.getText();
            Statement add=MyconObj.createStatement();
            add.executeUpdate(sql);
            clearFlightFields();
        } catch(SQLException e){
        }
        updateFlightsTable();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        if(!emptyField()){
            flightDate = flightDateChooser.getDate();
            java.sql.Date sqlDate = new java.sql.Date(flightDate.getTime());
            getFlightFields();
            try{
                PreparedStatement add =MyconObj.prepareStatement("Insert Into ROOT.FLIGHTS values (?,?,?,?,?,?,?,?)");
                add.setInt(1, flightproject.flightProject.generateID("FLIGHTS"));
                add.setString(2, departureAirport);
                add.setString(3, arrivalAirport);
                add.setDate(4, sqlDate);
                add.setString(5, departureTime);
                add.setString(6, flightDuration);
                add.setDouble(7, basePrice);
                add.setString(8, airline);
                int row=add.executeUpdate();
            } catch(SQLException e){
            }
            updateFlightsTable();
            clearFlightFields();
        } else {
            JOptionPane.showMessageDialog(null, "Complete Missing Data Fields!");
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void FlightManagementTabPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightManagementTabPanelMouseClicked
        ReservationsPanal.setVisible(false);
        FlightManagementPanel.setVisible(true);
        FlightManagementTabPanel.setBackground(new Color(94, 170, 211));
        ReservationsTabPanel.setBackground(new Color (53, 146, 196));
        updateFlightsTable();
    }//GEN-LAST:event_FlightManagementTabPanelMouseClicked

    private void ReservationsTabPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservationsTabPanelMouseClicked
        ReservationsPanal.setVisible(true);
        FlightManagementPanel.setVisible(false);
        FlightManagementTabPanel.setBackground(new Color(53, 146, 196));
        ReservationsTabPanel.setBackground(new Color (94, 170, 211));
        updateReservationsTable();
    }//GEN-LAST:event_ReservationsTabPanelMouseClicked

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
            java.util.logging.Logger.getLogger(FlightAgentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightAgentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightAgentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightAgentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlightAgentUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JPanel FlightManagementPanel;
    private javax.swing.JPanel FlightManagementTabPanel;
    private javax.swing.JPanel ReservationsPanal;
    private javax.swing.JPanel ReservationsTabPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JTable Table_1;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField airlineTxt;
    private javax.swing.JComboBox<String> arrivalAirportBox;
    private javax.swing.JComboBox<String> departureAirportBox;
    private javax.swing.JTextField departureTimeTxt;
    private javax.swing.JTextField durationTxt;
    private com.toedter.calendar.JDateChooser flightDateChooser;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JLabel showFlightsPanal;
    private javax.swing.JLabel showReservPanal;
    // End of variables declaration//GEN-END:variables
}
