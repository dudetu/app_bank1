package com.example.app_bank1.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.app_bank1.other_paymens.categories.controller.BankAccountsController;
import com.example.app_bank1.other_paymens.categories.entity.BankAccounts;
import com.example.app_bank1.other_paymens.categories.service.BankAccountsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BankAccountsControllerTest {

    @Mock
    private BankAccountsService bankAccountsService;

    @InjectMocks
    private BankAccountsController bankAccountsController;

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

        when(bankAccountsService.getAllBankAccounts()).thenReturn(bankAccounts);

        // Act
        ResponseEntity<List<BankAccounts>> response = bankAccountsController.getAllBankAccounts();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bankAccounts, response.getBody());
        verify(bankAccountsService, times(1)).getAllBankAccounts();
    }

    @Test
    void getBankAccountById_ValidId_ShouldReturnBankAccount() {
        // Arrange
        Long id = 1L;
        BankAccounts bankAccount = new BankAccounts();

        when(bankAccountsService.getBankAccountById(id)).thenReturn(bankAccount);

        // Act
        ResponseEntity<BankAccounts> response = bankAccountsController.getBankAccountById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bankAccount, response.getBody());
        verify(bankAccountsService, times(1)).getBankAccountById(id);
    }

    @Test
    void createBankAccount_ValidBankAccount_ShouldReturnCreatedBankAccount() {
        // Arrange
        BankAccounts bankAccount = new BankAccounts();
        BankAccounts createdBankAccount = new BankAccounts();

        when(bankAccountsService.createBankAccount(bankAccount)).thenReturn(createdBankAccount);

        // Act
        ResponseEntity<BankAccounts> response = bankAccountsController.createBankAccount(bankAccount);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdBankAccount, response.getBody());
        verify(bankAccountsService, times(1)).createBankAccount(bankAccount);
    }

    @Test
    void updateBankAccount_ValidIdAndBankAccount_ShouldReturnUpdatedBankAccount() {
        // Arrange
        Long id = 1L;
        BankAccounts bankAccount = new BankAccounts();
        BankAccounts updatedBankAccount = new BankAccounts();

        when(bankAccountsService.updateBankAccount(bankAccount)).thenReturn(updatedBankAccount);

        // Act
        ResponseEntity<BankAccounts> response = bankAccountsController.updateBankAccount(id, bankAccount);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedBankAccount, response.getBody());
        assertEquals(id, updatedBankAccount.getId());
        verify(bankAccountsService, times(1)).updateBankAccount(bankAccount);
    }

    @Test
    void deleteBankAccount_ValidId_ShouldReturnNoContent() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<Void> response = bankAccountsController.deleteBankAccount(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(bankAccountsService, times(1)).deleteBankAccountById(id);
    }

    @Test
    void getBankAccountsForClient_ValidClientId_ShouldReturnListOfBankAccounts() {
        // Arrange
        Long clientId = 1L;
        List<BankAccounts> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccounts());
        bankAccounts.add(new BankAccounts());

        when(bankAccountsService.getBankAccountsForClientAccount(any())).thenReturn(bankAccounts);

        // Act
        ResponseEntity<List<BankAccounts>> response = bankAccountsController.getBankAccountsForClient(clientId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bankAccounts, response.getBody());
        verify(bankAccountsService, times(1)).getBankAccountsForClientAccount(any());
    }
}
