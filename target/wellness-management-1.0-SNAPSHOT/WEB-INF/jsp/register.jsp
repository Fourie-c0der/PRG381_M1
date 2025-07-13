<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register - BC Student Wellness</title>
</head>
<body>
    <h2>Register</h2>
    <form action="RegisterServlet" method="post">
        Student Number: <input type="text" name="student_number" required><br>
        Name: <input type="text" name="name" required><br>
        Surname: <input type="text" name="surname" required><br>
        Email: <input type="email" name="email" required><br>
        Phone: <input type="text" name="phone" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Register">
    </form>
    <a href="login.jsp">Already have an account? Login</a>
</body>
</html>
