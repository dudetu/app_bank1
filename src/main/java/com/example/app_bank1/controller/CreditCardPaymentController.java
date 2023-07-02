package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.app_bank1.service.CreditCardPaymentService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/credit-card-payments")
public class CreditCardPaymentController {

    private final CreditCardPaymentService creditCardPaymentService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl = "https://lunar-star-116208.postman.com/api"; // Замените на фактический URL API

    public CreditCardPaymentController(CreditCardPaymentService creditCardPaymentService, RestTemplate restTemplate) {
        this.creditCardPaymentService = creditCardPaymentService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<CreditCardPayment> getAllPayments() {

         // Make a call to the payment system API using RestTemplate
        ResponseEntity<CreditCardPayment[]> response = restTemplate.getForEntity(remoteApiUrl + "/credit-card-payments", CreditCardPayment[].class);

        // Check response status and take appropriate action
        if (response.getStatusCode().is2xxSuccessful()) {
            CreditCardPayment[] payments = response.getBody();
            return List.of(payments);
        } else {
            throw new RuntimeException("Failed to fetch credit card payments");
        }
    }

    @PostMapping
    public ResponseEntity<String> makePayment(@RequestBody CreditCardPayment creditCardPayment) {

        // Make a call to the payment system API using RestTemplate
        ResponseEntity<String> response = restTemplate.postForEntity(remoteApiUrl + "/credit-card-payments", creditCardPayment, String.class);

        // Check response status and take appropriate action
        if (response.getStatusCode().is2xxSuccessful()) {
            creditCardPaymentService.makePayment(creditCardPayment);
            return ResponseEntity.ok("Credit card payment successful");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Failed to make credit card payment");
        }
    }
}







