package com.eventplanner.user_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Veritabanında 'users' adında tablo oluşacak
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password; // Gerçekte şifreli olmalı, şimdilik düz metin

    // Boş Constructor (JPA için şart)
    public User() {
    }

    // Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter ve Setter'lar (IntelliJ'de Generate ile de yapabilirsiniz)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}