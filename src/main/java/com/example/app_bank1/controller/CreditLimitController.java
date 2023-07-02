package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.entite.CreditLimit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.other_paymens.categories.accumulation.CreditLimitService;

@RestController
@RequestMapping("/credit-limits")
public class CreditLimitController {

    private final CreditLimitService creditLimitService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl = "https://lunar-star-116208.postman.com/api";

    public CreditLimitController(CreditLimitService creditLimitService, RestTemplate restTemplate) {
        this.creditLimitService = creditLimitService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditLimit> getCreditLimit(@PathVariable Long id) {

        // Calling a remote API to get credit limit data by ID
        ResponseEntity<CreditLimit> response = restTemplate.getForEntity(remoteApiUrl + "/credit-limits/" + id, CreditLimit.class);

        // Handling the response from the remote API
        if (response.getStatusCode().is2xxSuccessful()) {
            CreditLimit creditLimit = response.getBody();
            if (creditLimit != null) {

                // Return credit limit data
                return ResponseEntity.ok(creditLimit);
            }
        }

        // Credit limit not found or an error occurred while calling the remote API
        return ResponseEntity.notFound().build();
    }
}



