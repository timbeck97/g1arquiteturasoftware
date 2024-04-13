package com.apigateway.config;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

public class CustomAuthorizationFilter implements HandlerFilterFunction<ServerResponse, ServerResponse> {


    @Override
    public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
        if (request.pathVariable("name").equalsIgnoreCase("test")) {
            return ServerResponse.status(FORBIDDEN).build();
        }
        return next.handle(request);
    }
}