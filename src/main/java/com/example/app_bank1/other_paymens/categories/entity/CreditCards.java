package com.example.app_bank1.other_paymens.categories.entity;

import com.example.app_bank1.other_paymens.categories.entity.payments.CreditCardPayment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Represents a credit card.
 */
@Data
@Entity
@Table(name = "credit_card")
public class CreditCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @ManyToOne
    @JoinColumn(name = "parent_credit_card_id")
    private CreditCards parentCreditCard;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @OneToMany(mappedBy = "creditCard")
    private List<CreditCardTopUp> creditCardTopUps;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<CreditCardPayment> creditCardPayments;

    @OneToOne(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private CreditLimit creditLimit;

    /**
     * Gets the ID of the credit card.
     *
     * @return The ID of the credit card.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the credit card.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the credit card number.
     *
     * @return The credit card number.
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Sets the credit card number.
     *
     * @param creditCardNumber The credit card number to set.
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Gets the parent credit card, if any.
     *
     * @return The parent credit card.
     */
    public CreditCards getParentCreditCard() {
        return parentCreditCard;
    }

    /**
     * Sets the parent credit card.
     *
     * @param parentCreditCard The parent credit card to set.
     */
    public void setParentCreditCard(CreditCards parentCreditCard) {
        this.parentCreditCard = parentCreditCard;
    }

    /**
     * Gets the client account associated with the credit card.
     *
     * @return The client account.
     */
    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    /**
     * Sets the client account for the credit card.
     *
     * @param clientAccount The client account to set.
     */
    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    /**
     * Gets the list of credit card top-ups associated with the credit card.
     *
     * @return The list of credit card top-ups.
     */
    public List<CreditCardTopUp> getCreditCardTopUps() {
        return creditCardTopUps;
    }

    /**
     * Sets the list of credit card top-ups for the credit card.
     *
     * @param creditCardTopUps The list of credit card top-ups to set.
     */
    public void setCreditCardTopUps(List<CreditCardTopUp> creditCardTopUps) {
        this.creditCardTopUps = creditCardTopUps;
    }

    /**
     * Gets the list of credit card payments associated with the credit card.
     *
     * @return The list of credit card payments.
     */
    public List<CreditCardPayment> getCreditCardPayments() {
        return creditCardPayments;
    }

    /**
     * Sets the list of credit card payments for the credit card.
     *
     * @param creditCardPayments The list of credit card payments to set.
     */
    public void setCreditCardPayments(List<CreditCardPayment> creditCardPayments) {
        this.creditCardPayments = creditCardPayments;
    }

    /**
     * Gets the credit limit associated with the credit card.
     *
     * @return The credit limit.
     */
    public CreditLimit getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the credit limit for the credit card.
     *
     * @param creditLimit The credit limit to set.
     */
    public void setCreditLimit(CreditLimit creditLimit) {
        this.creditLimit = creditLimit;
    }
}

