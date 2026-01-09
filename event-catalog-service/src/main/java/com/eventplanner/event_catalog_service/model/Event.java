package com.eventplanner.event_catalog_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "events") // MongoDB'de 'events' koleksiyonuna kaydedilecek
@Data // Lombok: Getter, Setter, toString vb. otomatik oluşturur
@AllArgsConstructor // Tüm parametreli constructor
@NoArgsConstructor // Parametresiz constructor
public class Event {
    @Id
    private String id;
    private String title;
    private String category;
    private LocalDate date;
    private String location;
    private Integer capacity;
}