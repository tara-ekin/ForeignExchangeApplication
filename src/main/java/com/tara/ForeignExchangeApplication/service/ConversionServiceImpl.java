package com.tara.ForeignExchangeApplication.service;

import com.tara.ForeignExchangeApplication.service.external.api.ConversionApi;
import com.tara.ForeignExchangeApplication.service.model.Conversion;
import com.tara.ForeignExchangeApplication.service.model.ExchangeRate;
import com.tara.ForeignExchangeApplication.web.request.ConversionRequest;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService{
    @Override
    public Conversion makeConversion(ExchangeRate exchangeRate, ConversionRequest conversionRequest) {
        ConversionApi conversionApi = new ConversionApi();

        return conversionApi.makeConversion(exchangeRate, conversionRequest);
    }
}
