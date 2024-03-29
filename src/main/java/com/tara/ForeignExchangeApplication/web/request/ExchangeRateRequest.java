package com.tara.ForeignExchangeApplication.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
public class ExchangeRateRequest {
    private final String sourceCurrency;
    private final String targetCurrency;
}
