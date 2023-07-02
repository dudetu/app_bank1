package com.example.app_bank1.service;

import com.example.app_bank1.account.PaymentApiResponse;
import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.repository.BankAccountPaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;

class BankAccountPaymentServiceTest {

    @Mock
    private BankAccountPaymentRepository bankAccountPaymentRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BankAccountPaymentService bankAccountPaymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makePayment_ValidPayment_SavesPaymentAndProcessesResponse() {
        // Arrange
        BankAccountPayment payment = new BankAccountPayment();
        Object paymentRequest = null;
        PaymentApiResponse response = new PaymentApiResponse();
        when(restTemplate.postForObject(anyString(), any(), eq(PaymentApiResponse.class))).thenReturn(response);

        // Act
        bankAccountPaymentService.makePayment(payment);

        // Assert
        verify(bankAccountPaymentRepository, times(1)).save(payment);
        verify(restTemplate, times(1)).postForObject(anyString(), eq(paymentRequest), eq(PaymentApiResponse.class));
        // Add assertions for response processing if needed
    }

    @Test
    void makePayment_InvalidPayment_HandlesException() {
        // Arrange
        BankAccountPayment payment = new BankAccountPayment();
        Object paymentRequest = null;
        when(restTemplate.postForObject(anyString(), any(), eq(PaymentApiResponse.class))).thenThrow(new RuntimeException("API error"));

        // Act
        bankAccountPaymentService.makePayment(payment);

        // Assert
        verify(bankAccountPaymentRepository, times(1)).save(payment);
        verify(restTemplate, times(1)).postForObject(anyString(), eq(paymentRequest), eq(PaymentApiResponse.class));
        // Add assertions for exception handling if needed
    }
}