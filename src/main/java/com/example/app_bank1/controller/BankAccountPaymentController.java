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

    @GetMapping
    public List<BankAccountPayment> getAllPayments() {
        String apiUrl = "https://api.payment-system.com/payments";

        // Проверьте, что учетные записи отправителя и получателя не совпадают.
        // Check that the sender's account and the recipient's account are not the same

        ResponseEntity<BankAccountPayment[]> response = restTemplate.getForEntity(apiUrl, BankAccountPayment[].class);

        // Обработать ответ и вернуть результат
        // Process the answer and return the result

        if (response.getStatusCode().is2xxSuccessful()) {
            BankAccountPayment[] payments = response.getBody();
            return List.of(payments);
        } else {
            throw new RuntimeException("Failed to fetch bank account payments");
        }
    }

    @PostMapping
    public ResponseEntity<String> makePayment(@RequestBody BankAccountPayment bankAccountPayment) {
        String apiUrl = "https://api.payment-system.com/payments";

        // Выполнить вызов POST к API платежной системы
        // Make a POST call to the payment system API
        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, bankAccountPayment, String.class);

        // Обработать ответ и вернуть соответствующий результат
        // Process the answer and return the corresponding result

        if (response.getStatusCode().is2xxSuccessful()) {
            bankAccountPaymentService.makePayment(bankAccountPayment);
            return ResponseEntity.ok("Bank account payment successful");
        } else {
            ResponseEntity<String> body = ResponseEntity.status(response.getStatusCode()).body("Failed to make bank account payment");
            return body;
        }


    }}



