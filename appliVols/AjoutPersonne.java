package appliVols;

import affichageVols.TableauVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mariemeba on 11/01/2016.
 */
public class AjoutPersonne extends JFrame {
    JLabel l, l2;

    public void start() {

        l = new JLabel();
        l2 = new JLabel();

        l.setText("	Nom de l'employé :");
        JTextField nomAAjouter = new JTextField();
        nomAAjouter.setText("                 ");
        l2.setText(" Prenom de l'employé :");
        JTextField prenomAAjouter = new JTextField();
        prenomAAjouter.setText("                 ");


        // JTextArea ps = new JTextArea();
        JButton butValiderPiloteAction = new JButton();
        butValiderPiloteAction.setText("Pilote");
        JButton butValiderCoPiloteAction = new JButton();
        butValiderCoPiloteAction.setText("CoPilote");
        JButton butValiderPnc = new JButton();
        butValiderPnc.setText("Pnc");
        JButton butRetour = new JButton(new RetourAction());

        add(l);
        add(nomAAjouter);
        add(l2);
        add(prenomAAjouter);
        add(butValiderPiloteAction);
        add(butValiderCoPiloteAction);
        add(butValiderPnc);
        add(butRetour);
        System.out.println(nomAAjouter.getText());
        System.out.println(prenomAAjouter.getText());

        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerVol("123", CDG.getNomAeroport(), "Londres", "Airbus", "10/11/12");

        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");

        butValiderCoPiloteAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.setText("Copilote");

                CDG.creerCopilote(nomAAjouter.getText(), prenomAAjouter.getText());

                for (int i = 0; i < CDG.getListePersonne().size(); i++) {
                    System.out.println(CDG.getListePersonne().get(i).getNom() + " ; " + CDG.getListePersonne().get(i).getPrenom() + " ; " + CDG.getListePersonne().get(i).getFonction());
                }

            }
        });

        butValiderPnc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.setText("Pnc");

                CDG.creerPnc(nomAAjouter.getText(), prenomAAjouter.getText());

                for (int i = 0; i < CDG.getListePersonne().size(); i++) {
                    System.out.printf(CDG.getListePersonne().get(i).getNom() + " ; " + CDG.getListePersonne().get(i).getPrenom() + " ; " + CDG.getListePersonne().get(i).getFonction());
                }

            }
        });
        butValiderPiloteAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.setText("Pilote");

                CDG.creerPilote(nomAAjouter.getText(), prenomAAjouter.getText());

                for (int i = 0; i < CDG.getListePersonne().size(); i++) {
                    System.out.printf(CDG.getListePersonne().get(i).getNom() + " ; " + CDG.getListePersonne().get(i).getPrenom() + " ; " + CDG.getListePersonne().get(i).getFonction());
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
