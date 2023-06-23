package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
    @Table(name = "credit_card_payments")
    public class   CreditCardPayment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "credit_card_number")
        private String creditCardNumber;

        @Column(name = "amount")
        private BigDecimal amount;

        // Геттеры, сеттеры и другие поля
    }


