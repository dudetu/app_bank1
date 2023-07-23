package com.example.app_bank1.other_paymens.categories.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {


    private static final String CREDIT_CARD_REGEX = "^4\\d{15}|^5\\d{15}";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @OneToMany(mappedBy = "creditCard")
    private List<CreditCardTopUp> creditCardTopUps;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<CreditCardPayment> creditCardPayments;

    @OneToOne(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private CreditLimit creditLimit;

    @OneToMany(mappedBy = "creditCard")
    private List<BankStatementTransaction> bankStatementTransactions;

    /**
     * Performs a transaction on the credit card.
     *
     * @param amount      the amount of the transaction
     * @param description a description of the transaction
     * @throws IllegalArgumentException if the amount is not positive or there is insufficient credit limit
     */
    public void performTransaction(BigDecimal amount, String description) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }


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
