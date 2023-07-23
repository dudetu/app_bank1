package com.example.app_bank1.other_paymens.categories.entity.payments;

import com.example.app_bank1.other_paymens.categories.entity.BankAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Represents a bank account payment.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bank_account_payments")
public class BankAccountPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bank_account_number")
    private Long bankAccountNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    /**
     * Returns the ID of the user.
     *
     * @return The ID of the user.
     */
    public Object getUsersId() {
        Object o = null;
        return o;
    }

    /**
     * Returns the bank account associated with the payment.
     *
     * @return The bank account associated with the payment.
     */
    public Object getBankAccount() {
        return null;
    }
}



