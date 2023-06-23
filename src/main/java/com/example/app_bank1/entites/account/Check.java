package com.example.app_bank1.entites.account;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Check {
    @Entity
    public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String accountNumber;
        private String ownerName;
        private String accountType;
        private double balance;

        // Конструкторы, геттеры и сеттеры

        // Методы
    }

}
