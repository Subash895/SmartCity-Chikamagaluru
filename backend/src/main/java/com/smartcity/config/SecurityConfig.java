package com.smartcity.config;
// This package stores configuration classes for the application.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// This tells Spring:
// "This class contains configuration settings."

public class SecurityConfig {

    @Bean
    // This creates a BCryptPasswordEncoder bean
    // so we can inject it anywhere (like in UserController).

    public BCryptPasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder is used to hash passwords securely.
        return new BCryptPasswordEncoder();
    }

    @Bean
    // This configures HTTP security settings.

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            // Disable CSRF (useful for testing APIs in Postman)

            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );
            // Allow all requests without authentication for now

        return http.build();
    }
}