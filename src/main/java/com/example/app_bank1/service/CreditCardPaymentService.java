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

    public void processPayment(CreditCardPayment payment) {
        // Вызов API платежной системы для осуществления платежа
        // Call the API of the payment system to make a payment

        boolean paymentSuccessful;
        paymentSuccessful = makePayment(payment);

        if (paymentSuccessful) {
            // Сохранение информации о платеже в базе данных
            // Saving information about the payment in the database
            creditCardPaymentRepository.save(payment);
            System.out.println("Платеж успешно выполнен!"); // Дополнительная логика: вывод сообщения в консоль
        } else {
            System.out.println("Платеж не выполнен!"); // Дополнительная логика: вывод сообщения в консоль
        }
    }

    public boolean makePayment(CreditCardPayment payment) {

        // Здесь можно добавить код для вызова API платежной системы
        // и выполнения платежа с использованием данных из объекта payment
        // Вернуть true, если платеж выполнен успешно, иначе false
        // Пример кода:

        // Here you can add the code to call the API of the payment system
        // And make the payment using the data from the payment object
        // Return true if the payment was executed successfully, otherwise false
        // Example code:
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.payment-system.com/payments";
        PaymentApiResponse response = restTemplate.postForObject(apiUrl, payment, PaymentApiResponse.class);
        return response.isSuccessful();

    }
}







