package com.example.app_bank1.other_paymens.categories.entity;



import com.example.app_bank1.other_paymens.categories.entity.Transactions.AccountGenerator;
import com.example.app_bank1.other_paymens.categories.entity.payments.BankAccountPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount extends AbstractPersistable<Long> {

    private static final String BANK_ACCOUNT_REGEX = "\\d{10}";

    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "bankAccount")
    private List<CreditCard> creditCards;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<BankAccountPayment> bankAccountPayments;

    @OneToMany(mappedBy = "bankAccount")
    private List<BankStatementTransaction> bankStatementTransactions;

    // Геттер для списка трансакций с банковского счета
    public List<BankStatementTransaction> getBankStatementTransactions() {
        return bankStatementTransactions;
    }

    /**
     * Sets the account number manually.
     *
     * @param accountNumber The account number to set.
     */
    public void setAccountNumberManually(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Метод для генерации номера банковского счета.
     * Вызывайте этот метод при необходимости сгенерировать новый номер счета.
     */
    public void generateAccountNumber() {
        AccountGenerator accountGenerator = new AccountGenerator();

        String generatedAccount;
        String generatedAccountNumber = accountGenerator.generateCustomBankAccountNumber(BANK_ACCOUNT_REGEX);
        setAccountNumber(generatedAccountNumber);
    }

    public Double getId(Long id) {
        return null;
    }

    /*
    public void getId(Long id) {
    }

     */
}

