package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.CreditCardPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.app_bank1.other_paymens.categories.service.CreditCardPaymentService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * This class represents a REST controller for handling credit card payments.
 * It provides endpoints for retrieving all payments and making a payment.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/credit-card-payments")
public class CreditCardPaymentController {

    private final CreditCardPaymentService creditCardPaymentService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl; // Actual URL and connection to the API should be added

    /**
     *  Извлекает все платежи по кредитным картам.
     * Retrieves all credit card payments.
     *
     *  Список платежей по кредитным картам.
     * @return The list of credit card payments.
     *
     * Если при получении платежей возникла ошибка.
     * @throws RuntimeException If there is an error fetching the payments.
     */
    @GetMapping("/get-all")
    public List<CreditCardPayment> getAllPayments() {
        // Выполните вызов API платежной системы с помощью RestTemplate
        // Make a call to the payment system API using RestTemplate
        ResponseEntity<CreditCardPayment[]> response = restTemplate.getForEntity(remoteApiUrl + "/credit-card-payments", CreditCardPayment[].class);

        // Проверить статус ответа и предпринять соответствующие действия
        // Check response status and take appropriate action
        if (response.getStatusCode().is2xxSuccessful()) {
            CreditCardPayment[] payments = response.getBody();
            return List.of(payments);
        } else {
            throw new RuntimeException("Failed to fetch credit card payments");
        }
    }

    /**
     * Осуществляет платеж по кредитной карте.
     * Makes a credit card payment.
     *
     * Платежные реквизиты кредитной карты.
     * @param creditCardPayment The credit card payment details.
     *
     * Сущность ответа, указывающая на статус платежа.
     * @return The response entity indicating the status of the payment.
     */
    @PostMapping("/make")
    public ResponseEntity<String> makePayment(@RequestBody CreditCardPayment creditCardPayment) {
        // Выполните вызов API платежной системы с помощью RestTemplate
        // Make a call to the payment system API using RestTemplate
        ResponseEntity<String> response = restTemplate.postForEntity(remoteApiUrl + "/credit-card-payments", creditCardPayment, String.class);

        // Проверить статус ответа и предпринять соответствующие действия
        // Check response status and take appropriate action
        if (response.getStatusCode().is2xxSuccessful()) {
            creditCardPaymentService.makePayment(creditCardPayment);
            return ResponseEntity.ok("Credit card payment successful");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Failed to make credit card payment");
        }
    }
}






