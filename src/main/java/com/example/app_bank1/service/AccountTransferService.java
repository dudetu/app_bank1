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
    public Object receive;

    public AccountTransferService(AccountTransferRepository accountTransferRepository) {
        this.accountTransferRepository = accountTransferRepository;
    }

    public List<AccountTransfer> getAllTransfers() {
        return accountTransferRepository.findAll();
    }

    public void makeTransfer(AccountTransfer accountTransfer) {

        // Логика выполнения перевода на счет
        // Например, вызов API платежной системы для выполнения перевода
        // И сохранение информации о переводе в базе данных
        accountTransferRepository.save(accountTransfer);
    }

    @Autowired
    private PaymentSystemService paymentSystemService;

    public void executeTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) throws TransferException {
        // Call the API of the payment system to perform a transfer
        // Вызов API платежной системы для выполнения перевода

        boolean transferSuccessful = paymentSystemService.transferFunds(sourceAccount, destinationAccount, amount);

        if (transferSuccessful) {

            // Сохранение информации о переводе в базе данных
            // Saving translation information in the database
            AccountTransfer transfer = new AccountTransfer();
            transfer.setSourceAccount(sourceAccount);
            transfer.setDestinationAccount(destinationAccount);
            transfer.setAmount(amount);
            accountTransferRepository.save(transfer);
        } else {

            // Обработка ошибки перевода
            // Processing a translation error
            throw new TransferException("Не удалось выполнить перевод. Пожалуйста, попробуйте еще раз позже.");
        }
    }

    public void receiveTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) {

        // Логика приема перевода со счета другого банка
        // Сохранение информации о переводе в базе данных
        // Logic of acceptance of transfer from another bank account
        // Saving information about the transfer in the database

        AccountTransfer transfer = new AccountTransfer();
        transfer.setSourceAccount(sourceAccount);
        transfer.setDestinationAccount(destinationAccount);
        transfer.setAmount(amount);
        accountTransferRepository.save(transfer);
    }


    public void setPaymentSystemService(PaymentSystemService paymentSystemService) {
    }
}


