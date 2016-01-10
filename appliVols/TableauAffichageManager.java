package appliVols;

import affichageVols.TableauVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class TableauAffichageManager extends JFrame {
    private ModeleTableauAffichageManager modele = new ModeleTableauAffichageManager();
    private JTable tableau;

    public TableauAffichageManager() {
        super();

        setTitle("Tableau de Gestion des employes");
        setSize(400,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableau = new JTable(modele);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));
        boutons.add(new JButton(new RetourAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        pack();
    }

    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimer");
        }

        public void actionPerformed(ActionEvent e) {
            int[] selection = tableau.getSelectedRows();

            for (int i = selection.length - 1; i >= 0; i--) {
                modele.removeAmi(selection[i]);
            }
        }
    }
    private class AddAction extends AbstractAction {
        private AddAction() {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {
            //new JTableBasiqueAvecModeleDynamiqueObjet().setVisible(true);
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
            VolTab vol = new VolTab(CDG.getListeVols().get(0).getAvion().getReference(), CDG.getListeVols().get(0).getNumero(), CDG.getListeVols().get(0).getDestination(), CDG.getListeVols().get(0).getDateDepart(), CDG.getListeVols().get(0).getAvion().getType().getNom(), CDG.getNomAeroport() ,CDG.getListeVols().get(0).getEquipage().getPilote().getNom(), CDG.getListeVols().get(0).getEquipage().getPilote().getPrenom(), CDG.getListeVols().get(0).getEquipage().getPilote().getFonction());
            modele.addAmi(vol);
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