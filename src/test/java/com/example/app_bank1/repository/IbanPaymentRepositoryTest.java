package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.entity.payments.IbanPayment;
import com.example.app_bank1.other_paymens.categories.repository.IbanPaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class IbanPaymentRepositoryTest {

    @Autowired
    private IbanPaymentRepository ibanPaymentRepository;

    @Test
    void findByIban_ReturnsMatchingPayments() {
        // Упорядочить
        // Arrange
        IbanPayment payment1 = new IbanPayment();
        payment1.setIban("ABC123");
        ibanPaymentRepository.save(payment1);

        IbanPayment payment2 = new IbanPayment();
        payment2.setIban("DEF456");
        ibanPaymentRepository.save(payment2);
        // Действие
        // Act
        List<IbanPayment> payments = ibanPaymentRepository.findByIban("ABC123");
        // Проверить
        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment1, payments.get(0));
    }

    @Test
    void findByAmountGreaterThan_ReturnsMatchingPayments() {
        // Упорядочить
        // Arrange
        IbanPayment payment1 = new IbanPayment();
        payment1.setAmount(new BigDecimal("100.00"));
        ibanPaymentRepository.save(payment1);

        IbanPayment payment2 = new IbanPayment();
        payment2.setAmount(new BigDecimal("200.00"));
        ibanPaymentRepository.save(payment2);
        // Действие
        // Act
        List<IbanPayment> payments = ibanPaymentRepository.findByAmountGreaterThan(new BigDecimal("150.00"));
        // Проверить
        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment2, payments.get(0));
    }
}
