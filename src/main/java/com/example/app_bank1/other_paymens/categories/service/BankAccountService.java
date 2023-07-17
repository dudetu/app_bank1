package com.example.app_bank1.other_paymens.categories.service;


import com.example.app_bank1.other_paymens.categories.entity.Transactions.BankAccount;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





    @Service
    public class BankAccountService {
        private final BankAccountRepository bankAccountRepository;

        @Autowired
        public BankAccountService(BankAccountRepository bankAccountRepository) {
            this.bankAccountRepository = bankAccountRepository;
        }


        public BankAccount createBankAccount(BankAccount bankAccount) {
            return null;
        }
    }