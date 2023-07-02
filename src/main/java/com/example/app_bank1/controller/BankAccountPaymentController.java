package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.service.BankAccountPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bank-account-payments")
public class BankAccountPaymentController {

    private final BankAccountPaymentService bankAccountPaymentService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl = "https://lunar-star-116208.postman.com/api"; // Замените на фактический URL API

    @GetMapping
    public List<BankAccountPayment> getAllPayments() {

       // Make a call to the payment system API using RestTemplate
        ResponseEntity<BankAccountPayment[]> response = restTemplate.getForEntity(remoteApiUrl + "/payments", BankAccountPayment[].class);

        // Check response status and take appropriate action
        if (response.getStatusCode().is2xxSuccessful()) {
            BankAccountPayment[] payments = response.getBody();
            return List.of(payments);
        } else {
            throw new RuntimeException("Failed to fetch bank account payments");
        }
    }

    @PostMapping
    public ResponseEntity<String> makePayment(@RequestBody BankAccountPayment bankAccountPayment) {

          // Make a call to the payment system API using RestTemplate

        ResponseEntity<String> response = restTemplate.postForEntity(remoteApiUrl + "/payments", bankAccountPayment, String.class);

        // Check response status and take appropriate action
        if (response.getStatusCode().is2xxSuccessful()) {
            bankAccountPaymentService.makePayment(bankAccountPayment);
            return ResponseEntity.ok("Bank account payment successful");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Failed to make bank account payment");
        }
    }
}




