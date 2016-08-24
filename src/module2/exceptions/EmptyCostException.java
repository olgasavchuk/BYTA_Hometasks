package module2.exceptions;

/**
 * The class is used for handling the situation when the cost of the bouquet is empty or negative
 */

public class EmptyCostException extends Exception {
    public EmptyCostException(String message) {
        super(message);
    }
}
