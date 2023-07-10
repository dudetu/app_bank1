package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.payments.PaymentApiResponse;
import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountPaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *
 *
 */
@Service
public class BankAccountPaymentService {

    private final BankAccountPaymentRepository bankAccountPaymentRepository;
    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(BankAccountPaymentService.class);

    public BankAccountPaymentService(BankAccountPaymentRepository bankAccountPaymentRepository, RestTemplate restTemplate) {
        this.bankAccountPaymentRepository = bankAccountPaymentRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * Получить все платежи по банковским счетам.
     * Get all payments made through bank accounts.
     *
     * @return список платежей по банковским счетам
     * a list of payments made through bank accounts
     */
    public List<BankAccountPayment> getAllPayments() {
        return bankAccountPaymentRepository.findAll();
    }

    /**
     * Выполнить платеж по банковскому счету.
     * Execute a payment through a bank account.
     * Сохранить информацию о платеже в базе данных и отправить запрос к API платежной системы.
     * Save the payment information in the database and send a request to the payment system API.
     *
     * @param bankAccountPayment информация о платеже
     *                           the payment information
     */
    public void makePayment(BankAccountPayment bankAccountPayment) {
        bankAccountPaymentRepository.save(bankAccountPayment);

        String apiUrl = "https://api.payment-system.com/payments";

        try {
            Object paymentRequest = null; // Здесь должна быть инициализация и заполнение объекта paymentRequest
            PaymentApiResponse response = restTemplate.postForObject(apiUrl, paymentRequest, PaymentApiResponse.class);
            // При необходимости обработайте ответ от API платежной системы
            // Process the response from the payment system API if needed

        } catch (Exception e) {
            // Обработка исключения при вызове API платежной системы
            // Exception handling when API of the payment system is called
            logger.error("Произошла ошибка при выполнении платежа через API платежной системы: " + e.getMessage());
        }
    }
}
    


