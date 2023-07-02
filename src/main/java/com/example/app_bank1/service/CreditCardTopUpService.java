package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.CreditCardTopUpRepository;


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
        }

    }




