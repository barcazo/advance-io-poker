package io.advance.brian.fivecarddraw.exception;

/**
 * Exception Handling
 */
public class InvalidHandException extends RuntimeException {

    public InvalidHandException(String message) {
        super(message);
    }

    public InvalidHandException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidHandException(Throwable cause) {
        super(cause);
    }

    public InvalidHandException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
