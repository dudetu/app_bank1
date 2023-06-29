package com.example.app_bank1.other_paymens.categories;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "utility_bills")
public class UtilityBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bill_number")
    private String billNumber;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;


    @Column(name = "card_number;")
    private String cardNumber;

    @Column(name = "amount")
    private BigDecimal amount;


}



