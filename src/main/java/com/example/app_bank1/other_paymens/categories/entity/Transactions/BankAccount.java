package com.example.app_bank1.other_paymens.categories.entity.Transactions;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "bank_account")

public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "sourceAccount")
    private List<Transfer> outgoingTransfers;

    @OneToMany(mappedBy = "destinationAccount")
    private List<Transfer> incomingTransfers;

    // Дополнительные геттеры и сеттеры
}

@Entity
class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private BankAccount sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private BankAccount destinationAccount;

    // Дополнительные геттеры и сеттеры
}




