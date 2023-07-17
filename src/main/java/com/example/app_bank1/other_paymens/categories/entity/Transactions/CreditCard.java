package com.example.app_bank1.other_paymens.categories.entity.Transactions;


import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "credit_card_number")
    private String creditCardNumber;



    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;


}

