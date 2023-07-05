package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardTopUpRepository extends JpaRepository<CreditCardTopUp, Long> {
    // A method to search for credit card deposits by card number
    // Метод для поиска пополнений кредитной карты по номеру карты
    List<CreditCardTopUp> findByCreditCardNumber(String creditCardNumber);
}
