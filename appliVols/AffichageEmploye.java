package appliVols;

import affichageVols.TableauVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by mariemeba on 11/01/2016.
 */
    public class AffichageEmploye extends JFrame {
        private ModeleTableauAffichageManager modele = new ModeleTableauAffichageManager();
        private JTable tableau;

        public AffichageEmploye() {
            super();

            setTitle("Tableau de vol Consultation pour employes");
            setSize(400,1000);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            tableau = new JTable(modele);

            getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

            JPanel boutons = new JPanel();

            boutons.add(new JButton(new RetourAction()));

            getContentPane().add(boutons, BorderLayout.SOUTH);


            pack();
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
    }
