package com.example.app_bank1.other_paymens.categories.service;

import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService{
    @Override
    public BankAccount createBankAccount() {
        //some logic
        return new BankAccount();
    }

    @Override
    public void deleteBankAccount() {
        //deleted account
    }
}
