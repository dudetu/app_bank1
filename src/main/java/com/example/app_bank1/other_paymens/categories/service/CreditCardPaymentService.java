package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.payments.CreditCardPayment;
import com.example.app_bank1.other_paymens.categories.entity.payments.PaymentApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardPaymentRepository;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;



/**
 * Сервисный класс для управления платежами по кредитным картам.
 */
@Service
public class CreditCardPaymentService {

    private final CreditCardPaymentRepository creditCardPaymentRepository;

    public CreditCardPaymentService(CreditCardPaymentRepository creditCardPaymentRepository) {
        this.creditCardPaymentRepository = creditCardPaymentRepository;
    }

    /**
     * Получить все платежи по кредитным картам.
     *
     * @return список платежей по кредитным картам
     */
    @Cacheable("creditCardPayments")
    public List<CreditCardPayment> getAllPayments() {
        return creditCardPaymentRepository.findAll();
    }

    /**
     * Обработать платеж по кредитной карте.
     *
     * @param payment информация о платеже
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
     *
     * @param payment информация о платеже
     * @return true, если платеж выполнен успешно, иначе false
     */
    public boolean makePayment(CreditCardPayment payment) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.payment-system.com/payments";
        PaymentApiResponse response = restTemplate.postForObject(apiUrl, payment, PaymentApiResponse.class);
        return response.isSuccessful();
    }

    /**
     * Очистить кеш платежей по кредитным картам.
     * Этот метод должен вызываться после создания/обновления платежа.
     */
    @CacheEvict(value = "creditCardPayments", allEntries = true)
    public void clearCache() {
        // Метод используется для очистки кеша платежей по кредитным картам
    }
}
