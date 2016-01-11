package vol;

import exception.EquipageException;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by anais on 09/01/2016.
 */
public class Equipage implements Serializable {
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

        public void addPilote(Pilote p) throws EquipageException {

            if (this.pilote == null ) {
                this.pilote = p;
            }
            else throw new EquipageException("Un pilote est d�j� inscrit :" + getPilote().getNom() + " " + getPilote().getPrenom() + "\n");
        }

        public void addCoPilote(Copilote c) throws EquipageException {
            if(this.copilote == null) {
                this.copilote = c;
            }
            else throw new EquipageException("Un pilote est d�j� inscrit :" + getCopilote().getNom() + " " + getCopilote().getPrenom() + "\n");
        }

        public boolean addPNC(Pnc p) throws EquipageException {
            if(isAuMin() && isAuMax()) {
                return false;
            }
            else {
                if(this.vol.equipageAuComplet()) {
                    this.auMax = true;
                    this.auMin = true;
                }
                else {
                    if(!this.listePnc.contains(p)) {
                        this.listePnc.add(p);
                        return true;
                    }
                    else throw new EquipageException("Un pilote est d�j� inscrit :" + p.getNom() + " " + p.getPrenom() + "\n");
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
            if(getPilote() != null && getCopilote() != null && getListePnc().size() != 0) {
                chaine += "\n" + getPilote().toString() + "\n" + getCopilote().toString();
                for (int i = 0; i < getListePnc().size(); i++) {
                    chaine += "\n" + getListePnc().get(i).toString();
                }
            }
            else chaine += " \n\n L'equipage n'est pas au complet !";
            chaine += "\n\n*******************************************";
            return chaine;
        }
}
