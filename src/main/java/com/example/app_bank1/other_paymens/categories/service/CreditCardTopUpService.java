package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardTopUpRepository;

import java.util.List;

/**
 *
 *
 */
@Service
@RequiredArgsConstructor
public class CreditCardTopUpService {

    private final CreditCardTopUpRepository creditCardTopUpRepository;
    private final PaymentApiService paymentApiService;

    /**
     * Получить все операции пополнения кредитных карт.
     * Get all credit card top-up transactions.
     *
     * @return список операций пополнения кредитных карт
     *         a list of credit card top-up transactions
     */
    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpRepository.findAll();
    }

    /**
     * Пополнить кредитную карту.
     * Top-up a credit card.
     * Выполняет вызов API платежной системы для пополнения кредитной карты.
     * Сохраняет информацию о пополнении в базе данных.
     * Выполняет дополнительную логику, такую как отправку уведомления пользователю.
     *
     * @param creditCardTopUp информация о пополнении кредитной карты
     *                       the credit card top-up information
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
     * Send a notification to the user about the credit card top-up.
     *
     * @param creditCardTopUp информация о пополнении кредитной карты
     *                       the credit card top-up information
     */
    private void sendNotification(CreditCardTopUp creditCardTopUp) {


        // Logic of sending a notification to the user
        // For example, sending email, SMS, etc.
        System.out.println("Notification sent to user: " + creditCardTopUp.getUserEmail());

    }
}

