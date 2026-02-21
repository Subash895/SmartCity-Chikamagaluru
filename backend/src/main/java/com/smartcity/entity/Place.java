package com.smartcity.entity;
// This class belongs to the "entity" package.
// Entity classes represent database tables.

import jakarta.persistence.*;
// Import JPA annotations like @Entity, @Id, etc.

@Entity
// This tells Spring Boot:
// "This class should be mapped to a database table."

@Table(name = "places")
// This tells Hibernate:
// "Use the table named 'places' in MySQL."

public class Place {

    @Id
    // Marks this field as PRIMARY KEY.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This tells database to auto-generate ID (AUTO_INCREMENT in MySQL).

    private Long id;
    // Represents the id column in places table.


    private String name;
    // Represents the name column.


    private String category;
    // Represents the category column.
    // Example: MARKET, TOURIST, etc.


    private Double latitude;
    // Stores latitude value (map coordinate).


    private Double longitude;
    // Stores longitude value (map coordinate).


    // ===== GETTERS =====
    // Used to READ values from this object.

    public Long getId() {
        return id;
    }
    // Returns id value.


    public String getName() {
        return name;
    }
    // Returns name value.


    public String getCategory() {
        return category;
    }
    // Returns category value.


    public Double getLatitude() {
        return latitude;
    }
    // Returns latitude value.


    public Double getLongitude() {
        return longitude;
    }
    // Returns longitude value.


    // ===== SETTERS =====
    // Used to CHANGE values in this object.

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}