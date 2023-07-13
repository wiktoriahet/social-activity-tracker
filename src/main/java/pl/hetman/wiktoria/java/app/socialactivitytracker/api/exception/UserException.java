package pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception;

public class UserException extends Exception{
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
