package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.UtilityBill;
import com.example.app_bank1.repository.UtilityBillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UtilityBillServiceTest {

    @Mock
    private UtilityBillRepository billRepository;

    private UtilityBillService billService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        billService = new UtilityBillService(billRepository);
    }

    @Test
    void getAllBills_ShouldReturnAllBills() {
        // Arrange
        UtilityBill bill1 = new UtilityBill();
        UtilityBill bill2 = new UtilityBill();
        List<UtilityBill> expectedBills = Arrays.asList(bill1, bill2);

        when(billRepository.findAll()).thenReturn(expectedBills);

        // Act
        List<UtilityBill> actualBills = billService.getAllBills();

        // Assert
        assertEquals(expectedBills, actualBills);
    }

    @Test
    void createBill_ShouldSaveBill() {
        // Arrange
        UtilityBill bill = new UtilityBill();

        // Act
        billService.createBill(bill);

        // Assert
        verify(billRepository).save(bill);
    }

    @Test
    void setUtilityBills_ShouldSetBills() {
        // Arrange
        List<UtilityBill> utilityBills = Arrays.asList(new UtilityBill(), new UtilityBill());

        // Act
        billService.setUtilityBills(utilityBills);


    }
}
