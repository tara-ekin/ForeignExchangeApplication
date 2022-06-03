package com.tara.ForeignExchangeApplication.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class ConversionRequest {
    private ExchangeRateRequest exchangeRateRequest;
    private float sourceAmount;
}
