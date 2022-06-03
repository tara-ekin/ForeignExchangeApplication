package com.tara.ForeignExchangeApplication.service.external.api;

import com.tara.ForeignExchangeApplication.service.model.Conversion;
import com.tara.ForeignExchangeApplication.service.model.ExchangeRate;
import com.tara.ForeignExchangeApplication.web.request.ConversionRequest;


import java.util.UUID;

public class ConversionApi {

    public Conversion makeConversion(ExchangeRate exchangeRate, ConversionRequest request) {
        Conversion conversion = new Conversion();

        conversion.setSourceCurrency(request.getExchangeRateRequest().getSourceCurrency());
        conversion.setTargetCurrency(request.getExchangeRateRequest().getTargetCurrency());
        conversion.setSourceAmount(request.getSourceAmount());

        if(exchangeRate.isSuccess()) {
            conversion.setExchangeRate(exchangeRate.getRate());
            conversion.setTargetAmount(request.getSourceAmount() * conversion.getExchangeRate());
            conversion.setTransactionId(UUID.randomUUID());
            conversion.setSuccess(true);
        }
        else {
            conversion.setSuccess(false);
        }

        return conversion;
    }
}
