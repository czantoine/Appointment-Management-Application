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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MySQLConnect {

    Connection conn = null;

    public static Connection connectDB() {
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/Projet?serverTimezone=UTC", "josia_root", "josia_root");
            JOptionPane.showMessageDialog(null, "Connected to the database");
            return conn;
        } 
        
        catch (SQLException ex) {
            
            // Si une exception SQL survient, il affiche les messages d’erreurs du SGBD
            System.out.println("\n*** ERREUR SQL ***\n");
            while (ex != null) {
                System.out.println("SQL Etat: " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Code de l'erreur: "
                        + ex.getErrorCode());
                ex = ex.getNextException();
            }
            return null;
        } // catch SQL
        
        
    }

}

/*


try {

            //CONNEXION A LA BDD
            //Class.forName("com.mysql.jdbc.Driver.").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBProjet", "root", "root");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "root");
            System.out.println("Successful Connection breh brehhh");

            //DECLARATION DES UTILISATIONS
            //Creation d'un objet Statement
            Statement state = conn.createStatement();

            //L'obj ResultSet contient le resultat de la requete SQL
            ResultSet result = state.executeQuery("SELECT * FROM users");
            //stmt.executeUpdate("UPDATE emp SET num = 20 WHERE num=10");//-->pour update, insert etc

            System.out.println();

            //AFFICHAGE
            ResultSetMetaData resultMeta = result.getMetaData();

            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {

                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t");

            }

            System.out.println("\n------------------------------------------------------------------------------");

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.print("  \t" + result.getObject(i).toString() + "\t |");

                }
                System.out.println("\n-----------------------------------------------------------------------------");
            }

             //LA MEME
             /*
            while(result.next()){
            System.out.print("\t" + result.getInt("user_id") + "\t |");
            System.out.print("\t" + result.getString("username") + "\t |");
            System.out.println("\n---------------------------------");
             }*/
             
            /*
            //Fermer l’ordre et la connexion
            result.close();
            state.close();
            conn.close();

        } catch (SQLException ex) {
            
            // Si une exception SQL survient, il affiche les messages d’erreurs du SGBD
            System.out.println("\n*** ERREUR SQL ***\n");
            while (ex != null) {
                System.out.println("SQL Etat: " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Code de l'erreur: "
                        + ex.getErrorCode());
                ex = ex.getNextException();
            }












*/