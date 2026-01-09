package com.eventplanner.booking_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// name = "event-catalog-service": Eureka'da kayıtlı olan ismin AYNISI olmalı
@FeignClient(name = "event-catalog-service")
public interface EventCatalogClient {

    // Karşı servisteki çağırmak istediğimiz metodun imzasını aynen yazıyoruz
    @GetMapping("/events/{id}")
    Object getEventById(@PathVariable("id") String id);
    // Not: Dönüş tipini şimdilik 'Object' yaptık, normalde DTO (Data Transfer Object) kullanılır.
}
