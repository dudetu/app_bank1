package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.AccountTransfer;
import com.example.app_bank1.exception.TransferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app_bank1.other_paymens.categories.repository.AccountTransferRepository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 *
 */

@Service
public class AccountTransferService {

    private final AccountTransferRepository accountTransferRepository;

    @Autowired
    private PaymentSystemService paymentSystemService;

    public AccountTransferService(AccountTransferRepository accountTransferRepository) {
        this.accountTransferRepository = accountTransferRepository;
    }

    /**
     * Get a list of all transfers between accounts.
     *
     * @return the list of transfers between accounts
     */
    @Cacheable("transfers")
    public List<AccountTransfer> getAllTransfers() {
        return accountTransferRepository.findAll();
    }

    /**
     * Make a transfer between accounts.
     *
     * @param accountTransfer the transfer information
     */
    public void makeTransfer(AccountTransfer accountTransfer) {
        // Logic for performing a transfer between accounts
        // For example, calling the payment system API to execute the transfer
        // And saving the transfer information in the database

        accountTransferRepository.save(accountTransfer);
    }

    /**
     * Execute a transfer using the payment system.
     *
     * @param sourceAccount      the source account number
     * @param destinationAccount the destination account number
     * @param amount             the transfer amount
     * @throws TransferException if an error occurs during the transfer
     */
    public void executeTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) throws TransferException {
        // Call the payment system API to execute the transfer
        boolean transferSuccessful = paymentSystemService.transferFunds(sourceAccount, destinationAccount, amount);

        if (transferSuccessful) {
            // Save the transfer information in the database
            AccountTransfer transfer = new AccountTransfer();
            transfer.setSourceAccount(sourceAccount);
            transfer.setDestinationAccount(Long.valueOf(destinationAccount));
            transfer.setAmount(amount);
            accountTransferRepository.save(transfer);
        } else {
            throw new TransferException("Failed to execute the transfer. Please try again later.");
        }
    }

    /**
     * Receive a transfer from another bank account.
     *
     * @param sourceAccount      the source account number
     * @param destinationAccount the destination account number
     * @param amount             the transfer amount
     */
    public void receiveTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) {
        AccountTransfer transfer = new AccountTransfer();
        transfer.setSourceAccount(sourceAccount);
        transfer.setDestinationAccount(Long.valueOf(destinationAccount));
        transfer.setAmount(amount);
        accountTransferRepository.save(transfer);
    }

    /**
     * Set the payment system service.
     *
     * @param paymentSystemService the payment system service to set
     */
    public void setPaymentSystemService(PaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }

    /**
     * Clear the cache for transfers.
     */
    @CacheEvict(value = "transfers", allEntries = true)
    public void clearTransfersCache() {
        // This method clears the cache for transfers.
        // It can be called after making a new transfer or receiving a transfer.
        // This ensures that the cache is updated with the latest transfers.
    }
}
