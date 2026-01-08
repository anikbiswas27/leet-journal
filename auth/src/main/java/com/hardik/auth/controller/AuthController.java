package com.hardik.auth.controller;

import com.hardik.auth.CustomUserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
class AuthController {

    private final CustomUserDetails customUserDetails;

    AuthController(CustomUserDetails customUserDetails) {
        this.customUserDetails = customUserDetails;
    }

    @GetMapping()
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        String user = customUserDetails.newUser(username, password);

        return "name: " + user;
    }
}
