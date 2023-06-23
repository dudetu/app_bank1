package controller;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servise.AccountTransferService;

import java.util.List;

@RestController
@RequestMapping("/account-transfers")
public class AccountTransferController {

    private final AccountTransferService accountTransferService;

    public AccountTransferController(AccountTransferService accountTransferService) {
        this.accountTransferService = accountTransferService;
    }

    @GetMapping
    public List<AccountTransfer> getAllTransfers() {
        return accountTransferService.getAllTransfers();
    }

    @PostMapping
    public ResponseEntity<String> makeTransfer(@RequestBody AccountTransfer accountTransfer) {
        accountTransferService.makeTransfer(accountTransfer);
        return ResponseEntity.ok("Account transfer successful");
    }

    // Другие методы для обработки перевода на счет
}
