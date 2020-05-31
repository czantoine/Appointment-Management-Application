package pjbdd;

public class ConsultationEntiere {
    private String date;
    private String heure;
    private String nb_pers;
    private String type_paiement;
    private String prix;
    private String type_consultation;
    private String nb_anxiete;
    private String comportement;
    private String mots_cle;
    private String posture;

    public ConsultationEntiere(String date, String heure, String nb_pers, String type_paiement, String prix, String type_consultation, String nb_anxiete, String comportement, String mots_cle, String posture) {
        this.date = date;
        this.heure = heure;
        this.nb_pers = nb_pers;
        this.type_paiement = type_paiement;
        this.prix = prix;
        this.type_consultation = type_consultation;
        this.nb_anxiete = nb_anxiete;
        this.comportement = comportement;
        this.mots_cle = mots_cle;
        this.posture = posture;
    }

    public String getComportement() {
        return comportement;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getMots_cle() {
        return mots_cle;
    }

    public String getNb_anxiete() {
        return nb_anxiete;
    }

    public String getNb_pers() {
        return nb_pers;
    }

    public String getPosture() {
        return posture;
    }

    public String getPrix() {
        return prix;
    }

    public String getType_consultation() {
        return type_consultation;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    
    
    
}
