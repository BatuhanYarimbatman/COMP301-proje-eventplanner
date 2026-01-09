package com.eventplanner.payment_service.model; // Pakete dikkat

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;     // Ödemeyi yapan
    private Long bookingId;  // Hangi rezervasyon için?
    private Double amount;   // Tutar

    private LocalDateTime paymentDate;
    private String status; // "SUCCESS", "FAILED"
}
