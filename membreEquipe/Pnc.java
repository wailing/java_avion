package membreEquipe;

import exception.InvariantBroken;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Pnc extends Personne{

    public Pnc(String nom, String prenom) throws InvariantBroken {
        super(nom, prenom);
    }

    @Override
    public String getFonction() {
        return "PNC";
    }

    @Override
    public String toString() {
        String resultat = super.toString();
        resultat += "\nFonction : Personnels navigants et commerciaux (PNC)";
        return resultat;
    }
}
