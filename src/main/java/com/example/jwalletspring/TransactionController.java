package com.example.jwalletspring;

import com.example.jwalletspring.dto.TransactionRequest;
import jakarta.validation.Valid;
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
    public Transaction create(@Valid @RequestBody TransactionRequest request) {
        return service.saveTransaction(request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteTransaction(id);
        return "Transaction with ID " + id + " removed successfully.";
    }
}
