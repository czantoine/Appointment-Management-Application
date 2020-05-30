

import java.text.SimpleDateFormat;
import java.util.Date;


public class Rdv {
    
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    
    
    private int id_rdv;
    private Date date;
    private String heure;
    private int prix;
    private String reglement;
    private String anxiete;
    private String mots_clef;
    private String postures;
    private String comportement;
    private int id_patient;
    
    public Rdv(int id_rdv, Date date, String heure, int prix, String reglement, String anxiete, String mots_clef, String postures, String comportement, int id_patient) {
        this.id_rdv = id_rdv;
        this.date = date;
        this.heure = heure;
        this.prix = prix;
        this.reglement = reglement;
        this.anxiete = anxiete;
        this.mots_clef = mots_clef;
        this.postures = postures;
        this.comportement = comportement;
        this.id_patient = id_patient;
    }

    public SimpleDateFormat getDateformat() {
        return dateformat;
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

    public String getAnxiete() {
        return anxiete;
    }

    public String getMots_clef() {
        return mots_clef;
    }

    public String getPostures() {
        return postures;
    }

    public String getComportement() {
        return comportement;
    }

    public int getId_patient() {
        return id_patient;
    }
    
}