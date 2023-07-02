package com.example.app_bank1.other_paymens.categories.entite;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data

@Entity
@Table(name = "credit_limit")
public class CreditLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "card_number;")
    private String cardNumber;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;




}



