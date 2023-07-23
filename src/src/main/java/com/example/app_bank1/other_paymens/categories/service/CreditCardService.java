package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.BankStatementTransaction;
import com.example.app_bank1.other_paymens.categories.entity.CreditCard;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public List<BankStatementTransaction> getCreditCardTransactions(Long creditCardId) {
        CreditCard creditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new EntityNotFoundException("Credit card not found with ID: " + creditCardId));
        return creditCard.getBankStatementTransactions();
    }
}