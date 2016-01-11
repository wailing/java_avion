package membreEquipe;

import exception.InvariantBroken;
import persistance.ConnexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class Pilote extends Personne{

    public Pilote(String nom, String prenom) throws InvariantBroken {
        super(nom, prenom);
        try {
            Connection connexion = ConnexionBD.getConnexionBD();
            PreparedStatement ps = connexion.prepareStatement("INSERT INTO Personnels (nom, prenom, fonction) VALUES (?,?,?)");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, getFonction());
            ps.executeUpdate();
        }catch (SQLException S) {
            S.printStackTrace();
        }
    }

    @Override
    public String getFonction() {
        return "Pilote";
    }

    @Override
    public String toString() {
        String resultat = super.toString();
        resultat += "\nFonction : Pilote";
        return resultat;
    }
}
