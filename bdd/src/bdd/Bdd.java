package bdd;

import java.sql.*;

public class Bdd {

  public static void main(String[] args) {      
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver O.K.");

      String url = "jdbc:mysql://localhost:8889/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
      String user = "root";
      String passwd = "root";

      Connection con= DriverManager.getConnection(url,user,passwd);
      System.out.println("Connexion effective !");         
         
    } catch (Exception e) {
      e.printStackTrace();
    }      
  }
}