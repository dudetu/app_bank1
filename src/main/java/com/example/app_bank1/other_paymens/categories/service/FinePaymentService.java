package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.payments.FinePayment;
import com.example.app_bank1.other_paymens.categories.repository.FinePaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FinePaymentService {

    private final FinePaymentRepository finePaymentRepository;
    private final Logger logger = LoggerFactory.getLogger(FinePaymentService.class);

    public FinePaymentService(FinePaymentRepository finePaymentRepository) {
        this.finePaymentRepository = finePaymentRepository;
    }

    /**
     * Получить все платежи за штрафы.
     *
     * @return список всех платежей за штрафы
     */
    @Cacheable("finePayments")
    public List<FinePayment> getAllPayments() {
        return finePaymentRepository.findAll();
    }

    /**
     * Осуществить платеж за штраф.
     *
     * @param finePayment информация о платеже за штраф
     */
    @CacheEvict(value = "finePayments", allEntries = true)
    public void makeFinePayment(FinePayment finePayment) {
        boolean paymentSuccess = makePayment(finePayment.getAmount());

        if (paymentSuccess) {
            finePaymentRepository.save(finePayment);
            logger.info("Оплата штрафа выполнена успешно.");
            sendPaymentConfirmation(finePayment);
            updatePaymentStatus(finePayment);
        } else {
            logger.error("Не удалось выполнить оплату штрафа.");
            notifyPaymentFailure(finePayment);
        }
    }

    /**
     * Выполнить платеж.
     *
     * @param amount сумма платежа
     * @return true, если платеж выполнен успешно, иначе false
     */
    public boolean makePayment(BigDecimal amount) {
        // Implementation of payment processing logic
        // Replace with your actual payment system integration code
        return false;
    }

    /**
     * Отправить подтверждение платежа пользователю.
     *
     * @param finePayment информация о платеже за штраф
     */
    private void sendPaymentConfirmation(FinePayment finePayment) {
        // Logic for sending payment confirmation to the user
        // Replace with your actual implementation
        logger.info("Отправлено подтверждение оплаты пользователю: " + finePayment.getUserEmail());
    }

    /**
     * Обновить статус платежа.
     *
     * @param finePayment информация о платеже за штраф
     */
    private void updatePaymentStatus(FinePayment finePayment) {
        // Logic for updating the payment status or performing related operations
        // Replace with your actual implementation
        finePayment.setStatus("PAID");
        finePaymentRepository.save(finePayment);
        logger.info("Обновлен статус платежа: " + finePayment.getStatus());
    }

    /**
     * Уведомить пользователя о неудаче платежа.
     *
     * @param finePayment информация о платеже за штраф
     */
    private void notifyPaymentFailure(FinePayment finePayment) {
        // Logic for notifying the user or performing actions after payment failure
        // Replace with your actual implementation
        logger.info("Отправлено уведомление о неудаче платежа пользователю: " + finePayment.getUserEmail());
    }

}
