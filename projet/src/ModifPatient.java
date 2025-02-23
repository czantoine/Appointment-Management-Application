
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModifPatient extends javax.swing.JFrame {
     Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
   
    public ModifPatient() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
        show_user();
    }
    
  
    
    public ArrayList<Patient>ListPatient(){
        ArrayList<Patient> patientList = new ArrayList<>();
             conn = SQLConnection.connectDB();
        
 
        
        try{
 
            st = conn.createStatement();
            String query1 = "SELECT * FROM patient";
            st = conn.createStatement();
            rs = st.executeQuery(query1);
            Patient patient;
            
            while(rs.next()){
                patient = new Patient(
                                     rs.getInt("id_patient"),
                                     rs.getString("type"),
                                     rs.getString("Nom"),
                                     rs.getString("Prenom"),
                                     rs.getString("Email"),
                                     rs.getString("Nd_Prenom"),
                                     rs.getString("Sexe"),
                                     rs.getString("Connaissance"),
                                     rs.getString("Profession_actuelle"),
                                     rs.getString("Profession_anterieur"),
                                     rs.getString("Classification")
                                     );
                patientList.add(patient);            
            }       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return patientList;
    }
    
    public void show_user(){
        ArrayList<Patient> list = ListPatient();
        DefaultTableModel model = (DefaultTableModel)modiftable.getModel();
        model.setColumnIdentifiers(new Object[]{"id_patient","Nom","Prenom","Email","Nd_Prenom","Sexe","Connaissance","Profession_actuelle","Profession_anterieur","Classification"});
        Object[] row = new Object [10];
        
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getId_patient();
            row[1] = list.get(i).getNom();
            row[2] = list.get(i).getPrenom();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getNd_prenom();
            row[5] = list.get(i).getSexe();
            row[6] = list.get(i).getConnaissance();
            row[7] = list.get(i).getProfession_actuelle();
            row[8] = list.get(i).getProfession_anterieur();
            row[9] = list.get(i).getClassification();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNd_Prenom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbClassification = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbConnaissance = new javax.swing.JComboBox<>();
        txtProfession_actuelle = new javax.swing.JTextField();
        txtProfession_anterieur = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btxtEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        modiftable = new javax.swing.JTable();
        txtNom = new javax.swing.JLabel();
        txtPrenom = new javax.swing.JLabel();
        cmbSexe = new javax.swing.JLabel();
        txtMotdepasse = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Modifier un patient");

        jLabel4.setText("Second Prénom :");

        txtNd_Prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNd_PrenomActionPerformed(evt);
            }
        });

        jLabel6.setText("Classification :");

        cmbClassification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enfant", "Ado", "Femme", "Homme", "Couple" }));

        jLabel7.setText("Connaissance :");

        jLabel8.setText("Profession actuelle : ");

        jLabel9.setText("Profession antérieur :");

        cmbConnaissance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autre patient", "Docteur", "Bouche à oreille", "Pages Jaunes", "Internet", "Autre" }));

        txtProfession_anterieur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfession_anterieurActionPerformed(evt);
            }
        });

        back.setText("Retourner au menu");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel10.setText("Email : ");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btxtEmail.setText("*");

        modiftable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        modiftable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modiftableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(modiftable);

        txtNom.setText("jLabel2");

        txtPrenom.setText("jLabel2");

        cmbSexe.setText("jLabel2");

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Suppresion");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNd_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbConnaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProfession_actuelle, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProfession_anterieur, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbClassification, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btxtEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(update)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(back)
                        .addGap(140, 193, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPrenom)
                                    .addComponent(cmbSexe)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtMotdepasse)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNd_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btxtEmail)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbConnaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMotdepasse))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtProfession_actuelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtProfession_anterieur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtPrenom)
                                .addGap(15, 15, 15)
                                .addComponent(cmbSexe)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update)
                            .addComponent(delete))
                        .addGap(16, 16, 16))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Mainmenu back = new Mainmenu ();
        back.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void txtProfession_anterieurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfession_anterieurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfession_anterieurActionPerformed

    private void modiftableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiftableMouseClicked
        int i = modiftable.getSelectedRow();
        TableModel model = modiftable.getModel();
        txtNom.setText(model.getValueAt(i,1).toString());
        txtPrenom.setText(model.getValueAt(i,2).toString());
        cmbSexe.setText(model.getValueAt(i,5).toString());
        txtNd_Prenom.setText(model.getValueAt(i,4).toString());
        txtEmail.setText(model.getValueAt(i,3).toString());
        cmbConnaissance.setSelectedItem((model.getValueAt(i,6).toString()));
        txtProfession_actuelle.setText(model.getValueAt(i,7).toString());
        txtProfession_anterieur.setText(model.getValueAt(i,8).toString());
        cmbClassification.setSelectedItem((model.getValueAt(i,9).toString())); 
        txtMotdepasse.setText(model.getValueAt(i,10).toString());
    }//GEN-LAST:event_modiftableMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         try{

            int row = modiftable.getSelectedRow();
            String value = (modiftable.getModel().getValueAt(row,0).toString());
            String query = "UPDATE `patient` SET `Nom`=?,`Prenom`=?,`Nd_Prenom`=?,`Sexe`=?,`Connaissance`=?,`Profession_actuelle`=?,`Profession_anterieur`=?,`Classification`=?,`email`=?,`password`=? where id_patient="+value;
            
            pst = conn.prepareStatement(query);
            pst.setString(1, txtNom.getText());
            pst.setString(2, txtPrenom.getText());
            pst.setString(3, txtNd_Prenom.getText()); 
            pst.setString(4, cmbSexe.getText());
            pst.setString(5, cmbConnaissance.getSelectedItem().toString());
            pst.setString(6, txtProfession_actuelle.getText());
            pst.setString(7, txtProfession_anterieur.getText());
            pst.setString(8, cmbClassification.getSelectedItem().toString());
            pst.setString(9, txtEmail.getText());
            pst.setString(10, txtMotdepasse.getText());
            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)modiftable.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null,"Patient modifié");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Supprimer le patient, cette action est irréversible","Supprimé", JOptionPane.YES_NO_OPTION);
        if(opt==0){
        try{

            int row = modiftable.getSelectedRow();
            String value = (modiftable.getModel().getValueAt(row,0).toString());
            String query = "DELETE FROM patient WHERE id_patient="+value;
        
            PreparedStatement pst = conn.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)modiftable.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null,"Patient supprimé");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void txtNd_PrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNd_PrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNd_PrenomActionPerformed

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
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel btxtEmail;
    private javax.swing.JComboBox<String> cmbClassification;
    private javax.swing.JComboBox<String> cmbConnaissance;
    private javax.swing.JLabel cmbSexe;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable modiftable;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtMotdepasse;
    private javax.swing.JTextField txtNd_Prenom;
    private javax.swing.JLabel txtNom;
    private javax.swing.JLabel txtPrenom;
    private javax.swing.JTextField txtProfession_actuelle;
    private javax.swing.JTextField txtProfession_anterieur;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
