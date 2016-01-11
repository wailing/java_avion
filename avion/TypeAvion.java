package avion;

import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Personne;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class TypeAvion implements Serializable {

    private String nom;
    private int min;
    private int max;
    private ArrayList<Personne> listePersonneQualifiees;

    public TypeAvion(String nom, int min, int max) {
        this.nom = nom;
        this.min = min;
        this.max = max;
        this.listePersonneQualifiees = new ArrayList<>();
    }

    public TypeAvion(String nom) {
        this.nom = nom;
        this.min = 1;
        this.max = 1;
        this.listePersonneQualifiees = new ArrayList<>();
    }

    public void addQualifie(Personne m) throws EquipageException {
        if(this.listePersonneQualifiees.contains(m)) {
            throw new EquipageException("La personne est deja qualifiee pour ce type d'avion : " + this.toString());
        }
        this.listePersonneQualifiees.add(m);
    }

    public void delQualifie(Personne m) throws EquipageException {
        if(!this.listePersonneQualifiees.contains(m)) {
            throw new EquipageException("La personne n'est pas qualifiee pour ce type d'avion : " + this.toString() + " On ne peut donc pas supprimer une qualication inexistante !!!\n");
        }
        this.listePersonneQualifiees.remove(m);
    }

    public void purgeQualifies()throws EquipageException, InvariantBroken {
        this.listePersonneQualifiees.clear();
    }

    public String getNom() {
        return nom;
    }

    public int getMinPNC() {
        return min;
    }

    public int getMaxPNC() {
        return max;
    }

    public ArrayList<Personne> getListePersonneQualifiees() {
        return listePersonneQualifiees;
    }

    @Override
    public String toString() {
       String chaine = "\n ----------------\nType d'avion : " + getNom();
        chaine += "\nMinimum de PNC : " + getMinPNC();
        chaine += "\nMaximum de PNC : " + getMaxPNC();
        chaine += "\n ----------------\n";
        return chaine;
    }
}
