package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BankAccountPaymentRepository extends JpaRepository<BankAccountPayment, Long> {
    // Методы для операций с платежами по банковским счетам
    // Methods for operations with bank account payments

    // Метод поиска платежей по номеру банковского счета
    // Method to search payments by bank account number
    List<BankAccountPayment> findByBankAccountNumber(String bankAccountNumber);

    // Метод поиска платежей с суммой, превышающей указанное значение
    // Method to search payments with an amount greater than the specified value
    List<BankAccountPayment> findByAmountGreaterThan(BigDecimal amount);

    // Метод поиска платежей по номеру банковского счета и сумме, превышающей заданное значение
    // Method to search payments by bank account number and amount greater than a specified value
    List<BankAccountPayment> findByBankAccountNumberAndAmountGreaterThan(String bankAccountNumber, BigDecimal amount);
}



