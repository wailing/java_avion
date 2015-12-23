package equipage;

import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;
import vol.Vol;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Equipage {
    private boolean auMin;
    private boolean auMax;
    private Pilote pilote;
    private Copilote copilote;
    private Pnc pnc;
    private Vol vol;

    public Equipage(Vol v) {
        this.auMin = false;
        this.auMax = false;
        this.pilote = new Pilote(null, null);
        this.copilote = new Copilote(null, null);
        this.pnc = new Pnc(null, null);
        this.vol = v;
    }

    public void addPilote(Pilote p) {

    }

    public void addCoPilote(Copilote c) {

    }

    public boolean addPNC(Pnc p) {
        return false;
    }
}
