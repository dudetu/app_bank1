package com.example.app_bank1.entites.account;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "ownerName")
    private String ownerName;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "balance")
    private double balance;


    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private  String phone;

    @Column(name = "email")
    private String email;


}
