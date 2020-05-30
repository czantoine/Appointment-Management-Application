package pjbdd;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModifConsultation extends javax.swing.JFrame implements ActionListener {

    //Datbase Conn
    Connection conn = null;

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    String time;
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();

    public ModifConsultation() {
        initComponents();
        
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        show_cons();
    }

    public ArrayList<Consultations> listeCons() {
        ArrayList<Consultations> consultations = new ArrayList<>();
        try {
            conn = MySQLConnect.connectDB();
            Statement state = conn.createStatement();
            ResultSet resultSet = state.executeQuery("SELECT * FROM consultations");
            Consultations cons;
            while (resultSet.next()) {

                cons = new Consultations(resultSet.getInt("id_consultation"), resultSet.getString("date"), resultSet.getString("heure"), resultSet.getInt("nb_pers"), resultSet.getString("type_paiement"), resultSet.getDouble("prix"), resultSet.getString("type_consultation"), resultSet.getInt("nb_anxiete"), Integer.parseInt(resultSet.getString("etat_consultation")));
                consultations.add(cons);
            }
            resultSet.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("erreur dans crreation liste cons");
        }
        return consultations;

    }

    public void show_cons() {
        ArrayList<Consultations> liste = listeCons();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[8];

        for (int i = 0; i < liste.size(); i++) {
            row[0] = liste.get(i).getIdCons();
            row[1] = liste.get(i).getNbPersonnes();
            row[2] = liste.get(i).getDate();
            row[3] = liste.get(i).getHeure();
            row[4] = liste.get(i).getTypePaiement();
            row[5] = liste.get(i).getPrix();
            row[6] = liste.get(i).getTypeCons();
            row[7] = liste.get(i).getNbAnx();
            model.addRow(row);

        }
    }

    private void initComponents() {

       buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(550, 200);
        setTitle("Update Consultation");
        
        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "idConsultation", "NbPersonnes", "Date", "Heure", "Type Paiement", "Prix", "Type Consultation", "NbAnxiété"
                }
        ));

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Date :");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Time :");

        jRadioButton1.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Morning");

        jRadioButton2.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Afternoon");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Morning :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30"}));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Afternoon :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30"}));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Payment type :");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price :");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Consutation type :");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Advice", "Couple Therapy", "Anxiety", "Depression"}));
        jComboBox4.addActionListener(this);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Anxiety");
        jLabel8.setVisible(false);
        jTextField2.setVisible(false);
        jRadioButton1.addActionListener(this);
        jRadioButton2.addActionListener(this);

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(this);

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(this);

        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jComboBox1.setVisible(false);
        jComboBox2.setVisible(false);
        
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Modify a selected consultation.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton2))
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(101, 101, 101)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(100, 100, 100)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand() == jRadioButton1.getActionCommand()) {

            jComboBox1.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(false);
            jComboBox2.setVisible(false);
            this.revalidate();
            this.repaint();

        }
        if (ae.getActionCommand() == jRadioButton2.getActionCommand()) {

            jComboBox1.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(true);
            jComboBox2.setVisible(true);
            this.revalidate();
            this.repaint();

        }
        if (ae.getActionCommand() == jComboBox4.getActionCommand()) {
            if (jComboBox4.getSelectedItem() == "Anxiety") {
                System.out.println("Axniet");
                jLabel8.setVisible(true);
                jTextField2.setVisible(true);
                this.revalidate();
                this.repaint();
            } else {
                jLabel8.setVisible(false);
                jTextField2.setVisible(false);
                this.revalidate();
                this.repaint();
            }

        }
        if (ae.getActionCommand() == jButton1.getActionCommand()) {//Update button
            try {

                conn = MySQLConnect.connectDB();  //enlever ce commentaire pour connecter a la base de données !!!!
                Date date = jDateChooser1.getDate();

                if ((jComboBox4.getSelectedItem() == "Anxiety" && jTextField2.getText().isEmpty()) || (jTextField3.getText().isEmpty()) || (jTextField1.getText().isEmpty()) || (date == null) || (buttonGroup1.getSelection() == null)) {
                    JOptionPane.showMessageDialog(null, "You must complete ALL fields", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

                } else {

                    //CONDITION PAS DE TRAVAIL LES DIMANCHES
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                    System.out.println("day of week : " + dayOfWeek);
                    if (dayOfWeek == 1) {
                        JOptionPane.showMessageDialog(null, "The office is closed on Sundays", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

                    } else {

                        //Recuperation et formatage date pour inserer dans bdd
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dateformat = sdf.format(date); //format à inserer dans la database

                        ///CONDITION 10 HEURES
                        ResultSet rest = null;
                        PreparedStatement pst2 = conn.prepareStatement("SELECT COUNT(heure) AS rowcount FROM consultations WHERE date=?");
                        pst2.setString(1, dateformat);
                        rest = pst2.executeQuery();

                        int count = 0;
                        while (rest.next()) {
                            count = rest.getInt(1);
                        }

                        if (count == 20) {
                            JOptionPane.showMessageDialog(null, "You can't insert because the day is full of bookings", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

                        } else {

                            if (jRadioButton1.isSelected()) {
                                time = (String) jComboBox1.getSelectedItem() + ":00";//Si c'est le matin
                            } else if (jRadioButton2.isSelected()) {
                                time = (String) jComboBox2.getSelectedItem() + ":00";//Si c'est l'aprem
                            }

                            //CONDITION SI HEURE DEJA BOOKEE
                            ResultSet resdate = null;
                            PreparedStatement pstdate = conn.prepareStatement("SELECT heure FROM consultations WHERE date=?");
                            pstdate.setString(1, dateformat);// a verif avec database
                            resdate = pstdate.executeQuery();

                            while (resdate.next()) {
                                dates.add(resdate.getString(1));//Contient les heures déjà prises à cette date là
                            }

                            boolean verif = false;
                            System.out.println(Time.valueOf(time).toString());

                            for (int i = 0; i < dates.size(); i++) {
                                if (dates.get(i).equals(Time.valueOf(time).toString())) {
                                    verif = true;
                                }

                            }

                            if (verif) {
                                JOptionPane.showMessageDialog(null, "Date and time already booked", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

                            } else {
                                System.out.println("C'est bon on peut book");

                                int row = jTable1.getSelectedRow();
                                String val = (jTable1.getModel().getValueAt(row, 0).toString());//idConsultation
                                PreparedStatement prep = conn.prepareStatement("UPDATE consultations SET date=?, heure=?, type_paiement=?, prix=?, type_consultation=?, nb_anxiete=? WHERE id_consultation=" + val);

                                prep.setString(1, dateformat);
                                prep.setTime(2, Time.valueOf(time));//OU STRING
                                prep.setString(3, jTextField3.getText());
                                prep.setString(4, jTextField1.getText());
                                prep.setString(5, (String) jComboBox4.getSelectedItem());
                                if (jComboBox4.getSelectedItem() == "Anxiety") {
                                    prep.setString(6, jTextField2.getText());
                                } else {
                                    prep.setNull(6, java.sql.Types.INTEGER);
                                }

                                if (prep.executeUpdate() > 0) {
                                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                                    model.setRowCount(0);
                                    show_cons();
                                    JOptionPane.showMessageDialog(null, "Consultation updated sucessfully.");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Error for insert table Consultation", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                }

                            }

                        }

                    }

                }
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (ae.getActionCommand() == jButton2.getActionCommand()) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new MainPage().setVisible(true);
                }
            });
            this.dispose();

        }

    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {

        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String timeDay = model.getValueAt(i, 3).toString();
        System.out.println(timeDay);

        if (timeDay.equals("08:00:00") || timeDay.equals("08:30:00") || timeDay.equals("09:00:00") || timeDay.equals("09:30:00") || timeDay.equals("10:00:00") || timeDay.equals("10:30:00") || timeDay.equals("11:00:00") || timeDay.equals("11:30:00") || timeDay.equals("12:00:00") || timeDay.equals("12:30:00") || timeDay.equals("13:00:00") || timeDay.equals("13:30:00")) {

            jRadioButton1.setSelected(true);
            jComboBox1.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(false);
            jComboBox2.setVisible(false);
            this.revalidate();
            this.repaint();

            switch (timeDay) {
                case "08:00:00":
                    jComboBox1.setSelectedIndex(0);
                    break;
                case "08:30:00":
                    jComboBox1.setSelectedIndex(1);
                    break;
                case "09:00:00":
                    jComboBox1.setSelectedIndex(2);
                    break;
                case "09:30:00":
                    jComboBox1.setSelectedIndex(3);
                    break;
                case "10:00:00":
                    jComboBox1.setSelectedIndex(4);
                    break;
                case "10:30:00":
                    jComboBox1.setSelectedIndex(5);
                    break;
                case "11:00:00":
                    jComboBox1.setSelectedIndex(6);
                    break;
                case "11:30:00":
                    jComboBox1.setSelectedIndex(7);
                    break;
                case "12:00:00":
                    jComboBox1.setSelectedIndex(8);
                    break;
                case "12:30:00":
                    jComboBox1.setSelectedIndex(9);
                    break;
                case "13:00:00":
                    jComboBox1.setSelectedIndex(10);
                    break;
                case "13:30:00":
                    jComboBox1.setSelectedIndex(11);
                    break;

            }

        } else {
            jRadioButton2.setSelected(true);
            jComboBox1.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(true);
            jComboBox2.setVisible(true);

            switch (timeDay) {
                case "14:00:00":
                    jComboBox2.setSelectedIndex(0);
                    break;
                case "14:30:00":
                    jComboBox2.setSelectedIndex(1);
                    break;
                case "15:00:00":
                    jComboBox2.setSelectedIndex(2);
                    break;
                case "15:30:00":
                    jComboBox2.setSelectedIndex(3);
                    break;
                case "16:00:00":
                    jComboBox2.setSelectedIndex(4);
                    break;
                case "16:30:00":
                    jComboBox2.setSelectedIndex(5);
                    break;
                case "17:00:00":
                    jComboBox2.setSelectedIndex(6);
                    break;
                case "17:30:00":
                    jComboBox2.setSelectedIndex(7);
                    break;
                case "18:00:00":
                    jComboBox2.setSelectedIndex(8);
                    break;
                case "18:30:00":
                    jComboBox2.setSelectedIndex(9);
                    break;
                case "19:00:00":
                    jComboBox2.setSelectedIndex(10);
                    break;
                case "19:30:00":
                    jComboBox2.setSelectedIndex(11);
                    break;

            }
            this.revalidate();
            this.repaint();
        }

        jTextField3.setText(model.getValueAt(i, 4).toString());
        jTextField1.setText(model.getValueAt(i, 5).toString());

        String typeCons = model.getValueAt(i, 6).toString();

        if (typeCons.equals("Anxiety")) {

            jLabel8.setVisible(true);
            jTextField2.setVisible(true);
            this.revalidate();
            this.repaint();
            jComboBox4.setSelectedIndex(2);

            jTextField2.setText(model.getValueAt(i, 7).toString());

        } else {
            switch (typeCons) {
                case "Advice":
                    jComboBox4.setSelectedIndex(0);
                    break;
                case "Couple Therapy":
                    jComboBox4.setSelectedIndex(1);
                    break;
                case "Depression":
                    jComboBox4.setSelectedIndex(3);
                    break;

            }

        }
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 2));
            jDateChooser1.setDate(date);
        } catch (Exception e) {
            System.out.println("Erreur dans jdatechooser");
        }

        //String dateString = ((jTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        //jDateChooser1.setCalendar((Calendar)model.getValueAt(a, 1).toString());
        // String time = model.getValueAt(a, a)
    }

}
