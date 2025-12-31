package com.example.jwalletspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BitcoinResponse {
    private Double price;
    private LocalDateTime updateAt;
}
