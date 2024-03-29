package com.tara.ForeignExchangeApplication.web.controller;

import com.tara.ForeignExchangeApplication.dao.ConversionDao;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@RequestMapping("/deneme")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DemoController {
    private final ExchangeService exchangeService;
    private final ExchangeServiceV2 exchangeServiceV2;
    private final ConversionService conversionService;
    private final ConversionDao conversionDao;          // bunun yeri burası mı?

    @ApiOperation(value = "Create exchange demo")
    @GetMapping("/info")
    public String getInfo() {
        return "uçusa hazır";
    }

    @ApiOperation(value = "Get exchange rate (version 1)")
    @GetMapping("/rate/{source},{target}")
    public float getRate(@PathVariable("source") String source, @PathVariable("target") String target) throws Exception {
        return exchangeService.getExchangeRate(source, target);
    }

    @ApiOperation(value = "Get exchange rate (version 2)")
    @PostMapping("/rate")
    // burada success kontrolü ile sadece float mu dönsek
    public ExchangeRate getRate2(@RequestBody ExchangeRateRequest request) throws Exception {
        return exchangeServiceV2.getExchangeRate(request);
    }

    @ApiOperation(value = "Make conversion")
    @PostMapping("/conversion")
    public Conversion convert(@RequestBody ConversionRequest request) throws Exception {
        Conversion conversion = conversionService.makeConversion(exchangeServiceV2.getExchangeRate(request.getExchangeRateRequest()), request);
        if (conversion.isSuccess()) {
            conversionDao.insertConversion(conversion);
        }
        return conversion;
    }

    @ApiOperation(value = "List all conversions made")
    @GetMapping("/list")
    public List<Conversion> listAllConversions() {
        return conversionDao.selectAllTransactions();
    }

    @ApiOperation(value = "Filter conversions by ID")
    @GetMapping("/conversion-by-id/{id}")
    public Optional<Conversion> getConversionById(@PathVariable("id") UUID id) {
        return conversionDao.selectTransactionById(id);
        // "No such transaction" diye bir mesaj ekleyebiliriz. şu an bu durumda null dönüyor.
    }

    @ApiOperation(value = "Filter conversions by date")
    @GetMapping("/conversions-by-date/{date}")
    public Stream<Conversion> getConversionByDate(/*@Validated*/ @PathVariable("date")
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                    LocalDate date) {
        // geçersiz tarihler için hata mesajı dönmeliyiz
        return conversionDao.selectTransactionByDate(date);
    }
}
