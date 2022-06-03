package com.tara.ForeignExchangeApplication.web.controller;

import com.tara.ForeignExchangeApplication.service.ConversionService;
import com.tara.ForeignExchangeApplication.service.ExchangeService;
import com.tara.ForeignExchangeApplication.service.ExchangeServiceV2;
import com.tara.ForeignExchangeApplication.service.model.Conversion;
import com.tara.ForeignExchangeApplication.service.model.ExchangeRate;
import com.tara.ForeignExchangeApplication.web.request.ConversionRequest;
import com.tara.ForeignExchangeApplication.web.request.ExchangeRateRequest;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/deneme")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DemoController {
    private final ExchangeService exchangeService;
    private final ExchangeServiceV2 exchangeServiceV2;
    private final ConversionService conversionService;

    @ApiOperation(value = "Create exchange demo")
    @GetMapping("/getInfo")
    public String getInfo() {
        return "uçusa hazır";
    }

    @ApiOperation(value = "Get exchange rate (version 1)")
    @GetMapping("/getRate/{source},{target}")
    public float getRate(@PathVariable("source") String source, @PathVariable("target") String target) throws Exception {
        return exchangeService.getExchangeRate(source, target);
    }

    @ApiOperation(value = "Get exchange rate (version 2)")
    @PostMapping("/getRate/")
    // burada success kontrolü ile sadece float mu dönsek
    public ExchangeRate getRate2(@RequestBody ExchangeRateRequest request) throws Exception {
        return exchangeServiceV2.getExchangeRate(request);
    }

    @ApiOperation(value = "Make conversion")
    @PostMapping("/convert/")
    public Conversion convert(@RequestBody ConversionRequest request) throws Exception {
        return conversionService.makeConversion(exchangeServiceV2.getExchangeRate(request.getExchangeRateRequest()), request);
    }
}
