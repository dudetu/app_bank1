package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.service.CreditCardTopUpService;

import java.util.List;

@RestController
@RequestMapping("/credit-card-top-ups")
public class CreditCardTopUpController {

    private final CreditCardTopUpService creditCardTopUpService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl = "https://lunar-star-116208.postman.com/api";

    public CreditCardTopUpController(CreditCardTopUpService creditCardTopUpService, RestTemplate restTemplate) {
        this.creditCardTopUpService = creditCardTopUpService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpService.getAllTopUps();
    }

    @PostMapping
    public ResponseEntity<String> topUpCreditCard(@RequestBody CreditCardTopUp creditCardTopUp) {

        // Calling a remote API to make a payment using the provided data
        ResponseEntity<String> response = restTemplate.postForEntity(remoteApiUrl + "/credit-card-top-ups", creditCardTopUp, String.class);

        // Handling the response from the remote API
        if (response.getStatusCode().is2xxSuccessful()) {

            // Payment completed successfully
            return ResponseEntity.ok("Credit card top-up successful");
        } else {

            // Handling an error when making a payment
            return ResponseEntity.status(response.getStatusCode()).body("Credit card top-up failed");
        }
    }
}
