package membreEquipe;

import avion.TypeAvion;

import java.util.ArrayList;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Personne {
    private String nom;
    private String prenom;
    private ArrayList<TypeAvion> typeAvionOperationnel;

    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.typeAvionOperationnel = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public boolean peutVoler(TypeAvion t) {
        if (this.typeAvionOperationnel.contains(t)) {
            return true;
        }
        return false;
    }

    public boolean addQualification(TypeAvion type) {
        if(this.typeAvionOperationnel.size() < 2) {
            this.typeAvionOperationnel.add(type);
            return true;
        }
        return false;
    }

    public boolean delQualification(TypeAvion type, boolean fromType){  //a quoi sert fromType ??????
        if(this.typeAvionOperationnel.contains(type)) {
            this.typeAvionOperationnel.remove(type);
            return true;
        }
        return false;
    }
}
