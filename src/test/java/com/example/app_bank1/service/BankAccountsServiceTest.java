package com.example.app_bank1.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.app_bank1.other_paymens.categories.entity.BankAccounts;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountsRepository;
import com.example.app_bank1.other_paymens.categories.service.BankAccountsService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class BankAccountsServiceTest {

    @Mock
    private BankAccountsRepository bankAccountsRepository;

    @InjectMocks
    private BankAccountsService bankAccountsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBankAccounts_ValidInput_ShouldReturnListOfBankAccounts() {
        // Arrange
        List<BankAccounts> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccounts());
        bankAccounts.add(new BankAccounts());

        when(bankAccountsRepository.findAll()).thenReturn(bankAccounts);

        // Act
        List<BankAccounts> result = bankAccountsService.getAllBankAccounts();

        // Assert
        assertEquals(2, result.size());
        verify(bankAccountsRepository, times(1)).findAll();
    }

    @Test
    void getBankAccountById_ValidId_ShouldReturnBankAccount() {
        // Arrange
        Long id = 1L;
        BankAccounts bankAccount = new BankAccounts();
        bankAccount.setId(id);

        when(bankAccountsRepository.findById(id)).thenReturn(Optional.of(bankAccount));

        // Act
        BankAccounts result = bankAccountsService.getBankAccountById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(bankAccountsRepository, times(1)).findById(id);
    }

    @Test
    void getBankAccountById_InvalidId_ShouldThrowEntityNotFoundException() {
        // Arrange
        Long id = 1L;

        when(bankAccountsRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> bankAccountsService.getBankAccountById(id));
        verify(bankAccountsRepository, times(1)).findById(id);
    }

    @Test
    void createBankAccount_ValidBankAccount_ShouldReturnCreatedBankAccount() {
        // Arrange
        BankAccounts bankAccount = new BankAccounts();
        when(bankAccountsRepository.save(bankAccount)).thenReturn(bankAccount);

        // Act
        BankAccounts result = bankAccountsService.createBankAccount(bankAccount);

        // Assert
        assertNotNull(result);
        verify(bankAccountsRepository, times(1)).save(bankAccount);
    }

    @Test
    void updateBankAccount_ValidBankAccount_ShouldReturnUpdatedBankAccount() {
        // Arrange
        Long id = 1L;
        BankAccounts bankAccount = new BankAccounts();
        bankAccount.setId(id);

        when(bankAccountsRepository.existsById(id)).thenReturn(true);
        when(bankAccountsRepository.save(bankAccount)).thenReturn(bankAccount);

        // Act
        BankAccounts result = bankAccountsService.updateBankAccount(bankAccount);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(bankAccountsRepository, times(1)).existsById(id);
        verify(bankAccountsRepository, times(1)).save(bankAccount);
    }

    @Test
    void updateBankAccount_InvalidBankAccount_ShouldThrowEntityNotFoundException() {
        // Arrange
        Long id = 1L;
        BankAccounts bankAccount = new BankAccounts();
        bankAccount.setId(id);

        when(bankAccountsRepository.existsById(id)).thenReturn(false);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> bankAccountsService.updateBankAccount(bankAccount));
        verify(bankAccountsRepository, times(1)).existsById(id);
        verify(bankAccountsRepository, never()).save(bankAccount);
    }

    @Test
    void deleteBankAccountById_ValidId_ShouldDeleteBankAccount() {
        // Arrange
        Long id = 1L;
        when(bankAccountsRepository.existsById(id)).thenReturn(true);

        // Act
        bankAccountsService.deleteBankAccountById(id);

        // Assert
        verify(bankAccountsRepository, times(1)).existsById(id);
        verify(bankAccountsRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteBankAccountById_InvalidId_ShouldThrowEntityNotFoundException() {
        // Arrange
        Long id = 1L;
        when(bankAccountsRepository.existsById(id)).thenReturn(false);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> bankAccountsService.deleteBankAccountById(id));
        verify(bankAccountsRepository, times(1)).existsById(id);
        verify(bankAccountsRepository, never()).deleteById(id);
    }

    @Test
    void getBankAccountsForClientAccount_ValidClientAccount_ShouldReturnListOfBankAccounts() {
        // Arrange
        ClientAccount clientAccount = new ClientAccount();
        List<BankAccounts> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccounts());
        bankAccounts.add(new BankAccounts());

        when(bankAccountsRepository.findByClientAccount(clientAccount)).thenReturn(bankAccounts);

        // Act
        List<BankAccounts> result = bankAccountsService.getBankAccountsForClientAccount(clientAccount);

        // Assert
        assertEquals(2, result.size());
        verify(bankAccountsRepository, times(1)).findByClientAccount(clientAccount);
    }
}
