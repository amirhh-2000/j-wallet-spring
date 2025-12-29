package com.example.jwalletspring;

import com.example.jwalletspring.dto.TransactionRequest;
import com.example.jwalletspring.service.BitcoinService;
import com.example.jwalletspring.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;
    private final BitcoinService bitcoinService;

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

    @GetMapping("/btc")
    public String bitcoinPrice() {
        return bitcoinService.getCurrentPrice();
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
