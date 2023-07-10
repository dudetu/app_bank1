package com.example.app_bank1.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import com.example.app_bank1.other_paymens.categories.repository.SavingsAccountRepository;
import com.example.app_bank1.other_paymens.categories.service.SavingsAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

class SavingsAccountServiceTest {

    @Mock
    private SavingsAccountRepository savingsAccountRepository;

    private SavingsAccountService savingsAccountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        savingsAccountService = new SavingsAccountService(savingsAccountRepository);
    }

    @Test
    void getSavingsAccountById_ExistingId_ReturnsSavingsAccount() throws ChangeSetPersister.NotFoundException {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        SavingsAccount expectedAccount = new SavingsAccount();
        when(savingsAccountRepository.findById(accountId)).thenReturn(Optional.of(expectedAccount));

        // Act
        SavingsAccount result = savingsAccountService.getSavingsAccountById(accountId);

        // Assert
        assertEquals(expectedAccount, result);
    }

    @Test
    void getSavingsAccountById_NonExistingId_ThrowsNotFoundException() {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        when(savingsAccountRepository.findById(accountId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ChangeSetPersister.NotFoundException.class, () -> savingsAccountService.getSavingsAccountById(accountId));
    }

    @Test
    void createSavingsAccount_ReturnsSavedSavingsAccount() {
        // Упорядочить
        // Arrange
        SavingsAccount accountToSave = new SavingsAccount();
        SavingsAccount savedAccount = new SavingsAccount();
        when(savingsAccountRepository.save(accountToSave)).thenReturn(savedAccount);

        // Act
        SavingsAccount result = savingsAccountService.createSavingsAccount(accountToSave);

        // Assert
        assertEquals(savedAccount, result);
    }

    @Test
    void updateSavingsAccount_ExistingId_ReturnsUpdatedSavingsAccount() throws ChangeSetPersister.NotFoundException {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        SavingsAccount existingAccount = new SavingsAccount();
        SavingsAccount updatedAccount = new SavingsAccount();
        when(savingsAccountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));
        when(savingsAccountRepository.save(existingAccount)).thenReturn(updatedAccount);
        // Действие
        // Act
        SavingsAccount result = savingsAccountService.updateSavingsAccount(accountId, existingAccount);
        // Проверить
        // Assert
        assertEquals(updatedAccount, result);
    }

    @Test
    void updateSavingsAccount_NonExistingId_ThrowsNotFoundException() {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        SavingsAccount account = new SavingsAccount();
        when(savingsAccountRepository.findById(accountId)).thenReturn(Optional.empty());
         //Действие и проверка
        // Act and Assert
        assertThrows(ChangeSetPersister.NotFoundException.class, () -> savingsAccountService.updateSavingsAccount(accountId, account));
    }

    @Test
    void deleteSavingsAccount_ExistingId_DeletesAccount() throws ChangeSetPersister.NotFoundException {
        // Упорядочить
        // Arrange
        long accountId = 1L;
        SavingsAccount existingAccount = new SavingsAccount();
        when(savingsAccountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));
        // Действие
        // Act
        savingsAccountService.deleteSavingsAccount(accountId);
        // Проверить
        // Assert
        verify(savingsAccountRepository, times(1)).delete(existingAccount);
    }
}
