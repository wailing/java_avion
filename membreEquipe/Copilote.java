package membreEquipe;

import exception.InvariantBroken;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class Copilote extends Personne {

    public Copilote(String nom, String prenom)throws InvariantBroken {
        super(nom, prenom);
    }

    @Override
    public String toString() {
        String resultat = super.toString();
        resultat += "\nFonction : Copilote";
        return resultat;
    }
}
