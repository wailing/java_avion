package appliVols;

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