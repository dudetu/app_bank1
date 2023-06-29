package com.example.app_bank1.repository;


import com.example.app_bank1.other_paymens.categories.UtilityBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface UtilityBillRepository extends JpaRepository<UtilityBill, Long> {

    // Пользовательский метод для получения счетов за коммунальные услуги по номеру счета
    // Custom method to retrieve utility bills by bill number

    UtilityBill findByBillNumber(String billNumber);

    // Пользовательский метод для получения счетов за коммунальные услуги на сумму, превышающую заданное значение
    // Custom method to retrieve utility bills by amount greater than a given value
    List<UtilityBill> findByAmountGreaterThan(BigDecimal amount);

    // Add other custom methods as per your requirements

}


