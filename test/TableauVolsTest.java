package test;

import affichageVols.TableauVols;
import membreEquipe.Pilote;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anais on 09/01/2016.
 */
public class TableauVolsTest {

    @Test
    public void testCreerPilote() throws Exception {
        System.out.println("\n\nTEST CREER PILOTE\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerPilote("Ha", "Anais");
        assertTrue(CDG.getListePersonne().size() == 1);
        assertEquals(CDG.getListePersonne().get(0).getNom(), "Ha");
        assertEquals(CDG.getListePersonne().get(0).getPrenom(), "Anais");

        CDG.creerPilote("Ba", "Marieme");

        assertTrue(CDG.getListePersonne().size() == 2);
        assertEquals(CDG.getListePersonne().get(1).getNom(), "Ba");
        assertEquals(CDG.getListePersonne().get(1).getPrenom(), "Marieme");

        CDG.creerPilote("Ha", "Anais");
        assertTrue(CDG.getListePersonne().size() == 3);
        assertEquals(CDG.getListePersonne().get(2).getNom(), "Ha");
        assertEquals(CDG.getListePersonne().get(2).getPrenom(), "Anais");

        TableauVols Orly = new TableauVols("Orly");
        Orly.creerPilote("Ha", "Anais");
        assertTrue(Orly.getListePersonne().size() == 1);
        assertEquals(Orly.getListePersonne().get(0).getNom(), "Ha");
        assertEquals(Orly.getListePersonne().get(0).getPrenom(), "Anais");
    }

    @Test
    public void testCreerPnc() throws Exception {
        System.out.println("\n\nTEST CREER PNC\n");
        TableauVols CDG = new TableauVols("CDG");

        CDG.creerPnc("Ha", "Anais");
        assertTrue(CDG.getListePersonne().size() == 1);
        assertEquals(CDG.getListePersonne().get(0).getNom(), "Ha");
        assertEquals(CDG.getListePersonne().get(0).getPrenom(), "Anais");

        CDG.creerPnc("Ba", "Marieme");

        assertTrue(CDG.getListePersonne().size() == 2);
        assertEquals(CDG.getListePersonne().get(1).getNom(), "Ba");
        assertEquals(CDG.getListePersonne().get(1).getPrenom(), "Marieme");

        CDG.creerPnc("Ha", "Anais");
        assertTrue(CDG.getListePersonne().size() == 3);
        assertEquals(CDG.getListePersonne().get(2).getNom(), "Ha");
        assertEquals(CDG.getListePersonne().get(2).getPrenom(), "Anais");

        TableauVols Orly = new TableauVols("Orly");
        Orly.creerPnc("Ha", "Anais");
        assertTrue(Orly.getListePersonne().size() == 1);
        assertEquals(Orly.getListePersonne().get(0).getNom(), "Ha");
        assertEquals(Orly.getListePersonne().get(0).getPrenom(), "Anais");
    }

    @Test
    public void testCreerCopilote() throws Exception {
        System.out.println("\n\nTEST CREER COPILOTE\n");
        TableauVols CDG = new TableauVols("CDG");

        CDG.creerCopilote("Ha", "Anais");
        assertTrue(CDG.getListePersonne().size() == 1);
        assertEquals(CDG.getListePersonne().get(0).getNom(), "Ha");
        assertEquals(CDG.getListePersonne().get(0).getPrenom(), "Anais");

        CDG.creerCopilote("Ba", "Marieme");

        assertTrue(CDG.getListePersonne().size() == 2);
        assertEquals(CDG.getListePersonne().get(1).getNom(), "Ba");
        assertEquals(CDG.getListePersonne().get(1).getPrenom(), "Marieme");

        CDG.creerCopilote("Ha", "Anais");
        assertTrue(CDG.getListePersonne().size() == 3);
        assertEquals(CDG.getListePersonne().get(2).getNom(), "Ha");
        assertEquals(CDG.getListePersonne().get(2).getPrenom(), "Anais");

        TableauVols Orly = new TableauVols("Orly");
        Orly.creerCopilote("Ha", "Anais");
        assertTrue(Orly.getListePersonne().size() == 1);
        assertEquals(Orly.getListePersonne().get(0).getNom(), "Ha");
        assertEquals(Orly.getListePersonne().get(0).getPrenom(), "Anais");
    }

    @Test
    public void testCreerAvion() throws Exception {
        System.out.println("\n\nTEST CREER AVION\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerAvion("Airbus", "Airbus 380");
        assertTrue(CDG.getListeAvion().size() == 0);

        CDG.creerTypeAvion("Airbus 380", 2, 3);
        CDG.creerAvion("Airbus", "Airbus 380");

        assertTrue(CDG.getListeAvion().size() == 1);
        assertEquals(CDG.getListeAvion().get(0).getReference(), "Airbus");
        assertEquals(CDG.getListeAvion().get(0).getType().getNom(), "Airbus 380");
    }

    @Test
    public void testCreerTypeAvion() throws Exception {
        System.out.println("\n\nTEST CREER TYPE AVION\n");
        TableauVols CDG = new TableauVols("CDG");

        CDG.creerTypeAvion("Airbus 380", 2, 3);

        assertTrue(CDG.getListeTypeAvion().size() == 1);
        assertEquals(CDG.getListeTypeAvion().get(0).getNom(), "Airbus 380");
        assertEquals(CDG.getListeTypeAvion().get(0).getMinPNC(), 2);
        assertEquals(CDG.getListeTypeAvion().get(0).getMaxPNC(), 3);
    }

    @Test
    public void testCreerTypeAvion2() throws Exception {
        System.out.println("\n\nTEST CREER TYPE AVION 2 \n");
        TableauVols CDG = new TableauVols("CDG");

        CDG.creerTypeAvion("Airbus 380");

        assertTrue(CDG.getListeTypeAvion().size() == 1);
        assertEquals(CDG.getListeTypeAvion().get(0).getNom(), "Airbus 380");
        assertEquals(CDG.getListeTypeAvion().get(0).getMinPNC(), 1);
        assertEquals(CDG.getListeTypeAvion().get(0).getMaxPNC(), 1);
    }

    @Test
    public void testCreerVol() throws Exception {
        System.out.println("\n\nTEST CREER VOL\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus 380", 2, 3);
        CDG.creerAvion("Airbus", "Airbus 380");
        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");

        assertTrue(CDG.getListeVols().size() == 1);
        assertEquals(CDG.getListeVols().get(0).getNumero(), "123");
        assertEquals(CDG.getListeVols().get(0).getAvion().getReference(), "Airbus");
        assertEquals(CDG.getListeVols().get(0).getAvion().getType().getNom(), "Airbus 380");
        assertEquals(CDG.getListeVols().get(0).getDateDepart(), "10/11/12");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getPilote(), null);
        assertEquals(CDG.getListeVols().get(0).getEquipage().getCopilote(), null);
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().size(), 0);

        CDG.creerPilote("Ha", "Anais");

        //attention si 2 fois meme nom et prenom dans fonctions differentes => ne marche pas !!
        CDG.affecterMembreVol("Ha", "Anais", "Pilote", "123");
    }

