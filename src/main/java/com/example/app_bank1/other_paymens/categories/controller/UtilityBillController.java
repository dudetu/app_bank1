package com.example.app_bank1.other_paymens.categories.controller;


import com.example.app_bank1.other_paymens.categories.entity.UtilityBill;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.other_paymens.categories.service.UtilityBillService;

import java.util.List;


/**
 * This controller handles operations related to utility bills.
 */
@RestController
@RequestMapping("/utility-bills")
@RequiredArgsConstructor
public class UtilityBillController {

    private final UtilityBillService utilityBillService;
    private final RestTemplate restTemplate;
    private final String remoteApiUrl;

    /**
     * Извлекает все счета за коммунальные услуги из удаленного API.
     * Retrieves all utility bills from the remote API.
     *
     * Список счетов за коммунальные услуги.
     * @return The list of utility bills.
     *
     * Если при получении счетов за коммунальные услуги из удаленного API возникла ошибка.
     * @throws RuntimeException If there is an error retrieving utility bills from the remote API.
     */
    @GetMapping(value = "/get-all")
    public List<UtilityBill> getAllBills() {
        ResponseEntity<List> response = restTemplate.getForEntity(remoteApiUrl + "/utility-bills", List.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            List<UtilityBill> bills = response.getBody();
            return bills;
        }
        throw new RuntimeException("Failed to retrieve utility bills from remote API");
    }

    /**
     * Создает счет за коммунальные услуги через удаленный API.
     * Creates a utility bill through the remote API.
     *
     * Создаваемый счет за коммунальные услуги.
     * @param utilityBill The utility bill to be created.
     *
     * Сущность ответа HTTP, указывающая на успех создания счета за коммунальные услуги.
     * @return The HTTP response entity indicating the success of the utility bill creation.
     *
     * Если возникла ошибка при создании счета за коммунальные услуги через удаленный API.
     * @throws RuntimeException If there is an error creating the utility bill through the remote API.
     */
    @PostMapping(value = "/create")
    public ResponseEntity<String> createBill(@RequestBody UtilityBill utilityBill) {
        ResponseEntity<String> response = restTemplate.postForEntity(remoteApiUrl + "/utility-bills", utilityBill, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Utility bill created successfully");
        }
        throw new RuntimeException("Failed to create utility bill through remote API");
    }
}





