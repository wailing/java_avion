package vol;

import avion.Avion;
import vol.Equipage;
import exception.EquipageException;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class Vol {
    private String numero;
    private String site;
    private String destination;
    private String dateDepart;
    private Equipage equipage;
    private Avion avion;

    public Vol(String num, String site, String dest, Avion av, String dep) {
        this.numero = num;
        this.site = site;
        this.destination = dest;
        this.avion = av;
        this.dateDepart = dep;
        this.equipage = new Equipage(this);
    }

    public Vol(String num, String dep) {
        this.numero = num;
        this.dateDepart = dep;
        this.site = null;
        this.destination = null;
        this.avion = null;
        this.equipage = new Equipage(this);
    }

    public void addPilote(Pilote p) throws EquipageException {
        if(p.peutVoler(getAvion().getType())) {
            this.equipage.addPilote(p);
        }
        else {
            throw new EquipageException("Le pilote " + p.getNom() + " " + p.getPrenom() + " ne peut pas voler sur cette avion.\n");
        }
    }

    public void addCoPilote(Copilote c) throws EquipageException {
        if (c.peutVoler(getAvion().getType())) {
            this.equipage.addCoPilote(c);
        }
        else {
            throw new EquipageException("Le copilote " + c.getNom() + " " + c.getPrenom() + " ne peut pas voler sur cette avion.\n");
        }
    }

    public boolean addPNC(Pnc p) throws EquipageException {
        if(!p.peutVoler(getAvion().getType())) {
            throw new EquipageException("Le PNC " + p.getNom() + " " + p.getPrenom() + " ne peut pas voler sur cette avion.\n");
        }
        else {
            boolean result = this.equipage.addPNC(p);
            if (result) {
                return true;
            } else {
                throw new EquipageException("Le PNC " + p.getNom() + " " + p.getPrenom() + " ne peut pas voler sur cette avion.\n");
            }
        }
    }

    public boolean equipageAuComplet() {
        if(this.equipage.getPilote() != null && this.equipage.getCopilote() != null) {
            System.out.println("min " + this.avion.getType().getMinPNC() + " max " + this.avion.getType().getMaxPNC() + " size liste " + this.equipage.getListePnc().size());
            if (this.equipage.getListePnc().size() >= this.avion.getType().getMinPNC()) {
                if (this.equipage.getListePnc().size() <= this.avion.getType().getMaxPNC()) {
                    System.out.println("I'm here");
                    return true;
                }
            }
        }
        return false;
    }

    public String getNumero() {
        return numero;
    }

    public String getSite() {
        return site;
    }

    public String getDestination() {
        return destination;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public Equipage getEquipage() {
        return equipage;
    }

    public Avion getAvion() {
        return avion;
    }


    public void setListePnc(Pnc pnc) throws EquipageException{
        if(equipage.getListePnc().contains(pnc)) {
            equipage.getListePnc().remove(pnc);
        }
        else {
            throw new EquipageException("Le PNC de l'equipage n'existe pas\n");
        }
    }

    @Override
    public String toString() {
        String chaine = "\n\n*******************************************";
        chaine += "\nDescription du vol numero  " + getNumero();
        chaine += "\nAeroport de depart : " + getSite();
        chaine += "\nDestination : " + getDestination();
        chaine += "\nDate de depart : " + getDateDepart();
        if (getAvion() != null ){
            chaine += getAvion().toString();
        }
        else {
            chaine += "L'avion n'existe pas !\n\n";
        }

        if (getEquipage() != null) {
            chaine += getEquipage().toString();
        }
        else {
            chaine += "\n\nL'equipage n'existe pas !";
        }
        chaine += "\n\n*******************************************";
        return chaine;
    }
}
