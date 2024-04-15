package com.apigateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConnectionValidator {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisConnectionValidator(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean validateConnection() {
        try {
            // Tente realizar uma operação básica com o Redis
            stringRedisTemplate.opsForValue().set("connection_check", "test");
            String value = stringRedisTemplate.opsForValue().get("connection_check");
            return "test".equals(value);
        } catch (Exception e) {
            // Se ocorrer uma exceção, a conexão com o Redis falhou
            e.printStackTrace();
            return false;
        }
    }
}
