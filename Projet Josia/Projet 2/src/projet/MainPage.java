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

//page main de la psy

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MainPage extends javax.swing.JFrame implements ActionListener {

    //Datbase Conn
    Connection conn = null;
    Statement stmt = null;
    ResultSet result = null;
    PreparedStatement pstmt = null;

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration   

    public MainPage() throws HeadlessException {
        initComponents();
     
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(550, 200);
        setTitle("Psychologist appointments");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setText("WELCOME.");

        jButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton1.setText("Add Patient");
        jButton1.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //si on clique sur addpatient
        if (ae.getActionCommand() == jButton1.getActionCommand()) {
            
            


            System.out.println("Tout va bien INSH");
            java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            //new AddPatient().setVisible(true); //Lancer la page de patient
                            
                            new AddConsultation().setVisible(true); //Lancer la page de consultation

                          
                        }
                    });
                    
                    this.dispose(); //eteindre la page 

        }

    }

}
