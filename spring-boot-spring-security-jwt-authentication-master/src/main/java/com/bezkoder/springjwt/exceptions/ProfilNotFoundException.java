package com.bezkoder.springjwt.exceptions;

public class ProfilNotFoundException extends RuntimeException {
    public ProfilNotFoundException(String message) {
        super(message);
    }
}
