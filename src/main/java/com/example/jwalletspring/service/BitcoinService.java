package com.example.jwalletspring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class BitcoinService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public BitcoinService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String getCurrentPrice() {
        String url = "https://data-api.coindesk.com/index/cc/v1/latest/tick?market=cadli&instruments=BTC-USD";

        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            double price = root.path("Data")
                    .path("BTC-USD")
                    .path("VALUE")
                    .asDouble();
            return "Bitcoin price: $" + price;
        } catch (Exception e) {
            return "Error getting price: " + e.getMessage();
        }
    }
}
