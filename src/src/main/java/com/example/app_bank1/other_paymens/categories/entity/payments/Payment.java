package com.example.app_bank1.other_paymens.categories.entity.payments;


import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a payment.
 */
@Data
@Table(name = "payment")
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "users_id")
    private Long usersId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "status")
    private String status;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    /**
     * Gets the ID of the payment.
     *
     * @return The ID of the payment.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the payment.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the ID of the user associated with the payment.
     *
     * @return The ID of the user.
     */
    public Long getUsersId() {
        return usersId;
    }

    /**
     * Sets the ID of the user associated with the payment.
     *
     * @param usersId The ID of the user to set.
     */
    public void setUsersId(Long usersId) {
        this.usersId = usersId;
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
     * Gets the status of the payment.
     *
     * @return The payment status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status for the payment.
     *
     * @param status The payment status to set.
     */
    public void setStatus(String status) {
        this.status = status;
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


