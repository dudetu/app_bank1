package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
    @Table(name = "fine_payments")
    public class FinePayment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fineNumber;

        private BigDecimal amount;

        // Геттеры, сеттеры и другие поля
    }



