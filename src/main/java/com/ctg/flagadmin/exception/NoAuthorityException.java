package com.ctg.flagadmin.exception;

public class NoAuthorityException extends Exception{
    public NoAuthorityException() {
        super();
    }

    public NoAuthorityException(String message) {
        super(message);
    }
}
