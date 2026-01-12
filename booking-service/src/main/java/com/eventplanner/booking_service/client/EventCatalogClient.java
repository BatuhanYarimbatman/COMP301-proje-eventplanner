package com.eventplanner.booking_service.client;

import com.eventplanner.booking_service.dto.EventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// İsim, event-catalog-service'in application.properties dosyasındaki isimle AYNI olmalı!
@FeignClient(name = "event-catalog-service")
public interface EventCatalogClient {

    @GetMapping("/events/{id}")
    EventDTO getEventById(@PathVariable("id") Long id);
}
