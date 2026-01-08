package com.hardik.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails {

    private final PasswordEncoder passwordEncoder;
    private final JdbcUserDetailsManager jdbcUserDetailsManager;

    CustomUserDetails(PasswordEncoder passwordEncoder, JdbcUserDetailsManager jdbcUserDetailsManager) {
        this.passwordEncoder = passwordEncoder;
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
    }

    public String newUser(String username, String password) {


        UserDetails user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();

        jdbcUserDetailsManager.createUser(user);

        return user.getUsername();
    }
}
