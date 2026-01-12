package com.eventplanner.booking_service.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // İlişkisel veritabanı olsa da mikroserviste nesne değil ID tutarız!
    private Long userId;
    private Long eventId;

    private LocalDateTime bookingDate;
    private String status; // CONFIRMED, CANCELLED, PENDING

    public Booking() {
        this.bookingDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Booking(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
        this.bookingDate = LocalDateTime.now();
        this.status = "CONFIRMED"; // Şimdilik direkt onaylı yapalım
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}