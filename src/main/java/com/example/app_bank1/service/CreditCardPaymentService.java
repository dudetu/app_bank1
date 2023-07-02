package com.example.app_bank1.service;


import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import com.example.app_bank1.account.PaymentApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.repository.CreditCardPaymentRepository;

import java.util.List;

@Service
public class CreditCardPaymentService {

    private final CreditCardPaymentRepository creditCardPaymentRepository;

    public CreditCardPaymentService(CreditCardPaymentRepository creditCardPaymentRepository) {
        this.creditCardPaymentRepository = creditCardPaymentRepository;
    }

    public List<CreditCardPayment> getAllPayments() {
        return creditCardPaymentRepository.findAll();
    }


    @Autowired
    private CreditCardPaymentRepository paymentRepository;

    public void processPayment(CreditCardPayment payment) {
        // Call the API of the payment system to make a payment

        boolean paymentSuccessful;
        paymentSuccessful = makePayment(payment);

        if (paymentSuccessful) {
            // Saving information about the payment in the database
            paymentRepository.save(payment);
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed!");
        }
    }

    public boolean makePayment(CreditCardPayment payment) {

        // Here you can insert the code to call the API of the payment system
        // And make the payment using the data passed from the payment object
        //return true if the payment was successful, or false otherwise
        // Example code:
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.payment-system.com/payments";
        PaymentApiResponse response = restTemplate.postForObject(apiUrl, payment, PaymentApiResponse.class);
        return response.isSuccessful();

    }
}







