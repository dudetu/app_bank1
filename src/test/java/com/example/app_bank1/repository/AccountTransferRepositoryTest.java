package com.example.app_bank1.repository;


import com.example.app_bank1.other_paymens.categories.entity.AccountTransfer;
import com.example.app_bank1.other_paymens.categories.repository.AccountTransferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class AccountTransferRepositoryTest {

    @Autowired
    private AccountTransferRepository accountTransferRepository;

    @Test
    public void testFindAll() {
        // Упорядочить
        // Arrange
        AccountTransfer transfer1 = new AccountTransfer();
        transfer1.setId(1L);
        transfer1.setAmount(BigDecimal.valueOf(100));
        accountTransferRepository.save(transfer1);

        AccountTransfer transfer2 = new AccountTransfer();
        transfer2.setId(2L);
        transfer2.setAmount(BigDecimal.valueOf(200));
        accountTransferRepository.save(transfer2);

        // Act
        List<AccountTransfer> transfers = accountTransferRepository.findAll();

        // Assert
        assertEquals(2, transfers.size());
    }

    @Test
    public void testSave() {
        // Упорядочить
        // Arrange
        AccountTransfer transfer = new AccountTransfer();
        transfer.setId(1L);
        transfer.setAmount(BigDecimal.valueOf(100));
        // Действие
        // Act
        AccountTransfer savedTransfer = accountTransferRepository.save(transfer);
        // Проверить
        // Assert
        assertTrue(accountTransferRepository.findById(savedTransfer.getId()).isPresent());
    }

    @Test
    public void testFindById() {
        // Упорядочить
        // Arrange
        AccountTransfer transfer = new AccountTransfer();
        transfer.setId(1L);
        transfer.setAmount(BigDecimal.valueOf(100));
        accountTransferRepository.save(transfer);
        // Действие
        // Act
        Optional<AccountTransfer> optionalTransfer = accountTransferRepository.findById(1L);
        // Проверить
        // Assert
        assertTrue(optionalTransfer.isPresent());
        assertEquals(1L, optionalTransfer.get().getId());
    }

}
