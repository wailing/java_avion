package vol;

import avion.Avion;
//import equipage.Equipage;
import exception.EquipageException;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Vol {
     class Equipage {
        private boolean auMin;
        private boolean auMax;
        private Pilote pilote;
        private Copilote copilote;
        private ArrayList<Pnc> listePnc;
        private Vol vol;

        public Equipage(Vol v) {
            Equipage.this.auMin = false;
            Equipage.this.auMax = false;
            Equipage.this.pilote = null;
            Equipage.this.copilote = null;
            Equipage.this.listePnc = new ArrayList<>();
            Equipage.this.vol = v;
        }

        public void addPilote(Pilote p) throws EquipageException{

            if (this.pilote == null ) {
                this.pilote = p;
            }
            else throw new EquipageException("Un pilote est déjà inscrit :" + getPilote().getNom() + " " + getPilote().getPrenom() + "\n");
        }

        public void addCoPilote(Copilote c) throws EquipageException {
            if(this.copilote == null) {
                this.copilote = c;
            }
            else throw new EquipageException("Un pilote est déjà inscrit :" + getCopilote().getNom() + " " + getCopilote().getPrenom() + "\n");
        }

        public boolean addPNC(Pnc p) throws EquipageException {
            if(isAuMin() && isAuMax()) {
                return false;
            }
            else {
                if(Equipage.this.vol.equipageAuComplet()) {
                    Equipage.this.auMax = true;
                    Equipage.this.auMin = true;
                }
                else {
                    if(!this.listePnc.contains(p)) {
                        Equipage.this.listePnc.add(p);
                    }
                    else throw new EquipageException("Un pilote est déjà inscrit :" + p.getNom() + " " + p.getPrenom() + "\n");
                }
            }
            return false;
        }

        public boolean isAuMin() {
            return auMin;
        }

        public boolean isAuMax() {
            return auMax;
        }

        public Pilote getPilote() {
            return pilote;
        }

        public Copilote getCopilote() {
            return copilote;
        }

        public ArrayList<Pnc> getListePnc() {
            return listePnc;
        }

        public Vol getVol() {
            return vol;
        }

         public void setAuMin(boolean auMin) {
             this.auMin = auMin;
         }

         public void setAuMax(boolean auMax) {
             this.auMax = auMax;
         }

         public void setPilote(Pilote pilote) {
             this.pilote = pilote;
         }

         public void setCopilote(Copilote copilote) {
             this.copilote = copilote;
         }

         public void setListePnc(ArrayList<Pnc> listePnc) {
             this.listePnc = listePnc;
         }

         @Override
        public String toString() {
            String chaine = "\n\n*******************************************";
            chaine += "\nEquipage de l'avion " + getVol().getNumero();
            chaine += "\n" + getPilote().toString() + "\n" + getCopilote().toString() ;
            for(int i = 0; i < getListePnc().size(); i++) {
                chaine += "\n" + getListePnc().get(i).toString();
            }
            chaine += "\n\n*******************************************";
            return chaine;
        }
    }

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
        if(p.peutVoler(getAvion().getType()))  {
            boolean result = this.equipage.addPNC(p);
            if (result) {
                return true;
            }
            else {
                throw new EquipageException("Le PNC " + p.getNom() + " " + p.getPrenom() + " ne peut pas voler sur cette avion.\n");
            }
        }
        return false;
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

    public Pilote getPilote() {
        return equipage.getPilote();
    }

    public Copilote getCopilote() {
        return equipage.getCopilote();
    }

    public ArrayList<Pnc> getListePnc() {
        return equipage.getListePnc();
    }

    public void setPilote(Pilote pilote) {
         equipage.setPilote(pilote);
    }

    public void setCopilote(Copilote copilote) {
         equipage.setCopilote(copilote);
    }

    public void setListePnc(Pnc pnc) throws EquipageException{
        if(equipage.getListePnc().contains(pnc)) {
            equipage.getListePnc().remove(pnc);
        }
        else {
            throw new EquipageException("Le PNC de l'equipage n'existe pas");
        }
    }

    @Override
    public String toString() {
        String chaine = "\n\n*******************************************";
        chaine += "\nDescription du vol numero  " + getNumero();
        chaine += "\nAeroport de depart : " + getSite();
        chaine += "\nDestination : " + getDestination();
        chaine += "\nDate de depart : " + getDateDepart();
        chaine += getAvion().toString() + getEquipage().toString();
        chaine += "\n\n*******************************************";
        return chaine;
    }
}
