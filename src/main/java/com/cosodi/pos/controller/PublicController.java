package com.cosodi.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/public")
public class PublicController {

    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of(
            "status", "UP",
            "message", "Public endpoint - No authentication required",
            "timestamp", System.currentTimeMillis()
        );
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        return Map.of(
            "application", "Point of Sale System",
            "version", "1.0.0",
            "authentication", "Basic Auth required for protected endpoints",
            "public_endpoints", "/api/v1/public/**",
            "protected_endpoints", "/api/v1/** (except public)"
        );
    }
} 