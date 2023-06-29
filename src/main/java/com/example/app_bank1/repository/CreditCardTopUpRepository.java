package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreditCardTopUpRepository extends JpaRepository<CreditCardTopUp, Long> {
    // Пример метода для поиска пополнений кредитной карты по номеру карты
    // An example of a method to search for credit card deposits by card number

    List<CreditCardTopUp> findByCreditCardNumber(String creditCardNumber);

}
