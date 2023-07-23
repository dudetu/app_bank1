package com.example.app_bank1.other_paymens.categories.service;
import com.example.app_bank1.other_paymens.categories.entity.CreditLimit;
import com.example.app_bank1.other_paymens.categories.repository.CreditLimitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Сервисный класс для управления кредитными лимитами.
 */
@Service
@RequiredArgsConstructor
public class CreditLimitService {

    private final CreditLimitRepository creditLimitRepository;
    private static final String CREDIT_LIMIT_NOT_FOUND_MESSAGE = "Кредитный лимит не найден";

    /**
     * Создать новый кредитный лимит.
     *
     * @param creditLimit информация о кредитном лимите
     * @return созданный кредитный лимит
     */
    public CreditLimit createCreditLimit(CreditLimit creditLimit) {
        return creditLimitRepository.save(creditLimit);
    }

    /**
     * Обновить существующий кредитный лимит.
     *
     * @param id                 идентификатор кредитного лимита
     * @param updatedCreditLimit обновленная информация о кредитном лимите
     * @return обновленный кредитный лимит
     * @throws NoSuchElementException если кредитный лимит не найден
     */
    @CacheEvict(value = "creditLimits", key = "#id")
    public CreditLimit updateCreditLimit(Long id, CreditLimit updatedCreditLimit) {
        CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(CREDIT_LIMIT_NOT_FOUND_MESSAGE));

        existingCreditLimit.setCardNumber(updatedCreditLimit.getCardNumber());
        existingCreditLimit.setCreditLimit(updatedCreditLimit.getCreditLimit());

        return creditLimitRepository.save(existingCreditLimit);
    }

    /**
     * Удалить кредитный лимит.
     *
     * @param id идентификатор кредитного лимита
     * @throws NoSuchElementException если кредитный лимит не найден
     */
    @CacheEvict(value = "creditLimits", key = "#id")
    public void deleteCreditLimit(Long id) {
        CreditLimit existingCreditLimit = creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(CREDIT_LIMIT_NOT_FOUND_MESSAGE));

        creditLimitRepository.delete(existingCreditLimit);
    }

    /**
     * Получить все кредитные лимиты.
     *
     * @return список всех кредитных лимитов
     */
    @Cacheable("creditLimits")
    public List<CreditLimit> getAllCreditLimits() {
        return creditLimitRepository.findAll();
    }

    /**
     * Получить кредитный лимит по идентификатору.
     *
     * @param id идентификатор кредитного лимита
     * @return кредитный лимит
     * @throws NoSuchElementException если кредитный лимит не найден
     */
    @Cacheable(value = "creditLimits", key = "#id")
    public CreditLimit getCreditLimitById(Long id) {
        return creditLimitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(CREDIT_LIMIT_NOT_FOUND_MESSAGE));
    }
}
