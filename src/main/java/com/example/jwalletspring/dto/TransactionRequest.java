package com.example.jwalletspring.dto;

import com.example.jwalletspring.TransactionType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TransactionRequest {

    @NotNull(message = "Type is required")
    private TransactionType type;

    @Min(value = 5, message = "Amounts must be at least 5$")
    private double amount;

    @NotBlank(message = "Category cannot be empty")
    private String category;
}
