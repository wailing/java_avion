package test;

import avion.Avion;
import avion.TypeAvion;
//import equipage.Equipage;
import exception.EquipageException;
import exception.InvariantBroken;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;
import org.junit.Test;
import vol.Vol;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */

public class VolTest {

    TypeAvion typeAirbus = new TypeAvion("Airbus A320", 2, 3);
    TypeAvion typeBoeing = new TypeAvion("Boeing 747", 3, 4);
    TypeAvion typePetitAvion = new TypeAvion("Airbus");

    Avion avion = new Avion(typePetitAvion, "AF300");
    Avion avion1 = new Avion(typeAirbus, "AF347");
    Avion avion2 = new Avion(typeBoeing, "AF545");


    @Test
    public void testAddPilote(){
        try {
            Date date = new Date();
            Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, "8/12/2015");

            Pilote p = new Pilote("Ha", "Anais");
            vol1.addPilote(p);

            assertEquals(vol1.getEquipage().getPilote().getNom(), p.getNom());
            assertEquals(vol1.getEquipage().getPilote().getPrenom(), p.getPrenom());

            Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, "2/12/2015");
            Pilote p1 = new Pilote("Ba", "Marieme");
            vol2.addPilote(p1);

            assertEquals(vol2.getEquipage().getPilote().getNom(), p1.getNom());
            assertEquals(vol2.getEquipage().getPilote().getPrenom(), p1.getPrenom());

            Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, "12/12/2015");

            assertEquals(null, vol3.getEquipage().getPilote().getNom());
            assertEquals(null, vol3.getEquipage().getPilote().getPrenom());
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddCoPilote() {
        try {
            Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, "10/12/2015");

            Copilote c = new Copilote("Ha", "Anais");
            vol1.addCoPilote(c);

            assertEquals(vol1.getEquipage().getCopilote().getNom(), c.getNom() );
            assertEquals(vol1.getEquipage().getPilote().getPrenom(), c.getPrenom());

            Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, "11/12/2015");
            Copilote c1 = new Copilote("Ba", "Marieme");
            vol2.addCoPilote(c1);

            assertEquals(vol2.getEquipage().getCopilote().getNom(), c1.getNom());
            assertEquals(vol2.getEquipage().getCopilote().getPrenom(), c1.getPrenom());

            Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, "12/12/2015");

            assertEquals(null, vol3.getEquipage().getCopilote().getNom());
            assertEquals(null, vol3.getEquipage().getCopilote().getPrenom());
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddPNC() {
        try {
            Date date = new Date();
            Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, "13/12/2015");

            Pnc p = new Pnc("Ha", "Anais");
            vol1.addPNC(p);

            assertTrue("Le PNC existe : ", vol1.getEquipage().getListePnc().contains(p));

            Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, "14/12/2015");
            Pnc p1 = new Pnc("Ba", "Marieme");
            vol2.addPNC(p1);

            assertTrue("Le PNC existe : ", vol2.getEquipage().getListePnc().contains(p1));
            assertFalse("Le PNC existe : ", vol2.getEquipage().getListePnc().contains(p));

            Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, "15/12/2015");

            assertTrue(vol3.getEquipage().getListePnc().size() == 0);
            vol3.addPNC(p);
            vol3.addPNC(p1);

            assertTrue(vol3.getEquipage().getListePnc().size() == 2);

            vol1.addPNC(p1);
            assertTrue(vol1.getEquipage().getListePnc().contains(p));
            assertFalse(vol1.getEquipage().getListePnc().contains(p1));
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEquipageAuComplet() {
        try {
            Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, "16/12/2015");
            Pilote pilote = new Pilote("Ba", "Marieme");
            Copilote copilote = new Copilote("Bla", "Blabla");
            Pnc p = new Pnc("Ha", "Anais");
            vol1.addPilote(pilote);
            vol1.addCoPilote(copilote);
            vol1.addPNC(p);

            assertTrue(vol1.equipageAuComplet());

            Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, "17/12/2015");

            vol2.addPilote(pilote);
            vol2.addCoPilote(copilote);
            vol2.addPNC(p);

            assertFalse(vol2.equipageAuComplet());

            Pnc p1 = new Pnc("Ha", "Julie");
            vol2.addPNC(p1);

            assertTrue(vol2.equipageAuComplet());

            Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, "18/12/2015");

            assertFalse(vol3.equipageAuComplet());

            vol3.addPNC(p);

            assertFalse(vol3.equipageAuComplet());
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }

    }

}
