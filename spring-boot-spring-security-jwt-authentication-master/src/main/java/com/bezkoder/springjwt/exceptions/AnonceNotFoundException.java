package com.bezkoder.springjwt.exceptions;

public class AnonceNotFoundException extends RuntimeException {
    public AnonceNotFoundException(String message) {
        super(message);
    }
}
