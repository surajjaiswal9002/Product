package com.Target.Product.FedUPI.services;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Target.Product.FedUPI.dto.TransactionRequest;
import com.Target.Product.FedUPI.dto.TransactionResponse;
import com.Target.Product.FedUPI.entity.TransactionEntiry;
import com.Target.Product.FedUPI.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class TransactionService {
	
	private final static Logger log = LoggerFactory.getLogger(TransactionService.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RedisTemplate<String, TransactionEntiry> redisTemplate;

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String EXTERNAL_SERVICE_URL = "http://external-service:8081/api/process";

    public TransactionResponse processTransaction(TransactionRequest request) {
        TransactionResponse response = new TransactionResponse();
        try {
            log.info("Processing transaction: {}", request.getTxnId());

            // Create Transaction entity
            TransactionEntiry txn = new TransactionEntiry();
            txn.setTxnId(request.getTxnId());
            txn.setAmount(request.getAmount());
            txn.setStatus("PENDING");

            // Save to Redis asynchronously
            executorService.submit(() -> {
                try {
                    redisTemplate.opsForValue().set(request.getTxnId(), txn);
                    log.info("Saved transaction {} to Redis", request.getTxnId());
                } catch (Exception e) {
                    log.error("Error saving transaction {} to Redis: {}", request.getTxnId(), e.getMessage());
                }
            });

            // Save to DB asynchronously
            executorService.submit(() -> {
                try {
                    transactionRepository.save(txn);
                    log.info("Saved transaction {} to DB", request.getTxnId());
                } catch (Exception e) {
                    log.error("Error saving transaction {} to DB: {}", request.getTxnId(), e.getMessage());
                }
            });

            // Send to external service (e.g., XML format)
            executorService.submit(() -> {
                try {
                    String xmlPayload = "<transaction><txnId>" + request.getTxnId() + "</txnId><amount>" + request.getAmount() + "</amount></transaction>";
                    String ack = restTemplate.postForObject(EXTERNAL_SERVICE_URL, xmlPayload, String.class);
                    log.info("Received ack for transaction {}: {}", request.getTxnId(), ack);

                    // Update status based on ack
                    txn.setStatus("SUCCESS");
                    transactionRepository.save(txn);
                    redisTemplate.opsForValue().set(request.getTxnId(), txn);

                } catch (Exception e) {
                    log.error("Error sending transaction {} to external service: {}", request.getTxnId(), e.getMessage());
                    txn.setStatus("FAILED");
                }
            });

            response.setStatCode(200);
            response.setStatus("Transaction is being processed asynchronously");

        } catch (Exception e) {
            log.error("Error processing transaction {}: {}", request.getTxnId(), e.getMessage());
            response.setStatCode(500);
            response.setStatus("Internal Server Error");
        }

        return response;
    }

    /**
     * Fetch transaction by txnId
     */
    public TransactionEntiry getTransactionById(String txnId) {
        // First check Redis
        TransactionEntiry txn = redisTemplate.opsForValue().get(txnId);
        if (txn != null) {
            return txn;
        }
        // Otherwise fetch from DB
        return transactionRepository.findById(txnId);
    }
}

