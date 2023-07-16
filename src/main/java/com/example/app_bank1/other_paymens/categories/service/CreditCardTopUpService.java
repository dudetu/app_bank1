package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardTopUpRepository;

import java.util.List;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


/**
 * Сервисный класс для управления пополнением кредитных карт.
 */
@Service
@RequiredArgsConstructor
public class CreditCardTopUpService {

    private final CreditCardTopUpRepository creditCardTopUpRepository;
    private final PaymentApiService paymentApiService;

    /**
     * Получить все операции пополнения кредитных карт.
     *
     * @return список операций пополнения кредитных карт
     */
    @Cacheable("creditCardTopUps")
    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpRepository.findAll();
    }

    /**
     * Пополнить кредитную карту.
     *
     * @param creditCardTopUp информация о пополнении кредитной карты
     */
    public void topUpCreditCard(CreditCardTopUp creditCardTopUp) {
        boolean topUpSuccessful = paymentApiService.makeTopUp(creditCardTopUp);

        if (topUpSuccessful) {
            creditCardTopUpRepository.save(creditCardTopUp);
            System.out.println("Credit card top-up successful.");
            sendNotification(creditCardTopUp);
        } else {
            System.out.println("Credit card top-up failed.");
        }
    }

    /**
     * Отправить уведомление пользователю о пополнении кредитной карты.
     *
     * @param creditCardTopUp информация о пополнении кредитной карты
     */
    private void sendNotification(CreditCardTopUp creditCardTopUp) {
        // Логика отправки уведомления пользователю
        // Например, отправка email, SMS и т.д.
        System.out.println("Notification sent to user: " + creditCardTopUp.getUserEmail());
    }

    /**
     * Очистить кеш операций пополнения кредитных карт.
     * Вызывается после создания/обновления операции.
     */
    @CacheEvict(value = "creditCardTopUps", allEntries = true)
    public void clearCache() {
        // Метод используется для очистки кеша операций пополнения кредитных карт
    }
}


