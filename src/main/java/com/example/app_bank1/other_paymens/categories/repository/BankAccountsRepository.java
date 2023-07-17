package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.BankAccounts;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import org.springframework.stereotype.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BankAccountsRepository extends JpaRepository<BankAccounts, Long> {
    List<BankAccounts> findByClientAccount(ClientAccount clientAccount);
}

