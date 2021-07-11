package com.syscow.jobseeker.exception;

public class RepositoryException extends RuntimeException{

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Exception ex) {
        super(message, ex);
    }
}
