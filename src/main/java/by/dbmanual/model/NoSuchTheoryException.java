package by.dbmanual.model;

public class NoSuchTheoryException extends Exception {
    public NoSuchTheoryException() {
    }

    public NoSuchTheoryException(String message) {
        super(message);
    }

    public NoSuchTheoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchTheoryException(Throwable cause) {
        super(cause);
    }
}
