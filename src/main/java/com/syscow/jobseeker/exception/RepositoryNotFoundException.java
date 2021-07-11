package com.syscow.jobseeker.exception;

public class RepositoryNotFoundException extends RuntimeException{

    public RepositoryNotFoundException(String message) {
        super(message);
    }

    public RepositoryNotFoundException(String message, Exception ex) {
        super(message, ex);
    }
}
