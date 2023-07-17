package com.example.app_bank1.other_paymens.categories.entity.Transactions;


import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "expense")
    private BigDecimal expense;

    @Column(name = "amount")
    private BigDecimal amount;



    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;


}
