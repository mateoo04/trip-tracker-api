package com.mateo.trip_tracker_api.exception;

/**
 * Iznimka koja se baca u slučaju neuspjelog pristupa repozitoriju.
 */
public class RepositoryAccessException extends RuntimeException {
    public RepositoryAccessException() {
    }

    public RepositoryAccessException(String message) {
        super(message);
    }

    public RepositoryAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryAccessException(Throwable cause) {
        super(cause);
    }

    public RepositoryAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
