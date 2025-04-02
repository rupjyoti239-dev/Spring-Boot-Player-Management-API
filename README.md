Spring Boot Player Management API

📌 Introduction

This is a Spring Boot REST API for managing players. It includes validation, exception handling, and CRUD operations.

🚀 Features

  ✅Create, Read, Update, and Delete (CRUD) operations for players

  ✅Data validation using DTOs and Jakarta Validation

  ✅Global exception handling with @RestControllerAdvice

  ✅Uses Spring Data JPA and H2 Database (or MySQL)

📌 End Points  
    GET         /player/list         Get all players

    GET        /player/view/{id}    Get a player by ID

    POST      /player/create       Create a new player

    PUT       /player/update/{id}   Update player

    DELETE   /player/delete/{id}    Delete player
