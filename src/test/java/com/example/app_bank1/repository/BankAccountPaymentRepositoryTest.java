package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.repository.BankAccountPaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BankAccountPaymentRepositoryTest {

    @Autowired
    private BankAccountPaymentRepository bankAccountPaymentRepository;

    @Test
    void findByBankAccountNumber_ReturnsMatchingPayments() {
        // Arrange
        BankAccountPayment payment1 = new BankAccountPayment();
        payment1.setBankAccountNumber("1234567890");
        bankAccountPaymentRepository.save(payment1);

        BankAccountPayment payment2 = new BankAccountPayment();
        payment2.setBankAccountNumber("0987654321");
        bankAccountPaymentRepository.save(payment2);

        // Act
        List<BankAccountPayment> payments = bankAccountPaymentRepository.findByBankAccountNumber("1234567890");

        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment1, payments.get(0));
    }

    @Test
    void findByAmountGreaterThan_ReturnsMatchingPayments() {
        // Arrange
        BankAccountPayment payment1 = new BankAccountPayment();
        payment1.setAmount(new BigDecimal("100.00"));
        bankAccountPaymentRepository.save(payment1);

        BankAccountPayment payment2 = new BankAccountPayment();
        payment2.setAmount(new BigDecimal("200.00"));
        bankAccountPaymentRepository.save(payment2);

        // Act
        List<BankAccountPayment> payments = bankAccountPaymentRepository.findByAmountGreaterThan(new BigDecimal("150.00"));

        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment2, payments.get(0));
    }

    @Test
    void findByBankAccountNumberAndAmountGreaterThan_ReturnsMatchingPayments() {
        // Arrange
        BankAccountPayment payment1 = new BankAccountPayment();
        payment1.setBankAccountNumber("1234567890");
        payment1.setAmount(new BigDecimal("100.00"));
        bankAccountPaymentRepository.save(payment1);

        BankAccountPayment payment2 = new BankAccountPayment();
        payment2.setBankAccountNumber("0987654321");
        payment2.setAmount(new BigDecimal("200.00"));
        bankAccountPaymentRepository.save(payment2);

        // Act
        List<BankAccountPayment> payments = bankAccountPaymentRepository.findByBankAccountNumberAndAmountGreaterThan("1234567890", new BigDecimal("150.00"));

        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment1, payments.get(0));
    }

    @Test
    void customQueryFindByAccountNumber_ReturnsMatchingPayments() {
        // Arrange
        BankAccountPayment payment1 = new BankAccountPayment();
        payment1.setBankAccountNumber("1234567890");
        bankAccountPaymentRepository.save(payment1);

        BankAccountPayment payment2 = new BankAccountPayment();
        payment2.setBankAccountNumber("0987654321");
        bankAccountPaymentRepository.save(payment2);

        // Act
        List<BankAccountPayment> payments = bankAccountPaymentRepository.customQueryFindByAccountNumber("0987654321");

        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment2, payments.get(0));
    }
}

