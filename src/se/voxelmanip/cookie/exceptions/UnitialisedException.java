package se.voxelmanip.cookie.exceptions;

/**
 * Exception entity for if a necessary initialisation step for a class hasn't been done.
 * This is a runtime exception as it indicates a programming error.
 * @author ROllerozxa
 */
public class UnitialisedException extends RuntimeException {
    /**
     * Constructor method
     * @param message Exception message
     */
    public UnitialisedException(String message) {
        super(message);
    }
}
