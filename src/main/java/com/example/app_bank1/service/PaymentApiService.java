package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.stereotype.Service;

@Service
public class PaymentApiService {
    public boolean makeTopUp(CreditCardTopUp creditCardTopUp) {
        return false;
    }
}
