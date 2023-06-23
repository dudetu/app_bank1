package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
    @Table(name = "bank_account_payments")
    public class BankAccountPayment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "bank_account_number")
        private String bankAccountNumber;

        @Column(name = "amount")
        private BigDecimal amount;

    public BankAccountPayment(Long id, String bankAccountNumber, BigDecimal amount) {
        this.id = id;
        this.bankAccountNumber = bankAccountNumber;
        this.amount = amount;
    }

    public BankAccountPayment() {

    }

    // Геттеры, сеттеры и другие поля
    }



