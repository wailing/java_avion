package appliVols;

import avion.Avion;
import exception.InvariantBroken;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Personne;
import membreEquipe.Pnc;
import vol.Vol;
import avion.TypeAvion;
import affichageVols.TableauVols;
import affichageVols.Aeroport;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;



public class ModeleTableauAffichageManager extends AbstractTableModel {
    private final List<VolTab> amis = new ArrayList<VolTab>();

    private final String[] entetes = {"Avion", "Vol", "Dest", "Date", "Type","Site","Prenom","Nom","Fonction"};

    TypeAvion type = new TypeAvion("A320", 1, 3);
    Avion av = new Avion(type, "13562");
    Vol v = new Vol("AF347", "Orly", "Londres", av, "12/01/2015");


   // boolean b = new v.addQualification(type);

   /* v.affichageVols.TableauVols.addPilote(pilote);
    Copilote copilote = new Copilote("Ba", "Marieme");
    v.addCoPilote(copilote);
    copilote.addQualification(type);
    v.addCoPilote(copilote);
    affecterCopiloteVol("BA","Marieme","AF380","CDG");
   */
    public ModeleTableauAffichageManager() {
        super();
        amis.add(new VolTab(av.getReference(),v.getNumero(), v.getDestination(),v.getDateDepart(),type.getNom(),v.getSite(),"Marieme","Ba","Pilote"));
    }

    public int getRowCount() {
        return amis.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return amis.get(rowIndex).getNumero();
            case 1:
                return amis.get(rowIndex).getNomVol();
            case 2:
                return amis.get(rowIndex).getDestination();
            case 3:
                return amis.get(rowIndex).getDateDepart();
            case 4:
                return amis.get(rowIndex).getNomTypeAvion();
            case 5:
                return amis.get(rowIndex).getSite();
            case 6:
                return amis.get(rowIndex).getPrenom();
            case 7:
                return amis.get(rowIndex).getNom();
            case 8:
                return amis.get(rowIndex).getFonction();
            case 9:
            return null;
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addAmi(VolTab v) {
        amis.add(v);
        fireTableRowsInserted(amis.size() -1, amis.size() -1);
    }

    public void removeAmi(int rowIndex) {
        amis.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}