package com.tara.ForeignExchangeApplication.service;

import com.tara.ForeignExchangeApplication.service.external.api.ExchangeRateApi;
import com.tara.ForeignExchangeApplication.web.request.ExchangeRateRequest;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService{

    @Override
    public float getExchangeRate(String source, String target) {
        ExchangeRateRequest request = new ExchangeRateRequest(source, target);
        ExchangeRateApi rateApi = new ExchangeRateApi();
        return rateApi.getExchangeRate(request);
    }
}
