package com.tara.ForeignExchangeApplication.web.controller;

import com.tara.ForeignExchangeApplication.service.ExchangeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/deneme")
@RestController
public class DemoController {
    private final ExchangeService exchangeService;

    @Autowired
    public DemoController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @ApiOperation(value = "Create exchange demo")
    @GetMapping("/getInfo")
    public String getInfo() {
        return "uçusa hazır";
    }

    @ApiOperation(value = "Get exchange rate")
    @GetMapping("/getRate/{source},{target}")
    public float getRate(@PathVariable("source") String source, @PathVariable("target") String target) {
        return exchangeService.getExchangeRate(source, target);
    }
}
