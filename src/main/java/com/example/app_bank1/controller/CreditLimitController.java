package com.example.app_bank1.controller;


import com.example.app_bank1.entites.account.CreditLimit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app_bank1.other_paymens.categories.accumulation.CreditLimitService;

@RestController
@RequestMapping("/credit-limits")
public class CreditLimitController {

    private final CreditLimitService creditLimitService;

    public CreditLimitController(CreditLimitService creditLimitService) {
        this.creditLimitService = creditLimitService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditLimit> getCreditLimit(@PathVariable Long id) {
        CreditLimit creditLimit = creditLimitService.getCreditLimitById(id);
        if (creditLimit != null) {
            return ResponseEntity.ok(creditLimit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Другие методы контроллера (например, создание, обновление, удаление CreditLimit)
}


