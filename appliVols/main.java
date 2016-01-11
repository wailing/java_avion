package appliVols;

import affichageVols.TableauVols;

import java.io.*;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */

public class main {

    public static void main(String[] args) {

        ObjectInputStream ois;
        ObjectOutputStream oos;

        TableauVols CDG = new TableauVols("Roissy CDG");
        TableauVols Orly = new TableauVols("Orly");

        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");
        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");

        CDG.qualifierMembreEquipage("Ha", "Anais", "Pilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ba", "Marieme", "Copilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Airbus A380");
        CDG.qualifierMembreEquipage("Chau", "Mickael", "PNC", "Airbus A380");

        CDG.affecterMembreVol("Ha", "Anais", "Pilote", "123");
        CDG.affecterMembreVol("Ha", "Anais", "PNC", "123");
        CDG.affecterMembreVol("Ba", "Marieme", "Copilote", "123");
        CDG.affecterMembreVol("Chau", "Mickael", "PNC", "123");

        CDG.afficherVolMembreEquipe("Ha", "Anais", "Pilote","123");

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("Aeroports.txt"))));

            oos.writeObject(CDG);
            oos.writeObject(Orly);
            oos.close();

            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("Aeroports.txt"))));

            try {
                System.out.println("Affichage des aeroports :");
                System.out.println("*************************\n");
                System.out.println(((TableauVols)ois.readObject()).toString());
                System.out.println(((TableauVols)ois.readObject()).toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       new InterfaceBase().setVisible(true);
    }
}
