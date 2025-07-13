
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1 id="head">Please sign up here!</h1>
        <form action="action" id="form">
            <h1>Enter your info</h1>
            <label for="studentNumber">Student Number:</label>
            <input type="text" id="studentNumber" name="studentNumber" class="input"><br><br>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" class="input"><br><br>
            <label for="Surname">Surname:</label>
            <input type="text" id="surname" name="surname" class="input"><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" class="input"><br><br>
            <label for="email">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" class="input"><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="input"><br><br>
            <input type="submit" value="Register" class="button" style="margin-left: 20px">
            <a href="login.jsp" style="margin-left: 40px; padding: 13px 10px; font-size: 18px;" class="link">Login</a>
        </form>
    </body>
</html>
