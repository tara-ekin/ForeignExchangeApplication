package com.tara.ForeignExchangeApplication.service;

import org.springframework.stereotype.Service;

@Service
public interface ExchangeService {
    float getExchangeRate(String source, String target);
}
