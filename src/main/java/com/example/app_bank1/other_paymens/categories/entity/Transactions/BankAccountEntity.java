package com.example.app_bank1.other_paymens.categories.entity.Transactions;


import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "bank_account_entity")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "parent_bank_account_id")
    private BankAccountEntity parentBankAccount;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<BankAccountPayment> bankAccountPayments;

}
