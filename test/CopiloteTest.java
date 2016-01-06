package test;

import avion.TypeAvion;
import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Copilote;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class CopiloteTest {

    @Test
    public void testPeutVoler() {
        try {
            Copilote c = new Copilote("Ba", "Marieme");
            TypeAvion airbus = new TypeAvion("Airbus", 2, 3);
            TypeAvion boeing = new TypeAvion("Boeing", 3, 4);
            c.addQualification(airbus);

            assertTrue(c.peutVoler(airbus));

            c.addQualification(boeing);

            assertTrue(c.peutVoler(airbus));
            assertTrue(c.peutVoler(boeing));
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddQualification() {
        try {
            Copilote c = new Copilote("Ha", "Anais");
            TypeAvion airbus = new TypeAvion("Airbus", 2, 3);

            c.addQualification(airbus);

            assertTrue(c.peutVoler(airbus));
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDelQualification() {  //a quoi sert fromType ??????
    }
}