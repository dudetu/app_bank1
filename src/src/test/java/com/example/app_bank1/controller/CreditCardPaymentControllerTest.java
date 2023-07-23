package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.controller.CreditCardPaymentController;
import com.example.app_bank1.other_paymens.categories.entity.CreditCardPayment;
import com.example.app_bank1.other_paymens.categories.service.CreditCardPaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
        // Упорядочить
        // Arrange
        CreditCardPayment[] payments = {new CreditCardPayment(), new CreditCardPayment()};
        ResponseEntity<CreditCardPayment[]> response = new ResponseEntity<>(payments, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(CreditCardPayment[].class))).thenReturn(response);

        // Действие
        // Act
        List<CreditCardPayment> result = creditCardPaymentController.getAllPayments();
        // Проверить
        // Assert
        assertEquals(payments.length, result.size());
        verify(restTemplate, times(1)).getForEntity(anyString(), eq(CreditCardPayment[].class));
    }

    @Test
    void makePayment_ValidPayment_ReturnsSuccessResponse() {
        // Упорядочить
        // Arrange
        CreditCardPayment payment = new CreditCardPayment();
        ResponseEntity<String> response = new ResponseEntity<>("Payment successful", HttpStatus.OK);
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class))).thenReturn(response);

        // Действие
        // Act
        ResponseEntity<String> result = creditCardPaymentController.makePayment(payment);
        // Проверить
        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Credit card payment successful", result.getBody());
        verify(restTemplate, times(1)).postForEntity(anyString(), any(), eq(String.class));
        verify(creditCardPaymentService, times(1)).makePayment(payment);
    }

    @Test
    void makePayment_InvalidPayment_ReturnsErrorResponse() {
        // Упорядочить
        // Arrange
        CreditCardPayment payment = new CreditCardPayment();
        ResponseEntity<String> response = new ResponseEntity<>("Payment failed", HttpStatus.BAD_REQUEST);
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class))).thenReturn(response);

        // Действие
        // Act
        ResponseEntity<String> result = creditCardPaymentController.makePayment(payment);
        // Проверить
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Failed to make credit card payment", result.getBody());
        verify(restTemplate, times(1)).postForEntity(anyString(), any(), eq(String.class));
        verify(creditCardPaymentService, never()).makePayment(payment);
    }
}
