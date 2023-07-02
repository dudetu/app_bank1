package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BankAccountPaymentRepository extends JpaRepository<BankAccountPayment, Long> {

    // Methods for operations with bank account replenishment
    // Method to search payments by bank account number
    List<BankAccountPayment> findByBankAccountNumber(String bankAccountNumber);

    // A method to search for payments with an amount greater than the specified value
    List<BankAccountPayment> findByAmountGreaterThan(BigDecimal amount);

    // A method to search for payments by bank account number and amount greater than a specified value
    List<BankAccountPayment> findByBankAccountNumberAndAmountGreaterThan(String bankAccountNumber, BigDecimal amount);

    // A method for executing your own query based on JPQL or SQL
    @Query("SELECT p FROM BankAccountPayment p WHERE p.bankAccountNumber = :accountNumber")
    List<BankAccountPayment> customQueryFindByAccountNumber(@Param("accountNumber") String accountNumber);
}



