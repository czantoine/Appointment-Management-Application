
public class Patient {
    private int id_patient;
    private String nom;
    private String prenom;
    private String email;
    private String nd_prenom;
    private String sexe;
    private String connaissance;
    private String profession_actuelle;
    private String profession_anterieur;
    private String classification;

    public Patient(int id_patient, String nom, String prenom, String email, String nd_prenom, String sexe, String connaissance, String profession_actuelle, String profession_anterieur, String classification) {
        this.id_patient = id_patient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nd_prenom = nd_prenom;
        this.sexe = sexe;
        this.connaissance = connaissance;
        this.profession_actuelle = profession_actuelle;
        this.profession_anterieur = profession_anterieur;
        this.classification = classification;
    }

    public int getId_patient() {
        return id_patient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getNd_prenom() {
        return nd_prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getConnaissance() {
        return connaissance;
    }

    public String getProfession_actuelle() {
        return profession_actuelle;
    }

    public String getProfession_anterieur() {
        return profession_anterieur;
    }

    public String getClassification() {
        return classification;
    }   
    
}
