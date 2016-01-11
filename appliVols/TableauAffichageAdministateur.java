package appliVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by mariemeba on 11/01/2016.
 */
    public class TableauAffichageAdministateur extends JFrame {
        private ModeleTableauAffichageManager modele = new ModeleTableauAffichageManager();
        private JTable tableau;

        public TableauAffichageAdministateur() {
            super();

            setTitle("Tableau de Gestion des employes");
            setSize(400,1000);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            tableau = new JTable(modele);

            getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

            JPanel boutons = new JPanel();

            boutons.add(new JButton(new ModifEmployeAction()));
            boutons.add(new JButton(new ModifVolAction()));
            boutons.add(new JButton(new ModifAvionAction()));

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
        private class ModifEmployeAction extends AbstractAction {
            private ModifEmployeAction() {
                super("Modifier les employes");
            }

            public void actionPerformed(ActionEvent e) {
                new AjoutPersonne().start();

                }
            }

    private class ModifVolAction extends AbstractAction {
        private ModifVolAction() {
            super("Modifier les vols");
        }
        public void actionPerformed(ActionEvent e) {
            new AjouterVol().start();

        }
    }
    private class ModifAvionAction extends AbstractAction {
        private ModifAvionAction() {
            super("Modifier les avions");
        }
        public void actionPerformed(ActionEvent e) {
            new AjouterAvion().start();

        }
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
