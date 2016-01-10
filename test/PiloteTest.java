package test;

import avion.TypeAvion;
import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Pilote;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class PiloteTest {

    @Test
    public void testPeutVoler() throws EquipageException, InvariantBroken {
        Pilote p = new Pilote("Ba", "Marieme");
        TypeAvion airbus = new TypeAvion("Airbus", 2, 3);
        TypeAvion boeing = new TypeAvion("Boeing", 3, 4);
        p.addQualification(airbus);

        assertTrue(p.peutVoler(airbus));

        p.addQualification(boeing);

        assertTrue(p.peutVoler(airbus));
        assertTrue(p.peutVoler(boeing));
    }

    @Test
    public void testAddQualification()  throws EquipageException , InvariantBroken {
        Pilote p = new Pilote("Ha", "Anais");
        TypeAvion airbus = new TypeAvion("Airbus", 2, 3);

        p.addQualification(airbus);

        assertTrue(p.peutVoler(airbus));
    }

    @Test
    public void testDelQualification() {  //a quoi sert fromType ??????
    }
}