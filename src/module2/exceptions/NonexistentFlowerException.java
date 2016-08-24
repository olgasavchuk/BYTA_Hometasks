package module2.exceptions;

/**
 * The class is used for handling the situation when the user tries to add flower which is out of the scope
 */

public class NonexistentFlowerException extends Exception {

    public NonexistentFlowerException(String message) {
        super(message);
    }
}
