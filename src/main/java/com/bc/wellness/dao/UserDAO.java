package com.bc.wellness.dao;
//Data Access Object (DAO) for the User model.
//This class is responsible for all low-level communication with the PostgreSQL database.
/*It contains methods for creating new users, validating login credentials,
and checking for existing user records.
 */
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt; //for password hashing
import com.bc.wellness.model.User;

public class UserDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/StudentDB";
    private final String dbUser = "postgres";
    private final String dbPassword = "ProgrammerBliss";

    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO Students (student_number, name, surname, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            stmt.setString(1, user.getStudentNumber());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, hashedPassword);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    public boolean userExists(String email, String studentNumber) throws SQLException {
        String sql = "SELECT 1 FROM Students WHERE email = ? OR student_number = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, studentNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public User validateUser(String email, String password) throws SQLException {
        String sql = "SELECT * FROM Students WHERE email = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedHashedPassword = rs.getString("password"); // Retrieve the hashed password

                    // Verify the provided password against the stored hashed password
                    if (BCrypt.checkpw(password, storedHashedPassword)) {
                        // If passwords match, create and return the User object
                        return new User(
                            rs.getString("student_number"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("phone"), 
                            storedHashedPassword // Store the hashed password in the User object
                        );
                    }    
                }
            } catch(SQLException e){
                System.err.println("Error validating user: " + e.getMessage());
                throw e;
            }
        }
        return null;
    }
}
