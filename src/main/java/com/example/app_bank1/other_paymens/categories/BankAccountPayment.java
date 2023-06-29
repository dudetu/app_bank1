package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bank_account_payments")
public class BankAccountPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "amount")
    private BigDecimal amount;




}



