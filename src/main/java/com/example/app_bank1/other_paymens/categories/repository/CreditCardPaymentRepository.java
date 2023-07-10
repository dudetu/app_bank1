package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.payments.CreditCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing credit card payments.
 */
@Repository
public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Long> {

    /**
     * Retrieves a list of credit card payments by credit card number.
     *
     * @param creditCardNumber The credit card number.
     * @return A list of credit card payments.
     */
    List<CreditCardPayment> findByCreditCardNumber(String creditCardNumber);
}
