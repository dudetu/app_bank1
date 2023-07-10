package com.example.app_bank1.other_paymens.categories.entity.payments;

import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "payment_request")
public class PaymentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amoun")
    private BigDecimal amount;

    @Column(name = "users_id")
    private Long usersId;

    @Column(name = "bank_accoun")
    private Long bankAccount;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;


}
