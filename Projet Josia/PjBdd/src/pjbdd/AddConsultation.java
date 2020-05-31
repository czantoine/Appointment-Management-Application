package pjbdd;

import java.awt.Dimension;
import java.awt.HeadlessException;
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
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddConsultation extends javax.swing.JFrame implements ActionListener {

    //Datbase Conn
    Connection conn = null;

    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    String time;
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> verifid = new ArrayList<>();

    public AddConsultation() throws HeadlessException {
        initComponents();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

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
            System.out.println("erreur dans creation liste cons");
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

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(550, 200);
        setTitle("New Consultation");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Add a new Consultation :");

        jLabel2.setText("Number of persons :");
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Patient 1 :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3"}));
        jComboBox1.addActionListener(this);

        jLabel4.setText("Patient 2 :");
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setVisible(false);

        jLabel5.setText("Patient 3 :");
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setVisible(false);

        jTextField2.setVisible(false);

        jTextField3.setVisible(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price :");

        jLabel7.setText("Payment type :");
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Type :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Advice", "Couple Therapy", "Anxiety", "Depression"}));
        jComboBox2.addActionListener(this);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Anxiety number :");
        jLabel9.setVisible(false);
        jTextField6.setVisible(false);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Time :");

        buttonGroup.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setBackground(new java.awt.Color(102, 153, 255));
        jRadioButton3.setText("In the morning");
        jRadioButton3.addActionListener(this);

        buttonGroup.add(jRadioButton4);
        jRadioButton4.setBackground(new java.awt.Color(102, 153, 255));
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("In the afternoon");
        jRadioButton4.addActionListener(this);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Morning :");
        jLabel12.setVisible(false);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30"}));
        jComboBox3.setVisible(false);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Afternoon :");
        jLabel13.setVisible(false);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30"}));
        jComboBox4.setVisible(false);

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit the Consultation");
        jButton1.addActionListener(this);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "idConsultation", "NbPersonnes", "Date", "Heure", "Type Paiement", "Prix", "Type Consultation", "NbAnxiété"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(693, 693, 693))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel10))
                                                                .addGap(39, 39, 39)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jLabel9)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(416, 416, 416))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(jTextField5)
                                                                                                .addComponent(jTextField1)
                                                                                                .addComponent(jTextField2)
                                                                                                .addComponent(jTextField3)
                                                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(58, 58, 58)
                                                                                .addComponent(jScrollPane1))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel11)
                                                                        .addComponent(jLabel12))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(28, 28, 28)
                                                                                .addComponent(jLabel13)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(131, 131, 131)
                                                                                .addComponent(jButton1)
                                                                                .addGap(19, 19, 19))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jRadioButton3)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jRadioButton4))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jRadioButton3)
                                                .addComponent(jRadioButton4)))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
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
        if (ae.getActionCommand() == jComboBox1.getActionCommand()) {
            //Affichage ou non des champs patient en fonction du nb de personnes dans la consultation
            if (jComboBox1.getSelectedItem() == "1") {
                jTextField1.setVisible(true);
                jTextField2.setVisible(false);
                jTextField3.setVisible(false);

                jLabel3.setVisible(true);
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);

                jTextField2.setText("");
                jTextField3.setText("");

                this.revalidate();
                this.repaint();
            } else if (jComboBox1.getSelectedItem() == "2") {

                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
                jTextField3.setVisible(false);

                jLabel3.setVisible(true);
                jLabel4.setVisible(true);
                jLabel5.setVisible(false);

                jTextField3.setText("");

                this.revalidate();
                this.repaint();

            } else if (jComboBox1.getSelectedItem() == "3") {
                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
                jTextField3.setVisible(true);

                jLabel5.setVisible(true);
                jLabel3.setVisible(true);
                jLabel4.setVisible(true);

                this.revalidate();
                this.repaint();

            }

        }
        if (ae.getActionCommand() == jRadioButton3.getActionCommand()) {

            jComboBox3.setVisible(true);
            jLabel12.setVisible(true);
            jLabel13.setVisible(false);
            jComboBox4.setVisible(false);
            this.revalidate();
            this.repaint();

        }
        if (ae.getActionCommand() == jRadioButton4.getActionCommand()) {

            jComboBox3.setVisible(false);
            jLabel12.setVisible(false);
            jLabel13.setVisible(true);
            jComboBox4.setVisible(true);
            this.revalidate();
            this.repaint();

        }
        if (ae.getActionCommand() == jComboBox2.getActionCommand()) {
            if (jComboBox2.getSelectedItem() == "Anxiety") {
                jLabel9.setVisible(true);
                jTextField6.setVisible(true);
                this.revalidate();
                this.repaint();
            } else {
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
                this.revalidate();
                this.repaint();
            }

        }
        if (ae.getActionCommand() == jButton1.getActionCommand()) {

            conn = MySQLConnect.connectDB();  //enlever ce commentaire pour connecter a la base de données !!!!
            PreparedStatement pst = null;
            try {

                Date date = jDateChooser1.getDate();

                if (((jComboBox1.getSelectedItem() == "1" && jTextField1.getText().isEmpty()) || (jComboBox1.getSelectedItem() == "2" && (jTextField2.getText().isEmpty() || jTextField1.getText().isEmpty())) || (jComboBox1.getSelectedItem() == "3" && (jTextField2.getText().isEmpty() || jTextField1.getText().isEmpty() || jTextField3.getText().isEmpty()))) || (jComboBox2.getSelectedItem() == "Anxiety" && jTextField6.getText().isEmpty()) || (jTextField4.getText().isEmpty()) || (jTextField5.getText().isEmpty()) || (date == null) || (buttonGroup.getSelection() == null)) {
                    JOptionPane.showMessageDialog(null, "You must complete ALL fields", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

                }
                if (jTextField1.getText().equals("1") || jTextField2.getText().equals("1") || jTextField3.getText().equals("1")) {
                    JOptionPane.showMessageDialog(null, "You can't insert the psy (admin)", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

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

                            //ici faire requete pour table Consulte
                            if (jComboBox1.getSelectedItem() == "1") {

                                try {

                                    PreparedStatement prestae = conn.prepareStatement("SELECT id_patient FROM patients");
                                    ResultSet resultid = prestae.executeQuery();

                                    while (resultid.next()) {
                                        verifid.add(resultid.getString(1));//Contient les ids de la bdd
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                boolean verifids = false;

                                for (int i = 0; i < verifid.size(); i++) {
                                    if (verifid.get(i).equals(jTextField1.getText())) {
                                        verifids = true;

                                    }

                                }

                                if (verifids) { //condition que le patient existe dans la bdd

                                    if (jRadioButton3.isSelected()) {
                                        time = (String) jComboBox3.getSelectedItem() + ":00";//Si c'est le matin
                                    } else if (jRadioButton4.isSelected()) {
                                        time = (String) jComboBox4.getSelectedItem() + ":00";//Si c'est l'aprem
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

                                        pst = conn.prepareStatement("INSERT INTO consultations (date, heure, nb_pers, type_paiement, prix, type_consultation, nb_anxiete) VALUES ( ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);//permet d'envoyer l'id consultation qui se crée automatiquement

                                        pst.setString(1, dateformat);
                                        pst.setTime(2, Time.valueOf(time));//OU STRING
                                        pst.setString(3, (String) jComboBox1.getSelectedItem());
                                        pst.setString(4, jTextField5.getText());
                                        pst.setString(5, jTextField4.getText());
                                        pst.setString(6, (String) jComboBox2.getSelectedItem());
                                        if (jComboBox2.getSelectedItem() == "Anxiety") {
                                            pst.setString(7, jTextField6.getText());
                                        } else {
                                            pst.setNull(7, java.sql.Types.INTEGER);
                                        }

                                        if (pst.executeUpdate() > 0) {
                                            JOptionPane.showMessageDialog(null, "Consultation inserted.");

                                            ResultSet rset = pst.getGeneratedKeys();

                                            if (rset.next()) {

                                                ids.add(rset.getInt(1));
                                                System.out.println("tab ids ");

                                            }

                                            //Insertion ids dans table consulte
                                            PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO consulte (id_patientcons,id_consultation) VALUES (?, ?)");
                                            stmt2.setString(1, jTextField1.getText());
                                            stmt2.setInt(2, ids.get(0));
                                            System.out.println(ids.get(0));

                                            if (stmt2.executeUpdate() > 0) {

                                                PreparedStatement pstn = conn.prepareStatement("INSERT INTO comportement (id_consu) VALUES (?)");
                                                pstn.setInt(1, ids.get(0));
                                                pstn.execute();

                                                PreparedStatement pst3 = conn.prepareStatement("INSERT INTO posture (id_consultation) VALUES (?)");
                                                pst3.setInt(1, ids.get(0));
                                                pst3.execute();

                                                PreparedStatement pstm = conn.prepareStatement("INSERT INTO mots_cle (id_consult) VALUES (?)");
                                                pstm.setInt(1, ids.get(0));
                                                pstm.execute();

                                                JOptionPane.showMessageDialog(null, "Consulte inserted.");
                                                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                                                model1.setRowCount(0);
                                                show_cons();
                                                JOptionPane.showMessageDialog(null, "Successfully inserted");
                                                java.awt.EventQueue.invokeLater(new Runnable() {
                                                    public void run() {

                                                        new MainPage().setVisible(true);
                                                    }
                                                });
                                                this.dispose();
                                                stmt2.close();
                                                rest.close();
                                                rset.close();

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error for insert table consulte", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Error for insert table Consultation", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                        }

                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "The patient doesn't exist, create him", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                }
                            } else if (jComboBox1.getSelectedItem() == "2") {//INSERTION POUR DEUX PATIENTS
                                if (jTextField1.getText().equals(jTextField2.getText()) || jTextField2.getText().equals(jTextField1.getText())) {
                                    JOptionPane.showMessageDialog(null, "Patients must different", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

                                } else {
                                    //Verification user existe
                                    try {

                                        PreparedStatement prestae = conn.prepareStatement("SELECT id_patient FROM patients");
                                        ResultSet resultid = prestae.executeQuery();

                                        while (resultid.next()) {
                                            verifid.add(resultid.getString(1));//Contient les heures déjà prises à cette date là
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    boolean verifids1 = false;

                                    for (int i = 0; i < verifid.size(); i++) {
                                        if (verifid.get(i).equals(jTextField1.getText())) {
                                            verifids1 = true;
                                        }

                                    }

                                    boolean verifids2 = false;
                                    for (int i = 0; i < verifid.size(); i++) {
                                        if (verifid.get(i).equals(jTextField2.getText())) {
                                            verifids2 = true;
                                        }

                                    }

                                    if (verifids1 && verifids2) {

                                        if (jRadioButton3.isSelected()) {
                                            time = (String) jComboBox3.getSelectedItem() + ":00";//Si c'est le matin
                                        } else if (jRadioButton4.isSelected()) {
                                            time = (String) jComboBox4.getSelectedItem() + ":00";//Si c'est l'aprem
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
                                            System.out.println("On peut book aussi dans 2");

                                            pst = conn.prepareStatement("INSERT INTO consultations (date, heure, nb_pers, type_paiement, prix, type_consultation, nb_anxiete) VALUES ( ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

                                            pst.setString(1, dateformat);
                                            pst.setTime(2, Time.valueOf(time));
                                            pst.setString(3, (String) jComboBox1.getSelectedItem());
                                            pst.setString(4, jTextField5.getText());
                                            pst.setString(5, jTextField4.getText());
                                            pst.setString(6, (String) jComboBox2.getSelectedItem());
                                            if (jComboBox2.getSelectedItem() == "Anxiety") {
                                                pst.setString(7, jTextField6.getText());
                                            } else {
                                                pst.setNull(7, java.sql.Types.INTEGER);
                                            }

                                            if (pst.executeUpdate() > 0) {
                                                JOptionPane.showMessageDialog(null, "Consultation inserted.");
                                                System.out.println("Ca va pst.executeUpdate ");

                                                ResultSet rset = pst.getGeneratedKeys();
                                                System.out.println("Ca va pst.executeUpdate ");

                                                if (rset.next()) {

                                                    ids.add(rset.getInt(1));
                                                    System.out.println("tab ids ");

                                                }
                                                PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO consulte (id_patientcons,id_consultation) VALUES (?, ?)");
                                                stmt2.setString(1, jTextField1.getText());
                                                stmt2.setInt(2, ids.get(0));

                                                if (stmt2.executeUpdate() > 0) {

                                                    PreparedStatement prepst = conn.prepareStatement("INSERT INTO consulte (id_patientcons,id_consultation) VALUES (?, ?)");
                                                    prepst.setString(1, jTextField2.getText());
                                                    prepst.setInt(2, ids.get(0));

                                                    if (prepst.executeUpdate() > 0) {

                                                        PreparedStatement pstn = conn.prepareStatement("INSERT INTO comportement (id_consu) VALUES (?)");
                                                        pstn.setInt(1, ids.get(0));
                                                        pstn.execute();

                                                        PreparedStatement pst3 = conn.prepareStatement("INSERT INTO posture (id_consultation) VALUES (?)");
                                                        pst3.setInt(1, ids.get(0));
                                                        pst3.execute();

                                                        PreparedStatement pstm = conn.prepareStatement("INSERT INTO mots_cle (id_consult) VALUES (?)");
                                                        pstm.setInt(1, ids.get(0));
                                                        pstm.execute();

                                                        JOptionPane.showMessageDialog(null, "Consulte inserted.");
                                                        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                                                        model1.setRowCount(0);
                                                        show_cons();
                                                        JOptionPane.showMessageDialog(null, "Successfully inserted");
                                                        java.awt.EventQueue.invokeLater(new Runnable() {
                                                            public void run() {

                                                                new MainPage().setVisible(true);
                                                            }
                                                        });
                                                        this.dispose();
                                                        prepst.close();

                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error for insert table consulte 2eme patient", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Error for insert table consulte 1er patient", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error for insert table Consultation", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "One of the patients doesn't doesn't exist, create him", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else if (jComboBox1.getSelectedItem() == "3") {//INSERTION POUR TROIS PATIENTS
                                if (jTextField1.getText().equals(jTextField2.getText()) || jTextField1.getText().equals(jTextField3.getText()) || jTextField2.getText().equals(jTextField1.getText()) || jTextField2.getText().equals(jTextField3.getText()) || jTextField3.getText().equals(jTextField1.getText()) || jTextField3.getText().equals(jTextField2.getText())) {
                                    JOptionPane.showMessageDialog(null, "Patients must different", "Insertion Denied", JOptionPane.ERROR_MESSAGE);

                                } else {

                                    //Verification user existe
                                    try {

                                        PreparedStatement prestae = conn.prepareStatement("SELECT id_patient FROM patients");
                                        ResultSet resultid = prestae.executeQuery();

                                        while (resultid.next()) {
                                            verifid.add(resultid.getString(1));//Contient les heures déjà prises à cette date là
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    boolean verifids1 = false;

                                    for (int i = 0; i < verifid.size(); i++) {
                                        if (verifid.get(i).equals(jTextField1.getText())) {
                                            verifids1 = true;
                                        }

                                    }

                                    boolean verifids2 = false;
                                    for (int i = 0; i < verifid.size(); i++) {
                                        if (verifid.get(i).equals(jTextField2.getText())) {
                                            verifids2 = true;
                                        }

                                    }

                                    boolean verifids3 = false;
                                    for (int i = 0; i < verifid.size(); i++) {
                                        if (verifid.get(i).equals(jTextField3.getText())) {
                                            verifids3 = true;
                                        }

                                    }

                                    if (verifids1 && verifids2 && verifids3) {

                                        System.out.println("Oui consulte inserted");

                                        if (jRadioButton3.isSelected()) {
                                            time = (String) jComboBox3.getSelectedItem() + ":00";//Si c'est le matin
                                        } else if (jRadioButton4.isSelected()) {
                                            time = (String) jComboBox4.getSelectedItem() + ":00";//Si c'est l'aprem
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

                                            System.out.println("On peut book aussi dans 2");

                                            pst = conn.prepareStatement("INSERT INTO consultations (date, heure, nb_pers, type_paiement, prix, type_consultation, nb_anxiete) VALUES ( ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

                                            pst.setString(1, dateformat);
                                            pst.setTime(2, Time.valueOf(time));//OU STRING
                                            pst.setString(3, (String) jComboBox1.getSelectedItem());
                                            pst.setString(4, jTextField5.getText());
                                            pst.setString(5, jTextField4.getText());
                                            pst.setString(6, (String) jComboBox2.getSelectedItem());
                                            if (jComboBox2.getSelectedItem() == "Anxiety") {
                                                pst.setString(7, jTextField6.getText());
                                            } else {
                                                pst.setNull(7, java.sql.Types.INTEGER);
                                            }

                                            if (pst.executeUpdate() > 0) {
                                                JOptionPane.showMessageDialog(null, "Consultation inserted.");
                                                System.out.println("Ca va pst.executeUpdate ");

                                                ResultSet rset = pst.getGeneratedKeys();
                                                System.out.println("Ca va pst.executeUpdate ");

                                                if (rset.next()) {

                                                    ids.add(rset.getInt(1));
                                                    System.out.println("tab ids ");

                                                }

                                                //Insertion ids dans table consulte
                                                PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO consulte (id_patientcons,id_consultation) VALUES (?, ?)");
                                                stmt2.setString(1, jTextField1.getText());
                                                stmt2.setInt(2, ids.get(0));

                                                if (stmt2.executeUpdate() > 0) {

                                                    PreparedStatement prepst = conn.prepareStatement("INSERT INTO consulte (id_patientcons,id_consultation) VALUES (?, ?)");
                                                    prepst.setString(1, jTextField2.getText());
                                                    prepst.setInt(2, ids.get(0));

                                                    if (prepst.executeUpdate() > 0) {

                                                        PreparedStatement prep3 = conn.prepareStatement("INSERT INTO consulte (id_patientcons,id_consultation) VALUES (?, ?)");
                                                        prep3.setString(1, jTextField3.getText());
                                                        prep3.setInt(2, ids.get(0));

                                                        if (prep3.executeUpdate() > 0) {

                                                            PreparedStatement pstn = conn.prepareStatement("INSERT INTO comportement (id_consu) VALUES (?)");
                                                            pstn.setInt(1, ids.get(0));
                                                            pstn.execute();

                                                            PreparedStatement pst3 = conn.prepareStatement("INSERT INTO posture (id_consultation) VALUES (?)");
                                                            pst3.setInt(1, ids.get(0));
                                                            pst3.execute();

                                                            PreparedStatement pstm = conn.prepareStatement("INSERT INTO mots_cle (id_consult) VALUES (?)");
                                                            pstm.setInt(1, ids.get(0));
                                                            pstm.execute();

                                                            JOptionPane.showMessageDialog(null, "Consulte inserted.");
                                                            DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                                                            model1.setRowCount(0);
                                                            show_cons();

                                                            JOptionPane.showMessageDialog(null, "Successfully inserted");
                                                            java.awt.EventQueue.invokeLater(new Runnable() {
                                                                public void run() {

                                                                    new MainPage().setVisible(true);
                                                                }
                                                            });
                                                            this.dispose();
                                                            prepst.close();
                                                            prep3.close();
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Error for insert table consulte 3eme patient", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                                        }

                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error for insert table consulte 2eme patient", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Error for insert table consulte 1er patient", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error for insert table Consultation", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "One of the patients doesn't doesn't exist, create him", "Not inserted", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }

                        }
                    }
                }
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong", "Not inserted", JOptionPane.ERROR_MESSAGE);
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

}
