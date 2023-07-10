package com.example.app_bank1.other_paymens.categories.entity.payments;

import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a fine payment.
 */
@Data
@Entity
@Table(name = "fine_payments")
public class FinePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fine_number")
    private String fineNumber;

    @Column(name = "card_number")
    private Boolean cardNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    /**
     * Checks if the payment was successful.
     *
     * @return {@code true} if the payment was successful, {@code false} otherwise.
     */
    public boolean isSuccessful() {
        return false;
    }

    /**
     * Gets the user's email associated with the fine payment.
     *
     * @return The user's email.
     */
    public String getUserEmail() {
        return null;
    }

    /**
     * Sets the status of the fine payment.
     *
     * @param status The status to set.
     */
    public void setStatus(String status) {
    }

    /**
     * Gets the status of the fine payment.
     *
     * @return The status of the fine payment.
     */
    public String getStatus() {
        return null;
    }
}

