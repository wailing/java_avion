package membreEquipe;

import avion.TypeAvion;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.EquipageException;
import exception.InvariantBroken;
import persistance.ConnexionBD;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public abstract class Personne implements Serializable {
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) throws InvariantBroken{
        if(nom == null || prenom == null) throw new InvariantBroken("Le nom ou le prenom est null !!");
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public boolean peutVoler(TypeAvion t) {
        if (t.getListePersonneQualifiees().contains(this)) {
            return true;
        }
        return false;
    }

    public boolean addQualification(TypeAvion type) throws InvariantBroken, EquipageException {
        if(type == null) throw new InvariantBroken("Le type d'avion pass� est null");
        if(this.peutVoler(type)) throw new EquipageException("La personne est deja qualifiee pour ce type : " + type.toString());
        else {
            type.addQualifie(this);
            return true;
        }
    }

    public boolean delQualification(TypeAvion type, boolean fromType){  //a quoi sert fromType ??????
        if(this.peutVoler(type)) {
            try {
                type.delQualifie(this);
                return true;
            } catch (EquipageException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
    
    public abstract String getFonction();

    @Override
    public String toString() {
        String resultat = "\nNom : " + getNom();
        resultat += "\nPrenom : " + getPrenom();
        return resultat;
    }
}
