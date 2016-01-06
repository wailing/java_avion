package exception;

/**
 * Created by Anaïs Ha and Marieme Ba on 23/12/2015.
 */
public class EquipageException extends Exception{

    /**
     * Crée une nouvelle instance de EquipageExceptions
     */
    public EquipageException() {}
    /**
     * Crée une nouvelle instance de EquipageException
     * @param message Le message détaillant exception
     */
    public EquipageException(String message) {
        super(message);
    }
    /**
     * Crée une nouvelle instance de EquipageException
     * @param cause L'exception à l'origine de cette exception
     */
    public EquipageException(Throwable cause) {
        super(cause);
    }
    /**
     * Crée une nouvelle instance de EquipageException
     * @param message Le message détaillant exception
     * @param cause L'exception à l'origine de cette exception
     */
    public EquipageException(String message, Throwable cause) {
        super(message, cause);
    }
}
