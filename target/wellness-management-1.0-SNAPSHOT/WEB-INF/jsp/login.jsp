<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - BC Student Wellness</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <a href="register.jsp">Don't have an account? Register</a>
</body>
</html>
