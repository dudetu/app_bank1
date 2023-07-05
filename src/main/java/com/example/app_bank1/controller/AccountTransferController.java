package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import com.example.app_bank1.service.AccountTransferService;
import com.example.app_bank1.service.PaymentSystemService;
import com.example.app_bank1.exception.TransferException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account-transfers")
public class AccountTransferController {

    private final AccountTransferService accountTransferService;
    private final PaymentSystemService paymentSystemService;

    public AccountTransferController(AccountTransferService accountTransferService,
                                     PaymentSystemService paymentSystemService) {
        this.accountTransferService = accountTransferService;
        this.paymentSystemService = paymentSystemService;
    }

    @GetMapping
    public List<AccountTransfer> getAllTransfers() {
        return accountTransferService.getAllTransfers();
    }

    @PostMapping
    public ResponseEntity<String> makeTransfer(@RequestBody AccountTransfer accountTransfer) {
        try {
            BigDecimal amount = accountTransfer.getAmount();

            // Проверяем, что сумма перевода положительная
            // Check that the transfer amount is positive
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new TransferException("Сумма перевода должна быть положительной.");
            }

            // Проверяем, что номера счетов отправителя и получателя не пустые
            // Check that the account numbers of the sender and the recipient are not empty
            if (accountTransfer.getSourceAccount().isEmpty() || accountTransfer.getDestinationAccount().isEmpty()) {
                throw new TransferException("Не указаны номера счетов отправителя и/или получателя.");
            }

            // Проверяем, что счет отправителя и счет получателя не совпадают
            // Check that the sender's account and the recipient's account are not the same

            if (accountTransfer.getSourceAccount().equals(accountTransfer.getDestinationAccount())) {
                throw new TransferException("Счет отправителя и счет получателя не могут совпадать.");
            }

            boolean transferSuccessful = paymentSystemService.transferFunds(accountTransfer.getSourceAccount(),
                    accountTransfer.getDestinationAccount(),
                    amount);

            if (transferSuccessful) {
                accountTransferService.makeTransfer(accountTransfer);
                return ResponseEntity.ok("Перевод выполнен успешно.");
            } else {
                throw new TransferException("Ошибка выполнения перевода. Пожалуйста, попробуйте еще раз.");
            }
        } catch (TransferException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

