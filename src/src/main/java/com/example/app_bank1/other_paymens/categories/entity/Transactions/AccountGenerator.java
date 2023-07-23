package com.example.app_bank1.other_paymens.categories.entity.Transactions;

import java.util.Random;

public class AccountGenerator {
    private static final String BANK_ACCOUNT_REGEX = "\\d{10}"; // Regular expression for a 10-digit bank account number
    private static final String CREDIT_CARD_REGEX = "\\d{16}"; // Regular expression for a 16-digit credit card number

    private static final String VISA_PREFIX = "4";
    private static final String MASTERCARD_PREFIX = "5";

    private final Random random;

    public AccountGenerator() {
        random = new Random();
    }

    /**
     * Generate a random bank account number.
     *
     * @return the generated bank account number
     */
    public String generateBankAccountNumber() {
        StringBuilder builder = new StringBuilder();

        while (builder.length() < 10) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        return builder.toString();
    }

    /**
     * Generate a random credit card number.
     *
     * @param cardType the type of credit card (e.g., "visa", "mastercard")
     * @return the generated credit card number
     */
    public String generateCreditCardNumber(String cardType) {
        StringBuilder builder = new StringBuilder();

        String prefix = "";

        if (cardType.equalsIgnoreCase("visa")) {
            prefix = VISA_PREFIX;
        } else if (cardType.equalsIgnoreCase("mastercard")) {
            prefix = MASTERCARD_PREFIX;
        }

        builder.append(prefix);

        while (builder.length() < 16) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        return builder.toString();
    }

    /**
     * Generate a random bank account number that matches the specified regex pattern.
     *
     * @param regexPattern the regex pattern for the bank account number
     * @return the generated bank account number
     */
    public String generateCustomBankAccountNumber(String regexPattern) {
        String generatedNumber = generateBankAccountNumber();

        while (!generatedNumber.matches(regexPattern)) {
            generatedNumber = generateBankAccountNumber();
        }

        return generatedNumber;
    }

    /**
     * Generate a random credit card number that matches the specified regex pattern.
     *
     * @param regexPattern the regex pattern for the credit card number
     * @param cardType     the type of credit card (e.g., "visa", "mastercard")
     * @return the generated credit card number
     */
    public String generateCustomCreditCardNumber(String regexPattern, String cardType) {
        String generatedNumber = generateCreditCardNumber(cardType);

        while (!generatedNumber.matches(regexPattern)) {
            generatedNumber = generateCreditCardNumber(cardType);
        }

        return generatedNumber;
    }

    public static void main(String[] args) {
        AccountGenerator accountGenerator = new AccountGenerator();

        for (int i = 0; i < 1         ; i++) {
            String bankAccountNumber = accountGenerator.generateBankAccountNumber();
            System.out.println("Bank Account Number: " + bankAccountNumber);

            String visaCardNumber = accountGenerator.generateCreditCardNumber("visa");
            System.out.println("Visa Card Number: " + visaCardNumber);

            String mastercardNumber = accountGenerator.generateCreditCardNumber("mastercard");
            System.out.println("Mastercard Number: " + mastercardNumber);
        }


    }
}
