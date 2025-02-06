package com.mateo.trip_tracker_api.exception;

/**
 * Iznimka koja se baca u slučaju neuspjelog pristupa repozitoriju.
 */
public class DatabaseFetchingException extends RuntimeException {
    public DatabaseFetchingException() {
    }

    public DatabaseFetchingException(String message) {
        super(message);
    }

    public DatabaseFetchingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseFetchingException(Throwable cause) {
        super(cause);
    }

    public DatabaseFetchingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
