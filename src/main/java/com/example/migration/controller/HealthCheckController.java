package com.example.migration.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/migration")
public class HealthCheckController {

    private final RedisTemplate<String, Object> redisTemplate;

    public HealthCheckController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/status")
    public String checkStatus() {
        return "Spring Boot 4.1.1 & Java 25 Migration Wrapper Active - Framework 7 Core Ready!";
    }

    @PostMapping("/cache/{key}")
    public String testRedisWrite(@PathVariable String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Successfully wrote to Redis under Boot 4 / Jackson 3 serializer setup!";
    }
}
