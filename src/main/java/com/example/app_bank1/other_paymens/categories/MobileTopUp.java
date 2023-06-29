package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name = "mobile_top_ups")

 public class MobileTopUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "card_number;")
    private String cardNumber;

   @Column(name = "amount")
    private BigDecimal amount;


}

