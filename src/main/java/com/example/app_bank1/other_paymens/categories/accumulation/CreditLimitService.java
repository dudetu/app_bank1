package com.example.app_bank1.other_paymens.categories.accumulation;

import com.example.app_bank1.entites.account.CreditLimit;
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
            // Логика создания нового кредитного лимита
            // Например, валидация данных и сохранение в базу данных

            // Logic of creating a new credit limit
            // For example, data validation and saving to the database



            return creditLimitRepository.save(creditLimit);
        }

        public CreditLimit updateCreditLimit(Long id, CreditLimit updatedCreditLimit) {
            // Логика обновления существующего кредитного лимита
            // Например, поиск по идентификатору, обновление полей и сохранение в базу данных

            // Logic for updating the existing credit limit
            // For example, searching by identifier, updating fields and saving to database


            CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Credit Limit not found"));

       //     existingCreditLimit.setId(updatedCreditLimit.getLimit());
        //    existingCreditLimit.setCardNumber(updatedCreditLimit.getCurrency());

            return creditLimitRepository.save(existingCreditLimit);
        }

        public void deleteCreditLimit(Long id) {
            // Логика удаления кредитного лимита
            // Например, поиск по идентификатору и удаление из базы данных

            // Logic of credit limit deletion
            // For example, search by identifier and deletion from the database
            CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Credit Limit not found"));

            creditLimitRepository.delete(existingCreditLimit);
        }

        public List<CreditLimit> getAllCreditLimits() {
            // Логика получения всех кредитных лимитов
            // Например, получение всех записей из базы данных

            // Logic of getting all credit limits
            // For example, getting all records from the database
            return creditLimitRepository.findAll();
        }

        public CreditLimit getCreditLimitById(Long id) {
            // Логика получения кредитного лимита по идентификатору
            // Например, поиск по идентификатору в базе данных

            // Logic of getting credit limit by identifier
            // For example, search by identifier in the database
            return creditLimitRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Credit Limit not found"));
        }
    }




