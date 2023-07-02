package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.UtilityBill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.service.UtilityBillService;

import java.util.List;

@RestController
@RequestMapping("/utility-bills")
public class UtilityBillController {

    private final UtilityBillService utilityBillService;
    private RestTemplate restTemplate;
    private final String remoteApiUrl = "https://lunar-star-116208.postman.com/api";

    public UtilityBillController(UtilityBillService utilityBillService) {
        this.utilityBillService = utilityBillService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<UtilityBill> getAllBills() {

        // Calling a remote API to get a list of accounts
        ResponseEntity<List> response = restTemplate.getForEntity(remoteApiUrl + "/utility-bills", List.class);
        // Handling the response from the remote API

        if (response.getStatusCode().is2xxSuccessful()) {
            List<UtilityBill> bills = response.getBody();
            return bills;
        }
        // Error when getting list of accounts via remote API

        throw new RuntimeException("Failed to retrieve utility bills from remote API");
    }

    @PostMapping
    public ResponseEntity<String> createBill(@RequestBody UtilityBill utilityBill) {
        // Calling a remote API to create an account

        ResponseEntity<String> response = restTemplate.postForEntity(remoteApiUrl + "/utility-bills", utilityBill, String.class);
        // Handling the response from the remote API

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Utility bill created successfully");
        }

        // Error when creating invoice via remote API

        throw new RuntimeException("Failed to create utility bill through remote API");
    }
}



