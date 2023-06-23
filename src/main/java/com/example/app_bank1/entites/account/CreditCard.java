package com.example.app_bank1.entites.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;




    @Entity
    public class CreditCard {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String cardNumber;
        private String ownerName;
        private LocalDate expirationDate;
        private double creditLimit;
        private double balance;

        // Конструкторы, геттеры и сеттеры

        // Методы
    }


