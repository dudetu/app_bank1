package com.example.app_bank1.service;


import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {

    private
    final SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountService(SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;
    }

    public SavingsAccount getSavingsAccountById(Long id)
            throws ChangeSetPersister.NotFoundException {
        return savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {

        // Additional logic if required

        return savingsAccountRepository.save(savingsAccount);
    }

    public SavingsAccount updateSavingsAccount(Long id, SavingsAccount savingsAccount)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());


        // Updating account fields

        return savingsAccountRepository.save(existingAccount);
    }

    public void deleteSavingsAccount(Long id)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());


        //Additional logic before deleting an account


        savingsAccountRepository.delete(existingAccount);
    }
}


