package com.Target.Product.FedUPI.repository;

import org.springframework.stereotype.Repository;


import com.Target.Product.FedUPI.entity.TransactionEntiry;
import com.Target.Product.FedUPI.repository.mapper.TransactionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TransactionRepository {

	@Qualifier("transactionJdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${query.insert.transaction}")
    private String insertTransactionQuery;

    @Value("${query.select.transaction.byId}")
    private String selectTransactionByIdQuery;

    public void save(TransactionEntiry transaction) {
        jdbcTemplate.update(insertTransactionQuery,
                transaction.getTxnId(),
                transaction.getAmount(),
                transaction.getStatus(),
                LocalDateTime.now()
        );
    }

    public TransactionEntiry findById(String txnId) {
        List<TransactionEntiry> results = jdbcTemplate.query(selectTransactionByIdQuery, new TransactionRowMapper(), txnId);
        return results.isEmpty() ? null : results.get(0);
    }
}

