package com.tav.eventservice.errors.exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(Constraint constraint) {
        super(constraint.getErrorMsg());
    }
}
