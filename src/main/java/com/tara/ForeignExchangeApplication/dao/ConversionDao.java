package com.tara.ForeignExchangeApplication.dao;

import com.tara.ForeignExchangeApplication.service.model.Conversion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface ConversionDao {
    int insertConversion(Conversion conversion);

    List<Conversion> selectAllTransactions();

    Optional<Conversion> selectTransactionById(UUID transactionId);

    Stream<Conversion> selectTransactionByDate(LocalDate transactionDate);
}