    @Test
    public void testSupprimerAvion() throws Exception {
        System.out.println("\n\nTEST SUPPRIMER AVION\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus 380", 2, 3);
        CDG.creerAvion("Airbus", "Airbus 380");
        CDG.creerAvion("Airbus1", "Airbus 380");
        CDG.supprimerAvion("Airbus");
        CDG.supprimerAvion("Airbus 3250");
        assertTrue(CDG.getListeAvion().size() == 1);
        assertEquals(CDG.getListeAvion().get(0).getReference(), "Airbus1");
    }

    @Test
    public void testSupprimerTypeAvion() throws Exception {
        System.out.println("\n\nTEST SUPPRIMER TYPE AVION\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A320", 2, 3);
        CDG.creerTypeAvion("Boeing 747", 2, 3);
        //est ce que tout les avion qui ont le type airbus 380 doit etre null ?
        CDG.supprimerTypeAvion("Airbus 380");
        CDG.supprimerTypeAvion("Boeing 747");
        assertTrue(CDG.getListeTypeAvion().size() == 1);
        assertEquals(CDG.getListeTypeAvion().get(0).getNom(), "Airbus A320");
    }

    @Test
    public void testSupprimerVol() throws Exception {
        System.out.println("\n\nTEST SUPPRIMER VOL\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerTypeAvion("Boeing 747");
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerAvion("Boeing", "Boeing 747");

        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");
        CDG.creerVol("456", CDG.getNomAeroport(), "Paris", "Boeing", "04/12/15");

        //mettre les equipage => vol = null
        CDG.supprimerVol("8978");
        CDG.supprimerVol("123");

        assertTrue(CDG.getListeVols().size() == 1);
        assertEquals(CDG.getListeVols().get(0).getNumero(), "456");
    }

    @Test
    public void testAffecterMembreVol() throws Exception {
        System.out.println("\n\nTEST AFFECTER MEMBRE VOL\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerTypeAvion("Boeing 747");
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerAvion("Boeing", "Boeing 747");
        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");
        CDG.creerVol("456", CDG.getNomAeroport(), "Paris", "Boeing", "04/12/15");

        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");

        //fonction doit etre egale a Pilote, Copilote ou PNC
        CDG.qualifierMembreEquipage("Ha", "Anais", "Pilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ba", "Marieme", "Copilote", "Boeing 747");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Airbus A380");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Boeing 747");
        CDG.qualifierMembreEquipage("Chau", "Mickael", "PNC", "Airbus A380");

        CDG.affecterMembreVol("Ha", "Anais", "Pilote", "123");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getPilote().getNom(), "Ha");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getPilote().getPrenom(), "Anais");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getPilote().getFonction(), "Pilote");


        CDG.affecterMembreVol("Ha", "Anais", "PNC", "123");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().get(0).getNom(), "Ha");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().get(0).getPrenom(), "Anais");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().get(0).getFonction(), "PNC");

        CDG.affecterMembreVol("Ba", "Marieme", "Copilote", "456");
        assertEquals(CDG.getListeVols().get(1).getEquipage().getCopilote().getNom(), "Ba");
        assertEquals(CDG.getListeVols().get(1).getEquipage().getCopilote().getPrenom(), "Marieme");
        assertEquals(CDG.getListeVols().get(1).getEquipage().getCopilote().getFonction(), "Copilote");

        CDG.affecterMembreVol("Ha", "Anais", "PNC", "456");

        assertEquals(CDG.getListeVols().get(1).getEquipage().getListePnc().get(0).getNom(), "Ha");
        assertEquals(CDG.getListeVols().get(1).getEquipage().getListePnc().get(0).getPrenom(), "Anais");
        assertEquals(CDG.getListeVols().get(1).getEquipage().getListePnc().get(0).getFonction(), "PNC");

        CDG.affecterMembreVol("Chau", "Mickael", "Pilote", "123");

        assertEquals(CDG.getListeVols().get(0).getEquipage().getPilote().getNom(), "Ha");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getPilote().getPrenom(), "Anais");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getPilote().getFonction(), "Pilote");

        CDG.affecterMembreVol("Chau", "Mickael", "PNC", "123");

        assertTrue(CDG.getListeVols().get(0).getEquipage().getListePnc().size() == 2);
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().get(1).getNom(), "Chau");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().get(1).getPrenom(), "Mickael");
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().get(1).getFonction(), "PNC");


        CDG.affecterMembreVol("Ba", "Marieme", "Copilote", "123");

        assertTrue(CDG.getListeVols().get(0).getEquipage().getCopilote() == null);
    }

    @Test
    public void testRetirerMembreVol() throws Exception {
        System.out.println("\n\nTEST RETIRER MEMBRE VOL\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerTypeAvion("Boeing 747");
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerAvion("Boeing", "Boeing 747");

        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");
        CDG.creerVol("456", CDG.getNomAeroport(), "Paris", "Boeing", "04/12/15");

        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");

        //fonction doit etre egale a Pilote, Copilote ou PNC
        CDG.qualifierMembreEquipage("Ha", "Anais", "Pilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ba", "Marieme", "Copilote", "Boeing 747");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Airbus A380");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Boeing 747");
        CDG.qualifierMembreEquipage("Chau", "Mickael", "PNC", "Airbus A380");

        CDG.affecterMembreVol("Ha", "Anais", "Pilote", "123");
        CDG.affecterMembreVol("Ha", "Anais", "PNC", "123");
        CDG.affecterMembreVol("Ba", "Marieme", "Copilote", "456");
        CDG.affecterMembreVol("Ha", "Anais", "PNC", "456");
        CDG.affecterMembreVol("Chau", "Mickael", "PNC", "123");

        CDG.retirerMembreVol("Ha", "Anais", "PNC", "123");
        assertTrue(CDG.getListeVols().get(0).getEquipage().getListePnc().size() == 1);
        assertEquals(CDG.getListeVols().get(0).getEquipage().getListePnc().get(0).getNom(), "Chau");
        CDG.retirerMembreVol("Ha", "Anais", "Pilote", "123");
        assertTrue(CDG.getListeVols().get(0).getEquipage().getPilote() == null);
        CDG.retirerMembreVol("Ba", "Marieme", "Copilote", "456");
        assertTrue(CDG.getListeVols().get(1).getEquipage().getCopilote() == null);
    }

    @Test
    public void testAfficherDonneeVol() throws Exception {
        System.out.println("\n\nTEST AFFICHAGE DONNEE VOL\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerTypeAvion("Boeing 747");
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerAvion("Boeing", "Boeing 747");

        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");
        CDG.creerVol("456", CDG.getNomAeroport(), "Paris", "Boeing", "04/12/15");

        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");

        //fonction doit etre egale a Pilote, Copilote ou PNC
        CDG.qualifierMembreEquipage("Ha", "Anais", "Pilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ba", "Marieme", "Copilote", "Boeing 747");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Airbus A380");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Boeing 747");
        CDG.qualifierMembreEquipage("Chau", "Mickael", "PNC", "Airbus A380");

        CDG.affecterMembreVol("Ha", "Anais", "Pilote", "123");
        CDG.affecterMembreVol("Ha", "Anais", "PNC", "123");
        CDG.affecterMembreVol("Ba", "Marieme", "Copilote", "456");
        CDG.affecterMembreVol("Ha", "Anais", "PNC", "456");
        CDG.affecterMembreVol("Chau", "Mickael", "PNC", "123");

        CDG.afficherDonneeVol("123");
        CDG.afficherDonneeVol("456");
    }

    @Test
    public void testAfficherVolMembreEquipe() throws Exception {
        System.out.println("\n\nTEST AFFICHAGE DONNEE MEMBRE VOL\n");
        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerTypeAvion("Boeing 747");
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerAvion("Boeing", "Boeing 747");

        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");
        CDG.creerVol("456", CDG.getNomAeroport(), "Paris", "Boeing", "04/12/15");

        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");

        //fonction doit etre egale a Pilote, Copilote ou PNC
        CDG.qualifierMembreEquipage("Ha", "Anais", "Pilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ba", "Marieme", "Copilote", "Boeing 747");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Airbus A380");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Boeing 747");
        CDG.qualifierMembreEquipage("Chau", "Mickael", "PNC", "Airbus A380");

        CDG.affecterMembreVol("Ha", "Anais", "Pilote", "123");
        CDG.affecterMembreVol("Ha", "Anais", "PNC", "123");
        CDG.affecterMembreVol("Ba", "Marieme", "Copilote", "456");
        CDG.affecterMembreVol("Ha", "Anais", "PNC", "456");
        CDG.affecterMembreVol("Chau", "Mickael", "PNC", "123");

        CDG.afficherVolMembreEquipe("Ha", "Anais", "Pilote", "123");
        CDG.afficherVolMembreEquipe("Ba", "Marieme", "Copilote", "456");
        CDG.afficherVolMembreEquipe("Ha", "Anais", "PNC", "456");
    }
}