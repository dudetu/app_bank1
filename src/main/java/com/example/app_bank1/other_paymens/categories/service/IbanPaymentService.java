package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.payments.IbanPayment;
import org.springframework.stereotype.Service;
import com.example.app_bank1.other_paymens.categories.repository.IbanPaymentRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 *
 */
@Service
public class IbanPaymentService {

    private final IbanPaymentRepository ibanPaymentRepository;

    public IbanPaymentService(IbanPaymentRepository ibanPaymentRepository) {
        this.ibanPaymentRepository = ibanPaymentRepository;
    }

    /**
     * Получить все платежи по IBAN.
     * Get all payments by IBAN.
     *
     * @return список всех платежей по IBAN
     *         a list of all payments by IBAN
     */
    public List<IbanPayment> getAllPayments() {
        return ibanPaymentRepository.findAll();
    }

    /**
     * Обработать платеж по IBAN.
     * Process a payment by IBAN.
     *
     * @param payment информация о платеже по IBAN
     *                the payment information by IBAN
     */
    public void processPayment(IbanPayment payment) {
        // Implementation of payment processing logic using API
        // It is assumed that there is a payment gateway API, which processes payments
        PaymentGateway paymentGateway = new PaymentGateway();
        boolean paymentSuccess = paymentGateway.processPayment(payment.getIban(), payment.getAmount());

        if (paymentSuccess) {
            // Save the payment information in the database
            ibanPaymentRepository.save(payment);
            System.out.println("Платеж успешно обработан.");
        } else {
            System.out.println("Ошибка при обработке платежа.");
        }
    }

    /**
     * Получить платеж по его идентификатору.
     * Get a payment by its identifier.
     *
     * @param paymentId идентификатор платежа
     *                  the payment identifier
     * @return платеж с указанным идентификатором
     *         the payment with the specified identifier
     * @throws NoSuchElementException если платеж не найден
     *                                if the payment is not found
     */
    public IbanPayment getPaymentById(Long paymentId) throws NoSuchElementException {
        // Retrieve a payment from the database by its identifier
        return ibanPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new NoSuchElementException("Платеж не найден."));
    }

    private class PaymentGateway {
        public boolean processPayment(String iban, BigDecimal amount) {
            // Implementation of payment processing logic using payment gateway API
            // Return true if payment is successful, otherwise return false
            return true;
        }
    }

}


