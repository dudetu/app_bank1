package com.example.app_bank1.service;

import com.example.app_bank1.account.PaymentApiResponse;
import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.repository.BankAccountPaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BankAccountPaymentService {

    private final BankAccountPaymentRepository bankAccountPaymentRepository;
    private final RestTemplate restTemplate;

    public BankAccountPaymentService(BankAccountPaymentRepository bankAccountPaymentRepository, RestTemplate restTemplate) {
        this.bankAccountPaymentRepository = bankAccountPaymentRepository;
        this.restTemplate = restTemplate;
    }

    public List<BankAccountPayment> getAllPayments() {
        return bankAccountPaymentRepository.findAll();
    }

    public void makePayment(BankAccountPayment bankAccountPayment) {
        bankAccountPaymentRepository.save(bankAccountPayment);

        String apiUrl = "https://api.payment-system.com/payments";

        // Initialize and populate paymentRequest before using
        // Object paymentRequest = ...

        try {
            Object paymentRequest = null;
            PaymentApiResponse response = restTemplate.postForObject(apiUrl, paymentRequest, PaymentApiResponse.class);

            // Process the response from the payment system API if needed
        } catch (Exception e) {

            // Handle the exception when calling the payment system API
        }
    }
}



    


