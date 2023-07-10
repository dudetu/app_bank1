package com.example.app_bank1.other_paymens.categories.entity.payments;

import com.example.app_bank1.other_paymens.categories.entity.CreditCards;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCards creditCard;

    /**
     * Checks if the payment was successful.
     *
     * @return {@code true} if the payment was successful, {@code false} otherwise.
     */
    public boolean isSuccessful() {
        return false;
    }
}


