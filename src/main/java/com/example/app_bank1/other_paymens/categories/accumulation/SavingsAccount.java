package com.example.app_bank1.other_paymens.categories.accumulation;


import jakarta.persistence.*;
import lombok.Data;


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


    // Метод для расчета процентов
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
    }

}
