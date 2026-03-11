package com.Transylvania.Hotel_Transylvania.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler  {

        @ExceptionHandler(OrderNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String handleOrderNotFound(OrderNotFoundException ex) {
            return ex.getMessage();
        }

        @ExceptionHandler(UserNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String handleUserNotFound(UserNotFoundException ex) {
            return ex.getMessage();
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public String handleGeneralException(Exception ex) {
            return "Something went wrong: " + ex.getMessage();
        }

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(RuntimeException ex) {
        log.error("Request failed: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }
    }

