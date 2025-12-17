package com.example.jwalletspring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteTransaction(id);
        return "Transaction with ID " + id + " removed successfully.";
    }
}
