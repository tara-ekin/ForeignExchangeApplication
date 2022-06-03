package com.tara.ForeignExchangeApplication.service;

import com.tara.ForeignExchangeApplication.service.model.ExchangeRate;
import com.tara.ForeignExchangeApplication.web.request.ExchangeRateRequest;
import org.springframework.stereotype.Service;

@Service
public interface ExchangeServiceV2 {
    ExchangeRate getExchangeRate(ExchangeRateRequest exchangeRateRequest) throws Exception;
}
