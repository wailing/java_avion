package appliVols;

import affichageVols.TableauVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Created by mariemeba on 11/01/2016.
 */
public class AffectationManager extends JFrame {
    JLabel l,l2,l3,l4;
    VolTab vol;
    public void start() {

        l = new JLabel();
        l2= new JLabel();
        l3= new JLabel();
        l4= new JLabel();

        l.setText("	Nom de l'employé :");
        JTextField nomAAjouter = new JTextField();
        nomAAjouter.setText("");
        l2.setText(" Prenom de l'employé :");
        JTextField prenomAAjouter = new JTextField();
        prenomAAjouter.setText("");
        l3.setText(" Fonction : ");
        JTextField fonctionAAjouter = new JTextField();
        nomAAjouter.setText("");
        l4.setText(" Numero du vol :");
        JTextField numVolAAjouter = new JTextField();
        numVolAAjouter.setText("");

        // JTextArea ps = new JTextArea();
        JButton butValider = new JButton();
        butValider.setText("Valider");
        JButton butRetour = new JButton(new RetourAction());

        add(l);
        add(nomAAjouter);
        add(l2);
        add(prenomAAjouter);
        add(l3);
        add(fonctionAAjouter);
        add(l4);
        add(numVolAAjouter);
        // add(ps);
        add(butValider);
        add(butRetour);
        System.out.println(nomAAjouter.getText());
        System.out.println(prenomAAjouter.getText());
        System.out.println(fonctionAAjouter.getText());
        System.out.println(numVolAAjouter.getText());

        TableauVols CDG = new TableauVols("CDG");
        CDG.creerTypeAvion("Airbus A380", 2, 3);
        CDG.creerAvion("Airbus", "Airbus A380");
        CDG.creerVol("123","CDG", "Londres", "Airbus", "10/11/12");
        CDG.creerPilote("Ha", "Anais");
        CDG.creerCopilote("Ba", "Marieme");
        CDG.creerPnc("Chau", "Mickael");
        CDG.creerPnc("Ha", "Anais");
        CDG.creerPnc("Bla", "Bla");
        CDG.qualifierMembreEquipage("Ha", "Anais", "Pilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ba", "Marieme", "Copilote", "Airbus A380");
        CDG.qualifierMembreEquipage("Ha", "Anais", "PNC", "Airbus A380");
        CDG.qualifierMembreEquipage("Chau", "Mickael", "PNC", "Airbus A380");
        CDG.qualifierMembreEquipage("Bla", "Bla", "PNC", "Airbus 380");

        butValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.setText("Valider");

                CDG.affecterMembreVol(nomAAjouter.getText(), prenomAAjouter.getText(), fonctionAAjouter.getText(), numVolAAjouter.getText());

                VolTab vol = new VolTab(numVolAAjouter.getText(),numVolAAjouter.getText(), CDG.getListeVols().get(0).getDestination(), CDG.getListeVols().get(0).getDateDepart(), CDG.getListeVols().get(0).getAvion().getType().getNom(), CDG.getNomAeroport() ,nomAAjouter.getText(), prenomAAjouter.getText(), CDG.getListeVols().get(0).getEquipage().getPilote().getFonction());

                for (int i = 0 ;i < CDG.getListePersonne().size() ; i++) {
                    System.out.printf(CDG.getListePersonne().get(i).getNom()+" ; "+CDG.getListePersonne().get(i).getPrenom()+" ; "+CDG.getListePersonne().get(i).getFonction());
                }
            }
        });

        setLayout(new FlowLayout());
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class RetourAction extends AbstractAction {
        private RetourAction() {
            super("Retour");
        }

        public void actionPerformed(ActionEvent e) {
            new InterfaceBase().setVisible(true);
            dispose();
        }
    }

    public VolTab getVol() {
        return vol;
    }
}
