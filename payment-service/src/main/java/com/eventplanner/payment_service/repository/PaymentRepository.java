package com.eventplanner.payment_service.repository;

import com.eventplanner.payment_service.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // HATA BURADAYDI: findByUserId yerine findByBookingId olmalı
    // Çünkü Payment entity'sinde 'userId' yok, 'bookingId' var.
    List<Payment> findByBookingId(Long bookingId);
}
