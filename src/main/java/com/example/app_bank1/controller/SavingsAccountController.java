package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.service.SavingsAccountService;

@RestController
@RequestMapping("/savings-accounts")
public class SavingsAccountController {

    private final SavingsAccountService savingsAccountService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl = "https://lunar-star-116208.postman.com/api";

    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsAccount> getSavingsAccountById(@PathVariable Long id)
            throws ChangeSetPersister.NotFoundException {

        // Calling a remote API to get savings account data by ID
        ResponseEntity<SavingsAccount> response = restTemplate.getForEntity(remoteApiUrl + "/savings-accounts/" + id, SavingsAccount.class);

        // Handling the response from the remote API
        if (response.getStatusCode().is2xxSuccessful()) {
            SavingsAccount savingsAccount = response.getBody();
            if (savingsAccount != null) {

                // Return savings account data
                return ResponseEntity.ok(savingsAccount);
            }
        }

        // Savings account not found or an error occurred while calling the remote API
        throw new ChangeSetPersister.NotFoundException();
    }

    @PostMapping
    public ResponseEntity<SavingsAccount> createSavingsAccount(@RequestBody SavingsAccount savingsAccount) {

        // Calling a remote API to create a savings account
        ResponseEntity<SavingsAccount> response = restTemplate.postForEntity(remoteApiUrl + "/savings-accounts", savingsAccount, SavingsAccount.class);

        // Handling the response from the remote API
        if (response.getStatusCode().is2xxSuccessful()) {
            SavingsAccount createdAccount = response.getBody();
            if (createdAccount != null) {

                // Return the created savings account
                return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
            }
        }

        // Error when creating savings account via remote API
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsAccount> updateSavingsAccount(@PathVariable Long id, @RequestBody SavingsAccount savingsAccount)
            throws ChangeSetPersister.NotFoundException {

        // Call remote API to update savings account
        restTemplate.put(remoteApiUrl + "/savings-accounts/" + id, savingsAccount);

        // Get updated savings account data
        SavingsAccount updatedAccount = savingsAccountService.getSavingsAccountById(id);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Long id)
            throws ChangeSetPersister.NotFoundException {

        // Call remote API for remote
        return null;
    }
}