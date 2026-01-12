package com.eventplanner.payment_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId; // Hangi rezervasyon için?
    private Double amount;
    private LocalDateTime paymentDate;
    private String status; // SUCCESS, FAILED

    public Payment() {
        this.paymentDate = LocalDateTime.now();
        this.status = "SUCCESS"; // Şimdilik hep başarılı varsayalım
    }

    public Payment(Long bookingId, Double amount) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
        this.status = "SUCCESS";
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
