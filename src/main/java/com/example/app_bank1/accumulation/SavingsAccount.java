package com.example.app_bank1.accumulation;


import jakarta.persistence.*;
import lombok.Data;

/**
 * This class represents a savings account with basic account information and balance.
 * It provides methods for calculating interest on the account balance.
 */
@Data
@Entity
@Table(name = "SavingsAccount")
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "balance")
    private double balance;

    /**
     * Calculates the interest on the account balance based on the interest rate.
     * The interest is added to the account balance.
     */
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
    }
}

