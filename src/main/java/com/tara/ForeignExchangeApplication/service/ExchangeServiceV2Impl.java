package com.tara.ForeignExchangeApplication.service;

import com.tara.ForeignExchangeApplication.service.external.api.ExchangeRateApi;
import com.tara.ForeignExchangeApplication.service.model.ExchangeRate;
import com.tara.ForeignExchangeApplication.web.request.ExchangeRateRequest;
import com.tara.ForeignExchangeApplication.web.response.ExchangeRateResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeServiceV2Impl implements ExchangeServiceV2{
    @Override
    public ExchangeRate getExchangeRate(ExchangeRateRequest exchangeRateRequest) throws Exception {
        ExchangeRateApi rateApi = new ExchangeRateApi();
        ExchangeRate exchangeRate = new ExchangeRate();

        try {

            ExchangeRateResponse response = rateApi.fetchExchangeRates(exchangeRateRequest);

            Map<String, Float> currencies = response.getRates().getCurrencies();
            float sourceRate = currencies.get(exchangeRateRequest.getSourceCurrency());
            float targetRate = currencies.get(exchangeRateRequest.getTargetCurrency());

            exchangeRate.setRate(targetRate/sourceRate);
            exchangeRate.setRateDate(response.getDate());
            exchangeRate.setSuccess(true);

        } catch (Exception e) {

            exchangeRate.setSuccess(false);
            exchangeRate.setErrorMessage("Hatalı birim girildi");

        }


        return exchangeRate;
    }
}
