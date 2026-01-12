package com.eventplanner.booking_service.service;

import com.eventplanner.booking_service.client.EventCatalogClient;
import com.eventplanner.booking_service.client.UserClient;
import com.eventplanner.booking_service.dto.EventDTO;
import com.eventplanner.booking_service.dto.UserDTO;
import com.eventplanner.booking_service.model.Booking;
import com.eventplanner.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final EventCatalogClient eventCatalogClient; // <--- Yeni Eklendi

    // Constructor Injection (Hepsini buraya ekliyoruz)
    public BookingService(BookingRepository bookingRepository, UserClient userClient, EventCatalogClient eventClient) {
        this.bookingRepository = bookingRepository;
        this.userClient = userClient;
        this.eventCatalogClient = eventClient;
    }

    public Booking createBooking(Booking booking) {
        // 1. User Kontrolü
        UserDTO user = userClient.getUserById(booking.getUserId());
        System.out.println("Kullanıcı doğrulandı: " + user.getUsername());

        // 2. Event Kontrolü (YENİ)
        // Eğer event yoksa, Event Service hata fırlatır ve işlem burada durur.
        EventDTO event = eventCatalogClient.getEventById(booking.getEventId());
        System.out.println("Etkinlik doğrulandı: " + event.getName());

        // 3. Her şey tamsa kaydet
        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
