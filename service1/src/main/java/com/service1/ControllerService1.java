package com.service1;

import jakarta.ws.rs.core.SecurityContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.stream.Collectors;

@RestController
public class ControllerService1 {


    @GetMapping("/message")
    public String test(Principal user) {
        return "SERVICO 1";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Scopes: " + authentication.getAuthorities();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Scopes: " + authentication.getAuthorities();
    }

}
