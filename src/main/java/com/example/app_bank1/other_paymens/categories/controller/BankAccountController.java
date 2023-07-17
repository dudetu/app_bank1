package com.example.app_bank1.other_paymens.categories.controller;


import com.example.app_bank1.other_paymens.categories.entity.Transactions.BankAccount;
import com.example.app_bank1.other_paymens.categories.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        BankAccount createdAccount = bankAccountService.createBankAccount(bankAccount);
        return ResponseEntity.ok(createdAccount);
    }

    // Другие методы для обработки запросов к банковским счетам
}
