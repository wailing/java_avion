package avion;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class Avion {

    private TypeAvion typeAvion;
    private String reference;

    public Avion(TypeAvion type, String ref) {
        this.typeAvion = type;
        this.reference = ref;
    }

    public String getReference() {
        return reference;
    }

    public TypeAvion getType() {
        return typeAvion;
    }

    @Override
    public String toString() {
        String chaine = "\n\n*******************************************";
        chaine += "\nReference de l'avion : " + getReference();
        chaine += getType().toString();
        chaine += "\n\n*******************************************";
        return chaine;
    }
}
