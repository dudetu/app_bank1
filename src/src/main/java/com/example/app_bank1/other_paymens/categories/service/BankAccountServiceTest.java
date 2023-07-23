package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.BankAccount;
import com.example.app_bank1.other_paymens.categories.entity.BankStatementTransaction;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankAccountServiceTest {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceTest(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankStatementTransaction> getBankAccountTransactions(Long bankAccountId) {
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Bank account not found with ID: " + bankAccountId));
        return bankAccount.getBankStatementTransactions();
    }

    public BankAccount getBankAccountById(Long id) {
        return null;
    }

    public BankAccount updateBankAccount(BankAccount existingBankAccount) {
        return null;
    }

    public List<BankAccount> getAllBankAccounts() {
        System.out.println("method called");    // Debug
        return bankAccountRepository.findAll();
    }

    public Object createBankAccount(BankAccount bankAccount) {
        return null;
    }

    public void deleteBankAccountById(Long id) {
    }

    public List<BankAccount> getBankAccountsForClientAccount(Object any) {


        return null;
    }
}