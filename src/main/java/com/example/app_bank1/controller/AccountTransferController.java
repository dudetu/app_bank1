package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import com.example.app_bank1.service.AccountTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/account-transfers")
public class AccountTransferController {

    private final AccountTransferService accountTransferService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl = "https://lunar-star-116208.postman.com/api";

    public AccountTransferController(AccountTransferService accountTransferService, RestTemplate restTemplate) {
        this.accountTransferService = accountTransferService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<AccountTransfer> getAllTransfers() {
        return accountTransferService.getAllTransfers();
    }

    @PostMapping
    public ResponseEntity<String> makeTransfer(@RequestBody AccountTransfer accountTransfer) {

       // Make a call to the payment system API using RestTemplate

        ResponseEntity<String> response = restTemplate.postForEntity(remoteApiUrl + "/transfers", accountTransfer, String.class);


        // Check response status and take appropriate action

        if (response.getStatusCode().is2xxSuccessful()) {
            accountTransferService.makeTransfer(accountTransfer);
            return ResponseEntity.ok("Account transfer successful");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Failed to make account transfer");
        }
    }
}
