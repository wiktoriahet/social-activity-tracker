package pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception;

public class MissingLabelActivityException extends ActivityException{

    public MissingLabelActivityException(String message) {
        super(message);
    }

    public MissingLabelActivityException(String message, Throwable cause) {
        super(message, cause);
    }
}
