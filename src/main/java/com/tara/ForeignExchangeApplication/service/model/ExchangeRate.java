package com.tara.ForeignExchangeApplication.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class ExchangeRate {
    private boolean success;
    private float rate;
    private String errorMessage;
}
