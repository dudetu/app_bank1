package com.example.app_bank1.other_paymens.categories.accumulation;

public class SavingsAccount {
    private Long id;

    private String accountNumber;
    private String ownerName;
    private double interestRate;
    private double balance;

    public SavingsAccount() {
    }

    // Конструкторы, геттеры и сеттеры

    // Метод для расчета процентов
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
    }
}


