package com.example.app_bank1.other_paymens.categories.controller;
import com.example.app_bank1.other_paymens.categories.entity.BankStatementTransaction;
import com.example.app_bank1.other_paymens.categories.service.BankStatementTransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bank-statement-transactions")
public class BankStatementTransactionController {

    private final BankStatementTransactionService bankStatementTransactionService;

    /**
     * Constructs a new BankStatementTransactionController with the specified BankStatementTransactionService.
     *
     * @param bankStatementTransactionService The BankStatementTransactionService used to retrieve bank statement transactions.
     */
    public BankStatementTransactionController(BankStatementTransactionService bankStatementTransactionService) {
        this.bankStatementTransactionService = bankStatementTransactionService;
    }

    /**
     * Retrieves a bank statement transaction by its ID.
     *
     * @param id The ID of the bank statement transaction to retrieve.
     * @return The BankStatementTransaction with the specified ID.
     */
    @GetMapping("/{id}")
    public BankStatementTransaction getBankStatementTransaction(@PathVariable Long id) {
        return bankStatementTransactionService.getBankStatementTransaction(id);
    }
}
