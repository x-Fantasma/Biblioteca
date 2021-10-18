package com.ceiba.biblioteca.domain.exceptions.core;

public class ResException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -8212396375137474687L;

    FailException exception;

    public ResException() {

    }

    public ResException(FailException exception) {
        this.exception = exception;
    }

    public FailException getException() {
        return exception;
    }

    public void setException(FailException exception) {
        this.exception = exception;
    }
}
