package com.tara.ForeignExchangeApplication.dao;

import com.tara.ForeignExchangeApplication.service.model.Conversion;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository("Dao")
public class InMemoryConversionDataAccessService implements ConversionDao {
    private static List<Conversion> DB = new ArrayList<>();

    @Override
    public int insertConversion(Conversion conversion) {
        DB.add(conversion);
        return 1;
    }

    @Override
    public List<Conversion> selectAllTransactions() {
        return DB;
    }

    @Override
    public Optional<Conversion> selectTransactionById(UUID transactionId) {
        return DB.stream()
                .filter(conversion -> conversion.getTransactionId().equals(transactionId))
                .findFirst();
    }

    @Override
    public Stream<Conversion> selectTransactionByDate(LocalDate transactionDate) {
        return DB.stream()
                .filter(conversion -> conversion.getTransactionDate().equals(transactionDate));
    }
}
