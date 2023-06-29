package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.controller.PaymentApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.repository.BankAccountPaymentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BankAccountPaymentService {

    private final BankAccountPaymentRepository bankAccountPaymentRepository;

//  //  public BankAccountPaymentService(BankAccountPaymentRepository bankAccountPaymentRepository) {
//        this.bankAccountPaymentRepository = bankAccountPaymentRepository;
//        BankAccountPayment payment = null;
//        savedPayment = bankAccountPaymentRepository.save(payment);
//    }

    public List<BankAccountPayment> getAllPayments() {
        return bankAccountPaymentRepository.findAll();
    }

    public void makePayment(BankAccountPayment bankAccountPayment) {

        bankAccountPaymentRepository.save(bankAccountPayment);
    }

    RestTemplate restTemplate = new RestTemplate();
    String apiUrl = "https://api.payment-system.com/payments";
    private Object paymentRequest;
    // Вызов API платежной системы для осуществления платежа
    //   Например :

    // Call the API of the payment system to make a payment
    // For example :

    //  RestTemplate restTemplate = new RestTemplate();
    // String apiUrl = "https://api.payment-system.com/payments";
    PaymentApiResponse response = restTemplate.postForObject(apiUrl, paymentRequest, PaymentApiResponse.class);


    // Сохранение информации о платеже в базу данных
    BankAccountPayment savedPayment;


}
    


