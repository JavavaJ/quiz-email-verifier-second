package com.sendmequiz.quizemailverifiersecond.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class PingSender {

    private final WebClient.Builder webClientBuilder;

    public void google() {
        // just ping google web-site
        webClientBuilder.build()
            .get()
            .uri("https://www.google.com/");
    }
}