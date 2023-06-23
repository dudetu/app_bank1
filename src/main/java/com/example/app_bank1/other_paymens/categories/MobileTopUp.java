package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "mobile_top_ups")

 public class MobileTopUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;

    private BigDecimal amount;

    // Геттеры, сеттеры и другие поля
}

