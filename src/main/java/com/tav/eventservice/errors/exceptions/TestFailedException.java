package com.tav.eventservice.errors.exceptions;

public class TestFailedException extends Exception {
    public TestFailedException(String testName) {
        super(testName + " failed");
        System.err.println(testName + " failed");
    }
}
