package appliVols;

import avion.Avion;
import avion.TypeAvion;
//import equipage.Equipage;
import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import vol.Vol;

import java.util.Date;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */

public class main {

    public static void main(String[] args) {
        TypeAvion type = new TypeAvion("AF380", 1, 3);
        Avion av = new Avion(type, "AF380");
        Date date = new Date();
        Vol v = new Vol("13562", "Orly", "Londres", av, date);

        try {
            Pilote pilote = new Pilote("Ha", "Anais");
            pilote.addQualification(type);
            v.addPilote(pilote);
            Copilote copilote = new Copilote("Ba", "Marieme");
            v.addCoPilote(copilote);
            copilote.addQualification(type);
            v.addCoPilote(copilote);
            System.out.println(v.toString());
            copilote.addQualification(type);
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        }
    }


}
