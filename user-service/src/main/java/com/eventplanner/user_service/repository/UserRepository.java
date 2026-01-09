package com.eventplanner.user_service.repository; // Paket ismini kontrol edin

import com.eventplanner.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Giriş işlemi için kullanıcı adına göre bulma metodu
    Optional<User> findByUsername(String username);
}