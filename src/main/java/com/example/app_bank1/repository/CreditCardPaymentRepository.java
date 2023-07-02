package com.example.app_bank1.repository;


import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Long> {

    // Example of a method to search for payments by credit card number
    List<CreditCardPayment> findByCreditCardNumber(String creditCardNumber);
}

