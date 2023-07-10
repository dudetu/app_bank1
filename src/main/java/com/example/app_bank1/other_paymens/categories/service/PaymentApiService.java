package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.payments.PaymentApiResponse;
import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 *
 */
@Service
public class PaymentApiService {
    /**
     * Perform a top-up of the credit card via the payment system API.
     *
     * @param creditCardTopUp the credit card top-up information
     * @return true if the top-up is successful, otherwise false
     */
    public boolean makeTopUp(CreditCardTopUp creditCardTopUp) {


        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.payment-system.com/top-up";
        PaymentApiResponse response = restTemplate.postForObject(apiUrl, creditCardTopUp, PaymentApiResponse.class);
        return response.isSuccessful();
    }
}







