package com.example.jwalletspring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitcoinService {
    private final RestTemplate restTemplate;

    public BitcoinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCurrentPrice() {
        String url = "https://data-api.coindesk.com/index/cc/v1/latest/tick?market=cadli&instruments=BTC-USD";

        return restTemplate.getForObject(url, String.class);
    }
}
