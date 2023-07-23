package com.example.app_bank1.other_paymens.categories.entity.payments;

import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents an IBAN payment.
 */
@Data
@Entity
@Table(name = "iban_payments")
public class IbanPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "iban")
    private String iban;

    @Column(name = "bank_account")
    private Long bankAccount;

    @Column(name = "amount")
    private BigDecimal amount;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    /**
     * Gets the ID of the IBAN payment.
     *
     * @return The ID of the IBAN payment.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the IBAN payment.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the IBAN number associated with the payment.
     *
     * @return The IBAN number.
     */
    public String getIban() {
        return iban;
    }

    /**
     * Sets the IBAN number for the payment.
     *
     * @param iban The IBAN number to set.
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Gets the bank account number associated with the payment.
     *
     * @return The bank account number.
     */
    public Long getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the bank account number for the payment.
     *
     * @param bankAccount The bank account number to set.
     */
    public void setBankAccount(Long bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Gets the amount of the payment.
     *
     * @return The payment amount.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount for the payment.
     *
     * @param amount The payment amount to set.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the client account associated with the payment.
     *
     * @return The client account.
     */
    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    /**
     * Sets the client account for the payment.
     *
     * @param clientAccount The client account to set.
     */
    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }
}



