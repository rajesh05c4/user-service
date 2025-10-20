package org.example.userservice.exception;

public class DuplicateAccountTypeException extends RuntimeException {
    public DuplicateAccountTypeException(String message) {
        super(message);
    }
}
