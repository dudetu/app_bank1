
package com.example.app_bank1.other_paymens.categories.entity;

import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Represents a bank account.
 */
@Data
@Entity
@Table(name = "bank_account")
public class BankAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<BankAccountPayment> bankAccountPayments;

    /**
     * Gets the ID of the bank account.
     *
     * @return The ID of the bank account.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the bank account.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the account number of the bank account.
     *
     * @return The account number of the bank account.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number of the bank account.
     *
     * @param accountNumber The account number to set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the client account associated with the bank account.
     *
     * @return The client account.
     */
    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    /**
     * Sets the client account for the bank account.
     *
     * @param clientAccount The client account to set.
     */
    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    /**
     * Gets the list of bank account payments associated with the bank account.
     *
     * @return The list of bank account payments.
     */
    public List<BankAccountPayment> getBankAccountPayments() {
        return bankAccountPayments;
    }

    /**
     * Sets the list of bank account payments for the bank account.
     *
     * @param bankAccountPayments The list of bank account payments to set.
     */
    public void setBankAccountPayments(List<BankAccountPayment> bankAccountPayments) {
        this.bankAccountPayments = bankAccountPayments;
    }
}

