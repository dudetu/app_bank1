package com.example.app_bank1.other_paymens.categories.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a credit limit for a credit card.
 */
@Data
@Entity
@Table(name = "credit_limit")
public class CreditLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "card_number")
    private Boolean cardNumber;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @OneToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCards creditCard;

    /**
     * Gets the ID of the credit limit.
     *
     * @return The ID of the credit limit.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the credit limit.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Checks if the credit card is associated with the credit limit.
     *
     * @return True if the credit card is associated, false otherwise.
     */
    public Boolean getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets whether the credit card is associated with the credit limit.
     *
     * @param cardNumber True if the credit card is associated, false otherwise.
     */
    public void setCardNumber(Boolean cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the credit limit amount.
     *
     * @return The credit limit amount.
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the credit limit amount.
     *
     * @param creditLimit The credit limit amount to set.
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Gets the credit card associated with the credit limit.
     *
     * @return The credit card.
     */
    public CreditCards getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the credit card for the credit limit.
     *
     * @param creditCard The credit card to set.
     */
    public void setCreditCard(CreditCards creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * Gets the credit limit value.
     *
     * @return The credit limit value.
     */
    public Long getLimit() {
        return null;
    }

    /**
     * Gets the currency of the credit limit.
     *
     * @return The currency.
     */
    public Boolean getCurrency() {
        return null;
    }
}



