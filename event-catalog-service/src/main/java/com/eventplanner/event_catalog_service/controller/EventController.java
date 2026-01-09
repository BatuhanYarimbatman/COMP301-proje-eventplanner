package com.eventplanner.event_catalog_service.controller;

import com.eventplanner.event_catalog_service.model.Event;
import com.eventplanner.event_catalog_service.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events") // Tüm istekler bu adresle başlayacak
public class EventController {

    @Autowired
    private EventRepository repository;

    // 1. Tüm Etkinlikleri Listele
    @GetMapping
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    // 2. Yeni Etkinlik Ekle
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return repository.save(event);
    }

    // 3. Kategoriye Göre Listele
    @GetMapping("/category/{category}")
    public List<Event> getEventsByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }

    // 4. ID ile Etkinlik Getir
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
}
