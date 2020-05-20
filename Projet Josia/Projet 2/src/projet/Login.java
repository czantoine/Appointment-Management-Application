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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame implements ActionListener {

    //Datbase Conn
    Connection conn = null;
    //DECLARATION DES UTILISATIONS
    //Creation d'un objet Statement
    Statement stmt = null;
    //L'obj ResultSet contient le resultat de la requete SQL
    ResultSet result = null;
    PreparedStatement pstmt = null;

    //les boutons et les affichages en attributs d'interface
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    // ctor de login appelle initComponents générée automatiquement
    public Login() throws HeadlessException {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //placement de l'interface à l'affichage
        setLocation(550, 200);
        setTitle("Psychologist appointments");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Email Adress");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        jTextField1.setText("");

        jTextField2.setText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"admin", "user"}));
        jComboBox1.addActionListener(this);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(193, 193, 193)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(37, 37, 37)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                                                .addComponent(jTextField2)))))
                                .addContainerGap(98, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(24, 24, 24))
        );

        pack();
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {

        // si quelquun appuie sur le bouton alors on compile le code
        if (ae.getActionCommand() == jButton1.getActionCommand()) {

            conn = MySQLConnect.connectDB();
            try {
                String combo = (String) jComboBox1.getSelectedItem();
                //si au moins un des champs est vide on affiche une erreur
                if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || combo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must complete ALL fields", "Access Denied", JOptionPane.ERROR_MESSAGE);

                } else {
                    pstmt = conn.prepareStatement("SELECT * FROM users WHERE mail=? AND password=? AND type=?");

                    pstmt.setString(1, jTextField1.getText());
                    pstmt.setString(2, jTextField2.getText());
                    pstmt.setString(3, (String) jComboBox1.getSelectedItem());
                    result = pstmt.executeQuery();
                    System.out.println(jComboBox1.getSelectedItem());

                    if (result.next()) {

                        JOptionPane.showMessageDialog(null, "Successly Connected.");

                        String username = jTextField1.getText();
                        int pass = Integer.parseInt(jTextField2.getText());
                        String type = (String) jComboBox1.getSelectedItem();

                        // création d'un nouvel Utilisateur actuel
                        User current = new User(username, pass, type); 
                        //on garde les infos du user
                        Projet.cur = current;

                        //si cc'est un admin on affiche la page mainpage pour les admin
                        if (current.getType() == "admin") {
                            System.out.println("On rentra dans la page reservee a psy");

                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    new MainPage().setVisible(true); //Page admin

                                }
                            });

                        } else if (current.getType() == "user") {
                            System.out.println("On rentra dans la page reservee a user");

                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    new MainPageP().setVisible(true); //Page patient

                                }
                            });

                        }

                        this.dispose(); //eteindre la page Login
                        result.close();
                        pstmt.close();

                    } else {
                        JOptionPane.showMessageDialog(null, "Mail, password or type of user not recognized", "Access Denied", JOptionPane.ERROR_MESSAGE);
                    }
                }

                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur catch");
            }

        }

    }

}