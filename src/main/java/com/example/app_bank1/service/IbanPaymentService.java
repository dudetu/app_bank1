package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.IbanPayment;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.IbanPaymentRepository;

import java.math.BigDecimal;
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
        // Реализация логики обработки платежа с использованием API
        // Implementation of payment processing logic using API

        // Предполагается, что существует API платежного шлюза, который обрабатывает платежи
        // It is assumed that there is a payment gateway API, which processes payments
        PaymentGateway paymentGateway = new PaymentGateway();
        boolean paymentSuccess = paymentGateway.processPayment(payment.getIban(), payment.getAmount());

        if (paymentSuccess) {
            // Сохранение информации о платеже в базу данных
            // Saving information about the payment in the database
            ibanPaymentRepository.save(payment);
            System.out.println("Платеж успешно обработан.");
        } else {
            System.out.println("Ошибка при обработке платежа.");
        }
    }

    public IbanPayment getPaymentById(Long paymentId) {
        // Получение платежа из базы данных по его идентификатору
        // Retrieve a payment from the database by its identifier
        return ibanPaymentRepository.findById(paymentId)
                .orElseThrow();
    }

    private class PaymentGateway {
        public boolean processPayment(String iban, BigDecimal amount) {
            // Реализация логики обработки платежа с использованием API платежного шлюза
            // Вернуть true, если платеж успешен, иначе вернуть false

            // Implementation of payment processing logic using payment gateway API
            // Return true if payment is successful, otherwise return false
            return true;
        }
    }
}


