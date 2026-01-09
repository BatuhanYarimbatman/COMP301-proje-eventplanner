package com.eventplanner.payment_service.controller;

import com.eventplanner.payment_service.model.Payment;
import com.eventplanner.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment processPayment(@RequestBody Payment payment) {
        // Gerçek hayatta burada banka entegrasyonu olur.
        // Biz simülasyon yapıyoruz:
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("SUCCESS");
        return repository.save(payment);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUser(@PathVariable Long userId) {
        return repository.findByUserId(userId);
    }
}