package affichageVols;

import avion.Avion;
import avion.TypeAvion;
import membreEquipe.Copilote;
import membreEquipe.Personne;
import membreEquipe.Pilote;
import membreEquipe.Pnc;
import vol.Vol;

import java.util.ArrayList;

/**
 * Created by anais on 06/01/2016.
 */
public class Aeroport {
    private String nomAeroport;
    private ArrayList<Personne> listePersonne;
    private ArrayList<Pilote> listePilote;
    private ArrayList<Pnc> listePNC;
    private ArrayList<Copilote> listeCoPilote;
    private ArrayList<Vol> listeVols;
    private ArrayList<Avion> listeAvion;
    private ArrayList<TypeAvion> listeTypeAvion;

    public Aeroport (String nom) {
        this.nomAeroport = nom;
        this.listePersonne = new ArrayList<Personne>();
        this.listePilote = new ArrayList<Pilote>();
        this.listeCoPilote = new ArrayList<Copilote>();
        this.listePNC = new ArrayList<Pnc>();
        this.listeVols = new ArrayList<Vol>();
        this.listeAvion = new ArrayList<Avion>();
        this.listeTypeAvion = new ArrayList<TypeAvion>();
    }

    public String getNomAeroport() {
        return nomAeroport;
    }

    public ArrayList<Personne> getListePersonne() {
        return listePersonne;
    }

    public ArrayList<Pilote> getListePilote() {
        return listePilote;
    }

    public ArrayList<Pnc> getListePNC() {
        return listePNC;
    }

    public ArrayList<Copilote> getListeCoPilote() {
        return listeCoPilote;
    }

    public ArrayList<Vol> getListeVols() {
        return listeVols;
    }

    public ArrayList<Avion> getListeAvion() {
        return listeAvion;
    }

    public ArrayList<TypeAvion> getListeTypeAvion() {
        return listeTypeAvion;
    }
}
