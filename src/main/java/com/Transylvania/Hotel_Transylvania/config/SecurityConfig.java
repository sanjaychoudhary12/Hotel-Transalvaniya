package com.Transylvania.Hotel_Transylvania.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // ✅ Swagger
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/api-docs/**",
                                "/api-docs"
                        ).permitAll()
                        // ✅ Actuator (monitoring)
                        .requestMatchers(
                                "/actuator/**"
                        ).permitAll()
                        // 🔒 Everything else
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
