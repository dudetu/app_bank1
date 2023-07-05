
package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.FinePayment;
import com.example.app_bank1.service.FinePaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fine-payments")
public class FinePaymentController {

    private final FinePaymentService finePaymentService;

    public FinePaymentController(FinePaymentService finePaymentService) {
        this.finePaymentService = finePaymentService;
    }

    @GetMapping
    public List<FinePayment> getAllPayments() {
        return finePaymentService.getAllPayments();
    }

    @PostMapping
    public ResponseEntity<String> makePayment(@RequestBody FinePayment finePayment) {
        finePaymentService.makeFinePayment(finePayment);
        // Дополнительная логика после оплаты
        // Выполнение действий в зависимости от статуса платежа

        // Additional logic after payment
        // Perform actions based on the payment status
        if (finePayment.isSuccessful()) {
            // Платеж прошел успешно
            // Выполнение действий при успешном платеже

            // Payment successful
            // Perform actions for successful payment
            return ResponseEntity.ok("Fine payment successful");
        } else {
            // Платеж прошел успешно
            // Выполнение действий при успешном платеже

            // Payment was successful
            // Actions on successful payment
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fine payment failed");
        }
    }


}



