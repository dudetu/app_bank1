package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountPaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BankAccountPaymentRepositoryTest {

    @Autowired
    private BankAccountPaymentRepository bankAccountPaymentRepository;

    @Test
    void findByBankAccountNumber_ReturnsMatchingPayments() {
        // Упорядочить
        // Arrange
        BankAccountPayment payment1 = new BankAccountPayment();
        payment1.setBankAccountNumber(Long.valueOf("1234567890"));
        bankAccountPaymentRepository.save(payment1);

        BankAccountPayment payment2 = new BankAccountPayment();
        payment2.setBankAccountNumber(Long.valueOf("0987654321"));
        bankAccountPaymentRepository.save(payment2);
        // Действие
        // Act
        List<BankAccountPayment> payments = bankAccountPaymentRepository.findByBankAccountNumber("1234567890");
        // Проверить
        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment1, payments.get(0));
    }
}
