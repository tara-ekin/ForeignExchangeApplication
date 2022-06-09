package com.tara.ForeignExchangeApplication.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class ExchangeRate {
    private boolean success;
    private float rate;
    private LocalDate rateDate;
    private String errorMessage;
}
