package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.IbanPayment;
import com.example.app_bank1.repository.IbanPaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class IbanPaymentServiceTest {

    @Mock
    private IbanPaymentRepository paymentRepository;

    private IbanPaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new IbanPaymentService(paymentRepository);
    }

    @Test
    void getAllPayments_ShouldReturnAllPayments() {
        // Arrange
        IbanPayment payment1 = new IbanPayment();
        IbanPayment payment2 = new IbanPayment();
        List<IbanPayment> expectedPayments = Arrays.asList(payment1, payment2);

        when(paymentRepository.findAll()).thenReturn(expectedPayments);

        // Act
        List<IbanPayment> actualPayments = paymentService.getAllPayments();

        // Assert
        assertEquals(expectedPayments, actualPayments);
    }

    @Test
    void processPayment_ShouldSavePayment() {
        // Arrange
        IbanPayment payment = new IbanPayment();

        when(paymentRepository.save(payment)).thenReturn(payment);

        // Act
        paymentService.processPayment(payment);

        // Assert
        // Add your assertions here
    }

    @Test
    void getPaymentById_ExistingPaymentId_ShouldReturnPayment() {
        // Arrange
        Long paymentId = 1L;
        IbanPayment expectedPayment = new IbanPayment();
        expectedPayment.setId(paymentId);

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(expectedPayment));

        // Act
        IbanPayment actualPayment = paymentService.getPaymentById(paymentId);

        // Assert
        assertEquals(expectedPayment, actualPayment);
    }

    @Test
    void getPaymentById_NonExistingPaymentId_ShouldThrowException() {
        // Arrange
        Long paymentId = 1L;

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        // Act & Assert
        // Add your assertions here for the expected exception when the payment is not found
    }

}
