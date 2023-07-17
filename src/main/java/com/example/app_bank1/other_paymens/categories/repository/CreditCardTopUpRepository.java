package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.CreditCardTopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing credit card top-ups.
 */
@Repository
public interface CreditCardTopUpRepository extends JpaRepository<CreditCardTopUp, Long> {

    /**
     * Retrieves a list of credit card top-ups by credit card number.
     *
     * @param creditCardNumber The credit card number.
     * @return A list of credit card top-ups.
     */
    List<CreditCardTopUp> findByCreditCardCreditCardNumber(String creditCardNumber);
}

