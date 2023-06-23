package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "iban_payments")
public class IbanPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String iban;

    private BigDecimal amount;

    // Геттеры, сеттеры и другие поля
}


