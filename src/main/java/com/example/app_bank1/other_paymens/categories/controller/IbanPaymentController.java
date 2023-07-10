package com.example.app_bank1.other_paymens.categories.controller;



import com.example.app_bank1.other_paymens.categories.entity.payments.IbanPayment;
import com.example.app_bank1.other_paymens.categories.service.IbanPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This controller handles IBAN payment operations.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/iban-payments")
public class IbanPaymentController {

    private final IbanPaymentService ibanPaymentService;


    /**
     * Извлекает все платежи в формате IBAN.
     * Retrieves all IBAN payments.
     *
     * Список платежей IBAN.
     * @return The list of IBAN payments.
     */
    @GetMapping(value = "/get-all")
    public List<IbanPayment> getAllPayments() {
        return ibanPaymentService.getAllPayments();
    }


    /**
     * Обрабатывает платеж IBAN.
     * Processes an IBAN payment.
     *
     * Платежные реквизиты IBAN.
     * @param payment The IBAN payment details.
     *
     * Сущность HTTP-ответа, указывающая на результат платежа.
     * @return The HTTP response entity indicating the result of the payment.
     */
    @PostMapping(value = "/process")
    public ResponseEntity<String> processPayment(@RequestBody IbanPayment payment) {
        ibanPaymentService.processPayment(payment);
        return ResponseEntity.ok("Платеж успешно обработан");
    }

    /**
     * Извлекает платеж IBAN по его идентификатору.
     * Retrieves an IBAN payment by its ID.
     *
     * Идентификатор платежа IBAN.
     * @param paymentId The ID of the IBAN payment.
     *
     * Сущность HTTP-ответа, содержащая платеж IBAN.
     * @return The HTTP response entity containing the IBAN payment.
     */
    @GetMapping("/{paymentId}")
    public ResponseEntity<IbanPayment> getPaymentById(@PathVariable Long paymentId) {
        IbanPayment payment = ibanPaymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(payment);
    }
}


