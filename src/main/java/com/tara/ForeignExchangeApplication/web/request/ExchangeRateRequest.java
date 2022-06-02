package com.tara.ForeignExchangeApplication.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@AllArgsConstructor

public class ExchangeRateRequest {
    @Getter private final String sourceCurrency;
    @Getter private final String targetCurrency;
}
