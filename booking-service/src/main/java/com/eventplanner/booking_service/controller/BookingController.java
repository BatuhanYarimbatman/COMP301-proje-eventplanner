package com.eventplanner.booking_service.controller;

import com.eventplanner.booking_service.client.EventCatalogClient; // Import
import com.eventplanner.booking_service.model.Booking;
import com.eventplanner.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException; // Hata fırlatmak için

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private EventCatalogClient eventClient; // <-- Feign Client'ı enjekte ettik

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody Booking booking) {

        // 1. Event Service'e sor: Bu ID'li etkinlik var mı?
        try {
            Object event = eventClient.getEventById(booking.getEventId());
            if (event == null) {
                throw new RuntimeException("Etkinlik bulunamadı!");
            }
        } catch (Exception e) {
            // Eğer Event Service hata dönerse veya bulamazsa 404 fırlat
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Böyle bir etkinlik yok: " + booking.getEventId());
        }

        // 2. Varsa işleme devam et
        booking.setBookingDate(LocalDate.now());
        booking.setStatus("CONFIRMED");
        return repository.save(booking);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return repository.findByUserId(userId);
    }
}
