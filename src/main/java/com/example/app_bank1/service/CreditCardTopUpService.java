package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.CreditCardTopUpRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardTopUpService {

    private final CreditCardTopUpRepository creditCardTopUpRepository;
    private final PaymentApiService paymentApiService;

    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpRepository.findAll();
    }

    public void topUpCreditCard(CreditCardTopUp creditCardTopUp) {
        // Выполните вызов API платежной системы для пополнения кредитной карты
        // Make a payment system API call to recharge a credit card

        boolean topUpSuccessful = paymentApiService.makeTopUp(creditCardTopUp);

        if (topUpSuccessful) {
            // Сохраните информацию о пополнении в базе данных
            // Save the replenishment information in the database
            creditCardTopUpRepository.save(creditCardTopUp);
            System.out.println("Credit card top-up successful.");

            // Дополнительная логика, например, отправка уведомления пользователю
            // Additional logic, such as sending a notification to the user
            sendNotification(creditCardTopUp);
        } else {
            // Обработка случая, когда пополнение не удалось
            // Можно выбросить исключение или выполнить другие действия
            // Handling the case when replenishment failed
            // You can throw an exception or perform other actions
            System.out.println("Credit card top-up failed.");

        }
    }

    private void sendNotification(CreditCardTopUp creditCardTopUp) {
        // Логика отправки уведомления пользователю
        // Например, отправка email, SMS и т.д.
        // Logic of sending a notification to the user
        // For example, sending email, SMS, etc.
        System.out.println("Notification sent to user: " + creditCardTopUp.getUserEmail());

    }
}

