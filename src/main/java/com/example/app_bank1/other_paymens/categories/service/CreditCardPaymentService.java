package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.payments.CreditCardPayment;
import com.example.app_bank1.other_paymens.categories.entity.payments.PaymentApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardPaymentRepository;

import java.util.List;

/**
 *
 *
 */
@Service
public class CreditCardPaymentService {

    private final CreditCardPaymentRepository creditCardPaymentRepository;

    public CreditCardPaymentService(CreditCardPaymentRepository creditCardPaymentRepository) {
        this.creditCardPaymentRepository = creditCardPaymentRepository;
    }

    /**
     * Получить все платежи по кредитным картам.
     * Get all payments made through credit cards.
     *
     * @return список платежей по кредитным картам
     * a list of payments made through credit cards
     */
    public List<CreditCardPayment> getAllPayments() {
        return creditCardPaymentRepository.findAll();
    }

    /**
     * Обработать платеж по кредитной карте.
     * Process a payment through a credit card.
     * Вызывает API платежной системы для выполнения платежа.
     * Saves the payment information in the database.
     *
     * @param payment информация о платеже
     *                the payment information
     */
    public void processPayment(CreditCardPayment payment) {
        boolean paymentSuccessful = makePayment(payment);

        if (paymentSuccessful) {
            creditCardPaymentRepository.save(payment);
            System.out.println("Payment successfully processed!");
        } else {
            System.out.println("Payment failed!");
        }
    }

    /**
     * Выполнить платеж по кредитной карте.
     * Make a payment through a credit card.
     *
     * @param payment информация о платеже
     *                the payment information
     * @return true, если платеж выполнен успешно, иначе false
     * true if the payment was executed successfully, otherwise false
     */
    public boolean makePayment(CreditCardPayment payment) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.payment-system.com/payments";
        PaymentApiResponse response = restTemplate.postForObject(apiUrl, payment, PaymentApiResponse.class);
        return response.isSuccessful();
    }
}