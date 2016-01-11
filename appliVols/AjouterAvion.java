
package appliVols;


        import affichageVols.TableauVols;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

/**
 * Created by mariemeba on 11/01/2016.
 */
public class AjouterAvion extends JFrame {
    JLabel l, l2,l3,l4,l5;

    public void start() {

        l = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();



        l.setText("	Nom de l'avion :");
        JTextField nomAvionAAjouter = new JTextField();
        nomAvionAAjouter.setText("                 ");
        l2.setText(" Nombre de PNC min :");
        JTextField minPNCAAjouter = new JTextField();
        minPNCAAjouter.setText("                 ");
        l3.setText(" Nombre de PNC max : ");
        JTextField maxPNCAAjouter = new JTextField();
        maxPNCAAjouter.setText("                 ");


        // JTextArea ps = new JTextArea();
        JButton butValider = new JButton();
        butValider.setText("Valider");
        JButton butRetour = new JButton(new RetourAction());

        add(l);
        add(nomAvionAAjouter);
        add(l2);
        add(minPNCAAjouter);
        add(l3);
        add(maxPNCAAjouter);

        add(butValider);
        add(butRetour);
        System.out.println(nomAvionAAjouter.getText());
        System.out.println(minPNCAAjouter.getText());
        System.out.println(maxPNCAAjouter.getText());

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
                CDG.creerTypeAvion(nomAvionAAjouter.getText(), 2, 3);


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

