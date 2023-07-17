package com.example.app_bank1.other_paymens.categories.controller;

import com.example.app_bank1.other_paymens.categories.entity.Transactions.CreditCard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        CreditCard creditCard;
        creditCard = creditCardService.getCreditCardById(id);
        return ResponseEntity.ok(creditCard);
    }

    @PostMapping("/create")
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        CreditCard createdCreditCard = creditCardService.createCreditCard(creditCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCreditCard);
    }



}
