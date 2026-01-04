package com.example.jwalletspring.service;

import com.example.jwalletspring.Transaction;
import com.example.jwalletspring.TransactionRepository;
import com.example.jwalletspring.TransactionType;
import com.example.jwalletspring.dto.TransactionRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @Mock
    private TransactionRepository repository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void should_save_transaction_successfully() {
        TransactionRequest request = new TransactionRequest();
        request.setAmount(5000.0);
        request.setType(TransactionType.valueOf("INCOME"));
        request.setCategory("Salary");

        Transaction savedTxMock = Transaction.builder()
                .id(1L)
                .amount(5000.0)
                .type(TransactionType.valueOf("INCOME"))
                .createdAt(LocalDateTime.now())
                .build();

        when(repository.save(any(Transaction.class))).thenReturn(savedTxMock);

        Transaction result = transactionService.saveTransaction(request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getAmount()).isEqualTo(5000.0);
    }
}