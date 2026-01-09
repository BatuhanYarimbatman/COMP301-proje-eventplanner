package com.eventplanner.booking_service.model; // Paket ismini kontrol edin

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;    // Hangi kullanıcı aldı?
    private String eventId; // Hangi etkinliğe aldı? (MongoDB ID'si String'dir)

    private LocalDate bookingDate;
    private String status; // "CONFIRMED", "CANCELLED"
}