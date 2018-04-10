package com.ctg.flagadmin.exception;

public class NoJWTException extends Exception {
    public NoJWTException() {
        super();
    }

    public NoJWTException(String message) {
        super(message);
    }
}
