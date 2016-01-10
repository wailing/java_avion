package test;

import avion.TypeAvion;
import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Personne;
import membreEquipe.Pilote;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class TypeAvionTest {

    @Test
    public void testAddQualifie() {
        try {
            Pilote pilote = new Pilote("Ha", "Anais");
            TypeAvion airbus = new TypeAvion("Airbus", 2, 3);

            airbus.addQualifie(pilote);

            assertTrue(airbus.getListePersonneQualifiees().contains(pilote));
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDelQualifie() {

    }

    @Test
    public void testPurgeQualifies() { // ????

    }
}