package com.example.jwalletspring.service;

import com.example.jwalletspring.Transaction;
import com.example.jwalletspring.TransactionRepository;
import com.example.jwalletspring.dto.TransactionRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction saveTransaction(TransactionRequest request) {
        Transaction t = Transaction.builder()
                .amount(request.getAmount())
                .type(request.getType())
                .category(request.getCategory())
                .build();

        return repository.save(t);
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
