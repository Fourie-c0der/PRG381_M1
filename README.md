# BC Student Wellness Management System

This project is a Java web application for managing student wellness services at Belgium Campus. It includes:
- JSP-based login and registration system
- Servlets for authentication and registration
- PostgreSQL database integration

## Project Structure
- `src/main/webapp/` - JSP pages
- `src/main/java/com/bc/wellness/` - Servlet classes

## Setup
1. Configure PostgreSQL and create the `users` table (see below).
2. Update database connection details in the servlets.
3. Build and deploy the project on a servlet container (e.g., Tomcat).

## PostgreSQL Users Table
```
CREATE TABLE users (
    student_number VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL
);
```
