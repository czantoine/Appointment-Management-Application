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

public class PrevAptPsy extends javax.swing.JFrame implements ActionListener {

    Connection conn = null;

    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    ArrayList<Integer> idcons = new ArrayList<>();

    public PrevAptPsy() {
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
                
                
                ResultSet resultSet = state.executeQuery("SELECT * FROM consultations WHERE etat_consultation=0 ORDER BY date, heure ");
                Consultations cons;
                while (resultSet.next()) {

                    cons = new Consultations(resultSet.getInt("id_consultation"), resultSet.getString("date"), resultSet.getString("heure"), resultSet.getInt("nb_pers"), resultSet.getString("type_paiement"), resultSet.getDouble("prix"), resultSet.getString("type_consultation"), resultSet.getInt("nb_anxiete"), Integer.parseInt(resultSet.getString("etat_consultation")));
                    consultations.add(cons);
                }

                resultSet.close();

            

            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return consultations;

    }

    public void show_cons() {
        ArrayList<Consultations> liste = listeCons();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < liste.size(); i++) {
            row[0] = liste.get(i).getDate();
            row[1] = liste.get(i).getHeure();
            row[2] = liste.get(i).getNbPersonnes();
            row[3] = liste.get(i).getTypePaiement();
            row[4] = liste.get(i).getPrix();
            row[5] = liste.get(i).getTypeCons();
            row[6] = liste.get(i).getNbAnx();
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
        setTitle("Next appointments - Not completed ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Hour", "NbPersons", "TypePayement", "Price", "Type", "NbAnxiety"
            }
        ));

        jScrollPane1.setViewportView(jTable1);

        

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Your next appointements :");

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
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
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
        if (ae.getActionCommand()==jButton2.getActionCommand()) {
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new MainPage().setVisible(true);
                }
            });
            this.dispose();
            
        }

    }

}
