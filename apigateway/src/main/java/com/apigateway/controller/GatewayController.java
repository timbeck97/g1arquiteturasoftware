package com.apigateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GatewayController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(GatewayController.class);



    @GetMapping("/token")
    public Mono<String> foo() {
        Mono<Object> map = ReactiveSecurityContextHolder.getContext()
                .map(m -> m.getAuthentication())
                .map(m -> m.getPrincipal());
        System.out.println(map);
        return map.map(m -> {
            if (m instanceof OAuth2User) {
                return ((OAuth2User) m).getAuthorities().toString();
            } else if (m instanceof OAuth2AuthenticatedPrincipal) {
                return ((OAuth2AuthenticatedPrincipal) m).getAuthorities().toString();
            } else if (m instanceof BearerTokenAuthentication) {
                return ((BearerTokenAuthentication) m).getAuthorities().toString();
            }else if(m instanceof Jwt){
                Jwt jwt = (Jwt) m;
                System.out.println(jwt.getClaims());
                System.out.println();
                System.out.println(jwt.getClaims().get("preferredUsername"));
                return jwt.getClaims().get("preferred_username").toString();
            } else {
                System.out.println(m.getClass());
                return m.toString();
            }
        });
        }


}
