package appliVols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by mariemeba on 09/01/2016.
 */
public class InterfaceBase extends JFrame {
    private ModeleTableauAffichageManager modele = new ModeleTableauAffichageManager();
    private JTable tableau;

    public InterfaceBase() {
        super();

        setTitle("Interface Application Marieme et Anais ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        JPanel boutons = new JPanel();

        boutons.add(new JButton(new EmployeAction()));
        boutons.add(new JButton(new ManagerAction()));
        boutons.add(new JButton(new AdministrateurAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        pack();
    }


    private class EmployeAction extends AbstractAction {
        private EmployeAction() {
            super("Employe");
        }

        public void actionPerformed(ActionEvent e) {
            new AffichageEmploye().setVisible(true);
        }
    }


    private class ManagerAction extends AbstractAction {
        private ManagerAction() {
            super("Manager");
        }

        public void actionPerformed(ActionEvent e) {

            new TableauAffichageManager().setVisible(true);
        }
    }


    private class AdministrateurAction extends AbstractAction {
        private AdministrateurAction() {
            super("Administrateur");
        }

        public void actionPerformed(ActionEvent e) {

            new TableauAffichageAdministateur().setVisible(true);
        }
    }
}

