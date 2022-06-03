package com.tara.ForeignExchangeApplication.service.external.api;

import com.sun.istack.internal.NotNull;
import com.tara.ForeignExchangeApplication.web.request.ExchangeRateRequest;
import com.tara.ForeignExchangeApplication.web.response.ExchangeRateResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExchangeRateApi {

    private String exchangeRatesAddress = "http://api.exchangeratesapi.io/api/latest?access_key=e988295081908c15b2ac2a1a78b96480&symbols=";

    private RestTemplate restTemplate = new RestTemplate();

    public ExchangeRateResponse fetchExchangeRates(@NotNull ExchangeRateRequest request) {
        String address = exchangeRatesAddress.concat((request.getSourceCurrency()) + "," + request.getTargetCurrency());
        ResponseEntity<ExchangeRateResponse> responseEntity = restTemplate.exchange(address, HttpMethod.GET,
                null, ExchangeRateResponse.class, "1");

        return responseEntity.getBody();
    }
}
