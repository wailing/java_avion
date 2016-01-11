package appliVols;

import avion.Avion;
import vol.Vol;
import avion.TypeAvion;
//import affichageVols.Aeroport;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;



public class ModeleTableauAffichageManager extends AbstractTableModel {
    private final List<VolTab> ListeVolTab = new ArrayList<VolTab>();

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
        ListeVolTab.add(new VolTab(av.getReference(),v.getNumero(), v.getDestination(),v.getDateDepart(),type.getNom(),v.getSite(),"Marieme","Ba","Pilote"));
    }

    public int getRowCount() {
        return ListeVolTab.size();
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
                return ListeVolTab.get(rowIndex).getNumero();
            case 1:
                return ListeVolTab.get(rowIndex).getNomVol();
            case 2:
                return ListeVolTab.get(rowIndex).getDestination();
            case 3:
                return ListeVolTab.get(rowIndex).getDateDepart();
            case 4:
                return ListeVolTab.get(rowIndex).getNomTypeAvion();
            case 5:
                return ListeVolTab.get(rowIndex).getSite();
            case 6:
                return ListeVolTab.get(rowIndex).getPrenom();
            case 7:
                return ListeVolTab.get(rowIndex).getNom();
            case 8:
                return ListeVolTab.get(rowIndex).getFonction();
            case 9:
            return null;
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addAmi(VolTab v) {
        ListeVolTab.add(v);
        fireTableRowsInserted(ListeVolTab.size() -1, ListeVolTab.size() -1);
    }

    public void removeAmi(int rowIndex) {
        ListeVolTab.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}