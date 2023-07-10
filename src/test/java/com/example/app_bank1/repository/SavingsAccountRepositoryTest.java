
package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import com.example.app_bank1.other_paymens.categories.repository.SavingsAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class SavingsAccountRepositoryTest {

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @Test
    void findByOwnerName_ReturnsMatchingAccounts() {
        // Упорядочить
        // Arrange
        SavingsAccount account1 = new SavingsAccount();
        account1.setOwnerName("John");
        savingsAccountRepository.save(account1);

        SavingsAccount account2 = new SavingsAccount();
        account2.setOwnerName("Jane");
        savingsAccountRepository.save(account2);
        // Действие
        // Act
        List<SavingsAccount> accounts = savingsAccountRepository.findByOwnerName("John");
        // Проверить
        // Assert
        assertEquals(1, accounts.size());
        assertEquals(account1, accounts.get(0));
    }

    @Test
    void findByBalanceGreaterThan_ReturnsMatchingAccounts() {
        // Упорядочить
        // Arrange
        SavingsAccount account1 = new SavingsAccount();
        account1.setBalance(1000.0);
        savingsAccountRepository.save(account1);

        SavingsAccount account2 = new SavingsAccount();
        account2.setBalance(2000.0);
        savingsAccountRepository.save(account2);
        // Действие
        // Act
        List<SavingsAccount> accounts = savingsAccountRepository.findByBalanceGreaterThan(1500.0);
        // Проверить
        // Assert
        assertEquals(1, accounts.size());
        assertEquals(account2, accounts.get(0));
    }
}
