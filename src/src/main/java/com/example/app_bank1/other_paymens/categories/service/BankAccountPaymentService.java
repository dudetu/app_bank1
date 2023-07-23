package com.example.app_bank1.other_paymens.categories.service;
import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import com.example.app_bank1.account.PaymentApiResponse;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountPaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Сервисный класс для управления платежами по банковским счетам.
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
     *
     * @return список платежей по банковским счетам
     */
    @Cacheable("bankAccountPayments")
    public List<BankAccountPayment> getAllPayments() {
        return bankAccountPaymentRepository.findAll();
    }

    /**
     * Выполнить платеж по банковскому счету.
     * Сохранить информацию о платеже в базе данных и отправить запрос к API платежной системы.
     *
     * @param bankAccountPayment информация о платеже
     */
    @CacheEvict(value = "bankAccountPayments", allEntries = true)
    public void makePayment(BankAccountPayment bankAccountPayment) {
        bankAccountPaymentRepository.save(bankAccountPayment);

        String apiUrl = "https://api.payment-system.com/payments";

        try {
            Object paymentRequest = createPaymentRequest(bankAccountPayment); // Инициализация и заполнение объекта paymentRequest
            PaymentApiResponse response = restTemplate.postForObject(apiUrl, paymentRequest, PaymentApiResponse.class);
            // При необходимости обработайте ответ от API платежной системы
            // Process the response from the payment system API if needed

        } catch (Exception e) {
            // Обработка исключения при вызове API платежной системы
            logger.error("Произошла ошибка при выполнении платежа через API платежной системы: " + e.getMessage());
        }
    }

    private Object createPaymentRequest(BankAccountPayment bankAccountPayment) {
        // Логика создания объекта paymentRequest на основе информации о платеже
        // ...

        return null; // Возвращаем созданный объект paymentRequest
    }
}





