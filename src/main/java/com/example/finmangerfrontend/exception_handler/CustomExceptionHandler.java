package com.example.finmangerfrontend.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler( HttpClientErrorException.class )
    protected ResponseEntity<?> handleForbiddenConflict( HttpClientErrorException exception ) {
        String message = exception.getMessage();
        return ResponseEntity.status( HttpStatus.FORBIDDEN ).body( message );
    }
}
