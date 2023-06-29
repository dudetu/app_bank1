package com.example.app_bank1.entites.account;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "bank_account")
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "balance")
    private double balance;


}

