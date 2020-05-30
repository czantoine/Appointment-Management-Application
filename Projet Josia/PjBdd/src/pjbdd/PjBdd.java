package pjbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PjBdd {

    public static User cur;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);//C'est ca qu'il faut lancer au DEPART
                //new MainPage().setVisible(false); //deuxieme page
                //new AddPatient().setVisible(true);
            }
        });

    }

}
