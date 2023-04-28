package com.bezkoder.springjwt.exceptions;

public class VehiculeNotFoundException extends RuntimeException {
    public VehiculeNotFoundException(String message) {
        super(message);
    }
}
