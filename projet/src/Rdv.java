

import java.text.SimpleDateFormat;
import java.util.Date;


public class Rdv {
    
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    
    
    private int id_rdv;
    private Date date;
    private String heure;
    private int prix;
    private String reglement;
    private int id_patient;
    

    public Rdv(int id_Rdv, Date Date, String Heure, int Prix, String Reglement, int id_Patient) {
        this.id_rdv = id_Rdv;
        this.date = Date;
        this.heure = Heure;
        this.prix = Prix;
        this.reglement = Reglement;
        this.id_patient = id_Patient;
    }

    public int getId_rdv() {
        return id_rdv;
    }

    public Date getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public int getPrix() {
        return prix;
    }

    public String getReglement() {
        return reglement;
    }
    
    public int getId_patient(){
        return id_patient;
    }
   
    
}
