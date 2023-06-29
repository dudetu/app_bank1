package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import com.example.app_bank1.exception.TransferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.AccountTransferRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountTransferService {

    private final AccountTransferRepository accountTransferRepository;

    public AccountTransferService(AccountTransferRepository accountTransferRepository) {
        this.accountTransferRepository = accountTransferRepository;
    }

    public List<AccountTransfer> getAllTransfers() {
        return accountTransferRepository.findAll();
    }

    public void makeTransfer(AccountTransfer accountTransfer) {
        // Логика выполнения перевода на счет
        // Например, вызов API платежной системы для осуществления перевода
        // и сохранение информации о переводе в базу данных

        // The logic of performing a transfer to the account
        // For example, calling the API of the payment system to make a transfer
        // And saving information about the transfer in the database
        accountTransferRepository.save(accountTransfer);
    }



        @Autowired
        private PaymentSystemService paymentSystemService;

    public void executeTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) throws TransferException {
            // Вызов API платежной системы для выполнения перевода
             // Calling the API of the payment system to perform a transfer

            boolean transferSuccessful = paymentSystemService.transferFunds(sourceAccount, destinationAccount, amount);

            if (transferSuccessful) {
                // Сохранение информации о переводе в базу данных
                //  Saving transfer information in the database

                AccountTransfer transfer = new AccountTransfer();
                transfer.setSourceAccount(sourceAccount);
                transfer.setDestinationAccount(destinationAccount);
                transfer.setAmount(amount);
                accountTransferRepository.save(transfer);
            } else {
                // Обработка ошибки при выполнении перевода
                //   Processing a translation error
                throw new TransferException("Failed to execute transfer. Please try again later.");
            }
        }

        public void receiveTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) {
            // Логика получения перевода с другого банковского счета
            // Сохранение информации о переводе в базу данных
            AccountTransfer transfer = new AccountTransfer();
            transfer.setSourceAccount(sourceAccount);
            transfer.setDestinationAccount(destinationAccount);
            transfer.setAmount(amount);
            accountTransferRepository.save(transfer);
        }

    }


