package com.example.app_bank1.controller;

import com.example.app_bank1.controller.AccountTransferController;
import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import com.example.app_bank1.service.AccountTransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccountTransferControllerTest {

    @Mock
    private AccountTransferService accountTransferService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AccountTransferController accountTransferController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTransfers_ReturnsListOfTransfers() {
        // Arrange
        List<AccountTransfer> transfers = new ArrayList<>();
        transfers.add(new AccountTransfer());
        transfers.add(new AccountTransfer());
        when(accountTransferService.getAllTransfers()).thenReturn(transfers);

        // Act
        List<AccountTransfer> result = accountTransferController.getAllTransfers();

        // Assert
        assertEquals(transfers.size(), result.size());
    }

    @Test
    void makeTransfer_ValidTransfer_ReturnsSuccessResponse() {
        // Arrange
        AccountTransfer transfer = new AccountTransfer();
        ResponseEntity<String> response = new ResponseEntity<>("Transfer successful", HttpStatus.OK);
        when(restTemplate.postForEntity(anyString(), any(AccountTransfer.class), eq(String.class))).thenReturn(response);

        // Act
        ResponseEntity<String> result = accountTransferController.makeTransfer(transfer);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Account transfer successful", result.getBody());
        verify(accountTransferService, times(1)).makeTransfer(transfer);
    }

    @Test
    void makeTransfer_InvalidTransfer_ReturnsErrorResponse() {
        // Arrange
        AccountTransfer transfer = new AccountTransfer();
        ResponseEntity<String> response = new ResponseEntity<>("Transfer failed", HttpStatus.BAD_REQUEST);
        when(restTemplate.postForEntity(anyString(), any(AccountTransfer.class), eq(String.class))).thenReturn(response);

        // Act
        ResponseEntity<String> result = accountTransferController.makeTransfer(transfer);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Failed to make account transfer", result.getBody());
        verify(accountTransferService, never()).makeTransfer(transfer);
    }
}
