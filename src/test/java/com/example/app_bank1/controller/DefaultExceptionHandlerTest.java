package com.example.app_bank1.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultExceptionHandlerTest {

    @Test
    void handle_Exception_ReturnsInternalServerErrorResponse() {
        // Arrange
        DefaultExceptionHandler exceptionHandler = new DefaultExceptionHandler();
        Exception exception = new Exception();

        // Act
        ResponseEntity result = exceptionHandler.handle(exception);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}
