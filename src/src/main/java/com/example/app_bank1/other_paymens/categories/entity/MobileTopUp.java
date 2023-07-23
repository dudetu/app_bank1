package com.example.app_bank1.other_paymens.categories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a mobile top-up transaction.
 */
@Data
@Entity
@Table(name = "mobile_top_ups")
public class MobileTopUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "card_number")
    private Boolean cardNumber;

    @Column(name = "amount")
    private BigDecimal amount;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    /**
     * Gets the ID of the mobile top-up transaction.
     *
     * @return The ID of the mobile top-up transaction.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the mobile top-up transaction.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the phone number associated with the mobile top-up transaction.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number for the mobile top-up transaction.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Checks if the mobile top-up is associated with a card number.
     *
     * @return True if the mobile top-up is associated with a card number, false otherwise.
     */
    public Boolean getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets whether the mobile top-up is associated with a card number.
     *
     * @param cardNumber True if the mobile top-up is associated with a card number, false otherwise.
     */
    public void setCardNumber(Boolean cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the amount of the mobile top-up transaction.
     *
     * @return The amount.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount for the mobile top-up transaction.
     *
     * @param amount The amount to set.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the client account associated with the mobile top-up transaction.
     *
     * @return The client account.
     */
    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    /**
     * Sets the client account for the mobile top-up transaction.
     *
     * @param clientAccount The client account to set.
     */
    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    /**
     * Gets the credit card associated with the mobile top-up transaction.
     *
     * @return The credit card.
     */
    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the credit card for the mobile top-up transaction.
     *
     * @param creditCard The credit card to set.
     */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}

