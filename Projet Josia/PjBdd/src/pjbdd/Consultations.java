package pjbdd;

public class Consultations {
    
    private int idCons;
    private String date;
    private String heure;
    private int nbPersonnes;
    private String typePaiement;
    private double prix;
    private String typeCons;
    private int nbAnx;
    private int etat;

    public Consultations(int idCons, String date, String heure, int nbPersonnes, String typePaiement, double prix, String typeCons, int nbAnx, int etat) {
        this.idCons = idCons;
        this.date = date;
        this.heure = heure;
        this.nbPersonnes = nbPersonnes;
        this.typePaiement = typePaiement;
        this.prix = prix;
        this.typeCons = typeCons;
        this.nbAnx = nbAnx;
        this.etat = etat;
    }

    public int getIdCons() {
        return idCons;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public double getPrix() {
        return prix;
    }

    public String getTypeCons() {
        return typeCons;
    }

    public int getNbAnx() {
        return nbAnx;
    }

    public int getEtat() {
        return etat;
    }
    
}
