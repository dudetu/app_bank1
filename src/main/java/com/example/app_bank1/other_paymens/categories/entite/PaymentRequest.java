package com.example.app_bank1.other_paymens.categories.entite;

import com.example.app_bank1.account.PaymentApiResponse;
import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.repository.AccountTransferRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "payment_request")
public class PaymentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amoun")
    private BigDecimal amount;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "bank_accoun")
    private String bankAccount;


    public void makePayment(BankAccountPayment bankAccountPayment) {
        AccountTransferRepository bankAccountPaymentRepository = null;
        bankAccountPaymentRepository.save(bankAccountPayment);

        String apiUrl = "https://api.payment-system.com/payments";

        // Инициализируйте и заполните paymentRequest перед использованием
        // Initialize and populate the paymentRequest before using it
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(bankAccountPayment.getAmount());
        paymentRequest.setUserId((Long) bankAccountPayment.getUserId());
        paymentRequest.setBankAccount((String) bankAccountPayment.getBankAccount());
        paymentRequest.setId(bankAccountPayment.getId());

        try {
            RestTemplate restTemplate = new RestTemplate();
            PaymentApiResponse response = restTemplate.postForObject(apiUrl, paymentRequest, PaymentApiResponse.class);
            // Обработайте ответ от API платежной системы, если необходимо
            // Process the response from the payment system API, if necessary
        } catch (Exception e) {
            // Обработайте исключение при вызове API платежной системы
            // Handle exception on payment system API call
        }
    }
}
