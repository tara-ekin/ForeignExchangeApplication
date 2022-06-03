package com.tara.ForeignExchangeApplication.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter @Setter
public class Conversion {
    private boolean success;
    private UUID transactionId;
    private String sourceCurrency;
    private String targetCurrency;
    private float sourceAmount;
    private float targetAmount;
    private float exchangeRate;
}
