/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author josia
 */
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import java.text.DateFormat;

public class AddConsultation extends javax.swing.JFrame implements ActionListener {

    //Datbase Conn
    Connection conn = null;
    Statement stmt = null;
    ResultSet result = null;
    PreparedStatement pstmt = null;

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration     

    private ArrayList<String> valeur = new ArrayList();
    
//     private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
//        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
//        return sDate;
   

    public AddConsultation() throws HeadlessException {
        initComponents();
        
    }

    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(550, 200);
        setTitle("New Consultation");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Add a new Consultation :");

        jLabel2.setText("Nombre de personnes :");

        jLabel3.setText("Patient 1 :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3"}));
        jComboBox1.addActionListener(this);

        jLabel4.setText("Patient 2 :");
        jLabel4.setVisible(false);

        jLabel5.setText("Patient 3 :");
        jLabel5.setVisible(false);

        jTextField2.setVisible(false);

        jTextField3.setVisible(false);

        jLabel6.setText("Price :");

        jLabel7.setText("Payment type :");

        jLabel8.setText("Consultation type :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Advice", "Couple Therapy", "Anxiety", "Depression"}));
        jComboBox2.addActionListener(this);

        jLabel9.setText("Anxiety number :");
        jLabel9.setVisible(false);
        jTextField6.setVisible(false);

        jLabel10.setText("Date :");

        jLabel11.setText("Time :");

        buttonGroup.add(jRadioButton3);
        jRadioButton3.setText("In the morning");
        jRadioButton3.addActionListener(this);

        buttonGroup.add(jRadioButton4);
        jRadioButton4.setText("In the afternoon");
        jRadioButton4.addActionListener(this);

        jLabel12.setText("Morning :");
        jLabel12.setVisible(false);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30"}));
        jComboBox3.setVisible(false);

        jLabel13.setText("Afternoon :");
        jLabel13.setVisible(false);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30"}));
        jComboBox4.setVisible(false);

        jButton1.setText("Submit the Consultation");
        jButton1.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel11))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addComponent(jRadioButton3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton4))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(63, 63, 63)
                                                                .addComponent(jLabel13)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel7)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabel10))
                                                        .addGap(39, 39, 39)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField1)
                                                                        .addComponent(jTextField2)
                                                                        .addComponent(jTextField3)
                                                                        .addComponent(jTextField4))
                                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 42, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1)))
                                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jRadioButton3)
                                                .addComponent(jRadioButton4)))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(23, 23, 23))
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand() == jComboBox1.getActionCommand()) {
            System.out.println("fsefs");
            
            //Affichage ou non des champs patient en fonction du nb de personnes dans la consultation
            if (jComboBox1.getSelectedItem() == "1") {
                System.out.println("DEUXIEME SYSOUT");
                jTextField1.setVisible(true);
                jTextField2.setVisible(false);
                jTextField3.setVisible(false);

                jLabel3.setVisible(true);
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);

                this.revalidate();
                this.repaint();
            } else if (jComboBox1.getSelectedItem() == "2") {

                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
                jTextField3.setVisible(false);

                jLabel3.setVisible(true);
                jLabel4.setVisible(true);
                jLabel5.setVisible(false);
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
        
        //combobox avec les heures si le type choisi est matin/soir l'un est affiché et l'autre non
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
        
        //combobox avec le type de consultation
        if (ae.getActionCommand() == jComboBox2.getActionCommand()) {
            
            //si c'est l'anxiete on active le nombre d'anxiete si le type de consultation est l'anxiete
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
            ResultSet res = null;
            PreparedStatement pst = null;
            
            
           
            
            

            try {
                Date uDate = jDateChooser1.getDate();
                
                 //convertir la date du java en sql
                java.sql.Date sqlDate = new java.sql.Date(uDate.getTime());
                
                //convertion de java util en java sql
               // java.sql.Date sDate = convertUtilToSql(uDate);
                
                if (((jComboBox1.getSelectedItem() == "1" && jTextField1.getText().isEmpty()) || (jComboBox1.getSelectedItem() == "2" && (jTextField2.getText().isEmpty() || jTextField1.getText().isEmpty())) || (jComboBox1.getSelectedItem() == "3" && (jTextField2.getText().isEmpty() || jTextField1.getText().isEmpty() || jTextField3.getText().isEmpty()))) || (jComboBox2.getSelectedItem() == "Anxiety" && jTextField6.getText().isEmpty()) || (jTextField4.getText().isEmpty()) || (jTextField5.getText().isEmpty()) || (uDate == null) || (buttonGroup.getSelection() == null)) {
                    JOptionPane.showMessageDialog(null, "You must complete ALL fields", "Insertion Denied", JOptionPane.ERROR_MESSAGE);
                    System.out.println("C'estpas bon");

                } else {
                    /*if (jTextField1.getText() == jTextField2.getText() || jTextField1.getText() == jTextField3.getText() || jTextField2.getText() == jTextField1.getText() || jTextField2.getText() == jTextField3.getText() || jTextField3.getText() == jTextField1.getText() || jTextField3.getText() == jTextField2.getText()) {
                    } else {
                    }*/
                    
                    System.out.println("C'est bon");
                        //METTRE ICI LES REQUETES, SQL ETC (BASE DE DONNEES)
                        
                    
                    //Creation fk recupération de idpatient dans consulte
                    pstmt = conn.prepareStatement("INSERT INTO consulte (idpatient, id_consultation) VALUES (?,?,?)");
                    pstmt.setString(1, jTextField1.getText());
                    //pstmt.setString(2, jTextField2.getText()); 
                    //pstmt.setString(3, "user");

                    //si cette requete a ete faite on peut faire les autres
                    if (pstmt.executeUpdate() > 0) {

                        JOptionPane.showMessageDialog(null, "Successly Connected.");
                        JOptionPane.showMessageDialog(null, "The idpatient was successfully inserted.");

                        //Creation nouvelle consultation
                        PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO 'consultation'('nb_personnes', 'Date','heure', 'Prix', 'type_paiement', 'type_de_consultation', 'nb_anxiete', 'id_patient') VALUES (?,?,?,?,?,?,?,?)");
                        
                        //nb de personnnes
                        stmt1.setString(1, (String) jComboBox1.getSelectedItem()); 
                
                        //date 
                        stmt1.setDate(2, sqlDate);
                  
                        //heure
                        if (jRadioButton3.addActionListener(this)){ 
                            stmt1.setString(3, (String) jComboBox3.getSelectedItem());  } 
                        
                        stmt1.setString(3, (String) jComboBox4.getSelectedItem());
                        
                        // prix
                        stmt1.setString(4, jTextField4.getText());
                        
                        //type paiement
                        stmt1.setString(5, jTextField5.getText()); 
                        
                        //type consultation
                        stmt1.setString(6, (String) jComboBox2.getSelectedItem()); 
                        
                        //nb d'anxiete
                        if(jComboBox2.getSelectedItem() == "Anxiety"){ 
                        stmt1.setString(7, jTextField6.getText());}
                        

                        if (stmt1.executeUpdate() > 0) {
                            JOptionPane.showMessageDialog(null, "A new consultation was successfully inserted.");

                            //ajout dans la table consulte
                            pst = conn.prepareStatement("SELECT id_patient FROM patients WHERE nom=?");
                            
                            pst.setString(1, jTextField1.getText());
                            res = pst.executeQuery();
                            
                            pst.setString(1, jTextField2.getText());
                            res = pst.executeQuery();
                            
                            pst.setString(1, jTextField3.getText());
                            res = pst.executeQuery();

                            if (res.next()) {

                                System.out.println(res.getString(1));
                                valeur.add(res.getString(1)); //stockage de l'id dans un tableau on s'en sert pour la fk

                            }

                            //Trouver le moyen de recuperer la valeur de l'id patient qui est entrain d'etre crée !!!ICI A REPRENDRE
                            PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO consulte (idpatient, idconsultation) VALUES (?, ?)");
                            stmt2.setString(1, jTextField1.getText());
                            stmt2.setString(2, valeur.get(0));

                            if (stmt2.executeUpdate() > 0) {
                                JOptionPane.showMessageDialog(null, "A new fk in consulte was successfully inserted.");

                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        new MainPage().setVisible(true); //Page psy

                                    }
                                });
                                this.dispose();

                            } else {
                                JOptionPane.showMessageDialog(null, "Error for the previous job", "Not inserted", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {

                            JOptionPane.showMessageDialog(null, "Patient error", "Not inserted", JOptionPane.ERROR_MESSAGE);

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Problem detected for patient", "Insertion Denied", JOptionPane.ERROR_MESSAGE);
                    }

                }
                conn.close();

                }
             catch (Exception e) {
                 e.printStackTrace();
                System.out.println("Erreur catch");
            }
        }

    }

}
