/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  kekan
 * Created: 12 Jul 2025
 */

CREATE TABLE IF NOT EXISTS Students(--create a Students table in PostgreSQL
--The table will store student information of those who have registered
    student_number VARCHAR(50) PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(10),
    password VARCHAR(255) NOT NULL
);
--Adding an index on the student number column for faster lookup
CREATE INDEX IF NOT EXISTS idx_users_student_number ON users (student_number);
--Adding an index on the email column for faster lookup as well
CREATE INDEX IF NOT EXISTS idx_users_email ON users (email);