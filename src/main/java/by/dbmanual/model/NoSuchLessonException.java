package by.dbmanual.model;

public class NoSuchLessonException extends Exception {
    public NoSuchLessonException() {
    }

    public NoSuchLessonException(String message) {
        super(message);
    }

    public NoSuchLessonException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchLessonException(Throwable cause) {
        super(cause);
    }
}
