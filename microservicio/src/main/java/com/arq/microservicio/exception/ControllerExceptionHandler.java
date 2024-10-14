package com.arq.microservicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

/**
 * @author : Freddy Torres
 * file :  ControllerExceptionHandler
 * @since : 1/10/2024, mar
 **/

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Message> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        Message message = new Message(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorsMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage().replaceAll("([\n\t])",""));
        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);
        ErrorsMessage message = new ErrorsMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                result,
                request.getDescription(false));
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsMessage> notValid(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));
        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);
        ErrorsMessage message = new ErrorsMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                result,
                request.getDescription(false));
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
