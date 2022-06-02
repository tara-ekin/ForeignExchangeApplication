package com.tara.ForeignExchangeApplication.web.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRates {
    private Map<String, Float> currencies;
    @JsonAnySetter
    public void setMap(String key, Float value) {
        if (currencies == null) {
            currencies = new LinkedHashMap<>();
        }
        currencies.put(key, value);
    }
}
