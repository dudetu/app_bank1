package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.account.BankStatement;
import com.example.app_bank1.other_paymens.categories.entity.AccountTransfer;
import com.example.app_bank1.other_paymens.categories.entity.BankAccounts;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.repository.BankAccountsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankStatementService {
    // ...

    public BankStatement generateBankStatement(Optional<AccountTransfer> accountTransfer) {
        // Получить клиентский аккаунт из Optional
        ClientAccount clientAccount = accountTransfer.map(AccountTransfer::getClientAccount).orElse(null);

        // Получить транзакции для данного клиентского аккаунта из репозитория
        BankAccountsRepository transactionRepository;
        transactionRepository = null;
        List<BankAccounts> transactions = transactionRepository.findByClientAccount(clientAccount);

        // Формирование выписки на основе полученных транзакций
        BankStatement bankStatement = new BankStatement();
        bankStatement.setClientAccount(clientAccount);
        bankStatement.setTransactions(transactions);

        return bankStatement;
    }
}

