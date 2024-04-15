package com.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
@Component("KeyResolverConfiguration")
public class KeyResolverConfiguration implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        System.out.println("IP ADDRESS: "+exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        Mono<Object> map = ReactiveSecurityContextHolder.getContext()
                .map(m -> m.getAuthentication())
                .map(m -> m.getPrincipal());
        Mono<String> login=map.map(m-> {
            Jwt jwt = (Jwt) m;
            String log=jwt.getClaims().get("preferred_username").toString();
            return log;
        });
        return login;
        //return Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }
}