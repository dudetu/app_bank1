package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import com.example.app_bank1.other_paymens.categories.service.BankAccountPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * This class represents a REST controller for handling bank account payments.
 * It provides endpoints for retrieving all payments and making a payment.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/bank-account-payments")
public class BankAccountPaymentController {

    private final BankAccountPaymentService bankAccountPaymentService;
    private final RestTemplate restTemplate;

    /**
     * Получает все платежи по банковским счетам
     * Retrieves all bank account payments.
     *
     *Список платежей по банковскому счету.
     * @return The list of bank account payments.
     *
     *Если при получении платежей возникла ошибка.
     * @throws RuntimeException If there is an error fetching the payments.
     */
    @GetMapping("/get-all")
    public List<BankAccountPayment> getAllPayments() {
        String apiUrl = "https://api.payment-system.com/payments";
        // Проверьте, что учетные записи отправителя и получателя не совпадают.
        // Check that the sender's account and the recipient's account are not the same

        ResponseEntity<BankAccountPayment[]> response = restTemplate.getForEntity(apiUrl, BankAccountPayment[].class);
        // Обрабатываем ответ и возвращаем результат
        // Process the response and return the result

        if (response.getStatusCode().is2xxSuccessful()) {
            BankAccountPayment[] payments = response.getBody();
            return List.of(payments);
        } else {
            throw new RuntimeException("Failed to fetch bank account payments");
        }
    }

    /**
     * Осуществляет платеж по банковскому счету.
     * Makes a bank account payment.
     *
     * Платежные реквизиты банковского счета.
     * @param bankAccountPayment The bank account payment details.
     *
     * Сущность ответа, указывающая на статус платежа.
     * @return The response entity indicating the status of the payment.
     */
    @PostMapping("/make-payment")
    public ResponseEntity<String> makePayment(@RequestBody BankAccountPayment bankAccountPayment) {
        String apiUrl = "https://api.payment-system.com/payments";

        /**
         * Выполните POST-вызов к API платежной системы
         * Make a POST call to the payment system API
         */
        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, bankAccountPayment, String.class);

        /**
         *  Обработать ответ и вернуть соответствующий результат
         * Process the response and return the corresponding result
         */
        if (response.getStatusCode().is2xxSuccessful()) {
            bankAccountPaymentService.makePayment(bankAccountPayment);
            return ResponseEntity.ok("Bank account payment successful");
        } else {
            ResponseEntity<String> body = ResponseEntity.status(response.getStatusCode()).body("Failed to make bank account payment");
            return body;
        }
    }
}



