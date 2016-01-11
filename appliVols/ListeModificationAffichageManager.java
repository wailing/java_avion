package appliVols;

import affichageVols.TableauVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mariemeba on 11/01/2016.
 */
public class ListeModificationAffichageManager extends JFrame{
    private JTable tableau;
    JLabel l;
    public void start() {

        l=new JLabel();
        l.setText("	Name :");
        JTextField txt=new JTextField();
        txt.setText("Anurag jain(csanuragjain)");
        JPasswordField ps=new JPasswordField(10);
        JButton but=new JButton(); but.setText("Submit");
        add(l); add(txt); add(ps); add(but);
        but.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                l.setText("Button clicked");
            }
        });
    }

    public ListeModificationAffichageManager() {
        super();

        setTitle("Modifcation des affectations ");
        setSize(400,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel boutons = new JPanel();



        boutons.add(new JButton(new AffecterAction()));
        boutons.add(new JButton(new RetourAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);


        pack();
    }

    /*private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimer");
        }

        public void actionPerformed(ActionEvent e) {
            int[] selection = tableau.getSelectedRows();

            for (int i = selection.length - 1; i >= 0; i--) {
                modele.removeAmi(selection[i]);
            }
        }
    }*/

    private class AffecterAction extends AbstractAction {
        private AffecterAction() {
            super("Affecter un membre");
        }

        public void actionPerformed(ActionEvent e) {
            JLabel label = new JLabel("Veuillez saisir le nom de l'employé ");
            String prenomAAjouter;

            TableauVols CDG = new TableauVols("CDG");
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


           // VolTab vol = new VolTab(CDG.getListeVols().get(0).getAvion().getReference(), CDG.getListeVols().get(0).getNumero(), CDG.getListeVols().get(0).getDestination(), CDG.getListeVols().get(0).getDateDepart(), CDG.getListeVols().get(0).getAvion().getType().getNom(), CDG.getNomAeroport() ,CDG.getListeVols().get(0).getEquipage().getPilote().getNom(), CDG.getListeVols().get(0).getEquipage().getPilote().getPrenom(), CDG.getListeVols().get(0).getEquipage().getPilote().getFonction());
           // modele.addAmi(vol);

            for (int i = 0 ;i <CDG.getListePersonne().size() ; i++) {
                System.out.printf(CDG.getListePersonne().get(i).getNom()+" ; "+CDG.getListePersonne().get(i).getPrenom()+" ; "+CDG.getListePersonne().get(i).getFonction());


                /*setDefaultValueOf(tf1, "Valeur par défault");
                //ajoute des validateurs
                addFieldValidator(tf1, CommonsValidator.required, FormatedMessage.getRequired(jl1));
                addFieldValidator(tf1, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl1));
                //ajoute un méssage  d'information lié à un élément
                addFieldInfoMessage(tf1, "Du blabla qui éxplique à quoi correspond le champ du formulaire...");*/

            }
        }
    }

    private class RetourAction extends AbstractAction {
        private RetourAction() {
            super("Retour");
        }

        public void actionPerformed(ActionEvent e) {
            new InterfaceBase().setVisible(true);
        }
    }

}

