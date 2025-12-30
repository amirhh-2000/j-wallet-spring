package com.example.jwalletspring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;

@Service
public class BitcoinService {
    private final WebClient webClient;

    public BitcoinService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://data-api.coindesk.com").build();
    }

    public String getCurrentPrice() {
        return webClient.get()
                .uri("/index/cc/v1/latest/tick?market=cadli&instruments=BTC-USD")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(root -> {
                    double price = root.path("Data")
                            .path("BTC-USD")
                            .path("VALUE")
                            .asDouble();
                    return "Bitcoin price: $" + price;
                })
                .block();
    }
}
