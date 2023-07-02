package com.example.app_bank1.other_paymens.categories.entite;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Table(name = "payment")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "status")
    private String status;



    public Payment() {
    }

    public Payment(Long userId, BigDecimal amount, String status) {
        this.userId = userId;
        this.amount = amount;
        this.status = status;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

