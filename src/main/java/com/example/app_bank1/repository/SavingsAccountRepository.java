package com.example.app_bank1.repository;


import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {

    // Custom method to retrieve savings accounts by owner name

    List<SavingsAccount> findByOwnerName(String ownerName);

    // Custom method to retrieve savings accounts by balance greater than a given value
    List<SavingsAccount> findByBalanceGreaterThan(double minBalance);


}
