/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package flightproject.PassengerP;

import flightproject.DBConnection;
import flightproject.flightProject;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import swing.DataSearch;
import swing.EventClick;
import swing.PanelSearch;

/**
 *
 * @author moham
 */
public class PassengerUI extends javax.swing.JFrame {

    private PanelSearch fromSearch;
    private PanelSearch toSearch;
    private JPopupMenu fromMenu;
    private JPopupMenu toMenu;
   
    public PassengerUI() {
        initComponents();
        //show flights as default and hide other panels
        FlightSearchingPanel.setVisible(true);
        BookingsPanel.setVisible(false);
        ReservationDetailsPanel.setVisible(false);
        PaymentPanel.setVisible(false);
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
    }
    
    private void updateResevrationTable(){
        try{
            Connection myConObj = DBConnection.connectDB();
            Statement myStatObj = myConObj.createStatement();
            String reservationQuery = "select * from Root.reservations.passengers where passengerid = "+flightProject.currentUserID;
            ResultSet myResObj1 = myStatObj.executeQuery(reservationQuery);
            while(myResObj1.next()){
                int numOfSeats = myResObj1.getInt("numofseats");
                int flightId = myResObj1.getInt("flightid");
                ResultSet myResObj2 = myStatObj.executeQuery("select * from root.flights where id = "+flightId);
                String from = myResObj2.getString("departureairport");
                String to = myResObj2.getString("arrivalairport");
                java.util.Date flightDate = myResObj2.getDate("flightdate");
                String departureTime = myResObj2.getString("departuretime");
                String airLine = myResObj2.getString("airline");
                String flightDuration = myResObj2.getString("flightduration");
                int reservationId = myResObj1.getInt("id");
                ResultSet myResObj3 = myStatObj.executeQuery("select * from root.payments where reservationid = "+reservationId);
                double price = myResObj3.getDouble("paymentamount");
                String tbData[] = {String.valueOf(reservationId),airLine, from, to, String.valueOf(flightDate), departureTime, flightDuration, String.valueOf(numOfSeats), String.valueOf(price), "Cancel"};
                DefaultTableModel reservationTableModel = (DefaultTableModel) reservationTable.getModel();
                reservationTableModel.addRow(tbData);
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        flightsTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bookingsTab = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        PaymentPanel = new javax.swing.JPanel();
        FlightSearchingPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fromSearchTxt = new swing.MyTextField();
        toSearchTxt = new swing.MyTextField();
        jLabel6 = new javax.swing.JLabel();
        departDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ReservationDetailsPanel = new javax.swing.JPanel();
        BookingsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        reservationIdRemoveTxt = new javax.swing.JTextField();
        reservationCancelButton = new javax.swing.JButton();

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
                .addGap(41, 41, 41)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addContainerGap(52, Short.MAX_VALUE))
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
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(flightsTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookingsTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        javax.swing.GroupLayout PaymentPanelLayout = new javax.swing.GroupLayout(PaymentPanel);
        PaymentPanel.setLayout(PaymentPanelLayout);
        PaymentPanelLayout.setHorizontalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        PaymentPanelLayout.setVerticalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        FlightSearchingPanel.setBackground(new java.awt.Color(231, 231, 231));

        jLabel4.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(53, 146, 196));
        jLabel4.setText("From");

        jLabel5.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(53, 146, 196));
        jLabel5.setText("To");

        fromSearchTxt.setBackground(new java.awt.Color(255, 255, 255));
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

        toSearchTxt.setBackground(new java.awt.Color(255, 255, 255));
        toSearchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toSearchTxtMouseClicked(evt);
            }
        });
        toSearchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSearchTxtActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(53, 146, 196));
        jLabel6.setText("Depart Date ");

        departDate.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 146, 196));
        jLabel1.setText("Fill the form below to see the best flight tickets.");

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(53, 146, 196));
        jLabel7.setText("Where Do You Want To Travel?");

        jButton1.setBackground(new java.awt.Color(56, 146, 196));
        jButton1.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FlightSearchingPanelLayout = new javax.swing.GroupLayout(FlightSearchingPanel);
        FlightSearchingPanel.setLayout(FlightSearchingPanelLayout);
        FlightSearchingPanelLayout.setHorizontalGroup(
            FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                            .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(8, 8, 8))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FlightSearchingPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(toSearchTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(departDate, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)))
                        .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                            .addComponent(fromSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlightSearchingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
        );
        FlightSearchingPanelLayout.setVerticalGroup(
            FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlightSearchingPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FlightSearchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(departDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        ReservationDetailsPanel.setBackground(new java.awt.Color(231, 231, 231));

        javax.swing.GroupLayout ReservationDetailsPanelLayout = new javax.swing.GroupLayout(ReservationDetailsPanel);
        ReservationDetailsPanel.setLayout(ReservationDetailsPanelLayout);
        ReservationDetailsPanelLayout.setHorizontalGroup(
            ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        ReservationDetailsPanelLayout.setVerticalGroup(
            ReservationDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        BookingsPanel.setBackground(new java.awt.Color(231, 231, 231));

        reservationTable.setBackground(new java.awt.Color(231, 231, 231));
        reservationTable.setForeground(new java.awt.Color(51, 51, 51));
        reservationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "Airline", "From", "To", "Flight Date", "Departure Time", "Flight Duration", "No. of Seats", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reservationTable.setFocusable(false);
        reservationTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        reservationTable.setRowHeight(25);
        reservationTable.setSelectionBackground(new java.awt.Color(86, 173, 219));
        reservationTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        reservationTable.setShowVerticalLines(false);
        reservationTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(reservationTable);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Reservation ID  : ");

        reservationIdRemoveTxt.setBackground(new java.awt.Color(255, 255, 255));
        reservationIdRemoveTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        reservationIdRemoveTxt.setForeground(new java.awt.Color(51, 51, 51));
        reservationIdRemoveTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationIdRemoveTxtActionPerformed(evt);
            }
        });

        reservationCancelButton.setBackground(new java.awt.Color(153, 0, 0));
        reservationCancelButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        reservationCancelButton.setForeground(new java.awt.Color(255, 255, 255));
        reservationCancelButton.setText("Cancel Reservation");
        reservationCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BookingsPanelLayout = new javax.swing.GroupLayout(BookingsPanel);
        BookingsPanel.setLayout(BookingsPanelLayout);
        BookingsPanelLayout.setHorizontalGroup(
            BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookingsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservationIdRemoveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reservationCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        BookingsPanelLayout.setVerticalGroup(
            BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookingsPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reservationIdRemoveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reservationCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
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
        updateResevrationTable();
    }//GEN-LAST:event_bookingsTabMouseClicked

    private void toSearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSearchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toSearchTxtActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reservationCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationCancelButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel reservation?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        int removedReservationId = Integer.parseInt(reservationIdRemoveTxt.getText());
        if(response == JOptionPane.YES_OPTION){
            flightproject.ReservationP.Reservation.deleteReservation(removedReservationId);
            flightproject.PaymentP.Payment.deletePayment(removedReservationId);
        } else if(response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION){
        }
    }//GEN-LAST:event_reservationCancelButtonActionPerformed

    private void reservationIdRemoveTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationIdRemoveTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reservationIdRemoveTxtActionPerformed
    private List<DataSearch> search(String search) {
        int limitData = 7;
        List<DataSearch> list = new ArrayList<>();
        String dataTesting[] = flightproject.FlightP.Flight.getAirports();
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
    String dataStory[] = {"Cairo",
        "Alexandria",
        "Paris",
        "London",
        "New York"};

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
            java.util.logging.Logger.getLogger(PassengerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassengerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BookingsPanel;
    private javax.swing.JPanel FlightSearchingPanel;
    private javax.swing.JPanel PaymentPanel;
    private javax.swing.JPanel ReservationDetailsPanel;
    private javax.swing.JPanel bookingsTab;
    private com.toedter.calendar.JDateChooser departDate;
    private javax.swing.JPanel flightsTab;
    private swing.MyTextField fromSearchTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton reservationCancelButton;
    private javax.swing.JTextField reservationIdRemoveTxt;
    private javax.swing.JTable reservationTable;
    private swing.MyTextField toSearchTxt;
    // End of variables declaration//GEN-END:variables
}
