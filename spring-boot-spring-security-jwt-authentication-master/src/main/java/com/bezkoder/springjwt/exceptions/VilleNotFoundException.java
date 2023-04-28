package com.bezkoder.springjwt.exceptions;

public class VilleNotFoundException extends RuntimeException {
    public VilleNotFoundException(String message) {
        super(message);
    }
}