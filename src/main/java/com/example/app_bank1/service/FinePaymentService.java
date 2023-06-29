package com.example.app_bank1.service;


import com.example.app_bank1.other_paymens.categories.FinePayment;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.FinePaymentRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
    public class FinePaymentService {

        private final FinePaymentRepository finePaymentRepository;

        public FinePaymentService(FinePaymentRepository finePaymentRepository) {
            this.finePaymentRepository = finePaymentRepository;
        }

        public List<FinePayment> getAllPayments() {
            return finePaymentRepository.findAll();
        }




        public void makeFinePayment(FinePayment finePayment) {
            // Вызовите API платежной системы для обработки платежа
            // Предполагается, что существует метод paymentSystemApi для осуществления платежа


            // Call the payment system API to process the payment
            // Assuming there is a paymentSystemApi method for making the payment

            FinePaymentService paymentSystemApi = null;
            boolean paymentSuccess = paymentSystemApi.makePayment(finePayment.getAmount());

            if (paymentSuccess) {

                // Сохраните информацию о платеже в базе данных

                // Save the payment information to the database
                finePaymentRepository.save(finePayment);
                System.out.println("Fine payment successful.");
            } else {
                System.out.println("Fine payment failed.");
            }
        }

    private boolean makePayment(BigDecimal amount) {
        return false;
    }


}






