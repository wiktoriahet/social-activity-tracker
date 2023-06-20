package pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception;

public class ActivityException extends Exception{

    public ActivityException(String message) {
        super(message);
    }

    public ActivityException(String message, Throwable cause) {
        super(message, cause);
    }
}
