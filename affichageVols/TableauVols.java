package affichageVols;

import avion.Avion;
import avion.TypeAvion;
import com.sun.corba.se.impl.encoding.TypeCodeOutputStream;
import exception.DejaExistantException;
import exception.EquipageException;
import exception.InvariantBroken;
import exception.NullException;
import membreEquipe.Copilote;
import membreEquipe.Personne;
import membreEquipe.Pilote;
import membreEquipe.Pnc;
import vol.Vol;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class TableauVols {
    private ArrayList<Aeroport> listeAeroports;
    private final String Pilote = "Pilote";
    private final String Copilote = "Copilote";
    private final String PNC = "PNC";

    public TableauVols(String nom) throws DejaExistantException {
        for (int i = 0; i < listeAeroports.size(); i++) {
            if (listeAeroports.get(i).getNomAeroport() == nom) {
                throw new DejaExistantException("L'aeroport " + nom + " existe deja !");
            }
        }
        Aeroport aeroport = new Aeroport(nom);
        this.listeAeroports.add(aeroport);
    }

    private Aeroport trouverAeroport(String nomAeroport) throws NullException{
        for (int i = 0; i < listeAeroports.size(); i++) {
            if(listeAeroports.get(i).getNomAeroport() == nomAeroport) {
                return listeAeroports.get(i);
            }
        }
        throw new NullException("L'aeroport n'existe pas !");
    }

    private Avion trouverAvion(Aeroport aeroport, String reference) throws NullException{
        for (int i = 0; i < aeroport.getListeAvion().size(); i++) {
            if(aeroport.getListeAvion().get(i).getReference() == reference) {
                return aeroport.getListeAvion().get(i);
            }
        }
        throw new NullException("L'avion n'existe pas !");
    }

    private TypeAvion trouverTypeAvion(Aeroport aeroport, String nomTypeAvion) throws NullException{
        for (int i = 0; i < aeroport.getListeTypeAvion().size(); i++) {
            if(aeroport.getListeTypeAvion().get(i).getNom() == nomTypeAvion) {
                return aeroport.getListeTypeAvion().get(i);
            }
        }
        throw new NullException("Le type d'avion n'existe pas !");
    }

    private Personne trouverPersonne(Aeroport aeroport, String nom, String prenom) throws NullException{
        for (int i = 0; i < aeroport.getListePersonne().size(); i++) {
            if(aeroport.getListePersonne().get(i).getNom() == nom && aeroport.getListePersonne().get(i).getPrenom() == prenom) {
                return aeroport.getListePersonne().get(i);
            }
        }
        throw new NullException("La personne n'existe pas !");
    }

    private Vol trouverVol(Aeroport aeroport, String numVol) throws NullException{
        for (int i = 0; i < aeroport.getListeVols().size(); i++) {
            if(aeroport.getListeTypeAvion().get(i).getNom() == numVol) {
                return aeroport.getListeVols().get(i);
            }
        }
        throw new NullException("Le type d'avion n'existe pas !");
    }

    public void creerPilote(String nom, String prenom, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            aeroport.getListePilote().add(new Pilote(nom, prenom));
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void creerPnc(String nom, String prenom, String nomAeroport){
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            aeroport.getListePNC().add(new Pnc(nom, prenom));
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (NullException n) {
            System.out.println(n.getMessage());
         }
    }

    public void creerCopilote(String nom, String prenom, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            aeroport.getListeCoPilote().add(new Copilote(nom, prenom));
        } catch (InvariantBroken i) {
            System.out.println(i.getMessage());
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void creerAvion(String nom, String nomAeroport, String nomType) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            TypeAvion type = trouverTypeAvion(aeroport, nomType);
            aeroport.getListeAvion().add(new Avion(type, nom));
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void creerTypeAvion (String nom, int min, int max, String  nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            aeroport.getListeTypeAvion().add(new TypeAvion(nom, min, max));
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void creerVol(String num, String site, String dest, String reference, String dep, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            Avion av = trouverAvion(aeroport, reference);
            aeroport.getListeVols().add(new Vol(num, site, dest, av, dep));
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void supprimerAvion(String reference, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            Avion av = trouverAvion(aeroport, reference);
            aeroport.getListeAvion().remove(av);
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void supprimerTypeAvion(String nom, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            TypeAvion typeAvion = trouverTypeAvion(aeroport, nom);
            //supprimer la qualif du type d'avion supprimer a toutes les personnes !!! ( peut etre a faire dans personne)
            aeroport.getListeTypeAvion().remove(typeAvion);
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void supprimerVol(String num, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            Vol vol = trouverVol(aeroport, num);
            aeroport.getListeVols().remove(vol);
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void affecterCopiloteVol(String nom, String prenom, String nomVol, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            Vol vol = trouverVol(aeroport, nomVol);
            Personne personne = trouverPersonne(aeroport, nom, prenom);
            if (Pilote == personne.getFonction()) {
                vol.addPilote((Pilote)personne);
            }
            else if (Copilote == personne.getFonction()) {
                vol.addCoPilote((Copilote)personne);
            }
            else if (PNC == personne.getFonction()) {
                vol.addPNC((Pnc)personne);
            }
        } catch (NullException n) {
            System.out.println(n.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    public void retirerMembreVol(String nom, String prenom, String nomVol, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            Vol vol = trouverVol(aeroport, nomVol);
            Personne personne = trouverPersonne(aeroport, nom, prenom);
            if (Pilote == personne.getFonction()) {
                if (vol.getPilote().getNom() == nom && vol.getPilote().getPrenom()== prenom) {
                    vol.setPilote(null);
                }
            }
            else if (Copilote == personne.getFonction()) {
                if (vol.getCopilote().getNom() == nom && vol.getCopilote().getPrenom()== prenom) {
                    vol.setCopilote(null);
                }
            }
            else if (PNC == personne.getFonction()) {
                vol.setListePnc((Pnc)personne);
            }
        } catch (NullException n) {
            System.out.println(n.getMessage());
        } catch (EquipageException e) {
            System.out.println(e.getMessage());
        }
    }

    public void afficherDonneeVol(String num, String nomAeroport) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            Vol vol = trouverVol(aeroport, num);
            vol.toString();
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }

    public void afficherVolMembreEquipe(String num, String nomAeroport, String nomMembre, String prenomMembre) {
        try {
            Aeroport aeroport = trouverAeroport(nomAeroport);
            Vol vol = trouverVol(aeroport, num);
            Personne membre = trouverPersonne(aeroport, nomMembre, prenomMembre);

            vol.toString();
        } catch (NullException n) {
            System.out.println(n.getMessage());
        }
    }
}
