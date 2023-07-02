package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import com.example.app_bank1.service.CreditCardPaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreditCardPaymentControllerTest {

    @Mock
    private CreditCardPaymentService creditCardPaymentService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CreditCardPaymentController creditCardPaymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPayments_ReturnsListOfPayments() {
        // Arrange
        CreditCardPayment[] payments = {new CreditCardPayment(), new CreditCardPayment()};
        ResponseEntity<CreditCardPayment[]> response = new ResponseEntity<>(payments, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(CreditCardPayment[].class))).thenReturn(response);

        // Act
        List<CreditCardPayment> result = creditCardPaymentController.getAllPayments();

        // Assert
        assertEquals(payments.length, result.size());
    }

    @Test
    void makePayment_ValidPayment_ReturnsSuccessResponse() {
        // Arrange
        CreditCardPayment payment = new CreditCardPayment();
        ResponseEntity<String> response = new ResponseEntity<>("Payment successful", HttpStatus.OK);
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class))).thenReturn(response);

        // Act
        ResponseEntity<String> result = creditCardPaymentController.makePayment(payment);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Credit card payment successful", result.getBody());
    }

    @Test
    void makePayment_InvalidPayment_ReturnsErrorResponse() {
        // Arrange
        CreditCardPayment payment = new CreditCardPayment();
        ResponseEntity<String> response = new ResponseEntity<>("Payment failed", HttpStatus.BAD_REQUEST);
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class))).thenReturn(response);

        // Act
        ResponseEntity<String> result = creditCardPaymentController.makePayment(payment);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Failed to make credit card payment", result.getBody());
    }
}
