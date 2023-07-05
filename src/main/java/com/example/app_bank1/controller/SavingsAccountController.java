package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.app_bank1.service.SavingsAccountService;

@RestController
@RequestMapping("/savings-accounts")
public class SavingsAccountController {

    private final SavingsAccountService savingsAccountService;

    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    @GetMapping("/{id}")
    // Получение счета по идентификатору
    // Get an account by its ID
    public ResponseEntity<SavingsAccount> getSavingsAccountById(@PathVariable Long id)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount savingsAccount = savingsAccountService.getSavingsAccountById(id);
        return ResponseEntity.ok(savingsAccount);
    }

    @PostMapping
    // Создание нового счета
    // Create a new account
    public ResponseEntity<SavingsAccount> createSavingsAccount(@RequestBody SavingsAccount savingsAccount) {
        SavingsAccount createdAccount = savingsAccountService.createSavingsAccount(savingsAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @PutMapping("/{id}")
    // Обновление счета по идентификатору
    // Update an account by its ID
    public ResponseEntity<SavingsAccount> updateSavingsAccount(@PathVariable Long id, @RequestBody SavingsAccount savingsAccount)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount updatedAccount = savingsAccountService.updateSavingsAccount(id, savingsAccount);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    // Удаление счета по идентификатору
    // Delete an account by its ID
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Long id)
            throws ChangeSetPersister.NotFoundException {
        savingsAccountService.deleteSavingsAccount(id);
        return ResponseEntity.noContent().build();
    }

}