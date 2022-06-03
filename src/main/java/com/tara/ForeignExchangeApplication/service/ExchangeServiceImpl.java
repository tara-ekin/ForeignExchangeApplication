package com.tara.ForeignExchangeApplication.service;

import com.tara.ForeignExchangeApplication.service.external.api.ExchangeRateApi;
import com.tara.ForeignExchangeApplication.web.request.ExchangeRateRequest;
import com.tara.ForeignExchangeApplication.web.response.ExchangeRateResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService{

    @Override
    public float getExchangeRate(String source, String target) {
        ExchangeRateRequest request = new ExchangeRateRequest(source, target);
        ExchangeRateApi rateApi = new ExchangeRateApi();

        ExchangeRateResponse response = rateApi.fetchExchangeRates(request);
        Map<String, Float> currencies = response.getRates().getCurrencies();
        float sourceRate = currencies.get(request.getSourceCurrency());
        float targetRate = currencies.get(request.getTargetCurrency());

        return targetRate/sourceRate;
    }
}
