package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.account.BankStatement;
import com.example.app_bank1.other_paymens.categories.entity.AccountTransfer;
import com.example.app_bank1.other_paymens.categories.repository.AccountTransferRepository;
import com.example.app_bank1.other_paymens.categories.service.BankStatementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/bank-statement")
public class BankStatementController {
    private BankStatementService bankStatementService;

    // Конструктор и другие методы контроллера

    @GetMapping("/{clientId}")
    public BankStatement getBankStatement(@PathVariable Long clientId) {
        AccountTransferRepository clientAccountRepository;
        clientAccountRepository = null;
        Optional<AccountTransfer> clientAccount = clientAccountRepository.findById(clientId);
        return bankStatementService.generateBankStatement(clientAccount);
    }
}
