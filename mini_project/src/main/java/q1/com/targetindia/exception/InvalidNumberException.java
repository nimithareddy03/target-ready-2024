package com.targetindia.exception;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException() {
    }

    public InvalidNumberException(String message) {
        super(message);
    }

    public InvalidNumberException(Throwable cause) {
        super(cause);
    }
}