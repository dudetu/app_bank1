package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.CreditLimit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.app_bank1.other_paymens.categories.service.CreditLimitService;


/**
 * This class represents a REST controller for handling credit limits.
 * It provides an endpoint for retrieving credit limit data by ID.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/credit-limits")
public class CreditLimitController {

    private final CreditLimitService creditLimitService;
    private final RestTemplate restTemplate;
    private String remoteApiUrl;

    /**
     * Получает данные о кредитном лимите для заданного идентификатора.
     * Retrieves the credit limit data for a given ID.
     *
     * Идентификатор кредитного лимита.
     * @param id The ID of the credit limit.
     *
     * Сущность ответа, содержащая данные о кредитном лимите.
     * @return The response entity containing the credit limit data.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CreditLimit> getCreditLimit(@PathVariable Long id) {
        // Вызов удаленного API для получения данных о кредитном лимите по ID
        // Calling a remote API to get credit limit data by ID
        ResponseEntity<CreditLimit> response = restTemplate.getForEntity(remoteApiUrl + "/credit-limits/" + id, CreditLimit.class);

        // Обработка ответа от удаленного API
        // Handling the response from the remote API
        if (response.getStatusCode().is2xxSuccessful()) {
            CreditLimit creditLimit = response.getBody();
            if (creditLimit != null) {

                // Возврат данных о кредитном лимите
                // Return credit limit data
                return ResponseEntity.ok(creditLimit);
            }
        }


        return ResponseEntity.notFound().build();
    }
}




