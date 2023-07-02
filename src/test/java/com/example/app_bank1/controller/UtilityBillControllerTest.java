package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.UtilityBill;
import com.example.app_bank1.service.UtilityBillService;
import com.example.app_bank1.repository.UtilityBillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UtilityBillControllerTest {

    @Mock
    private UtilityBillRepository utilityBillRepository;

    private UtilityBillService utilityBillService;
    private UtilityBillController utilityBillController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); // Инициализируем аннотации Mockito
        utilityBillService = new UtilityBillService(utilityBillRepository); // Создаем сервис с заглушкой репозитория
        utilityBillController = new UtilityBillController(utilityBillService); // Создаем контроллер
    }

    @Test
    void getAllBills_ReturnsListOfUtilityBills() {
        // Arrange
        List<UtilityBill> utilityBills = new ArrayList<>();
        utilityBills.add(new UtilityBill());
        when(utilityBillRepository.findAll()).thenReturn(utilityBills); // Устанавливаем заглушку для метода findAll()

        // Act
        List<UtilityBill> result = utilityBillController.getAllBills();

        // Assert
        assertEquals(utilityBills, result);
    }

    @Test
    void createBill_ReturnsSuccessMessage() {
        // Arrange
        UtilityBill utilityBill = new UtilityBill();
        when(utilityBillRepository.save(utilityBill)).thenReturn(utilityBill); // Устанавливаем заглушку для метода save()

        // Act
        ResponseEntity<String> result = utilityBillController.createBill(utilityBill);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Utility bill created successfully", result.getBody());
    }
}

