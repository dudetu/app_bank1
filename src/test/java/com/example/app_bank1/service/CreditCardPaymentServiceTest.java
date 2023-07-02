package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import com.example.app_bank1.repository.CreditCardPaymentRepository;
import com.example.app_bank1.service.CreditCardPaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreditCardPaymentServiceTest {

    @Mock
    private CreditCardPaymentRepository paymentRepository;

    private CreditCardPaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new CreditCardPaymentService(paymentRepository);
    }

    @Test
    void processPayment_WhenPaymentSuccessful_SavePayment() {
        // Arrange
        CreditCardPayment payment = new CreditCardPayment();
        when(paymentRepository.save(any())).thenReturn(payment);
        when(paymentService.makePayment(any())).thenReturn(true);

        // Act
        paymentService.processPayment(payment);

        // Assert
        assertTrue(payment.isSuccessful());
    }

    @Test
    void processPayment_WhenPaymentFailed_DoNotSavePayment() {
        // Arrange
        CreditCardPayment payment = new CreditCardPayment();
        when(paymentService.makePayment(any())).thenReturn(false);

        // Act
        paymentService.processPayment(payment);

        // Assert
        assertFalse(payment.isSuccessful());
    }
}
