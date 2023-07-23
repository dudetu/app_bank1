
package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.AccountTransfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * Repository for managing account transfers.
 */
@Repository
public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Long> {

    /**
     * Retrieves a list of account transfers by user ID.
     *
     * @param usersId The user ID.
     * @return A list of account transfers.
     */
    List<AccountTransfer> findByUsersId(Long usersId);

    /**
     * Retrieves a list of account transfers within a specified amount range.
     *
     * @param minAmount The minimum amount.
     * @param maxAmount The maximum amount.
     * @return A list of account transfers.
     */
    List<AccountTransfer> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);

    /**
     * Retrieves account transfer information by ID.
     *
     * @param id The ID of the account transfer.
     * @return An Optional containing the account transfer, or empty if not found.
     */
    Optional<AccountTransfer> findById(Long id);
}



