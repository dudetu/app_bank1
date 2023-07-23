package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.payments.IbanPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


/**

 Repository interface for managing IbanPayment entities.

 Provides methods for saving and retrieving IBAN payments.
 */
@Repository
public interface IbanPaymentRepository extends JpaRepository<IbanPayment, Long> {

    /**

     Finds payments by IBAN.
     @param iban The IBAN to search for.
     @return The list of payments with the specified IBAN.
     */
    List<IbanPayment> findByIban(String iban);
    /**

     Finds payments with an amount greater than the specified value.
     @param minAmount The minimum amount for the payments.
     @return The list of payments with an amount greater than the specified value.
     */
    @Query("SELECT p FROM IbanPayment p WHERE p.amount > :minAmount")
    List<IbanPayment> findByAmountGreaterThan(@Param("minAmount") BigDecimal minAmount);
}

