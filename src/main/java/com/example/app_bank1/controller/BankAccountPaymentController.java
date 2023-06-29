package com.example.app_bank1.controller;


import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.service.BankAccountPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/bank-account-payments")
    public class BankAccountPaymentController {

        private final BankAccountPaymentService bankAccountPaymentService;

        public BankAccountPaymentController(BankAccountPaymentService bankAccountPaymentService) {
            this.bankAccountPaymentService = bankAccountPaymentService;
        }

        @GetMapping
        public List<BankAccountPayment> getAllPayments() {
            return bankAccountPaymentService.getAllPayments();
        }

        @PostMapping
        public ResponseEntity<String> makePayment(@RequestBody BankAccountPayment bankAccountPayment) {
            bankAccountPaymentService.makePayment(bankAccountPayment);
            return ResponseEntity.ok("Bank account payment successful");
        }

        // Другие методы для обработки пополнения банковского счета
    }



