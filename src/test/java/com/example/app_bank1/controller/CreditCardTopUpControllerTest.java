package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.controller.CreditCardTopUpController;
import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import com.example.app_bank1.other_paymens.categories.service.CreditCardTopUpService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreditCardTopUpControllerTest {

    @Mock
    private CreditCardTopUpService creditCardTopUpService;

    @InjectMocks
    private CreditCardTopUpController creditCardTopUpController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTopUps_ReturnsListOfTopUps() {
        // Упорядочить
        // Arrange
        List<CreditCardTopUp> topUps = new ArrayList<>();
        topUps.add(new CreditCardTopUp());
        topUps.add(new CreditCardTopUp());
        when(creditCardTopUpService.getAllTopUps()).thenReturn(topUps);

        // Действие
        // Act
        List<CreditCardTopUp> result = creditCardTopUpController.getAllTopUps();
        // Проверить
        // Assert
        assertEquals(topUps.size(), result.size());
    }

    @Test
    void topUpCreditCard_ReturnsOkResponse() {
        // Упорядочить
        // Arrange
        CreditCardTopUp creditCardTopUp = new CreditCardTopUp();

        // Действие
        // Act
        ResponseEntity<String> response = creditCardTopUpController.topUpCreditCard(creditCardTopUp);
        // Проверить
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Credit card top-up successful", response.getBody());
        verify(creditCardTopUpService, times(1)).topUpCreditCard(creditCardTopUp);
    }
}
