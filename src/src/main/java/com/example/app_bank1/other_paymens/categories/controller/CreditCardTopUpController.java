package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.other_paymens.categories.service.CreditCardTopUpService;

import java.util.List;


/**
 * This class represents a REST controller for handling credit card top-ups.
 * It provides endpoints for retrieving all top-ups and performing a top-up.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/credit-card-top-ups")
public class CreditCardTopUpController {

    private final CreditCardTopUpService creditCardTopUpService;
    private final RestTemplate restTemplate;


    /**
     * Получает все пополнения кредитных карт.
     * Retrieves all credit card top-ups.
     *
     *  Список пополнений кредитной карты.
     * @return The list of credit card top-ups.
     */
    @GetMapping("/get-all")
    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpService.getAllTopUps();
    }


    /**
     *  Выполняет пополнение счета кредитной карты.
     * Performs a top-up on a credit card.
     *
     * Данные о пополнении кредитной карты.
     * @param creditCardTopUp The credit card top-up details.
     *
     * Сущность ответа, указывающая на статус пополнения счета.
     * @return The response entity indicating the status of the top-up.
     */
    @PostMapping("/top-up")
    public ResponseEntity<String> topUpCreditCard(@RequestBody CreditCardTopUp creditCardTopUp) {
        // Вызов удаленного API для осуществления платежа с использованием предоставленных данных
        // Здесь вы можете использовать restTemplate для вызова удаленного API
        // Ваш код для вызова удаленного API


        // Calling a remote API to make a payment using the provided data
        // Here you can use restTemplate to call the remote API
        // Your code to call the remote API


        creditCardTopUpService.topUpCreditCard(creditCardTopUp);
        // Возвращение ответа, основанного на результате пополнения счета кредитной карты
        // Returning a response based on the result of the credit card top-up

        return ResponseEntity.ok("Credit card top-up successful");
    }
}

