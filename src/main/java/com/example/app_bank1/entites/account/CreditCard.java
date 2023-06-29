package com.example.app_bank1.entites.account;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "card_number;")
    private String cardNumber;

    @Column(name = "expirationDate")
    private LocalDate expirationDate;

    @Column(name = "credit_Limit")
    private Double creditLimit;


}


