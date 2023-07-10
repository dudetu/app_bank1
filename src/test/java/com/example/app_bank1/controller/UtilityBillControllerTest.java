package com.example.app_bank1.controller;

import com.example.app_bank1.other_paymens.categories.controller.UtilityBillController;
import com.example.app_bank1.other_paymens.categories.entity.UtilityBill;
import com.example.app_bank1.other_paymens.categories.service.UtilityBillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UtilityBillControllerTest {

    @Mock
    private UtilityBillService utilityBillService;

    @Mock
    private RestTemplate restTemplate;

    private UtilityBillController utilityBillController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        String remoteApiUrl = "http://example.com/api";
        utilityBillController = new UtilityBillController(utilityBillService, restTemplate, remoteApiUrl);
    }

    @Test
    void getAllBills_ReturnsListOfUtilityBills() {
        // Arrange
        List<UtilityBill> utilityBills = new ArrayList<>();
        utilityBills.add(new UtilityBill());
        when(utilityBillService.getAllBills()).thenReturn(utilityBills);

        // Act
        List<UtilityBill> result = utilityBillController.getAllBills();

        // Assert
        assertEquals(utilityBills, result);
    }

    @Test
    void createBill_ReturnsSuccessMessage() {
        // Arrange
        UtilityBill utilityBill = new UtilityBill();
        ResponseEntity<String> successResponse = ResponseEntity.ok("Utility bill created successfully");
        when(restTemplate.postForEntity("http://example.com/api/utility-bills", utilityBill, String.class))
                .thenReturn(successResponse);

        // Act
        ResponseEntity<String> result = utilityBillController.createBill(utilityBill);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Utility bill created successfully", result.getBody());
    }
}
