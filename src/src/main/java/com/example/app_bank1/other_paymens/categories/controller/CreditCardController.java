package com.example.app_bank1.other_paymens.categories.controller;
import com.example.app_bank1.other_paymens.categories.entity.BankStatementTransaction;
import com.example.app_bank1.other_paymens.categories.service.CreditCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    /**
     * Constructs a new CreditCardController with the specified CreditCardService.
     *
     * @param creditCardService The CreditCardService used to retrieve credit card transactions.
     */
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    /**
     * Retrieves a list of bank statement transactions associated with the credit card by its ID.
     *
     * @param id The ID of the credit card to retrieve the transactions for.
     * @return The list of bank statement transactions associated with the credit card.
     */
    @GetMapping("/{id}/transactions")
    public List<BankStatementTransaction> getCreditCardTransactions(@PathVariable Long id) {
        return creditCardService.getCreditCardTransactions(id);
    }
}
