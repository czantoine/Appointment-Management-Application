import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Antoine
 */


public class SQLConnection {
    
    Connection conn = null;

    public static Connection connectDB() {
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/Projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            return conn;
        } 

        catch (SQLException ex) {
            System.out.println("\n*** ERREUR SQL ***\n");
            while (ex != null) {
                System.out.println("SQL Etat: " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Code de l'erreur: "
                        + ex.getErrorCode());
                ex = ex.getNextException();
            }
            return null;
        }
   } 
}
