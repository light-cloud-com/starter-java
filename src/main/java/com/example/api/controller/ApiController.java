package com.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/")
    public Map<String, Object> root() {
        return Map.of(
            "message", "Welcome to your Java API",
            "version", "1.0.0",
            "endpoints", Map.of(
                "health", "/health",
                "root", "/"
            )
        );
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        long uptime = ManagementFactory.getRuntimeMXBean().getUptime() / 1000;
        return Map.of(
            "status", "healthy",
            "timestamp", Instant.now().toString(),
            "uptime", uptime
        );
    }
}
