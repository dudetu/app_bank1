package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.controller.FinePaymentController;
import com.example.app_bank1.other_paymens.categories.entity.payments.FinePayment;
import com.example.app_bank1.other_paymens.categories.service.FinePaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FinePaymentControllerTest {

    @Mock
    private FinePaymentService finePaymentService;

    private FinePaymentController finePaymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        finePaymentController = new FinePaymentController(finePaymentService);
    }

    @Test
    void getAllPayments_ReturnsListOfPayments() {
        // Упорядочить
        // Arrange
        List<FinePayment> payments = new ArrayList<>();
        payments.add(new FinePayment());
        payments.add(new FinePayment());
        when(finePaymentService.getAllPayments()).thenReturn(payments);
        // Действие
        // Act
        List<FinePayment> result = finePaymentController.getAllPayments();
        // Проверить
        // Assert
        assertEquals(payments.size(), result.size());
    }

    @Test
    void makePayment_ReturnsSuccessfulResponse() {
        // Упорядочить
        // Arrange
        FinePayment finePayment = new FinePayment();
        // Действие
        // Act
        ResponseEntity<String> result = finePaymentController.makePayment(finePayment);
        // Проверить
        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Fine payment successful", result.getBody());
    }
}
