package com.Target.Product.FedUPI.repository.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.Target.Product.FedUPI.entity.TransactionEntiry;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<TransactionEntiry> {

    @Override
    public TransactionEntiry mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionEntiry txn = new TransactionEntiry();
        txn.setTxnId(rs.getString("txn_id"));
        txn.setAmount(rs.getDouble("amount"));
        txn.setStatus(rs.getString("status"));
       // txn.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return txn;
    }
}

