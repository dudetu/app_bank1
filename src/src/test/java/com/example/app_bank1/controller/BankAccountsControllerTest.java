package com.example.app_bank1.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.app_bank1.other_paymens.categories.controller.BankAccountController;
import com.example.app_bank1.other_paymens.categories.entity.BankAccount;
import com.example.app_bank1.other_paymens.categories.service.BankAccountServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(BankAccountController.class)
class BankAccountControllerTest {

    @MockBean
    private BankAccountServiceTest bankAccountService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBankAccounts_ValidInput_ShouldReturnListOfBankAccounts() throws Exception {
        // Arrange
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount());
        bankAccounts.add(new BankAccount());

        when(bankAccountService.getAllBankAccounts()).thenReturn(bankAccounts);

        // Act
        mockMvc.perform(get("/bank-account/get-all"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.length()").value(bankAccounts.size()));
    }

    @Test
    void getBankAccountById_ValidId_ShouldReturnBankAccount() throws Exception {
        // Arrange
        Long id = 1L;
        BankAccount bankAccount = new BankAccount();

        when(bankAccountService.getBankAccountById(id)).thenReturn(bankAccount);

        // Act
        mockMvc.perform(get("/bank-account/{id}", id))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value(id));
    }


}
