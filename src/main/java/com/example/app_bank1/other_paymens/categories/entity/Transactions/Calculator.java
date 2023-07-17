package com.example.app_bank1.other_paymens.categories.entity.Transactions;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }
}


