package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository for managing bank account payments.
 */
@Repository
public interface BankAccountPaymentRepository extends JpaRepository<BankAccountPayment, Long> {

    /**
     * Retrieves a list of bank account payments by bank account number.
     *
     * @param bankAccountNumber The bank account number.
     * @return A list of bank account payments.
     */
    List<BankAccountPayment> findByBankAccountNumber(String bankAccountNumber);

    /**
     * Retrieves a list of bank account payments with an amount greater than the specified value.
     *
     * @param amount The minimum amount.
     * @return A list of bank account payments.
     */
    List<BankAccountPayment> findByAmountGreaterThan(BigDecimal amount);

    /**
     * Retrieves a list of bank account payments by bank account number and amount greater than a specified value.
     *
     * @param bankAccountNumber The bank account number.
     * @param amount            The minimum amount.
     * @return A list of bank account payments.
     */
    List<BankAccountPayment> findByBankAccountNumberAndAmountGreaterThan(String bankAccountNumber, BigDecimal amount);
}




