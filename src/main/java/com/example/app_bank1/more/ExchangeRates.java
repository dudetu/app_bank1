package com.example.app_bank1.more;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRates {
    @Value("${exchange.rate.usd.to.eur}")
    private double usdToEurRate;

    @Value("${exchange.rate.eur.to.usd}")
    private double eurToUsdRate;



    public double convertUsdToEur(double usdAmount) {
        return usdAmount * usdToEurRate;
    }

    public double convertEurToUsd(double eurAmount) {
        return eurAmount * eurToUsdRate;
    }
}


