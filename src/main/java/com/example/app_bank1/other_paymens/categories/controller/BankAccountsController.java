package com.example.app_bank1.other_paymens.categories.controller;


import com.example.app_bank1.other_paymens.categories.entity.BankAccounts;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.service.BankAccountsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-accounts")
@RequiredArgsConstructor
public class BankAccountsController {

    private final BankAccountsService bankAccountsService;

    /**
     * Получить все банковские счета.
     *
     * @return список банковских счетов
     */
    @GetMapping("/get-all")
    public ResponseEntity<List<BankAccounts>> getAllBankAccounts() {
        List<BankAccounts> bankAccounts = bankAccountsService.getAllBankAccounts();
        return ResponseEntity.ok(bankAccounts);
    }

    /**
     * Получить банковский счет по идентификатору.
     *
     * @param id идентификатор банковского счета
     * @return найденный банковский счет
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @GetMapping("/{id}")
    public ResponseEntity<BankAccounts> getBankAccountById(@PathVariable Long id) {
        BankAccounts bankAccount = bankAccountsService.getBankAccountById(id);
        return ResponseEntity.ok(bankAccount);
    }

    /**
     * Создать новый банковский счет.
     *
     * @param bankAccount новый банковский счет
     * @return созданный банковский счет
     */
    @PostMapping("/create")
    public ResponseEntity<BankAccounts> createBankAccount(@RequestBody BankAccounts bankAccount) {
        BankAccounts createdBankAccount = bankAccountsService.createBankAccount(bankAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBankAccount);
    }

    /**
     * Обновить информацию о банковском счете.
     *
     * @param id           идентификатор банковского счета
     * @param bankAccount обновленная информация о банковском счете
     * @return обновленный банковский счет
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @PutMapping("/{id}")
    public ResponseEntity<BankAccounts> updateBankAccount(@PathVariable Long id, @RequestBody BankAccounts bankAccount) {
        bankAccount.setId(id);
        BankAccounts updatedBankAccount = bankAccountsService.updateBankAccount(bankAccount);
        return ResponseEntity.ok(updatedBankAccount);
    }

    /**
     * Удалить банковский счет по идентификатору.
     *
     * @param id идентификатор банковского счета для удаления
     * @return ответ с кодом 204 No Content в случае успешного удаления
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        bankAccountsService.deleteBankAccountById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Получить список банковских счетов для клиентского аккаунта.
     *
     * @param clientId идентификатор клиентского аккаунта
     * @return список банковских счетов
     */
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<BankAccounts>> getBankAccountsForClient(@PathVariable Long clientId) {
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(clientId);
        List<BankAccounts> bankAccounts = bankAccountsService.getBankAccountsForClientAccount(clientAccount);
        return ResponseEntity.ok(bankAccounts);
    }

    /**
     * Обработчик исключения EntityNotFoundException.
     *
     * @param exception исключение EntityNotFoundException
     * @return ответ с кодом 404 Not Found и сообщением об ошибке
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}

