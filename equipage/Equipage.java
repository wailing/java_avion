package equipage;

import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;
import vol.Vol;

import java.util.ArrayList;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Equipage {
    private boolean auMin;
    private boolean auMax;
    private Pilote pilote;
    private Copilote copilote;
    private ArrayList<Pnc> listePnc;
    private Vol vol;

    public Equipage(Vol v) {
        this.auMin = false;
        this.auMax = false;
        this.pilote = new Pilote(null, null);
        this.copilote = new Copilote(null, null);
        this.listePnc = new ArrayList<>();
        this.vol = v;
    }

    public void addPilote(Pilote p) {
        this.pilote = p;
    }

    public void addCoPilote(Copilote c) {
        this.copilote = c;
    }

    public boolean addPNC(Pnc p) {
        //verifier si auMin est atteint et auMax n'est pas surpassé
        if(isAuMin() && isAuMax()) {
            return false;
        }
        else if (isAuMax()) {
            this.listePnc.add(p);
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
}
