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

    // Custom method to retrieve payments by IBAN
    List<IbanPayment> findByIban(String iban);

    // Custom query to retrieve payments by amount greater than a given value

    @Query("SELECT p FROM IbanPayment p WHERE p.amount > :minAmount")
    List<IbanPayment> findByAmountGreaterThan(@Param("minAmount") BigDecimal minAmount);


}


