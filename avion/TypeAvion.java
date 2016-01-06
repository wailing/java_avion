package avion;

import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Personne;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class TypeAvion {

    private String nom;
    private int min;
    private int max;

    public TypeAvion(String nom, int min, int max) {
        this.nom = nom;
        this.min = min;
        this.max = max;
    }

    public TypeAvion(String nom) {
        this.nom = nom;
        this.min = 1;
        this.max = 1;
    }

    public void addQualifie(Personne m) throws EquipageException {
        try {
            m.addQualification(this);
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        }
    }

    public void delQualifie(Personne m) throws EquipageException {
        m.delQualification(this, true); /// fromType ???
    }

    public void purgeQualifies()throws EquipageException, InvariantBroken { // ????

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

    @Override
    public String toString() {
       String chaine = "\n ----------------\nType d'avion : " + getNom();
        chaine += "\nMinimum de PNC : " + getMinPNC();
        chaine += "\nMaximum de PNC : " + getMaxPNC();
        chaine += "\n ----------------\n";
        return chaine;
    }
}
