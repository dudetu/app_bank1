package com.example.app_bank1.other_paymens.categories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents an account transfer.
 */
@Data
@Entity
@Table(name = "account_transfers")
public class AccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "source_account")
    private String sourceAccount;

    @Column(name = "destination_account")
    private Long destinationAccount;

    @Column(name = "card_number")
    private Boolean cardNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "users_id")
    private Long usersId;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    /**
     * Gets the ID of the account transfer.
     *
     * @return The ID of the account transfer.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the account transfer.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the source account number for the transfer.
     *
     * @return The source account number.
     */
    public String getSourceAccount() {
        return sourceAccount;
    }

    /**
     * Sets the source account number for the transfer.
     *
     * @param sourceAccount The source account number to set.
     */
    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    /**
     * Gets the destination account number for the transfer.
     *
     * @return The destination account number.
     */
    public Long getDestinationAccount() {
        return destinationAccount;
    }

    /**
     * Sets the destination account number for the transfer.
     *
     * @param destinationAccount The destination account number to set.
     */
    public void setDestinationAccount(Long destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    /**
     * Checks if the transfer is associated with a card number.
     *
     * @return True if the transfer is associated with a card number, false otherwise.
     */
    public Boolean getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets whether the transfer is associated with a card number.
     *
     * @param cardNumber True if the transfer is associated with a card number, false otherwise.
     */
    public void setCardNumber(Boolean cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the amount of the transfer.
     *
     * @return The transfer amount.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount for the transfer.
     *
     * @param amount The transfer amount to set.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the ID of the user associated with the transfer.
     *
     * @return The ID of the user.
     */
    public Long getUsersId() {
        return usersId;
    }

    /**
     * Sets the ID of the user associated with the transfer.
     *
     * @param usersId The ID of the user to set.
     */
    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    /**
     * Gets the client account associated with the transfer.
     *
     * @return The client account.
     */
    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    /**
     * Sets the client account for the transfer.
     *
     * @param clientAccount The client account to set.
     */
    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    /**
     * This method is empty because it is not required for the current functionality of the application.
     * It can be implemented in the future if needed.
     *
     * @param userId The ID of the user to set.
     */
    public void setUserId(long userId) {
        // This method is intentionally left empty.
        // It can be implemented in the future if needed.
    }
}



