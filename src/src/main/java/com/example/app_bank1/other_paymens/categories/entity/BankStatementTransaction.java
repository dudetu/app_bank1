package com.example.app_bank1.other_paymens.categories.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Represents a bank statement transaction entity.
 */
@Data
@Entity
@Table(name = "bank_statement_transaction")
public class BankStatementTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    // Дополнительные поля, которые могут понадобиться, например, статус транзакции

    /**
     * Default constructor for BankStatementTransaction.
     */
    public BankStatementTransaction() {
    }

    /**
     * Gets the ID of the bank statement transaction.
     *
     * @return The ID of the bank statement transaction.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the bank statement transaction.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }


}

