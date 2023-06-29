package com.example.app_bank1.repository;

import com.example.app_bank1.entites.account.CreditLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditLimitRepository extends JpaRepository<CreditLimit, Long> {

    // Дополнительные методы репозитория, если необходимо
    // Additional repository methods, if necessary
}


