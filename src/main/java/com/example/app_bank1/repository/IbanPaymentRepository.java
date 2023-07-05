package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.IbanPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IbanPaymentRepository extends JpaRepository<IbanPayment, Long> {

    // Метод для поиска платежей по IBAN
    // Method for searching payments by IBAN
    List<IbanPayment> findByIban(String iban);

    // Запрос для поиска платежей с суммой больше заданного значения
    // Query to search for payments with an amount greater than the specified value
    @Query("SELECT p FROM IbanPayment p WHERE p.amount > :minAmount")
    List<IbanPayment> findByAmountGreaterThan(@Param("minAmount") BigDecimal minAmount);
}


