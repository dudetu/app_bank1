package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import com.example.app_bank1.repository.CreditCardTopUpRepository;
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

    public void setUp() {
        MockitoAnnotations.openMocks(this);
        topUpService = new CreditCardTopUpService(topUpRepository, paymentApiService);
    }

    @Test
    void getAllTopUps_ShouldReturnAllTopUps() {
        // Arrange
        CreditCardTopUp topUp1 = new CreditCardTopUp();
        CreditCardTopUp topUp2 = new CreditCardTopUp();
        List<CreditCardTopUp> expectedTopUps = Arrays.asList(topUp1, topUp2);

        when(topUpRepository.findAll()).thenReturn(expectedTopUps);

        // Act
        List<CreditCardTopUp> actualTopUps = topUpService.getAllTopUps();

        // Assert
        assertEquals(expectedTopUps, actualTopUps);
    }

    @Test
    void topUpCreditCard_ShouldTopUpCreditCard() {
        // Arrange
        CreditCardTopUp topUp = new CreditCardTopUp();

        // Act
        topUpService.topUpCreditCard(topUp);


    }
}
