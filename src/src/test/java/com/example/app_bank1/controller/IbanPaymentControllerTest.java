package com.example.app_bank1.controller;


import com.example.app_bank1.other_paymens.categories.controller.IbanPaymentController;
import com.example.app_bank1.other_paymens.categories.entity.payments.IbanPayment;
import com.example.app_bank1.other_paymens.categories.service.IbanPaymentService;
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

class IbanPaymentControllerTest {

    @Mock
    private IbanPaymentService ibanPaymentService;

    private IbanPaymentController ibanPaymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ibanPaymentController = new IbanPaymentController(ibanPaymentService);
    }

    @Test
    void getAllPayments_ReturnsListOfPayments() {
        // Упорядочить
        // Arrange
        List<IbanPayment> payments = new ArrayList<>();
        payments.add(new IbanPayment());
        payments.add(new IbanPayment());
        when(ibanPaymentService.getAllPayments()).thenReturn(payments);
         //Действие
        // Act
        List<IbanPayment> result = ibanPaymentController.getAllPayments();
        // Проверить
        // Assert
        assertEquals(payments.size(), result.size());
    }

    @Test
    void processPayment_ReturnsSuccessfulResponse() {
        // Упорядочить
        // Arrange
        IbanPayment payment = new IbanPayment();
        // Действие
        // Act
        ResponseEntity<String> result = ibanPaymentController.processPayment(payment);
        // Проверить
        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Платеж успешно обработан", result.getBody());
    }

    @Test
    void getPaymentById_ReturnsPayment() {
        // Упорядочить
        // Arrange
        Long paymentId = 1L;
        IbanPayment payment = new IbanPayment();
        payment.setId(paymentId);
        when(ibanPaymentService.getPaymentById(paymentId)).thenReturn(payment);
        // Действие
        // Act
        ResponseEntity<IbanPayment> result = ibanPaymentController.getPaymentById(paymentId);
        // Проверить
        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(payment, result.getBody());
    }
}
