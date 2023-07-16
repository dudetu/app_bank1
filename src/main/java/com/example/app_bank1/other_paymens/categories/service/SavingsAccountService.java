package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import com.example.app_bank1.other_paymens.categories.repository.SavingsAccountRepository;
import jakarta.persistence.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Сервисный класс для работы с счетами накопительного типа.
 */
@Service
public class SavingsAccountService {
        /**
         * Transfer funds from the source account to the destination account.
         *
         * @param sourceAccount      the source account number
         * @param destinationAccount the destination account number
         * @param amount             the amount to transfer
         * @return true if the transfer is successful, false if there is an error
         */
        public boolean transferFunds(String sourceAccount, String destinationAccount, BigDecimal amount) {

            // You need to add the appropriate logic related to interacting with payment systems or databases.

            // Currently returning false to indicate that the transfer is not being performed.
            return false;
        }

        /**
         * Transfer funds from the source account to the destination account.
         *
         * @param sourceAccount      the source account number
         * @param destinationAccount the destination account number
         * @param amount             the amount to transfer
         * @return true if the transfer is successful, false if there is an error
         */
        public boolean transferFunds(String sourceAccount, Long destinationAccount, BigDecimal amount) {
            return false;
        }



    private final SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountService(SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;
    }

    /**
     * Получить счет накопительного типа по его идентификатору.
     *
     * @param id идентификатор счета накопительного типа
     * @return счет накопительного типа
     * @throws ChangeSetPersister.NotFoundException если счет не найден
     */



    /**
     * Создать новый счет накопительного типа.
     *
     * @param savingsAccount счет накопительного типа для создания
     * @return созданный счет накопительного типа
     */
    @CacheEvict(value = "savingsAccounts", allEntries = true)
    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
        return savingsAccountRepository.save(savingsAccount);
    }

    /**
     * Обновить существующий счет накопительного типа.
     *
     * @param id             идентификатор счета накопительного типа
     * @param savingsAccount обновленные данные счета накопительного типа
     * @return обновленный счет накопительного типа
     * @throws ChangeSetPersister.NotFoundException если счет не найден
     */
    @CacheEvict(value = "savingsAccounts", key = "#id")
    public SavingsAccount updateSavingsAccount(Long id, SavingsAccount savingsAccount)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Обновление полей счета при необходимости

        return savingsAccountRepository.save(existingAccount);
    }

    /**
     * Удалить счет накопительного типа.
     *
     * @param id идентификатор счета накопительного типа
     * @throws ChangeSetPersister.NotFoundException если счет не найден
     */
    @CacheEvict(value = "savingsAccounts", key = "#id")
    public void deleteSavingsAccount(Long id) throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        savingsAccountRepository.delete(existingAccount);
    }

    public SavingsAccount getSavingsAccountById(Long id) {
        return null;
    }
}


