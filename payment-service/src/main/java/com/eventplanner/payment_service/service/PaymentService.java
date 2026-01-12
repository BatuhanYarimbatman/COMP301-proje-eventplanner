package com.eventplanner.payment_service.service;

import com.eventplanner.payment_service.model.Payment;
import com.eventplanner.payment_service.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(Payment payment) {
        // Gerçek hayatta burada banka entegrasyonu olur.
        // Biz şimdilik veritabanına "Ödendi" diye kaydediyoruz.
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
