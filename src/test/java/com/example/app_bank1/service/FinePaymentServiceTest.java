package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.FinePayment;
import com.example.app_bank1.repository.FinePaymentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class FinePaymentServiceTest {

    @Mock
    private FinePaymentRepository paymentRepository;

    private FinePaymentService paymentService;

    public void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new FinePaymentService(paymentRepository);
    }

    @Test
    void getAllPayments_ShouldReturnAllPayments() {
        // Arrange
        FinePayment payment1 = new FinePayment();
        FinePayment payment2 = new FinePayment();
        List<FinePayment> expectedPayments = Arrays.asList(payment1, payment2);

        when(paymentRepository.findAll()).thenReturn(expectedPayments);

        // Act
        List<FinePayment> actualPayments = paymentService.getAllPayments();

        // Assert
        assertEquals(expectedPayments, actualPayments);
    }

    @Test
    void makeFinePayment_PaymentSuccess_ShouldSavePayment() {
        // Arrange
        FinePayment payment = new FinePayment();
        payment.setAmount(BigDecimal.TEN);

        when(paymentRepository.save(payment)).thenReturn(payment);
        when(paymentService.makePayment(payment.getAmount())).thenReturn(true);

        // Act
        paymentService.makeFinePayment(payment);

        // Assert
        // Add your assertions here
    }

    @Test
    void makeFinePayment_PaymentFailure_ShouldNotSavePayment() {
        // Arrange
        FinePayment payment = new FinePayment();
        payment.setAmount(BigDecimal.TEN);

        when(paymentService.makePayment(payment.getAmount())).thenReturn(false);

        // Act
        paymentService.makeFinePayment(payment);


    }

}