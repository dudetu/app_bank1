package com.example.app_bank1.other_paymens.categories;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data

@Entity
@Table(name = "fine_payments")
public class FinePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = " fineNumber")
    private String fineNumber;

    @Column(name = "card_number;")
    private String cardNumber;

    @Column(name = "amount")
    private BigDecimal amount;


    public boolean isSuccessful() {
        return false;
    }

    public String getUserEmail() {
        return null;
    }

    public void setStatus(String paid) {
    }

    public String getStatus() {
        return null;
    }
}



