package membreEquipe;

import exception.InvariantBroken;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Pilote extends Personne{

    public Pilote(String nom, String prenom) throws InvariantBroken {
        super(nom, prenom);
    }

    @Override
    public String toString() {
        String resultat = super.toString();
        resultat += "\nFonction : Pilote";
        return resultat;
    }
}
