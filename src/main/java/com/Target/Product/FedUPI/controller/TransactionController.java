package com.Target.Product.FedUPI.controller;

import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.junit.jupiter.api.AutoClose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Target.Product.FedUPI.dto.TransactionRequest;
import com.Target.Product.FedUPI.dto.TransactionResponse;
import com.Target.Product.FedUPI.services.TransactionService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

	  private static final Logger log = LoggerFactory.getLogger(TransactionController.class);
	  @Autowired
      private  TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createTransaction(@Valid @RequestBody TransactionRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Validate request
            
        	
        	log.info("Processing transaction: {}", request.getTxnId());

            TransactionResponse txnResponse = transactionService.processTransaction(request);

            response.put("statusCode", txnResponse.getStatus());
            response.put("statusDesc", txnResponse.getStatus());

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            log.error("Error processing transaction {}: {}", request.getTxnId(), e.getMessage(), e);
            response.put("statusCode", 500);
            response.put("statusDesc", "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

  /*  @GetMapping("/{txnId}")
    public ResponseEntity<Map<String, Object>> getTransaction(@PathVariable String txnId) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Validate txnId
            if (txnId == null || txnId.isEmpty()) {
                response.put("statusCode", 400);
                response.put("statusDesc", "txnId is required");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            log.info("Fetching transaction: {}", txnId);

            Transaction txn = transactionService.getTransactionById(txnId);
            if (txn == null) {
                response.put("statusCode", 404);
                response.put("statusDesc", "Transaction not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                response.put("statusCode", 200);
                response.put("statusDesc", "SUCCESS");
                response.put("transaction", txn);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            log.error("Error fetching transaction {}: {}", txnId, e.getMessage(), e);
            response.put("statusCode", 500);
            response.put("statusDesc", "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    */
}
