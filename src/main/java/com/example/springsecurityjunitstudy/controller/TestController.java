package com.example.springsecurityjunitstudy.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableGlobalMethodSecurity(securedEnabled = true)
public class TestController {

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(value = "/user")
    public SecurityMessage user() {
        return SecurityMessage.builder()
                .message("user page")
                .auth(SecurityContextHolder.getContext().getAuthentication())
                .build();
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping(value = "admin")
    public SecurityMessage admin() {
        return SecurityMessage.builder()
                .message("admin page")
                .auth(SecurityContextHolder.getContext().getAuthentication())
                .build();
    }
}