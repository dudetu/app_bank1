package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.accumulation.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
    /**
     * Retrieves savings accounts by owner name.
     *
     * @param ownerName the name of the account owner
     * @return a list of savings accounts matching the owner name
     */
    List<SavingsAccount> findByOwnerName(String ownerName);

    /**
     * Retrieves savings accounts with a balance greater than the specified value.
     *
     * @param minBalance the minimum balance value
     * @return a list of savings accounts with a balance greater than the specified value
     */
    List<SavingsAccount> findByBalanceGreaterThan(double minBalance);

    /**
     * Retrieves savings accounts by owner name and with a balance greater than the specified value.
     *
     * @param ownerName  the name of the account owner
     * @param minBalance the minimum balance value
     * @return a list of savings accounts matching the owner name and with a balance greater than the specified value
     */
    List<SavingsAccount> findByOwnerNameAndBalanceGreaterThan(String ownerName, double minBalance);
}


