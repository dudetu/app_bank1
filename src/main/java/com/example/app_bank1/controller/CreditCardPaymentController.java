package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.app_bank1.service.CreditCardPaymentService;

import java.util.List;

@RestController
    @RequestMapping("/credit-card-payments")
    public class CreditCardPaymentController {

        private final CreditCardPaymentService creditCardPaymentService;

        public CreditCardPaymentController(CreditCardPaymentService creditCardPaymentService) {
            this.creditCardPaymentService = creditCardPaymentService;
        }

        @GetMapping
        public List<CreditCardPayment> getAllPayments() {
            return creditCardPaymentService.getAllPayments();
        }

        @PostMapping
        public ResponseEntity<String> makePayment(@RequestBody CreditCardPayment creditCardPayment) {
            creditCardPaymentService.makePayment(creditCardPayment);
            return ResponseEntity.ok("Credit card payment successful");
        }

        // Другие методы для обработки пополнения счета кредитной карты
    }






