package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Long> {

    // Methods for performing operations with transfers to the account
    List<AccountTransfer> findAccountTransferByIdAndAmountIsBetween(Long id, BigDecimal amount, BigDecimal amount2);

    // A method to save information about the transfer to the account
    AccountTransfer save(AccountTransfer accountTransfer);

    // A method to get information about a transfer by identifier
    Optional<AccountTransfer> findById(Long id);


    void save(BankAccountPayment bankAccountPayment);
}
