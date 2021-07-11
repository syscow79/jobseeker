package com.syscow.jobseeker.exception;

import com.syscow.jobseeker.entity.JobError;
import com.syscow.jobseeker.model.JobErrorResponse;
import com.syscow.jobseeker.service.JobErrorResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private final JobErrorResponseService jobErrorResponseService;

    public ControllerExceptionHandler(JobErrorResponseService jobErrorResponseService) {
        this.jobErrorResponseService = jobErrorResponseService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JobErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(fieldName + " :" + errorMessage);
            System.out.println("############ : " + fieldName + " :" + errorMessage);
        });
        return jobErrorResponseService.save(ex, errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public JobErrorResponse handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach((error) -> {
            String fieldName = error.getPropertyPath().toString();
            String errorMessage = error.getMessage();
            errors.add(fieldName + " :" + errorMessage);
        });
        return jobErrorResponseService.save(ex, errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RepositoryException.class)
    public JobErrorResponse handleRepositoryException(RepositoryException ex) {
        return jobErrorResponseService.save(ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RepositoryNotFoundException.class)
    public JobErrorResponse handleRepositoryNotFoundException(RepositoryNotFoundException ex) {
        return jobErrorResponseService.save(ex);
    }
}