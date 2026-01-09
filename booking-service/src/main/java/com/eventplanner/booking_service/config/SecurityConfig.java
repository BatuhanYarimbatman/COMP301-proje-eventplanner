package com.eventplanner.booking_service.config; // Paket ismini kendi projene göre düzelt!

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
        http
                .csrf(csrf -> csrf.disable()) // Postman için CSRF'i kapat
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // HİÇBİR ŞEY SORMA, HERKESE İZİN VER
                );

        return http.build();
    }
}