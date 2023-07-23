package com.example.app_bank1.controller;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.app_bank1.other_paymens.categories.controller.ClientAccountController;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.service.ClientAccountService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

public class ClientAccountControllerTest {

    @Mock
    private ClientAccountService clientAccountService;

    @InjectMocks
    private ClientAccountController clientAccountController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientAccountController).build();
    }

    @Test
    public void testGetAllClientAccounts() throws Exception {
        // Arrange
        ClientAccount clientAccount1 = new ClientAccount();
        clientAccount1.setId(1L);
        ClientAccount clientAccount2 = new ClientAccount();
        clientAccount2.setId(2L);
        List<ClientAccount> clientAccounts = Arrays.asList(clientAccount1, clientAccount2);

        when(clientAccountService.getAllClientAccounts()).thenReturn(clientAccounts);

        // Act & Assert
        mockMvc.perform(get("/client-accounts/get-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(clientAccount1.getId()))
                .andExpect(jsonPath("$[1].id").value(clientAccount2.getId()));
    }

    @Test
    public void testGetClientAccountById() throws Exception {
        // Arrange
        Long accountId = 1L;
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(accountId);

        when(clientAccountService.getClientAccountById(accountId)).thenReturn(clientAccount);

        // Act & Assert
        mockMvc.perform(get("/client-accounts/{id}", accountId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(accountId));
    }

    @Test
    public void testGetClientAccountById_NotFound() throws Exception {
        // Arrange
        Long accountId = 1L;

        when(clientAccountService.getClientAccountById(accountId)).thenThrow(EntityNotFoundException.class);

        // Act & Assert
        mockMvc.perform(get("/client-accounts/{id}", accountId))
                .andExpect(status().isNotFound());
    }


}
