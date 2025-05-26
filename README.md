# Project Overview

This Spring Boot REST API project implements a fully functional backend for an eCommerce application, covering all core entities with complete CRUD operations.

## Features

### User Management
* User registration and login (basic authentication)
* Role field included (e.g., `USER`, `ADMIN`) for future security enhancements

### Profile Management
* One-to-one linked profile per user
* Update profile details like name and phone

### Product Management
* CRUD operations for products
* Each product is linked to a category

### Category Management
* Admin CRUD for product categories
* Categories group products logically

### Address Management
* Users can add, update, retrieve, and delete multiple addresses
* One-to-many relationship between users and addresses

## Tech Stack & Tools
* Spring Boot (Spring MVC, Spring Data JPA)
* SQL Server database
* RESTful API design
* Java Persistence API (JPA) for ORM
* Basic validation annotations (`@NotNull`, `@Email`, etc.)
* Global exception handling with `RuntimeException`
* Layered architecture: Controller, Service, Repository

## What Was Learned
* Building a REST API with layered architecture
* Implementing CRUD operations for multiple related entities
* Using JPA and Hibernate for ORM with SQL Server
* Basic user authentication setup
* Entity relationships:
  * OneToOne (User - Profile)
  * ManyToOne (Product - Category)
  * OneToMany (User - Addresses)
* Input validation and exception handling
