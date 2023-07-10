package com.example.app_bank1.other_paymens.categories.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * This class serves as a global exception handler for handling exceptions in the application.
 */
@ControllerAdvice
public class DefaultExceptionHandler {


    /**
     * Обрабатывает указанное исключение и возвращает HTTP-ответ со статусом внутренней ошибки сервера.
     * Handles the specified exception and returns an HTTP response with an internal server error status.
     *
     * Исключение, которое нужно обработать.
     * @param e The exception to handle.
     *
     * Сущность ответа HTTP со статусом внутренней ошибки сервера.
     * @return The HTTP response entity with an internal server error status.
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handle(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

