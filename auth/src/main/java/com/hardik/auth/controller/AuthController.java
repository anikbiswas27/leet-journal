package com.hardik.auth.controller;

import com.hardik.auth.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public String auth(Authentication authentication) {
        return "hello: " + authentication.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {


        return customUserDetails.newUser(username, password);
    }

}
