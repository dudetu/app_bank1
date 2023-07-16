package com.example.app_bank1.other_paymens.categories.service;


import com.example.app_bank1.other_paymens.categories.entity.BankAccounts;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервисный класс для управления банковскими счетами.
 */
@Service
public class BankAccountsService {

    private final BankAccountsRepository bankAccountsRepository;

    @Autowired
    public BankAccountsService(BankAccountsRepository bankAccountsRepository) {
        this.bankAccountsRepository = bankAccountsRepository;
    }

    /**
     * Получить все банковские счета.
     *
     * @return список банковских счетов
     */
    @Cacheable("bankAccounts")
    public List<BankAccounts> getAllBankAccounts() {
        return bankAccountsRepository.findAll();
    }

    /**
     * Получить банковский счет по идентификатору.
     *
     * @param id идентификатор банковского счета
     * @return найденный банковский счет
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @Cacheable(value = "bankAccounts", key = "#id")
    public BankAccounts getBankAccountById(Long id) {
        return (BankAccounts) bankAccountsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bank Account not found with id: " + id));
    }

    /**
     * Создать новый банковский счет.
     *
     * @param bankAccount новый банковский счет
     * @return созданный банковский счет
     */
    public BankAccounts createBankAccount(BankAccounts bankAccount) {
        return bankAccountsRepository.save(bankAccount);
    }

    /**
     * Обновить информацию о банковском счете.
     *
     * @param bankAccount обновленная информация о банковском счете
     * @return обновленный банковский счет
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @CacheEvict(value = "bankAccounts", key = "#bankAccount.id")
    public BankAccounts updateBankAccount(BankAccounts bankAccount) {
        if (!bankAccountsRepository.existsById(bankAccount.getId())) {
            throw new EntityNotFoundException("Bank Account not found with id: " + bankAccount.getId());
        }
        return bankAccountsRepository.save(bankAccount);
    }

    /**
     * Удалить банковский счет по идентификатору.
     *
     * @param id идентификатор банковского счета для удаления
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @CacheEvict(value = "bankAccounts", key = "#id")
    public void deleteBankAccountById(Long id) {
        if (!bankAccountsRepository.existsById(id)) {
            throw new EntityNotFoundException("Bank Account not found with id: " + id);
        }
        bankAccountsRepository.deleteById(id);
    }

    /**
     * Получить список банковских счетов для клиентского аккаунта.
     *
     * @param clientAccount клиентский аккаунт
     * @return список банковских счетов
     */
    @Cacheable("bankAccounts")
    public List<BankAccounts> getBankAccountsForClientAccount(ClientAccount clientAccount) {
        return bankAccountsRepository.findByClientAccount(clientAccount);
    }
}
