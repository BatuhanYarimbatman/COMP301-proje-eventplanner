package com.eventplanner.user_service.model; // Paket isminizi kendi projenize göre düzeltin!

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users") // PostgreSQL'de 'users' tablosu oluşacak
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // İleride şifreli (hashed) saklayacağız

    @Column(unique = true, nullable = false)
    private String email;

    private String role; // "USER", "ADMIN" vb.
}