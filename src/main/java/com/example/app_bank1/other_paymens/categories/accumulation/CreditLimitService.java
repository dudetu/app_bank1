package com.example.app_bank1.other_paymens.categories.accumulation;

import com.example.app_bank1.other_paymens.categories.entite.CreditLimit;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.CreditLimitRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CreditLimitService {

    private final CreditLimitRepository creditLimitRepository;

    public CreditLimitService(CreditLimitRepository creditLimitRepository) {
        this.creditLimitRepository = creditLimitRepository;
    }


    public CreditLimit createCreditLimit(CreditLimit creditLimit) {
        // Logic of creating a new credit limit
        // For example, data validation and saving to the database


        return creditLimitRepository.save(creditLimit);
    }

    public CreditLimit updateCreditLimit(Long id, CreditLimit updatedCreditLimit) {

        // Logic for updating the existing credit limit
        // For example, searching by identifier, updating fields and saving to database


        CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Credit Limit not found"));

        //     existingCreditLimit.setId(updatedCreditLimit.getLimit());
        //    existingCreditLimit.setCardNumber(updatedCreditLimit.getCurrency());

        return creditLimitRepository.save(existingCreditLimit);
    }

    public void deleteCreditLimit(Long id) {

        // Logic of credit limit deletion
        // For example, search by identifier and deletion from the database
        CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Credit Limit not found"));

        creditLimitRepository.delete(existingCreditLimit);
    }

    public List<CreditLimit> getAllCreditLimits() {

        // Logic of getting all credit limits
        // For example, getting all records from the database
        return creditLimitRepository.findAll();
    }

    public CreditLimit getCreditLimitById(Long id) {

        // Logic of getting credit limit by identifier
        // For example, search by identifier in the database
        return creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Credit Limit not found"));
    }
}




