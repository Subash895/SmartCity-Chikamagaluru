package com.smartcity.entity;  
// This tells Java that this class belongs to the package "entity".
// We usually keep database-related classes inside an entity package.

import jakarta.persistence.*;  
// This imports JPA (Hibernate) annotations like @Entity, @Id, etc.
// These annotations help connect Java with the database.

@Entity  
// This tells Spring Boot:
// "This class should be stored in the database as a table."

@Table(name = "users")  
// This tells Hibernate:
// "Map this class to the table called 'users' in MySQL."
// If you remove this, it will use table name "user" by default.

public class User {

    @Id  
    // This marks the primary key of the table.

    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    // This tells database to auto-generate ID (AUTO_INCREMENT in MySQL).

    private Long id;  
    // This represents the "id" column in the users table.


    private String name;  
    // This represents the "name" column in the database.
    // Each user will have a name.


    @Column(unique = true)  
    // This adds a UNIQUE constraint to the email column.
    // It means two users cannot have the same email.

    private String email;  
    // This represents the email column in database.


    private String password;  
    // This stores the user password.
    // (In real applications, we hash passwords before storing.)


    private String role;  
    // This stores the role of the user.
    // Example: "USER", "ADMIN"
    // This helps decide what permissions a user has.


    // ===== GETTERS =====
    // Getters are used to READ values from this object.

    public Long getId() { 
        return id; 
    }
    // Returns the id value.


    public String getName() { 
        return name; 
    }
    // Returns the name value.


    public String getEmail() { 
        return email; 
    }
    // Returns the email value.


    public String getPassword() { 
        return password; 
    }
    // Returns the password value.


    public String getRole() { 
        return role; 
    }
    // Returns the role value.


    // ===== SETTERS =====
    // Setters are used to CHANGE values in this object.

    public void setName(String name) { 
        this.name = name; 
    }
    // Sets the name value.


    public void setEmail(String email) { 
        this.email = email; 
    }
    // Sets the email value.


    public void setPassword(String password) { 
        this.password = password; 
    }
    // Sets the password value.


    public void setRole(String role) { 
        this.role = role; 
    }
    // Sets the role value.
}