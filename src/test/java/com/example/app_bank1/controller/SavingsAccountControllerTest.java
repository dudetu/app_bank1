package com.example.app_bank1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import com.example.app_bank1.service.SavingsAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class SavingsAccountControllerTest {

    @Mock
    private SavingsAccountService savingsAccountService;

    private SavingsAccountController savingsAccountController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        savingsAccountController = new SavingsAccountController(savingsAccountService);
    }

    @Test
    void getSavingsAccountById_ReturnsSavingsAccount() throws ChangeSetPersister.NotFoundException {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        SavingsAccount savingsAccount = new SavingsAccount();
        when(savingsAccountService.getSavingsAccountById(accountId)).thenReturn(savingsAccount);

        // Act
        ResponseEntity<SavingsAccount> result = savingsAccountController.getSavingsAccountById(accountId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(savingsAccount, result.getBody());
        verify(savingsAccountService, times(1)).getSavingsAccountById(accountId);
    }

    @Test
    void createSavingsAccount_ReturnsCreatedSavingsAccount() {
        // Упорядочить
        // Arrange
        SavingsAccount savingsAccount = new SavingsAccount();
        when(savingsAccountService.createSavingsAccount(savingsAccount)).thenReturn(savingsAccount);

        // Act
        ResponseEntity<SavingsAccount> result = savingsAccountController.createSavingsAccount(savingsAccount);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(savingsAccount, result.getBody());
        verify(savingsAccountService, times(1)).createSavingsAccount(savingsAccount);
    }

    @Test
    void updateSavingsAccount_ReturnsUpdatedSavingsAccount() throws ChangeSetPersister.NotFoundException {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        SavingsAccount savingsAccount = new SavingsAccount();
        when(savingsAccountService.updateSavingsAccount(accountId, savingsAccount)).thenReturn(savingsAccount);
        // Действие
        // Act
        ResponseEntity<SavingsAccount> result = savingsAccountController.updateSavingsAccount(accountId, savingsAccount);
        // Проверить
        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(savingsAccount, result.getBody());
        verify(savingsAccountService, times(1)).updateSavingsAccount(accountId, savingsAccount);
    }

    @Test
    void deleteSavingsAccount_ReturnsNoContent() throws ChangeSetPersister.NotFoundException {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        // Действие
        // Act
        ResponseEntity<Void> result = savingsAccountController.deleteSavingsAccount(accountId);
        // Проверить
        // Assert
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(savingsAccountService, times(1)).deleteSavingsAccount(accountId);
    }
}


