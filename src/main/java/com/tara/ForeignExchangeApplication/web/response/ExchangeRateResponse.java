package com.tara.ForeignExchangeApplication.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ExchangeRateResponse {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("timestamp")
    private int timestamp;

    @JsonProperty("base")
    private String base;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("rates")
    private ExchangeRates rates;

    // {"success":true,"timestamp":1653551643,"base":"EUR","date":"2022-05-26","rates":{"EUR":1,"TRY":17.523638}}
}
