package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardTopUpRepository;
import com.example.app_bank1.other_paymens.categories.service.CreditCardTopUpService;
import com.example.app_bank1.other_paymens.categories.service.PaymentApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreditCardTopUpServiceTest {

    @Mock
    private CreditCardTopUpRepository topUpRepository;

    @Mock
    private PaymentApiService paymentApiService;

    private CreditCardTopUpService topUpService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        topUpService = new CreditCardTopUpService(topUpRepository, paymentApiService);
    }

    @Test
    void getAllTopUps_ShouldReturnAllTopUps() {
        // Упорядочить
        // Arrange
        CreditCardTopUp topUp1 = new CreditCardTopUp();
        CreditCardTopUp topUp2 = new CreditCardTopUp();
        List<CreditCardTopUp> expectedTopUps = Arrays.asList(topUp1, topUp2);

        when(topUpRepository.findAll()).thenReturn(expectedTopUps);
        // Действие
        // Act
        List<CreditCardTopUp> actualTopUps = topUpService.getAllTopUps();
        // Проверить
        // Assert
        assertEquals(expectedTopUps, actualTopUps);
    }

    @Test
    void topUpCreditCard_ShouldTopUpCreditCard() {
        // Упорядочить
        // Arrange
        CreditCardTopUp topUp = new CreditCardTopUp();
        // Действие
        // Act
        topUpService.topUpCreditCard(topUp);


    }
}
