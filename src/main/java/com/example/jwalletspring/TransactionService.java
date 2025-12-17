package com.example.jwalletspring;

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

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
