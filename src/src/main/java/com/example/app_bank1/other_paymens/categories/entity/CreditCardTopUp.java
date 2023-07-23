package com.example.app_bank1.other_paymens.categories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a credit card top-up.
 */
@Data
@Entity
@Table(name = "credit_card_top_ups")
public class CreditCardTopUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "user_email")
    private String userEmail;

    /**
     * Gets the ID of the credit card top-up.
     *
     * @return The ID of the credit card top-up.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the credit card top-up.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the credit card associated with the top-up.
     *
     * @return The credit card.
     */
    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the credit card for the top-up.
     *
     * @param creditCard The credit card to set.
     */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * Gets the amount of the top-up.
     *
     * @return The amount of the top-up.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the top-up.
     *
     * @param amount The amount to set.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the user email associated with the top-up.
     *
     * @return The user email.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the user email for the top-up.
     *
     * @param userEmail The user email to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

