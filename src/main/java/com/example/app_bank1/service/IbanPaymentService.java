package com.example.app_bank1.service;


import com.example.app_bank1.other_paymens.categories.IbanPayment;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.IbanPaymentRepository;

import java.util.List;

@Service
public class IbanPaymentService {

    private final IbanPaymentRepository ibanPaymentRepository;

    public IbanPaymentService(IbanPaymentRepository ibanPaymentRepository) {
        this.ibanPaymentRepository = ibanPaymentRepository;
    }

    public List<IbanPayment> getAllPayments() {
        return ibanPaymentRepository.findAll();
    }


    public void processPayment(IbanPayment payment) {

        // Реализуйте логику обработки платежа с помощью API
        // Implement the logic for processing the payment using the API
        // Save the payment information to the database
        ibanPaymentRepository.save(payment);
    }

    public IbanPayment getPaymentById(Long paymentId) {


        // Retrieve the payment from the database by its ID
        return ibanPaymentRepository.findById(paymentId)
                .orElseThrow();
    }


}

