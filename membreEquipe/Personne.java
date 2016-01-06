package membreEquipe;

import avion.TypeAvion;

import java.util.ArrayList;

import exception.EquipageException;
import exception.InvariantBroken;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Personne {
    private String nom;
    private String prenom;
    private ArrayList<TypeAvion> typeAvionOperationnel;

    public Personne(String nom, String prenom) throws InvariantBroken{
        if(nom == null || prenom == null) throw new InvariantBroken("Le nom ou le prenom est null !!");
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

    public ArrayList<TypeAvion> getTypeAvionOperationnel() {
        return typeAvionOperationnel;
    }

    public boolean peutVoler(TypeAvion t) {
        if (this.typeAvionOperationnel.contains(t) && this.typeAvionOperationnel.size() >= 2) {
            return true;
        }
        return false;
    }

    public boolean addQualification(TypeAvion type) throws InvariantBroken, EquipageException {
        if(type == null) throw new InvariantBroken("Le type d'avion passé est null");
        if(this.typeAvionOperationnel.contains(type)) {
            throw new EquipageException("Le type à ajouter existe déjà : " + type.toString() + "pour cette personne " + this.getNom() + " " + this.getPrenom());
        }
        else {
            this.typeAvionOperationnel.add(type);
            return true;
        }
    }

    public boolean delQualification(TypeAvion type, boolean fromType){  //a quoi sert fromType ??????
        if(this.typeAvionOperationnel.contains(type)) {
            this.typeAvionOperationnel.remove(type);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String resultat = "\nNom : " + getNom();
        resultat += "\nPrenom : " + getPrenom();
        for (int i = 0; i < getTypeAvionOperationnel().size(); i++) {
            resultat += "\nType d'avion Operationnel : " + getTypeAvionOperationnel().get(i);
        }
        return resultat;
    }
}
