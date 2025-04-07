package com.juancuero.input.rest.exception;

import com.juancuero.exception.ErrorResponseCustom;
import com.juancuero.exception.ResourceAlreadyExistsException;
import com.juancuero.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseCustom> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponseCustom errorResponseCustom = new ErrorResponseCustom(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseCustom);
    }
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseCustom> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        ErrorResponseCustom errorResponseCustom = new ErrorResponseCustom(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseCustom);
    }
}
