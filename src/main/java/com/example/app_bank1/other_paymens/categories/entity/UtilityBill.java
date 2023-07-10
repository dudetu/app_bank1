package com.example.app_bank1.other_paymens.categories.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a utility bill.
 */
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

    @Column(name = "bank_account_id")
    private Long bankAccountId;

    @Column(name = "card_number")
    private Boolean cardNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    /**
     * Gets the ID of the utility bill.
     *
     * @return The ID of the utility bill.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the utility bill.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the bill number of the utility bill.
     *
     * @return The bill number.
     */
    public String getBillNumber() {
        return billNumber;
    }

    /**
     * Sets the bill number for the utility bill.
     *
     * @param billNumber The bill number to set.
     */
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    /**
     * Gets the bank account ID associated with the utility bill.
     *
     * @return The bank account ID.
     */
    public Long getBankAccountId() {
        return bankAccountId;
    }

    /**
     * Sets the bank account ID for the utility bill.
     *
     * @param bankAccountId The bank account ID to set.
     */
    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    /**
     * Checks if the utility bill is associated with a card number.
     *
     * @return True if the utility bill is associated with a card number, false otherwise.
     */
    public Boolean getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets whether the utility bill is associated with a card number.
     *
     * @param cardNumber True if the utility bill is associated with a card number, false otherwise.
     */
    public void setCardNumber(Boolean cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the amount of the utility bill.
     *
     * @return The amount.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount for the utility bill.
     *
     * @param amount The amount to set.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the client account associated with the utility bill.
     *
     * @return The client account.
     */
    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    /**
     * Sets the client account for the utility bill.
     *
     * @param clientAccount The client account to set.
     */
    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }
}









