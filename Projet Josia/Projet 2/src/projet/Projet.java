/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

//pour tout ce qui est sql connexion avec la bdd
import java.sql.*; 


/**
 *
 * @author josia
 */
public class Projet  {

   // connection to database
    private static final String username= "josia_root";
    private static final String password= "josia_root";
    private static final String 
            Conn_string="jdbc:mysql://localhost:3308/Projet?serverTimezone=UTC";
            //jdbc:mysql://localhost:3308/Projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC\",\"root\",\"root\" ";
    
    //user admin ou pas qui se connecte, on peut avoir ses infos grace à cette classe initialisée dans login   
    public static User cur; 

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Conn_string, username, password);
            System.out.println("Connected ! sheh");
            
            //statement de test pour voir si on peut modif la bdd 
           // Statement stmt = (Statement) conn.createStatement();
//            int id_users = 3;
//            String mail = "josiadounie@gmail.com";
//            String password = "Lilly";
//            String type="user";
            
            // String query = "INSERT INTO 'Projet'.'users' ('id_user','mail', 'password', 'type') VALUES ('"+id_users+"', '"+mail+"', '"+password+"', '"+type+"') ";

//            int id_patient = 1, age = 18; 
//            String nom = "Jonnes";
//            String prenom = "Indiana";
//            String sexe = "F";
//            String relation = "seule";
//            String moyen_connaissance = "net";
//            String profession_actuelle = "Aventuriere";
//                  
//            String insert = "INSERT INTO 'patients' ('id_patient', 'nom', 'prenom', 'age', 'sexe', 'relation', 'moyen_connaissance', 'profession_actuelle') VALUES ('"+id_patient+"', '"+nom+"', '"+prenom+"', '"+age+"', '"+sexe+"', '"+relation+"', '"+moyen_connaissance+"', '"+profession_actuelle+"') ";
//            
//            PreparedStatement pst;
//            
//            pst = conn.prepareStatement(insert);
            
            //stmt.executeUpdate(insert);
        
            
        }catch(SQLException e){
            System.err.println(e);
        }
        
        
        
        
        System.out.println("1, 2, 3 Test, tout va bien ! ");
        
        /*     try {

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
        } // catch SQL
        
        
        */
        
            //passage d'une page à une autre
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true); //pour afficher la page login
                //new MainPage().setVisible(false); //deuxieme page
            }
        });
    }
    
}





    

   