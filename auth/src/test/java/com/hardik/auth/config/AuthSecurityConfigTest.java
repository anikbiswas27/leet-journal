package com.hardik.auth.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.provisioning.UserDetailsManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuthSecurityConfigTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RegisteredClientRepository registeredClientRepository;

    @Autowired
    UserDetailsManager userDetailsManager;

    @Test
    void passwordEncoder_bean_created() {
        assertThat(passwordEncoder).isNotNull();
    }

    @Test
    void registeredClient_is_registered() {
        var client = registeredClientRepository.findByClientId("client");
        assertThat(client).isNotNull();
        assertThat(client.getClientId()).isEqualTo("client");
    }

    @Test
    void default_users_are_created() {
        assertThat(userDetailsManager.userExists("hardik")).isTrue();
        assertThat(userDetailsManager.userExists("xane")).isTrue();
        assertThat(userDetailsManager.userExists("sim")).isTrue();
    }
}