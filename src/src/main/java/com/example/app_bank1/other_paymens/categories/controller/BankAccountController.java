package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.BankAccount;
import com.example.app_bank1.other_paymens.categories.entity.BankStatementTransaction;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.service.BankAccountServiceTest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-account")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountServiceTest bankAccountService;

    /**
     * Получить все банковские счета.
     *
     * @return список банковских счетов
     */
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.getAllBankAccounts());
    }

    /**
     * Получить банковский счет по идентификатору.
     *
     * @param id идентификатор банковского счета
     * @return найденный банковский счет
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long id) {
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);
        return ResponseEntity.ok(bankAccount);
    }

    /**
     * Создать новый банковский счет.
     *
     * @param bankAccount новый банковский счет
     * @return созданный банковский счет
     */
    @PostMapping("/create")
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        BankAccount createdBankAccount = (BankAccount) bankAccountService.createBankAccount(bankAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBankAccount);
    }

    /**
     * Обновить информацию о банковском счете.
     *
     * @param id             идентификатор банковского счета
     * @param updatedAccount обновленная информация о банковском счете
     * @return обновленный банковский счет
     * @throws EntityNotFoundException если банковский счет не найден
     */
    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateBankAccount(@PathVariable Long id, @RequestBody BankAccount updatedAccount) {
        BankAccount existingBankAccount = bankAccountService.getBankAccountById(id);

        if (existingBankAccount == null) {
            throw new EntityNotFoundException("Bank account with id " + id + " not found");
        }

        // Обновление полей существующего банковского счета
        existingBankAccount.setAccountNumber(updatedAccount.getAccountNumber());
        existingBankAccount.setClientAccount(updatedAccount.getClientAccount());

        // Сохранение обновленного банковского счета в базу данных
        BankAccount updatedBankAccount = bankAccountService.updateBankAccount(existingBankAccount);
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
        bankAccountService.deleteBankAccountById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Получить список банковских счетов для клиентского аккаунта.
     *
     * @param clientId идентификатор клиентского аккаунта
     * @return список банковских счетов
     */
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<BankAccount>> getBankAccountsForClient(@PathVariable Long clientId) {
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(clientId);
        List<BankAccount> bankAccounts = bankAccountService.getBankAccountsForClientAccount(clientAccount);
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

    /**
     * Получить список транзакций для банковского счета.
     *
     * @param id идентификатор банковского счета
     * @return список транзакций для банковского счета
     */
    @GetMapping("/{id}/transactions")
    public List<BankStatementTransaction> getBankAccountTransactions(@PathVariable Long id) {
        return bankAccountService.getBankAccountTransactions(id);
    }
}

