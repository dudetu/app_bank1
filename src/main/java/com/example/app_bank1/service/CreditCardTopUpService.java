package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.CreditCardTopUpRepository;

import java.util.List;

@Service
public class CreditCardTopUpService {

    private final CreditCardTopUpRepository creditCardTopUpRepository;
    private final PaymentApiService paymentApiService;
    private CreditCardTopUp creditCardTopUp;

    public CreditCardTopUpService(CreditCardTopUpRepository creditCardTopUpRepository) {
        this.creditCardTopUpRepository = creditCardTopUpRepository;
        paymentApiService = null;
    }

    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpRepository.findAll();
    }


    public CreditCardTopUpService(CreditCardTopUpRepository creditCardTopUpRepository, PaymentApiService paymentApiService) {
        this.creditCardTopUpRepository = creditCardTopUpRepository;
        this.paymentApiService = paymentApiService;
    }

    public void topUpCreditCard(CreditCardTopUp creditCardTopUp) {
        this.creditCardTopUp = creditCardTopUp;
        // Вызов API платежной системы для осуществления пополнения
        // Call the API of the payment system for replenishment
        paymentApiService.makePayment(creditCardTopUp.getCreditCardNumber(), creditCardTopUp.getAmount());

        // Сохранение информации о пополнении в базу данных
        // Saving replenishment information in the database

        creditCardTopUpRepository.save(creditCardTopUp);
    }
}


