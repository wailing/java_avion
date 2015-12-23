package avion;

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

    public void addQualifie(Personne m) {

    }

    public void delQualifie(Personne m) {

    }

    public void purgeQualifies() {

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
}
