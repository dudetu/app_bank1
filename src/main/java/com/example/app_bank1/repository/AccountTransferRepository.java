package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Long> {


    // Методы для выполнения операций с переводами на счет
    // Methods for performing operations with transfers to the account
    List<AccountTransfer> findAccountTransferByIdAndAmountIsBetween(Long id, BigDecimal amount, BigDecimal amount2 );


    // Метод для сохранения информации о переводе на счет
    // A method to save information about the transfer to the account
    AccountTransfer save(AccountTransfer accountTransfer);

    // Метод для получения информации о переводе по идентификатору
    // A method to get information about a transfer by identifier
    Optional<AccountTransfer> findById(Long id);




}