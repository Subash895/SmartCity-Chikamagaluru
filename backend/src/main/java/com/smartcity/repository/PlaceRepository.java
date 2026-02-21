package com.smartcity.repository;
// This file belongs to repository package.
// Repository classes are responsible for talking to the database.

import org.springframework.data.jpa.repository.JpaRepository;
// This is the main interface from Spring Data JPA.
// It already contains ready-made database methods.

import com.smartcity.entity.Place;
// We import the Place entity (represents places table).

public interface PlaceRepository extends JpaRepository<Place, Long> {
    // This interface connects Place entity to database.
    
    // Place → Entity type (table name = places)
    // Long  → Type of primary key (id is Long)
    
    // We don't write any code here.
    // JpaRepository automatically gives us many methods.
}