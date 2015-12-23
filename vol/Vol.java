package vol;

import avion.Avion;
import equipage.Equipage;
import membreEquipe.Copilote;
import membreEquipe.Pilote;
import membreEquipe.Pnc;

import java.util.Date;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Vol {

    private String numero;
    private String site;
    private String destination;
    private Date dateDepart;
    private Equipage equipage;
    private Avion avion;

    public Vol(String num, String site, String dest, Avion av, Date dep) {
        this.numero = num;
        this.site = site;
        this.destination = dest;
        this.avion = av;
        this.dateDepart = dep;
    }

    public Vol(String num, Date dep) {
        this.numero = num;
        this.dateDepart = dep;
    }

    public void addPilote(Pilote p) {

    }

    public void addCoPilote(Copilote c) {

    }

    public boolean addPNC(Pnc p) {
        return false;
    }

    public boolean equipageAuComplet() {
        return false;
    }
}
