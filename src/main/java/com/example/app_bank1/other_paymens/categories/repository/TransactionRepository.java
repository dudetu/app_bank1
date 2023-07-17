package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.Transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Дополнительные методы репозитория, если необходимо
}

