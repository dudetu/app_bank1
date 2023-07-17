package com.example.app_bank1.other_paymens.categories.controller;


import com.example.app_bank1.other_paymens.categories.entity.Transactions.Transaction;
import com.example.app_bank1.other_paymens.categories.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow();
    }

    public Transaction createTransaction(Transaction transaction) {
        // Дополнительная логика, валидация и сохранение транзакции
        return transactionRepository.save(transaction);
    }



}
