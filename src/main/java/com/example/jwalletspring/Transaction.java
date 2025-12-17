package com.example.jwalletspring;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private double amount;
    private String category;
    private LocalDateTime createdAt;

    public Transaction(TransactionType type, double amount, String category) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.createdAt = LocalDateTime.now();
    }
}
