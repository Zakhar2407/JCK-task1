package com.innowise.arrays.exception;

public class CustomArrayException extends Exception {
    // Constructor without fields
    public CustomArrayException() {
        super();
    }

    // Constructor that accepts an error message
    public CustomArrayException(String message) {
        super(message);
    }

    // Constructor that accepts an error message and the root cause exception
    public CustomArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts only the root cause exception
    public CustomArrayException(Throwable cause) {
        super(cause);
    }
}
