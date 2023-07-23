package com.example.app_bank1.more;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class represents the exchange rates between USD and EUR currencies.
 * It provides methods to convert amounts between USD and EUR based on the defined rates.
 */
@Component
public class ExchangeRates {

    @Value("${exchange.rate.usd.to.eur}")
    private double usdToEurRate;

    @Value("${exchange.rate.eur.to.usd}")
    private double eurToUsdRate;

    /**
     * Converts the specified amount from USD to EUR based on the exchange rate.
     *
     * @param usdAmount the amount in USD to convert
     * @return the converted amount in EUR
     */
    public double convertUsdToEur(double usdAmount) {
        return usdAmount * usdToEurRate;
    }

    /**
     * Converts the specified amount from EUR to USD based on the exchange rate.
     *
     * @param eurAmount the amount in EUR to convert
     * @return the converted amount in USD
     */
    public double convertEurToUsd(double eurAmount) {
        return eurAmount * eurToUsdRate;
    }
}



