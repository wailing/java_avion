package appliVols;


import affichageVols.TableauVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mariemeba on 11/01/2016.
 */
public class AjouterVol extends JFrame {
    JLabel l, l2,l3,l4,l5;

    public void start() {

        l = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();

        l.setText("	Numero de Vol :");
        JTextField numVolAAjouter = new JTextField();
        numVolAAjouter.setText("                 ");
        l2.setText(" Nom Aeroport :");
        JTextField nomSiteAAjouter = new JTextField();
        numVolAAjouter.setText("                 ");
        l3.setText(" Destination : ");
        JTextField DestAAjouter = new JTextField();
        DestAAjouter.setText("                 ");
        l4.setText(" Type Avion :");
        JTextField TypeAvionAjouter = new JTextField();
        TypeAvionAjouter.setText("                 ");
        l5.setText(" Date de depart :");
        JTextField DateDepAAjouter = new JTextField();
        DateDepAAjouter.setText("                 ");


        // JTextArea ps = new JTextArea();
        JButton butValider = new JButton();
        butValider.setText("Valider");
        JButton butRetour = new JButton(new RetourAction());

        add(l);
        add(numVolAAjouter);
        add(l2);
        add(nomSiteAAjouter);
        add(l3);
        add(DestAAjouter);
        add(l4);
        add(TypeAvionAjouter);
        add(l5);
        add(DateDepAAjouter);

        add(butValider);
        add(butRetour);
        System.out.println(numVolAAjouter.getText());
        System.out.println(nomSiteAAjouter.getText());
        System.out.println(DestAAjouter.getText());
        System.out.println(TypeAvionAjouter.getText());
        System.out.println(DateDepAAjouter.getText());

        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerVol("123","Orly", "Londres", "Airbus", "10/11/12");

        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");

        butValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.setText("Valider");

                CDG.creerVol(numVolAAjouter.getText(), nomSiteAAjouter.getText(),DestAAjouter.getText(),TypeAvionAjouter.getText(),DateDepAAjouter.getText());

                for (int i = 0; i < CDG.getListePersonne().size(); i++) {
                    System.out.printf(CDG.getListeVols().get(i).getNumero() + " ; " + CDG.getListeVols().get(i).getSite() + " ; " + CDG.getListeVols().get(i).getDestination(),CDG.getListeVols().get(i).getAvion(),CDG.getListeVols().get(i).getDateDepart());
                }

            }
        });

        setLayout(new FlowLayout());
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class RetourAction extends AbstractAction {
        private RetourAction() {
            super("Retour");
        }

        public void actionPerformed(ActionEvent e) {
            new InterfaceBase().setVisible(true);
            dispose();
        }
    }
}

