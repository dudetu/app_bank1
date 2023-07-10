package com.example.app_bank1.other_paymens.categories.entity;

import com.example.app_bank1.other_paymens.categories.entity.payments.FinePayment;
import com.example.app_bank1.other_paymens.categories.entity.payments.IbanPayment;
import com.example.app_bank1.other_paymens.categories.entity.payments.PaymentRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Represents a client account.
 */
@Data
@Entity
@Table(name = "client_account")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner_name")
    private String ownerName;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<BankAccounts> bankAccounts;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<CreditCards> creditCards;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<FinePayment> finePayments;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<IbanPayment> ibanPayments;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<MobileTopUp> mobileTopUps;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<PaymentRequest> paymentRequests;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<UtilityBill> utilityBills;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL)
    private List<AccountTransfer> accountTransfers;

    /**
     * Gets the ID of the client account.
     *
     * @return The ID of the client account.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the client account.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the owner name of the client account.
     *
     * @return The owner name of the client account.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the owner name of the client account.
     *
     * @param ownerName The owner name to set.
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Gets the list of bank accounts associated with the client account.
     *
     * @return The list of bank accounts.
     */
    public List<BankAccounts> getBankAccounts() {
        return bankAccounts;
    }

    /**
     * Sets the list of bank accounts for the client account.
     *
     * @param bankAccounts The list of bank accounts to set.
     */
    public void setBankAccounts(List<BankAccounts> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    /**
     * Gets the list of credit cards associated with the client account.
     *
     * @return The list of credit cards.
     */
    public List<CreditCards> getCreditCards() {
        return creditCards;
    }

    /**
     * Sets the list of credit cards for the client account.
     *
     * @param creditCards The list of credit cards to set.
     */
    public void setCreditCards(List<CreditCards> creditCards) {
        this.creditCards = creditCards;
    }

    /**
     * Gets the list of fine payments associated with the client account.
     *
     * @return The list of fine payments.
     */
    public List<FinePayment> getFinePayments() {
        return finePayments;
    }

    /**
     * Sets the list of fine payments for the client account.
     *
     * @param finePayments The list of fine payments to set.
     */
    public void setFinePayments(List<FinePayment> finePayments) {
        this.finePayments = finePayments;
    }

    /**
     * Gets the list of IBAN payments associated with the client account.
     *
     * @return The list of IBAN payments.
     */
    public List<IbanPayment> getIbanPayments() {
        return ibanPayments;
    }

    /**
     * Sets the list of IBAN payments for the client account.
     *
     * @param ibanPayments The list of IBAN payments to set.
     */
    public void setIbanPayments(List<IbanPayment> ibanPayments) {
        this.ibanPayments = ibanPayments;
    }

    /**
     * Gets the list of mobile top-ups associated with the client account.
     *
     * @return The list of mobile top-ups.
     */
    public List<MobileTopUp> getMobileTopUps() {
        return mobileTopUps;
    }

    /**
     * Sets the list of mobile top-ups for the client account.
     *
     * @param mobileTopUps The list of mobile top-ups to set.
     */
    public void setMobileTopUps(List<MobileTopUp> mobileTopUps) {
        this.mobileTopUps = mobileTopUps;
    }

    /**
     * Gets the list of payment requests associated with the client account.
     *
     * @return The list of payment requests.
     */
    public List<PaymentRequest> getPaymentRequests() {
        return paymentRequests;
    }

    /**
     * Sets the list of payment requests for the client account.
     *
     * @param paymentRequests The list of payment requests to set.
     */
    public void setPaymentRequests(List<PaymentRequest> paymentRequests) {
        this.paymentRequests = paymentRequests;
    }

    /**
     * Gets the list of utility bills associated with the client account.
     *
     * @return The list of utility bills.
     */
    public List<UtilityBill> getUtilityBills() {
        return utilityBills;
    }

    /**
     * Sets the list of utility bills for the client account.
     *
     * @param utilityBills The list of utility bills to set.
     */
    public void setUtilityBills(List<UtilityBill> utilityBills) {
        this.utilityBills = utilityBills;
    }

    /**
     * Gets the list of account transfers associated with the client account.
     *
     * @return The list of account transfers.
     */
    public List<AccountTransfer> getAccountTransfers() {
        return accountTransfers;
    }

    /**
     * Sets the list of account transfers for the client account.
     *
     * @param accountTransfers The list of account transfers to set.
     */
    public void setAccountTransfers(List<AccountTransfer> accountTransfers) {
        this.accountTransfers = accountTransfers;
    }
}



