package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
    // Пользовательский метод для получения сберегательных счетов по имени владельца
    // Custom method to retrieve savings accounts by owner name
    List<SavingsAccount> findByOwnerName(String ownerName);

    // Пользовательский метод для получения сберегательных счетов по балансу, превышающему заданное значение
    // Custom method to retrieve savings accounts by balance greater than a given value
    List<SavingsAccount> findByBalanceGreaterThan(double minBalance);
    // Пользовательский метод для получения сберегательных счетов по имени владельца и балансу, превышающему заданное значение
    // Custom method to retrieve savings accounts by owner name and balance greater than a given value
    List<SavingsAccount> findByOwnerNameAndBalanceGreaterThan(String ownerName, double minBalance);
}

