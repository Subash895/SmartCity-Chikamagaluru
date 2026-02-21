package com.smartcity.repository;
// This tells Java that this interface belongs to the "repository" package.
// Repository classes are used to interact with the database.

import org.springframework.data.jpa.repository.JpaRepository;
// This imports JpaRepository.
// JpaRepository provides built-in methods like:
// save(), findAll(), deleteById(), findById(), etc.

import com.smartcity.entity.User;
// This imports the User entity class.
// We connect this repository with the User table.

public interface UserRepository extends JpaRepository<User, Long> {
    // This means:
    // This repository works with:
    //   Entity type: User
    //   Primary key type: Long

    // Because of JpaRepository,
    // we automatically get:
    // save()
    // findAll()
    // findById()
    // deleteById()
    // and many more methods.

    User findByEmail(String email);
    // This is a custom query method.
    // Spring automatically understands:
    // "Find a user where email = ?"
    // We will use this later for login.
}