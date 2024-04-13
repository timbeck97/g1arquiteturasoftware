package com.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.awt.image.DataBuffer;

//@Configuration
public class RouteConfig {
    //@Autowired
    private TokenRelayGatewayFilterFactory filterFactory;
    //@Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("sevice1module", r -> r.path("/service1/**")
                        .filters(f -> f.filter(filterFactory.apply()))
//                        .filters(f -> f.requestRateLimiter(c -> c
//                                .setRateLimiter(redisRateLimiter())
//                                .setKeyResolver(hostNameKeyResolver())))
                        .uri("http://127.0.0.1:8081"))
                .route("sevice2module", r -> r.path("/service2/**")
                        .filters(f -> f.filter(filterFactory.apply()))
//                        .filters(f -> f.requestRateLimiter(c -> c
//                                .setRateLimiter(redisRateLimiter())
//                                .setKeyResolver(hostNameKeyResolver())))
                        .uri("http://127.0.0.1:8082"))
                .route("authmodule", r -> r.path("/**")
                        .filters(f -> f.filter(filterFactory.apply()))
//                        .filters(f -> f.requestRateLimiter(c -> c
//                                .setRateLimiter(redisRateLimiter())
//                                .setKeyResolver(hostNameKeyResolver())))
                        .uri("http://127.0.0.1:8080"))
                .build();
    }

//    @Bean
//    public RedisRateLimiter redisRateLimiter() {
//        return new RedisRateLimiter(10, 20);
//    }
//    @Bean
//    public KeyResolver hostNameKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }
//    @Bean
//    public GatewayFilterFactory<RequestRateLimiterGatewayFilterFactory.Config> rateLimiterFilter() {
//        return new RequestRateLimiterGatewayFilterFactory( redisRateLimiter(), hostNameKeyResolver()) {
//            public Mono<Void> denyResponse(ServerWebExchange exchange, String key) {
//                org.springframework.http.server.reactive.ServerHttpResponse response = exchange.getResponse();
//                response.setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
//                response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//                return response.writeWith(Mono.just(response.bufferFactory().wrap("{\"message\":\"Too many requests\"}".getBytes())));
//
//            }
//        };
//    }
}
