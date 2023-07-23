package com.example.app_bank1.other_paymens.categories.entity;

import com.example.app_bank1.other_paymens.categories.entity.CreditCard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a credit card payment.
 */
@Data
@Entity
@Table(name = "credit_card_payments")
public class CreditCardPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "credit_card_number")
    private Boolean creditCardNumber;

    @Column(name = "amount")
    private BigDecimal amount;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    public CreditCardPayment(BigDecimal amount, String description, LocalDateTime now, CreditCard creditCard) {
    }

    public CreditCardPayment() {

    }

    /**
     * Checks if the payment was successful.
     *
     * @return {@code true} if the payment was successful, {@code false} otherwise.
     */
    public boolean isSuccessful() {
        return false;
    }
}


