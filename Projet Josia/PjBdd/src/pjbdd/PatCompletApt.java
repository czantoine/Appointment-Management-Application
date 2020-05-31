package pjbdd;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PatCompletApt extends javax.swing.JFrame implements ActionListener {

    Connection conn = null;

    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    ArrayList<Integer> idcons = new ArrayList<>();

    public PatCompletApt() {
        initComponents();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        show_cons();
    }

    public ArrayList<ConsultationEntiere> listeCons() {

        // System.out.println(PjBdd.cur.getMail());
        String mail = PjBdd.cur.getMail();
        String type = PjBdd.cur.getType();
        int mdp = PjBdd.cur.getPassword();

        ArrayList<ConsultationEntiere> consultations = new ArrayList<>();//A REPRENDRE ICI GET ID ET CONSULTATION
        try {
            conn = MySQLConnect.connectDB();

            //get id user
            PreparedStatement pst1 = conn.prepareStatement("SELECT id_user FROM users WHERE mail=? AND type=? AND password=?");
            pst1.setString(1, mail);
            pst1.setString(2, type);
            pst1.setInt(3, mdp);

            ResultSet result = pst1.executeQuery();
            result.next();
            int idUser = result.getInt(1);

            //Get id consultation ou y a idUser
            PreparedStatement pst2 = conn.prepareStatement("SELECT id_consultation FROM consulte WHERE id_patientcons=?");
            pst2.setInt(1, idUser);
            ResultSet resu = pst2.executeQuery();
            while (resu.next()) {
                idcons.add(resu.getInt(1));

            }
            //id_cons patient

            String sql = "SELECT c.date, c.heure, c.nb_pers, c.type_paiement, c.prix, c.type_consultation, c.nb_anxiete, com.comportement, m.mots_cle, p.posture FROM consultations c RIGHT JOIN comportement com ON c.id_consultation = com.id_consu RIGHT JOIN mots_cle m ON c.id_consultation = m.id_consult RIGHT JOIN posture p ON c.id_consultation = p.id_consultation WHERE c.id_consultation =? AND c.etat_consultation=1 ORDER BY c.date, c.heure";

            for (int i = 0; i < idcons.size(); i++) {
                //PreparedStatement state = conn.prepareStatement("SELECT * FROM consultations WHERE id_consultation=? ORDER BY date, heure");
                PreparedStatement state = conn.prepareStatement(sql);
                state.setInt(1, idcons.get(i));
                ResultSet resultSet = state.executeQuery();
                ConsultationEntiere cons;
                while (resultSet.next()) {

                    cons = new ConsultationEntiere(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
                    consultations.add(cons);
                }

                resultSet.close();

            }

            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("erreur dans crreation liste cons");
        }
        return consultations;

    }

    public void show_cons() {
        ArrayList<ConsultationEntiere> liste = listeCons();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[10];

        for (int i = 0; i < liste.size(); i++) {
            row[0] = liste.get(i).getDate();
            row[1] = liste.get(i).getHeure();
            row[2] = liste.get(i).getNb_pers();
            row[3] = liste.get(i).getType_paiement();
            row[4] = liste.get(i).getPrix();
            row[5] = liste.get(i).getType_consultation();
            row[6] = liste.get(i).getNb_anxiete();
            row[7] = liste.get(i).getComportement();
            row[8] = liste.get(i).getMots_cle();
            row[9] = liste.get(i).getPosture();
            model.addRow(row);

        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Previous appointments - Completed ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Date", "Hour", "NbPersons", "TypePayement", "Price", "Type", "NbAnxiety", "Behaviour", "KeyWords", "Posture"
                }
        ));

        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Your previous appointments :");

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(560, 560, 560)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(38, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
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
        if (ae.getActionCommand() == jButton2.getActionCommand()) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new MainPageP().setVisible(true);
                }
            });
            this.dispose();

        }

    }

}
