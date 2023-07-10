package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.example.app_bank1.other_paymens.categories.repository.SavingsAccountRepository;

/**
 *
 *
 */
@Service
public class SavingsAccountService {
    private final SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountService(SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;
    }

    /**
     * Get a savings account by its identifier.
     *
     * @param id the savings account identifier
     * @return the savings account
     * @throws ChangeSetPersister.NotFoundException if the account is not found
     */
    public SavingsAccount getSavingsAccountById(Long id) throws ChangeSetPersister.NotFoundException {
        return savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    /**
     * Create a new savings account.
     *
     * @param savingsAccount the savings account to create
     * @return the created savings account
     */
    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
        return savingsAccountRepository.save(savingsAccount);
    }

    /**
     * Update an existing savings account.
     *
     * @param id             the savings account identifier
     * @param savingsAccount the updated savings account data
     * @return the updated savings account
     * @throws ChangeSetPersister.NotFoundException if the account is not found
     */
    public SavingsAccount updateSavingsAccount(Long id, SavingsAccount savingsAccount)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Update the account fields if necessary

        return savingsAccountRepository.save(existingAccount);
    }

    /**
     * Delete a savings account.
     *
     * @param id the savings account identifier
     * @throws ChangeSetPersister.NotFoundException if the account is not found
     */
    public void deleteSavingsAccount(Long id) throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());



        savingsAccountRepository.delete(existingAccount);
    }

}
