package com.eventplanner.event_catalog_service.repository;

import com.eventplanner.event_catalog_service.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    // Standart metodlar (save, findAll vb.) otomatik gelir.
    // Ekstra olarak kategoriye göre arama ekleyelim:
    List<Event> findByCategory(String category);
}