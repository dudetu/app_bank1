package com.example.app_bank1.controller;



import com.example.app_bank1.other_paymens.categories.IbanPayment;
import com.example.app_bank1.service.IbanPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iban-payments")
public class IbanPaymentController {

    private final IbanPaymentService ibanPaymentService;

    public IbanPaymentController(IbanPaymentService ibanPaymentService) {
        this.ibanPaymentService = ibanPaymentService;
    }

    @GetMapping
    public List<IbanPayment> getAllPayments() {
        return ibanPaymentService.getAllPayments();
        //Метод getAllPayments обрабатывает GET-запрос по пути "/iban-payments" и возвращает список всех платежей.
        //The getAllPayments method processes a GET request to the path "/iban-payments" and returns a list of all payments.

    }

    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody IbanPayment payment) {
        ibanPaymentService.processPayment(payment);
        return ResponseEntity.ok("Платеж успешно обработан");
        //Метод processPayment обрабатывает POST-запрос по пути
        // "/iban-payments" и принимает объект IbanPayment в теле запроса. Он вызывает метод processPayment в IbanPaymentService для обработки платежа.

        //The processPayment method processes the POST-request by the path
        //"/iban-payments" and accepts an IbanPayment object in the body of the request. It calls processPayment method in IbanPaymentService to process the payment.
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<IbanPayment> getPaymentById(@PathVariable Long paymentId) {
        IbanPayment payment = ibanPaymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(payment);
        //Метод getPaymentById обрабатывает GET-запрос по пути "/iban-payments/{paymentId}",
        // где paymentId является переменной пути.
        // Он вызывает метод getPaymentById в IbanPaymentService для получения платежа по его идентификатору.

        //The getPaymentById method processes a GET request to the path "/iban-payments/{paymentId}",
        //where paymentId is a path variable.
        // It calls getPaymentById method in IbanPaymentService to retrieve payment by its identifier.
    }
}

