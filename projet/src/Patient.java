
public class Patient {
    private int id_patient;
    private String nom;
    private String prenom;
    private String email;
    
    public Patient(int id_Patient, String Nom, String Prenom, String Email){
        this.id_patient = id_Patient;
        this.nom = Nom;
        this.prenom = Prenom;
        this.email = Email;
    }

    public int getId_patient() {
        return id_patient;
    }
 
    public String getnom() {
        return nom;
    }

    public String getprenom() {
        return prenom;
    }

    public String getemail() {
        return email;
    }
     
    
    
}
