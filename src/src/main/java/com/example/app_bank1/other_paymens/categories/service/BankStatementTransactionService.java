package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.BankStatementTransaction;
import com.example.app_bank1.other_paymens.categories.repository.BankStatementTransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BankStatementTransactionService {

    private final BankStatementTransactionRepository bankStatementTransactionRepository;

    public BankStatementTransactionService(BankStatementTransactionRepository bankStatementTransactionRepository) {
        this.bankStatementTransactionRepository = bankStatementTransactionRepository;
    }

    public BankStatementTransaction getBankStatementTransaction(Long id) {
        return bankStatementTransactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bank statement transaction not found with ID: " + id));
    }
}