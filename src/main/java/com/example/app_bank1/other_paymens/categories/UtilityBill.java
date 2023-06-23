package com.example.app_bank1.other_paymens.categories;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
    @Table(name = "utility_bills")
    public class UtilityBill {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "bill_number")
        private String billNumber;

        @Column(name = "amount")
        private BigDecimal amount;

        // Геттеры, сеттеры и другие поля
    }



