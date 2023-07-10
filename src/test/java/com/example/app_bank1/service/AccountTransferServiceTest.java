package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.entity.AccountTransfer;
import com.example.app_bank1.exception.TransferException;
import com.example.app_bank1.other_paymens.categories.repository.AccountTransferRepository;
import com.example.app_bank1.other_paymens.categories.service.AccountTransferService;
import com.example.app_bank1.other_paymens.categories.service.PaymentSystemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountTransferServiceTest {

    private AccountTransferService accountTransferService;

    @Mock
    private AccountTransferRepository accountTransferRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        accountTransferService = new AccountTransferService(accountTransferRepository);
    }

    @Test
    public void testGetAllTransfers() {
        // Упорядочить
        // Arrange
        List<AccountTransfer> expectedTransfers = new ArrayList<>();
        when(accountTransferRepository.findAll()).thenReturn(expectedTransfers);
        //Действие
        // Act
        List<AccountTransfer> actualTransfers = accountTransferService.getAllTransfers();
        // Проверить
        // Assert
        assertEquals(expectedTransfers, actualTransfers);
        verify(accountTransferRepository, times(1)).findAll();
    }

    @Test
    public void testMakeTransfer() {
        // Упорядочить
        // Arrange
        AccountTransfer transfer = new AccountTransfer();
        //Действие
        // Act
        accountTransferService.makeTransfer(transfer);
        // Проверить
        // Assert
        verify(accountTransferRepository, times(1)).save(transfer);
    }

    @Test
    public void testExecuteTransfer_SuccessfulTransfer() throws TransferException {
        // Упорядочить
        // Arrange
        String sourceAccount = "sourceAccount";
        String destinationAccount = "destinationAccount";
        BigDecimal amount = BigDecimal.valueOf(100);
        boolean transferSuccessful = true;
        AccountTransfer savedTransfer = new AccountTransfer();
        when(accountTransferRepository.save(any(AccountTransfer.class))).thenReturn(savedTransfer);
        PaymentSystemService paymentSystemService = mock(PaymentSystemService.class);
        accountTransferService.setPaymentSystemService(paymentSystemService);
        when(paymentSystemService.transferFunds(sourceAccount, destinationAccount, amount)).thenReturn(transferSuccessful);
          //Действие
        // Act
        assertDoesNotThrow(() -> accountTransferService.executeTransfer(sourceAccount, destinationAccount, amount));
        // Проверить
        // Assert
        verify(paymentSystemService, times(1)).transferFunds(sourceAccount, destinationAccount, amount);
        verify(accountTransferRepository, times(1)).save(any(AccountTransfer.class));
    }

    @Test
    public void testExecuteTransfer_FailedTransfer() throws TransferException {
        // Упорядочить
        // Arrange
        String sourceAccount = "sourceAccount";
        String destinationAccount = "destinationAccount";
        BigDecimal amount = BigDecimal.valueOf(100);
        boolean transferSuccessful = false;
        PaymentSystemService paymentSystemService = mock(PaymentSystemService.class);
        accountTransferService.setPaymentSystemService(paymentSystemService);
        when(paymentSystemService.transferFunds(sourceAccount, destinationAccount, amount)).thenReturn(transferSuccessful);
        // Действие и Проверить
        // Act & Assert
        assertThrows(TransferException.class, () -> accountTransferService.executeTransfer(sourceAccount, destinationAccount, amount));
        verify(paymentSystemService, times(1)).transferFunds(sourceAccount, destinationAccount, amount);
        verify(accountTransferRepository, never()).save(any(AccountTransfer.class));
    }

    @Test
    public void testReceiveTransfer() {
       //Упорядочить
        // Arrange
        String sourceAccount = "sourceAccount";
        String destinationAccount = "destinationAccount";
        BigDecimal amount = BigDecimal.valueOf(100);
        AccountTransfer savedTransfer = new AccountTransfer();
        when(accountTransferRepository.save(any(AccountTransfer.class))).thenReturn(savedTransfer);

    }}