package com.eventplanner.event_catalog_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PostgreSQL için Long ve Auto Increment

    private String name;
    private String description;
    private String location;
    private LocalDate date;

    public Event() {}

    public Event(String name, String description, String location, LocalDate date) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}