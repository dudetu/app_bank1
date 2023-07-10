package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.AccountTransfer;
import com.example.app_bank1.other_paymens.categories.service.AccountTransferService;
import com.example.app_bank1.other_paymens.categories.service.PaymentSystemService;
import com.example.app_bank1.exception.TransferException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * This class represents a REST controller for handling account transfers.
 * It provides endpoints for retrieving all transfers and making a transfer.
 */
@RestController
@RequestMapping("/account-transfers")
@RequiredArgsConstructor
public class AccountTransferController {

    private final AccountTransferService accountTransferService;
    private final PaymentSystemService paymentSystemService;

    /**
     * Извлекает все переводы счетов.
     * Retrieves all account transfers.
     * <p>
     * Список переводов счетов
     *
     * @return The list of account transfers.
     */
    @GetMapping("/get-all")
    public List<AccountTransfer> getAllTransfers() {
        return accountTransferService.getAllTransfers();
    }

    /**
     * Осуществляет перевод со счета отправителя на счет получателя.
     * Makes a transfer from the sender's account to the recipient's account.
     * <p>
     * Реквизиты для перевода средств на счет
     *
     * @param accountTransfer The account transfer details.
     *                        <p>
     *                        Сущность ответа, указывающая на статус передачи.
     * @return The response entity indicating the status of the transfer.
     * <p>
     * Если в процессе передачи произошла ошибка.
     * @throws TransferException If there is an error during the transfer process.
     */
    @PostMapping("/make-transfer")
    public ResponseEntity<String> makeTransfer(@RequestBody AccountTransfer accountTransfer) throws TransferException {
        BigDecimal amount = accountTransfer.getAmount();

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new TransferException("The transfer amount must be positive.");
        }
        // Проверьте, что номера счетов отправителя и получателя не пустые
        // Check that the account numbers of the sender and the recipient are not empty

        if (!accountTransfer.getSourceAccount().isEmpty()) {
            // Проверьте, что учетные записи отправителя и получателя не совпадают
            // Check that the sender's account and the recipient's account are not the same

            if (accountTransfer.getSourceAccount().equals(accountTransfer.getDestinationAccount())) {
                throw new TransferException("The sender's account and the recipient's account cannot be the same.");
            }

            boolean transferSuccessful = paymentSystemService.transferFunds(
                    accountTransfer.getSourceAccount(),
                    accountTransfer.getDestinationAccount(),
                    amount
            );

            if (transferSuccessful) {
                accountTransferService.makeTransfer(accountTransfer);
                return ResponseEntity.ok("Transfer completed successfully.");
            } else {
                throw new TransferException("Error executing the transfer. Please try again.");
            }
        } else {
            throw new TransferException("Не указаны номера счетов отправителя и/или получателя.");
        }
    }
}
