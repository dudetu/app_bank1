package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.CreditLimit;
import org.springframework.stereotype.Service;
import com.example.app_bank1.other_paymens.categories.repository.CreditLimitRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 */
@Service
public class CreditLimitService {

    private final CreditLimitRepository creditLimitRepository;

    public CreditLimitService(CreditLimitRepository creditLimitRepository) {
        this.creditLimitRepository = creditLimitRepository;
    }

    /**
     * Создать новый кредитный лимит.
     * Create a new credit limit.
     *
     * @param creditLimit информация о кредитном лимите
     *                    the credit limit information
     * @return созданный кредитный лимит
     *         the created credit limit
     */
    public CreditLimit createCreditLimit(CreditLimit creditLimit) {

        return creditLimitRepository.save(creditLimit);
    }

    /**
     * Обновить существующий кредитный лимит.
     * Update an existing credit limit.
     *
     * @param id                 идентификатор кредитного лимита
     *                           the credit limit identifier
     * @param updatedCreditLimit обновленная информация о кредитном лимите
     *                           the updated credit limit information
     * @return обновленный кредитный лимит
     *         the updated credit limit
     * @throws NoSuchElementException если кредитный лимит не найден
     *                                  if the credit limit is not found
     */
    public CreditLimit updateCreditLimit(Long id, CreditLimit updatedCreditLimit) {

        CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Кредитный лимит не найден"));

        existingCreditLimit.setCardNumber(updatedCreditLimit.getCardNumber());
        existingCreditLimit.setCreditLimit(updatedCreditLimit.getCreditLimit());

        return creditLimitRepository.save(existingCreditLimit);
    }

    /**
     * Удалить кредитный лимит.
     * Delete a credit limit.
     *
     * @param id идентификатор кредитного лимита
     *           the credit limit identifier
     * @throws NoSuchElementException если кредитный лимит не найден
     *                                  if the credit limit is not found
     */
    public void deleteCreditLimit(Long id) {

        CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Кредитный лимит не найден"));

        creditLimitRepository.delete(existingCreditLimit);
    }

    /**
     * Получить все кредитные лимиты.
     * Get all credit limits.
     *
     * @return список всех кредитных лимитов
     *         a list of all credit limits
     */
    public List<CreditLimit> getAllCreditLimits() {

        return creditLimitRepository.findAll();
    }

    /**
     * Получить кредитный лимит по идентификатору.
     * Get a credit limit by identifier.
     *
     * @param id идентификатор кредитного лимита
     *           the credit limit identifier
     * @return кредитный лимит
     *         the credit limit
     * @throws NoSuchElementException если кредитный лимит не найден
     *                                  if the credit limit is not found
     */
    public CreditLimit getCreditLimitById(Long id) {

        return creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Кредитный лимит не найден"));
    }

}




