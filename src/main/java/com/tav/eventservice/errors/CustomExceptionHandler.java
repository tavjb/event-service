package com.tav.eventservice.errors;

import com.tav.eventservice.errors.exceptions.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    public ErrorDetailsDto invalidInputExeptionHandling(InvalidInputException e) {
        return new ErrorDetailsDto(e.getMessage());
    }
}
