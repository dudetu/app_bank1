package com.example.app_bank1.other_paymens.categories.repository;



import com.example.app_bank1.other_paymens.categories.entity.UtilityBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



@Repository
public interface UtilityBillRepository extends JpaRepository<UtilityBill, Long> {

    /**
     * Пользовательский метод для получения счетов за коммунальные услуги по номеру счета.
     *
     * @param billNumber номер счета
     * @return Optional счет за коммунальные услуги
     */
    Optional<UtilityBill> findByBillNumber(String billNumber);

    /**
     * Пользовательский метод для получения счетов за коммунальные услуги на сумму, превышающую заданное значение.
     *
     * @param amount заданное значение суммы
     * @return список счетов за коммунальные услуги
     */
    List<UtilityBill> findByAmountGreaterThan(BigDecimal amount);
}





