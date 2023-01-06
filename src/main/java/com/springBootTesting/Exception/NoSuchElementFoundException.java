package com.springBootTesting.Exception;

public class NoSuchElementFoundException extends RuntimeException {
    public NoSuchElementFoundException() {
        super();
    }

    public NoSuchElementFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchElementFoundException(String message) {
        super(message);
    }

    public NoSuchElementFoundException(Throwable cause) {
        super(cause);
    } 
}