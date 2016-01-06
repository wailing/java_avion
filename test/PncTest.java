package test;

import avion.TypeAvion;
import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Pnc;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class PncTest {

    @Test
    public void testPeutVoler() throws EquipageException, InvariantBroken {
        Pnc pnc = new Pnc("Ba", "Marieme");
        TypeAvion airbus = new TypeAvion("Airbus", 2, 3);
        TypeAvion boeing = new TypeAvion("Boeing", 3, 4);
        pnc.addQualification(airbus);

        assertTrue(pnc.peutVoler(airbus));

        pnc.addQualification(boeing);

        assertTrue(pnc.peutVoler(airbus));
        assertTrue(pnc.peutVoler(boeing));
    }

    @Test
    public void testAddQualification()  throws EquipageException , InvariantBroken {
        Pnc pnc = new Pnc("Ba", "Marieme");
        TypeAvion boeing = new TypeAvion("Boeing", 3, 4);

        pnc.addQualification(boeing);
        assertTrue(pnc.getTypeAvionOperationnel().contains(boeing));
    }

    @Test
    public void testDelQualification() {  //a quoi sert fromType ??????
    }
}