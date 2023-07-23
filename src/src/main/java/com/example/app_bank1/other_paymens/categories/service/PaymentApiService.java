package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.account.PaymentApiResponse;
import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 *
 */
@Service
public class PaymentApiService {

    @CacheEvict(value = "creditCardTopUp", key = "#creditCardTopUp.id")
    public boolean makeTopUp(CreditCardTopUp creditCardTopUp) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.payment-system.com/top-up";
        PaymentApiResponse response = restTemplate.postForObject(apiUrl, creditCardTopUp, PaymentApiResponse.class);
        return response.isSuccessful();
    }

}







