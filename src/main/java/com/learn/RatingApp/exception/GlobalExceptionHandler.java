package com.learn.RatingApp.exception;

import com.sun.net.httpserver.HttpsServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException exception) {
        Map<String, Object> exceptionDetails = new HashMap<>();
        exceptionDetails.put("Message", exception.getMessage());
        exceptionDetails.put("Success", Boolean.FALSE);
        exceptionDetails.put("Status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("Message", exception.getMessage());
        map.put("Success", Boolean.FALSE);
        map.put("Status", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}