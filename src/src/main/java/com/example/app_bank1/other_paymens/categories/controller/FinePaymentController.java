
package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.payments.FinePayment;
import com.example.app_bank1.other_paymens.categories.service.FinePaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This controller handles fine payment operations.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/fine-payments")
public class FinePaymentController {

    private final FinePaymentService finePaymentService;

    /**
     * Извлекает все штрафные платежи.
     * Retrieves all fine payments.
     *
     * Список штрафных платежей.
     * @return The list of fine payments.
     */
    @GetMapping(value = "/get-all")
    public List<FinePayment> getAllPayments() {
        return finePaymentService.getAllPayments();

    }

    /**
     * Производит оплату штрафа.
     * Makes a fine payment.
     *
     *  Мелкие платежные реквизиты.
     * @param finePayment The fine payment details.
     *
     * Сущность ответа HTTP, указывающая на результат платежа.
     * @return The HTTP response entity indicating the result of the payment.
     */
    @PostMapping(value = "/make")
    public ResponseEntity<String> makePayment(@RequestBody FinePayment finePayment) {
        finePaymentService.makeFinePayment(finePayment);

        // Дополнительная логика после оплаты
        // Выполнение действий в зависимости от статуса платежа

        // Additional logic after payment
        // Perform actions based on the payment status
        if (finePayment.isSuccessful()) {

            // Платеж прошел успешно
            // Payment successful

            return ResponseEntity.ok("Fine payment successful");
        } else {
            // Платеж не прошел
            // Payment failed

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fine payment failed");
        }
    }
}






