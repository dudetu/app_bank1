package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.UtilityBill;
import com.example.app_bank1.repository.UtilityBillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class UtilityBillRepositoryTest {

    @Autowired
    private UtilityBillRepository utilityBillRepository;

    @Test
    void findByBillNumber_ReturnsMatchingBill() {
        // Arrange
        UtilityBill bill = new UtilityBill();
        bill.setBillNumber("123456789");
        utilityBillRepository.save(bill);

        // Act
        UtilityBill result = utilityBillRepository.findByBillNumber("123456789");

        // Assert
        assertNotNull(result);
        assertEquals(bill, result);
    }

    @Test
    void findByAmountGreaterThan_ReturnsMatchingBills() {
        // Arrange
        UtilityBill bill1 = new UtilityBill();
        bill1.setAmount(new BigDecimal("1000.00"));
        utilityBillRepository.save(bill1);

        UtilityBill bill2 = new UtilityBill();
        bill2.setAmount(new BigDecimal("2000.00"));
        utilityBillRepository.save(bill2);

        // Act
        List<UtilityBill> result = utilityBillRepository.findByAmountGreaterThan(new BigDecimal("1500.00"));

        // Assert
        assertEquals(1, result.size());
        assertEquals(bill2, result.get(0));
    }
}
