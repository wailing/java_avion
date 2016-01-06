package exception;

/**
 * Created by Ana�s Ha and Marieme Ba on 23/12/2015.
 */
public class EquipageException extends Exception{

    /**
     * Cr�e une nouvelle instance de EquipageExceptions
     */
    public EquipageException() {}
    /**
     * Cr�e une nouvelle instance de EquipageException
     * @param message Le message d�taillant exception
     */
    public EquipageException(String message) {
        super(message);
    }
    /**
     * Cr�e une nouvelle instance de EquipageException
     * @param cause L'exception � l'origine de cette exception
     */
    public EquipageException(Throwable cause) {
        super(cause);
    }
    /**
     * Cr�e une nouvelle instance de EquipageException
     * @param message Le message d�taillant exception
     * @param cause L'exception � l'origine de cette exception
     */
    public EquipageException(String message, Throwable cause) {
        super(message, cause);
    }
}
