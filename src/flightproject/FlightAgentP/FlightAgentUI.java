
package flightproject.FlightAgentP;

import flightproject.DBConnection;
import flightproject.FlightP.Flight;
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
    int SeatCapacity;
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
        FlightsTable.setModel(DbUtils.resultSetToTableModel(MyresObj));
       } catch(SQLException e){   
        }
    }
    public void updateReservationsTable(){
        try{
        MyconObj=DriverManager.getConnection("jdbc:derby://localhost:1527/flight project DB", "root", "root");
        MystaObj=MyconObj.createStatement();
        MyresObj=MystaObj.executeQuery("SELECT * FROM ROOT.RESERVATIONS");
        ReservationsTable.setModel(DbUtils.resultSetToTableModel(MyresObj));
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
        flightDate = flightDateChooser.getDate();
        SeatCapacity = Integer.parseInt(SeatCapacityTxt.getText().trim());
    }
    public void clearFlightFields(){
        idTxt.setText("");
        airlineTxt.setText("");
        durationTxt.setText("");
        departureTimeTxt.setText("");
        priceTxt.setText("");
        SeatCapacityTxt.setText("");
    }
    public boolean emptyField(){
        if(airlineTxt.getText().equals("") || durationTxt.getText().equals("") || departureTimeTxt.getText().equals("") || priceTxt.getText().equals("") || SeatCapacityTxt.getText().equals("")){
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
        FlightsTable = new javax.swing.JTable();
        idTxt = new javax.swing.JTextField();
        durationTxt = new javax.swing.JTextField();
        departureTimeTxt = new javax.swing.JTextField();
        priceTxt = new javax.swing.JTextField();
        FlightIdLabel = new javax.swing.JLabel();
        FlightDepartureAirportLabel = new javax.swing.JLabel();
        FlightArrivalAirportLabel = new javax.swing.JLabel();
        FlightDateLabel = new javax.swing.JLabel();
        DepartureTimeLabel = new javax.swing.JLabel();
        FlightDuration = new javax.swing.JLabel();
        BasePriceLabel = new javax.swing.JLabel();
        airlineTxt = new javax.swing.JTextField();
        flightDateChooser = new com.toedter.calendar.JDateChooser();
        AirlineLabel = new javax.swing.JLabel();
        departureAirportBox = new javax.swing.JComboBox<>();
        arrivalAirportBox = new javax.swing.JComboBox<>();
        FlightHeaderLabel = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        SeatCapacityLabel = new javax.swing.JLabel();
        SeatCapacityTxt = new javax.swing.JTextField();
        ReservationsPanal = new javax.swing.JPanel();
        ReservationsHeaderLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ReservationsTable = new javax.swing.JTable();

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

        FlightsTable.setBackground(new java.awt.Color(204, 204, 204));
        FlightsTable.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        FlightsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(FlightsTable);

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

        FlightIdLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FlightIdLabel.setForeground(new java.awt.Color(51, 51, 51));
        FlightIdLabel.setText("ID                                     :");

        FlightDepartureAirportLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FlightDepartureAirportLabel.setForeground(new java.awt.Color(51, 51, 51));
        FlightDepartureAirportLabel.setText("Departure Airport   :");

        FlightArrivalAirportLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FlightArrivalAirportLabel.setForeground(new java.awt.Color(51, 51, 51));
        FlightArrivalAirportLabel.setText("Arrival Airport         :");

        FlightDateLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FlightDateLabel.setForeground(new java.awt.Color(51, 51, 51));
        FlightDateLabel.setText("Flight Date                  :");

        DepartureTimeLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        DepartureTimeLabel.setForeground(new java.awt.Color(51, 51, 51));
        DepartureTimeLabel.setText("Departure Time      :");

        FlightDuration.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FlightDuration.setForeground(new java.awt.Color(51, 51, 51));
        FlightDuration.setText("Flight Duration        :");

        BasePriceLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BasePriceLabel.setForeground(new java.awt.Color(51, 51, 51));
        BasePriceLabel.setText("Base Price                 :");

        airlineTxt.setBackground(new java.awt.Color(255, 255, 255));
        airlineTxt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        airlineTxt.setForeground(new java.awt.Color(51, 51, 51));

        flightDateChooser.setBackground(new java.awt.Color(255, 255, 255));
        flightDateChooser.setForeground(new java.awt.Color(51, 51, 51));

        AirlineLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        AirlineLabel.setForeground(new java.awt.Color(51, 51, 51));
        AirlineLabel.setText("Airline                           :");

        departureAirportBox.setBackground(new java.awt.Color(255, 255, 255));
        departureAirportBox.setForeground(new java.awt.Color(51, 51, 51));
        departureAirportBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        arrivalAirportBox.setBackground(new java.awt.Color(255, 255, 255));
        arrivalAirportBox.setForeground(new java.awt.Color(51, 51, 51));
        arrivalAirportBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        FlightHeaderLabel.setFont(new java.awt.Font("Roboto", 1, 56)); // NOI18N
        FlightHeaderLabel.setForeground(new java.awt.Color(51, 51, 51));
        FlightHeaderLabel.setText("Flight Management");

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

        SeatCapacityLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeatCapacityLabel.setForeground(new java.awt.Color(51, 51, 51));
        SeatCapacityLabel.setText("Seat Capacity          :");

        SeatCapacityTxt.setBackground(new java.awt.Color(255, 255, 255));
        SeatCapacityTxt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        SeatCapacityTxt.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout FlightManagementPanelLayout = new javax.swing.GroupLayout(FlightManagementPanel);
        FlightManagementPanel.setLayout(FlightManagementPanelLayout);
        FlightManagementPanelLayout.setHorizontalGroup(
            FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                        .addComponent(FlightDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flightDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                        .addComponent(FlightDepartureAirportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departureAirportBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addComponent(FlightIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FlightDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeatCapacityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeatCapacityTxt)
                            .addComponent(durationTxt))))
                .addGap(115, 115, 115)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addComponent(AirlineLabel)
                        .addGap(14, 14, 14)
                        .addComponent(airlineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BasePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FlightArrivalAirportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepartureTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(arrivalAirportBox, 0, 248, Short.MAX_VALUE))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(departureTimeTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(priceTxt))))))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                        .addComponent(FlightHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightManagementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        FlightManagementPanelLayout.setVerticalGroup(
            FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                .addComponent(FlightHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FlightIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(FlightDepartureAirportLabel))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(departureAirportBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(FlightDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(flightDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FlightDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(durationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AirlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(airlineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FlightArrivalAirportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(arrivalAirportBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addComponent(DepartureTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(BasePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FlightManagementPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(departureTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceTxt)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeatCapacityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeatCapacityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(FlightManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton)
                    .addComponent(UpdateButton)
                    .addComponent(AddButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ReservationsPanal.setBackground(new java.awt.Color(231, 231, 231));

        ReservationsHeaderLabel.setFont(new java.awt.Font("Roboto", 1, 56)); // NOI18N
        ReservationsHeaderLabel.setForeground(new java.awt.Color(51, 51, 51));
        ReservationsHeaderLabel.setText("Reservations");

        ReservationsTable.setBackground(new java.awt.Color(204, 204, 204));
        ReservationsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(ReservationsTable);

        javax.swing.GroupLayout ReservationsPanalLayout = new javax.swing.GroupLayout(ReservationsPanal);
        ReservationsPanal.setLayout(ReservationsPanalLayout);
        ReservationsPanalLayout.setHorizontalGroup(
            ReservationsPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsPanalLayout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(ReservationsHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
            .addGroup(ReservationsPanalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        ReservationsPanalLayout.setVerticalGroup(
            ReservationsPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationsPanalLayout.createSequentialGroup()
                .addComponent(ReservationsHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ReservationsPanal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FlightManagementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ReservationsPanal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(FlightManagementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if(!emptyField() || idTxt.getText().equals("")){
            getFlightFields();
            flightId = Integer.parseInt(idTxt.getText());
            Flight.updateFlight(flightId, departureAirport, arrivalAirport, departureTime, flightDuration, flightDate, basePrice, airline, SeatCapacity);
            updateFlightsTable();
            clearFlightFields();
        } else {
            JOptionPane.showMessageDialog(null, "Complete Missing Data Fields!");
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        flightId = Integer.parseInt(idTxt.getText());
        Flight.deleteFlight(flightId);
        clearFlightFields();
        updateFlightsTable();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        if(!emptyField()){
            getFlightFields();
            Flight.createNewFlight(departureAirport, arrivalAirport, departureTime, flightDuration, flightDate, basePrice, airline, SeatCapacity);
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
    private javax.swing.JLabel AirlineLabel;
    private javax.swing.JLabel BasePriceLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel DepartureTimeLabel;
    private javax.swing.JLabel FlightArrivalAirportLabel;
    private javax.swing.JLabel FlightDateLabel;
    private javax.swing.JLabel FlightDepartureAirportLabel;
    private javax.swing.JLabel FlightDuration;
    private javax.swing.JLabel FlightHeaderLabel;
    private javax.swing.JLabel FlightIdLabel;
    private javax.swing.JPanel FlightManagementPanel;
    private javax.swing.JPanel FlightManagementTabPanel;
    private javax.swing.JTable FlightsTable;
    private javax.swing.JLabel ReservationsHeaderLabel;
    private javax.swing.JPanel ReservationsPanal;
    private javax.swing.JPanel ReservationsTabPanel;
    private javax.swing.JTable ReservationsTable;
    private javax.swing.JLabel SeatCapacityLabel;
    private javax.swing.JTextField SeatCapacityTxt;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField airlineTxt;
    private javax.swing.JComboBox<String> arrivalAirportBox;
    private javax.swing.JComboBox<String> departureAirportBox;
    private javax.swing.JTextField departureTimeTxt;
    private javax.swing.JTextField durationTxt;
    private com.toedter.calendar.JDateChooser flightDateChooser;
    private javax.swing.JTextField idTxt;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JLabel showFlightsPanal;
    private javax.swing.JLabel showReservPanal;
    // End of variables declaration//GEN-END:variables
}
