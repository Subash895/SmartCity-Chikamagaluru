package com.smartcity.controller;
// This file belongs to the controller package.
// Controllers handle HTTP requests (GET, POST, PUT, DELETE).

import org.springframework.web.bind.annotation.*;
// Imports annotations like @RestController, @GetMapping, etc.

import org.springframework.beans.factory.annotation.Autowired;
// Used to automatically inject dependencies (like repository).

import java.util.List;
// Used because we return List<Place>.

import com.smartcity.entity.Place;
// Importing Place entity (represents places table).

import com.smartcity.repository.PlaceRepository;
// Importing repository (used to access database).

@RestController
// This tells Spring:
// "This class handles REST API requests and returns JSON."

@RequestMapping("/api/places")
// This sets the base URL for this controller.
// All methods inside this class will start with:
// http://localhost:8080/api/places

@CrossOrigin
// Allows frontend (React, etc.) to call this backend.
// Without this, browser may block requests.

public class PlaceController {

    @Autowired
    // Spring automatically creates PlaceRepository object
    // and injects it here.

    private PlaceRepository placeRepository;
    // This is used to interact with the database.

    // ================= GET ALL =================
    @GetMapping
    // This handles GET request:
    // GET http://localhost:8080/api/places

    public List<Place> getAllPlaces() {
        // Calls database and returns all rows from places table.
        return placeRepository.findAll();
    }

    // ================= ADD NEW =================
    @PostMapping
    // Handles POST request:
    // POST http://localhost:8080/api/places

    public Place addPlace(@RequestBody Place place) {
        // @RequestBody converts JSON → Place object.
        // Then save() inserts it into database.
        return placeRepository.save(place);
    }

    // ================= DELETE =================
    @DeleteMapping("/{id}")
    // Handles DELETE request:
    // DELETE http://localhost:8080/api/places/5

    public void deletePlace(@PathVariable Long id) {
        // @PathVariable takes ID from URL.
        // deleteById removes that row from database.
        placeRepository.deleteById(id);
    }

    // ================= UPDATE =================
    @PutMapping("/{id}")
    // Handles PUT request:
    // PUT http://localhost:8080/api/places/5

    public Place updatePlace(@PathVariable Long id,
                             @RequestBody Place updatedPlace) {

        // First find existing place by ID.
        // If not found, throw error.
        Place existingPlace = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found"));

        // Update values with new data
        existingPlace.setName(updatedPlace.getName());
        existingPlace.setCategory(updatedPlace.getCategory());
        existingPlace.setLatitude(updatedPlace.getLatitude());
        existingPlace.setLongitude(updatedPlace.getLongitude());

        // Save updated data back into database.
        return placeRepository.save(existingPlace);
    }
}