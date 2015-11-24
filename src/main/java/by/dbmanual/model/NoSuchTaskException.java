package by.dbmanual.model;

public class NoSuchTaskException extends Exception {
    public NoSuchTaskException() {
    }

    public NoSuchTaskException(String message) {
        super(message);
    }

    public NoSuchTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchTaskException(Throwable cause) {
        super(cause);
    }
}
