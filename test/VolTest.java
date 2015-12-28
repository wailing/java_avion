package test;

import avion.Avion;
import avion.TypeAvion;
import equipage.Equipage;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;
import org.junit.Test;
import vol.Vol;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
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
        Date date = new Date();
        Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, date);

        Pilote p = new Pilote("Ha", "Anais");
        vol1.addPilote(p);

        assertEquals(vol1.getEquipage().getPilote().getNom(), p.getNom());
        assertEquals(vol1.getEquipage().getPilote().getPrenom(), p.getPrenom());

        Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, date);
        Pilote p1 = new Pilote("Ba", "Marieme");
        vol2.addPilote(p1);

        assertEquals(vol2.getEquipage().getPilote().getNom(), p1.getNom());
        assertEquals(vol2.getEquipage().getPilote().getPrenom(), p1.getPrenom());

        Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, date);

        assertEquals(null, vol3.getEquipage().getPilote().getNom());
        assertEquals(null, vol3.getEquipage().getPilote().getPrenom());
    }

    @Test
    public void testAddCoPilote() {
        Date date = new Date();
        Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, date);

        Copilote c = new Copilote("Ha", "Anais");
        vol1.addCoPilote(c);

        assertEquals(vol1.getEquipage().getCopilote().getNom(), c.getNom());
        assertEquals(vol1.getEquipage().getCopilote().getPrenom(), c.getPrenom());

        Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, date);
        Copilote c1 = new Copilote("Ba", "Marieme");
        vol2.addCoPilote(c1);

        assertEquals(vol2.getEquipage().getCopilote().getNom(), c1.getNom());
        assertEquals(vol2.getEquipage().getCopilote().getPrenom(), c1.getPrenom());

        Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, date);

        assertEquals(null, vol3.getEquipage().getCopilote().getNom());
        assertEquals(null, vol3.getEquipage().getCopilote().getPrenom());
    }

    @Test
    public void testAddPNC() {
        Date date = new Date();
        Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, date);

        Pnc p = new Pnc("Ha", "Anais");
        vol1.addPNC(p);

        assertTrue("Le PNC existe : ", vol1.getEquipage().getListePnc().contains(p));

        Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, date);
        Pnc p1 = new Pnc("Ba", "Marieme");
        vol2.addPNC(p1);

        assertTrue("Le PNC existe : ", vol2.getEquipage().getListePnc().contains(p1));
        assertFalse("Le PNC existe : ", vol2.getEquipage().getListePnc().contains(p));

        Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, date);

        assertTrue(vol3.getEquipage().getListePnc().size() == 0);
        vol3.addPNC(p);
        vol3.addPNC(p1);

        assertTrue(vol3.getEquipage().getListePnc().size() == 2);

        vol1.addPNC(p1);
        assertTrue(vol1.getEquipage().getListePnc().contains(p));
        assertFalse(vol1.getEquipage().getListePnc().contains(p1));
    }

    @Test
    public void testEquipageAuComplet() {
        Date date = new Date();
        Vol vol1 = new Vol("AF001", "Orly", "Londres", avion, date);
        Pilote pilote = new Pilote("Ba", "Marieme");
        Copilote copilote = new Copilote("Bla", "Blabla");
        Pnc p = new Pnc("Ha", "Anais");
        vol1.addPilote(pilote);
        vol1.addCoPilote(copilote);
        vol1.addPNC(p);

        assertTrue(vol1.equipageAuComplet());

        Vol vol2 = new Vol("AF002", "Roissy", "Barcelone", avion1, date);

        vol2.addPilote(pilote);
        vol2.addCoPilote(copilote);
        vol2.addPNC(p);

        assertFalse(vol2.equipageAuComplet());

        Pnc p1 = new Pnc("Ha", "Julie");
        vol2.addPNC(p1);

        assertTrue(vol2.equipageAuComplet());

        Vol vol3 = new Vol("AF003", "Orly", "Madrid", avion2, date);

        assertFalse(vol3.equipageAuComplet());

        vol3.addPNC(p);

        assertFalse(vol3.equipageAuComplet());

    }

}