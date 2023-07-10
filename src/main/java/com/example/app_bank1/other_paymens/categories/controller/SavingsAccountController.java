package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.app_bank1.other_paymens.categories.service.SavingsAccountService;


/**
 * This controller handles operations related to savings accounts.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/savings-accounts")
public class SavingsAccountController {

    private final SavingsAccountService savingsAccountService;


    /**
     * Извлекает сберегательный счет по его идентификатору.
     * Retrieves a savings account by its ID.
     *
     * ID сберегательного счета.
     * @param id The ID of the savings account.
     *
     * Сущность HTTP-ответа, содержащая сберегательный счет.
     * @return The HTTP response entity containing the savings account.
     *
     * Если сберегательный счет не найден.
     * @throws ChangeSetPersister.NotFoundException If the savings account is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SavingsAccount> getSavingsAccountById(@PathVariable Long id)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount savingsAccount = savingsAccountService.getSavingsAccountById(id);
        return ResponseEntity.ok(savingsAccount);
    }


    /**
     * Создает новый сберегательный счет.
     * Creates a new savings account.
     *
     * Сберегательный счет, который будет создан.
     * @param savingsAccount The savings account to be created.
     *
     * Сущность HTTP-ответа, содержащая созданный сберегательный счет.
     * @return The HTTP response entity containing the created savings account.
     */
    @PostMapping(value = "/create")
    public ResponseEntity<SavingsAccount> createSavingsAccount(@RequestBody SavingsAccount savingsAccount) {
        SavingsAccount createdAccount = savingsAccountService.createSavingsAccount(savingsAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }


    /**
     * Обновляет сберегательный счет по его ID
     * Updates a savings account by its ID.
     *
     * Идентификатор сберегательного счета, который необходимо обновить.
     * @param id             The ID of the savings account to be updated.
     *
     * Обновленный сберегательный счет
     * @param savingsAccount The updated savings account.
     *
     * Сущность ответа HTTP, содержащая обновленный накопительный счет.
     * @return The HTTP response entity containing the updated savings account.
     *
     *  Если сберегательный счет не найден.
     * @throws ChangeSetPersister.NotFoundException If the savings account is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<SavingsAccount> updateSavingsAccount(@PathVariable Long id, @RequestBody SavingsAccount savingsAccount)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount updatedAccount = savingsAccountService.updateSavingsAccount(id, savingsAccount);
        return ResponseEntity.ok(updatedAccount);
    }

    /**
     * Удаление сберегательного счета по его идентификатору.
     * Deletes a savings account by its ID.
     *
     * Идентификатор сберегательного счета, который необходимо удалить.
     * @param id The ID of the savings account to be deleted.
     *
     * HTTP-сущность ответа, указывающая на успех удаления.
     * @return The HTTP response entity indicating the success of the deletion.
     *
     * Если сберегательный счет не найден.
     * @throws ChangeSetPersister.NotFoundException If the savings account is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Long id)
            throws ChangeSetPersister.NotFoundException {
        savingsAccountService.deleteSavingsAccount(id);
        return ResponseEntity.noContent().build();
    }
}
