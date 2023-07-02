package com.example.app_bank1.repository;


import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import com.example.app_bank1.repository.AccountTransferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AccountTransferRepositoryTest {

    @Autowired
    private AccountTransferRepository accountTransferRepository;

    @Test
    void findAccountTransferByIdAndAmountIsBetween_ReturnsMatchingAccountTransfers() {
        // Arrange
        AccountTransfer transfer1 = new AccountTransfer();
        transfer1.setId(1L);
        transfer1.setAmount(new BigDecimal("100.00"));
        accountTransferRepository.save(transfer1);

        AccountTransfer transfer2 = new AccountTransfer();
        transfer2.setId(2L);
        transfer2.setAmount(new BigDecimal("200.00"));
        accountTransferRepository.save(transfer2);

        AccountTransfer transfer3 = new AccountTransfer();
        transfer3.setId(3L);
        transfer3.setAmount(new BigDecimal("300.00"));
        accountTransferRepository.save(transfer3);

        // Act
        List<AccountTransfer> transfers = accountTransferRepository.findAccountTransferByIdAndAmountIsBetween(2L, new BigDecimal("150.00"), new BigDecimal("250.00"));

        // Assert
        assertEquals(1, transfers.size());
        assertEquals(transfer2, transfers.get(0));
    }

    @Test
    void save_SavesAccountTransfer() {
        // Arrange
        AccountTransfer transfer = new AccountTransfer();
        transfer.setId(1L);
        transfer.setAmount(new BigDecimal("100.00"));

        // Act
        AccountTransfer savedTransfer = accountTransferRepository.save(transfer);

        // Assert
        assertEquals(transfer, savedTransfer);
        assertTrue(accountTransferRepository.findById(1L).isPresent());
    }

    @Test
    void findById_ReturnsAccountTransferOptional() {
        // Arrange
        AccountTransfer transfer = new AccountTransfer();
        transfer.setId(1L);
        transfer.setAmount(new BigDecimal("100.00"));
        accountTransferRepository.save(transfer);

        // Act
        Optional<AccountTransfer> optionalTransfer = accountTransferRepository.findById(1L);

        // Assert
        assertTrue(optionalTransfer.isPresent());
        assertEquals(transfer, optionalTransfer.get());
    }

    @Test
    void save_SavesBankAccountPayment() {
        // Arrange
        BankAccountPayment payment = new BankAccountPayment();

        // Act
        accountTransferRepository.save(payment);


    }
}
