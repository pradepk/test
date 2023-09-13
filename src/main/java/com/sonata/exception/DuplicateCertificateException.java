package com.sonata.exception;

public class DuplicateCertificateException extends Exception {
     String message;

    public DuplicateCertificateException(String message) {
        //member variable to store our message
        super(message);
    }

    //overriding with our custom message
    @Override
    public String toString() {
        return message;
    }
}
