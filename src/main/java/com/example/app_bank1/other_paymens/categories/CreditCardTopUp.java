package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name = "credit_card_top_ups")
public class CreditCardTopUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @Column(name = "amount")
    private BigDecimal amount;


}

