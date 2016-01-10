package appliVols;

/**
 * Created by mariemeba on 09/01/2016.
 */
public class VolTab {
    private String numero;
    private String nomVol;
    private String destination;
    private String dateDepart;
    private String nomTypeAvion;
    private String site;
    private String prenom;
    private String nom;
    private String fonction;

    public VolTab(String numero, String nomVol, String destination, String dateDepart, String nomTypeAvion, String site, String prenom, String nom, String fonction) {
        this.numero = numero;
        this.nomVol = nomVol;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.nomTypeAvion = nomTypeAvion;
        this.site = site;
        this.prenom = prenom;
        this.nom = nom;
        this.fonction = fonction;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNomVol() {
        return nomVol;
    }

    public void setNomVol(String nomVol) {
        this.nomVol = nomVol;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getNomTypeAvion() {
        return nomTypeAvion;
    }

    public void setNomTypeAvion(String nomTypeAvion) {
        this.nomTypeAvion = nomTypeAvion;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}