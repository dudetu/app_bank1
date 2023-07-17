package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.Transactions.CreditCard;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard getCreditCardById(Long id) {
        return creditCardRepository.findById(id)
                .orElseThrow();
    }

    public CreditCard createCreditCard(CreditCard creditCard) {
        // Дополнительная логика, валидация и сохранение кредитной карты
        return creditCardRepository.save(creditCard);
    }



}
