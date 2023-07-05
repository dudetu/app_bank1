package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import com.example.app_bank1.service.AccountTransferService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(AccountTransferController.class)
public class AccountTransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountTransferService accountTransferService;

    @Test
    public void testGetAllTransfers() throws Exception {
        AccountTransfer transfer1 = new AccountTransfer();
        transfer1.setId(1L);
        transfer1.setUserId(1L);
        transfer1.setAmount(BigDecimal.valueOf(100.00));

        AccountTransfer transfer2 = new AccountTransfer();
        transfer2.setId(2L);
        transfer2.setUserId(2L);
        transfer2.setAmount(BigDecimal.valueOf(200.00));

        List<AccountTransfer> transfers = Arrays.asList(transfer1, transfer2);

        when(accountTransferService.getAllTransfers()).thenReturn(transfers);

        mockMvc.perform(MockMvcRequestBuilders.get("/account-transfers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].amount").value(100.00))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].amount").value(200.00));
    }

    @Test
    public void testMakeTransfer() throws Exception {
        AccountTransfer transfer = new AccountTransfer();
        transfer.setUserId(1L);
        transfer.setAmount(BigDecimal.valueOf(500.00));

        mockMvc.perform(MockMvcRequestBuilders.post("/account-transfers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\": 1, \"amount\": 500.00}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Account transfer successful"));
    }
}
