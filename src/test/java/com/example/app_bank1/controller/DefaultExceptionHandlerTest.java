package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.controller.DefaultExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultExceptionHandlerTest {

    @Test
    void handle_Exception_ReturnsInternalServerErrorResponse() {
        // Упорядочить
        // Arrange
        DefaultExceptionHandler exceptionHandler = new DefaultExceptionHandler();
        Exception exception = new Exception();

        // Действие
        // Act
        ResponseEntity result = exceptionHandler.handle(exception);
        // Проверить
        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}
