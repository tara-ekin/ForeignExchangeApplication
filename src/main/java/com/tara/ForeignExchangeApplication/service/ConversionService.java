package com.tara.ForeignExchangeApplication.service;

import com.tara.ForeignExchangeApplication.service.model.Conversion;
import com.tara.ForeignExchangeApplication.service.model.ExchangeRate;
import com.tara.ForeignExchangeApplication.web.request.ConversionRequest;
import org.springframework.stereotype.Service;

@Service
public interface ConversionService {
    Conversion makeConversion(ExchangeRate exchangeRate, ConversionRequest conversionRequest);
}
