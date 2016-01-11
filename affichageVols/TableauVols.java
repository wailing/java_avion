package affichageVols;

import avion.Avion;
import avion.TypeAvion;
import exception.EquipageException;
import exception.InvariantBroken;
import exception.NullException;
import membreEquipe.Copilote;
import membreEquipe.Personne;
import membreEquipe.Pilote;
import membreEquipe.Pnc;
import vol.Vol;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class TableauVols implements Serializable {
     class Aeroport implements Serializable {
        private String nomAeroport;
        private  ArrayList<Personne> listePersonne;
        private  ArrayList<Vol> listeVols;
        private  ArrayList<Avion> listeAvion;
        private  ArrayList<TypeAvion> listeTypeAvion;

        public Aeroport (String nom) {
            this.nomAeroport = nom;
            this.listePersonne = new ArrayList<Personne>();
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

    private Aeroport aeroport;
    private final String Pilote = "Pilote";
    private final String Copilote = "Copilote";
    private final String PNC = "PNC";

    public TableauVols(String nom) {
         aeroport = new Aeroport(nom);
    }

    private Avion trouverAvion(Aeroport aeroport, String reference) throws NullException{
        for (int i = 0; i < aeroport.getListeAvion().size(); i++) {
            if(aeroport.getListeAvion().get(i).getReference().equals(reference)) {
                return aeroport.getListeAvion().get(i);
            }
        }
        throw new NullException("L'avion n'existe pas !");
    }

    private TypeAvion trouverTypeAvion(Aeroport aeroport, String nomTypeAvion) throws NullException{
        for (int i = 0; i < aeroport.getListeTypeAvion().size(); i++) {
            if(aeroport.getListeTypeAvion().get(i).getNom().equals(nomTypeAvion)) {
                return aeroport.getListeTypeAvion().get(i);
            }
        }
        throw new NullException("Le type d'avion n'existe pas !");
    }

    private Personne trouverPersonne(Aeroport aeroport, String nom, String prenom, String fonction) throws NullException{
        for (int i = 0; i < aeroport.getListePersonne().size(); i++) {
            if(aeroport.getListePersonne().get(i).getNom().equals(nom) && aeroport.getListePersonne().get(i).getPrenom().equals(prenom) && aeroport.getListePersonne().get(i).getFonction().equals(fonction)) {
                return aeroport.getListePersonne().get(i);
            }
        }
        throw new NullException("La personne n'existe pas !");
    }

    private Vol trouverVol(Aeroport aeroport, String numVol) throws NullException{
        for (int i = 0; i < aeroport.getListeVols().size(); i++) {
            if(aeroport.getListeVols().get(i).getNumero().equals(numVol)) {
                return aeroport.getListeVols().get(i);
            }
        }
        throw new NullException("Le vol n'existe pas !");
    }

    public void creerPilote(String nom, String prenom) {
        try {
            Pilote pilote = new Pilote(nom, prenom);
            aeroport.getListePersonne().add(pilote);
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        }
    }

    public void creerPnc(String nom, String prenom){
        try {

            Pnc pnc = new Pnc(nom, prenom);
            aeroport.getListePersonne().add(pnc);
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        }
    }

    public void creerCopilote(String nom, String prenom) {
        try {
            Copilote copilote = new Copilote(nom, prenom);
            aeroport.getListePersonne().add(copilote);
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        }
    }

    public void qualifierMembreEquipage(String nom, String prenom, String fonction, String nomType) {
        try {
            TypeAvion type = trouverTypeAvion(aeroport, nomType);
            Personne personne = trouverPersonne(aeroport, nom, prenom, fonction);
            if (fonction.equals(Pilote) && Pilote == personne.getFonction()) {
                personne.addQualification(type);
            }
            else if (fonction.equals(Copilote) && Copilote == personne.getFonction()) {
                personne.addQualification(type);
            }
            else if (fonction.equals(PNC) && PNC == personne.getFonction()) {
                personne.addQualification(type);
            }
        } catch (NullException n) {
            System.out.println(n.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        }
    }

    public void creerAvion(String ref, String nomType) {
        try {
            TypeAvion type = trouverTypeAvion(aeroport, nomType);
            aeroport.getListeAvion().add(new Avion(type, ref));
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void creerTypeAvion (String nom, int min, int max) {
        aeroport.getListeTypeAvion().add(new TypeAvion(nom, min, max));
    }

    public void creerTypeAvion (String nom) {
        aeroport.getListeTypeAvion().add(new TypeAvion(nom));
    }

    public void creerVol(String num, String site, String dest, String reference, String dep) {
        try {
            Avion av = trouverAvion(aeroport, reference);
            aeroport.getListeVols().add(new Vol(num, site, dest, av, dep));
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void supprimerAvion(String reference) {
        try {
            Avion av = trouverAvion(aeroport, reference);
            for(int i = 0; i < getListeVols().size(); i++) {
                if(getListeVols().get(i).getAvion().equals(av)) {
                    getListeVols().get(i).setAvion(null);
                }
            }
            aeroport.getListeAvion().remove(av);

        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void supprimerTypeAvion(String nom) {
        try {
            TypeAvion typeAvion = trouverTypeAvion(aeroport, nom);
            //supprimer la qualif du type d'avion supprimer a toutes les personnes !!! ( peut etre a faire dans personne)
            typeAvion.purgeQualifies();
            aeroport.getListeTypeAvion().remove(typeAvion);
        } catch (NullException n) {
            System.out.println(n.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        }
    }

    public void supprimerVol(String num) {
        try {
            Vol vol = trouverVol(aeroport, num);
            aeroport.getListeVols().remove(vol);
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void affecterMembreVol(String nom, String prenom, String fonction, String nomVol) {
        try {
            Vol vol = trouverVol(aeroport, nomVol);
            Personne personne = trouverPersonne(aeroport, nom, prenom, fonction);
            if (fonction.equals(Pilote) && Pilote == personne.getFonction()) {
                vol.addPilote((Pilote)personne);
            }
            else if (fonction.equals(Copilote) && Copilote == personne.getFonction()) {
                vol.addCoPilote((Copilote)personne);
            }
            else if (fonction.equals(PNC) && PNC == personne.getFonction()) {
                vol.addPNC((Pnc)personne);
            }
        } catch (NullException n) {
            System.out.println(n.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }


    public void retirerMembreVol(String nom, String prenom, String fonction, String nomVol) {
        try {
            Vol vol = trouverVol(aeroport, nomVol);
            Personne personne = trouverPersonne(aeroport, nom, prenom,fonction);
            if (fonction.equals(Pilote) && Pilote.equals(personne.getFonction())) {
                if (vol.getEquipage().getPilote().getNom() == nom && vol.getEquipage().getPilote().getPrenom()== prenom) {
                    vol.getEquipage().setPilote(null);
                }
            }
            else if (fonction.equals(Copilote) && Copilote == personne.getFonction()) {
                if (vol.getEquipage().getCopilote().getNom() == nom && vol.getEquipage().getCopilote().getPrenom()== prenom) {
                    vol.getEquipage().setCopilote(null);
                }
            }
            else if (fonction.equals(PNC) && PNC == personne.getFonction()) {
                vol.setListePnc((Pnc)personne);
            }
        } catch (NullException n) {
            System.out.println(n.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    public void afficherDonneeVol(String num) {
        try {
            Vol vol = trouverVol(aeroport, num);
            System.out.println(vol.toString());
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void afficherVolMembreEquipe(String nomMembre, String prenomMembre, String fonction, String num) {
     //a
        try {
            System.out.println("\n\n*****************AFFICHAGE VOL D'UN MEMBRE ***************\n\n ");
            Vol vol = trouverVol(aeroport, num);
            Personne membre = trouverPersonne(aeroport, nomMembre, prenomMembre, fonction);
            for (int i = 0; i < getListeVols().size(); i++) {
                if (fonction.equals(Pilote) && Pilote.equals(membre.getFonction())) {
                    if (vol.getEquipage().getPilote().getNom() == nomMembre && vol.getEquipage().getPilote().getPrenom()== prenomMembre) {
                        System.out.println(getListeVols().get(i).toString());
                    }
                }
                else if (fonction.equals(Copilote) && Copilote == membre.getFonction()) {
                    if (vol.getEquipage().getCopilote().getNom() == nomMembre && vol.getEquipage().getCopilote().getPrenom()== prenomMembre) {
                        System.out.println(getListeVols().get(i).toString());
                    }
                }
                else if (fonction.equals(PNC) && PNC == membre.getFonction()) {
                    System.out.println(getListeVols().get(i).toString());
                }
            }
            System.out.println("\n\n*****************AFFICHAGE VOL D'UN MEMBRE ***************\n\n");
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public String getNomAeroport() {
        return aeroport.getNomAeroport();
    }

    public ArrayList<Personne> getListePersonne() {
        return aeroport.getListePersonne();
    }

    public ArrayList<Vol> getListeVols() {
        return aeroport.getListeVols();
    }

    public ArrayList<Avion> getListeAvion() {
        return aeroport.getListeAvion();
    }

    public ArrayList<TypeAvion> getListeTypeAvion() {
        return aeroport.getListeTypeAvion();
    }

    public String toString() {
        String chaine = "LISTE DES AEROPORTS \n\n";
        chaine += "NOM : " + this.getNomAeroport() +"\n";
        if (getListePersonne().size() == 0) {
        chaine += "\n\nIl n'y a personne dans l'aeroport";
        }
        else {
            for (int i = 0; i < getListePersonne().size(); i++) {
                chaine += "\n"+ getListePersonne().get(i).toString();
            }
        }
        if (getListeAvion().size() == 0) {
            chaine += "\n\nIl n'y a pas d'avion dans l'aeroport";
        }
        else {
            for (int i = 0; i < getListeAvion().size(); i++) {
                chaine += "\n" + getListeAvion().get(i).toString();
            }
        }
        if (getListeTypeAvion().size() == 0) {
            chaine += "\n\nIl n'y a pas de type d'avion dans l'aeroport";
        }
        else {
            for (int i = 0; i < getListeTypeAvion().size(); i++) {
                chaine += "\n" + getListeTypeAvion().get(i).toString();
            }
        }
        if (getListeVols().size() == 0) {
            chaine += "\n\nIl n'y a pas de type d'avion dans l'aeroport";
        }
        else {
            for (int i = 0; i < getListeVols().size(); i++) {
                chaine += "\n" + getListeVols().get(i).toString();
            }
        }
        chaine += "\n\n*****************************************************";
        return chaine;
    }
}
