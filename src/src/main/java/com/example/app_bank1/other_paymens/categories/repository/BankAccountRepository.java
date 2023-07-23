package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
