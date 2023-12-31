package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.controller.UtilityBillController;
import com.example.app_bank1.other_paymens.categories.entity.UtilityBill;
import com.example.app_bank1.other_paymens.categories.service.UtilityBillService;
import com.example.app_bank1.other_paymens.categories.repository.UtilityBillRepository;
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
        utilityBillController = new UtilityBillControllerBuilder().setUtilityBillService(utilityBillService).setRemoteApiUrl(remoteApiUrl).createUtilityBillController(); // Создаем контроллер
    }

    @Test
    void getAllBills_ReturnsListOfUtilityBills() {
        // Упорядочить
        // Arrange
        List<UtilityBill> utilityBills = new ArrayList<>();
        utilityBills.add(new UtilityBill());
        when(utilityBillRepository.findAll()).thenReturn(utilityBills); // Устанавливаем заглушку для метода findAll()
        // Действие
        // Act
        List<UtilityBill> result = utilityBillController.getAllBills();
        // Проверить
        // Assert
        assertEquals(utilityBills, result);
    }

    @Test
    void createBill_ReturnsSuccessMessage() {
        // Упорядочить
        // Arrange
        UtilityBill utilityBill = new UtilityBill();
        when(utilityBillRepository.save(utilityBill)).thenReturn(utilityBill); // Устанавливаем заглушку для метода save()
        // Действие
        // Act
        ResponseEntity<String> result = utilityBillController.createBill(utilityBill);
        // Проверить
        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Utility bill created successfully", result.getBody());
    }
}

