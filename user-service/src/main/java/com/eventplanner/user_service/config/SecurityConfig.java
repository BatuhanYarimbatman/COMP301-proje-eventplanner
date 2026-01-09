package com.eventplanner.user_service.config;

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
                // 1. CSRF Korumasını kapat (Postman/API testleri için gereklidir)
                .csrf(csrf -> csrf.disable())

                // 2. İzinleri ayarla
                .authorizeHttpRequests(auth -> auth
                        // "/users" ile başlayan her şeye izin ver (Register, Login vb.)
                        .requestMatchers("/users/**").permitAll()
                        // Geri kalan her şey için yine de kimlik sor (Opsiyonel)
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
