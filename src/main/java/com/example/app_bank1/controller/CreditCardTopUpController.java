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

    public CreditCardTopUpController(CreditCardTopUpService creditCardTopUpService, RestTemplate restTemplate) {
        this.creditCardTopUpService = creditCardTopUpService;
        this.restTemplate = restTemplate; //должны использовать RestTemplate или другой подходящий инструмент для этого вызова API.
    }

    @GetMapping
    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpService.getAllTopUps();
    }

    @PostMapping
    public ResponseEntity<String> topUpCreditCard(@RequestBody CreditCardTopUp creditCardTopUp) {
        // Вызов удаленного API для осуществления платежа с использованием предоставленных данных
        // Calling a remote API to make a payment using the provided data

        // Здесь можно использовать restTemplate для вызова удаленного API
        // Here you can use restTemplate to call the remote API

        // Ваш код для вызова удаленного API
        // Your code to call the remote API

        // Пример кода, как можно обновить сервис пополнения кредитной карты
        // Example code on how you can update the credit card top-up service
        creditCardTopUpService.topUpCreditCard(creditCardTopUp);

        // Возвращение ответа в зависимости от результата пополнения кредитной карты
        // Returning a response based on the result of the credit card top-up

        // Пример ответа в случае успешного пополнения
        // Example response in case of successful top-up
        return ResponseEntity.ok("Credit card top-up successful");


    }
}
