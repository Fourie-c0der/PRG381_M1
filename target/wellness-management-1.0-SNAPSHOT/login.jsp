
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Login Page</title>
    </head>
    <body>
        <h1 id="head">Welcome!!!</h1>
        <form action="action" id="form">
            <h1>Enter your info</h1>
            <label for="Username">Username:</label>
            <input type="text" id="Username" name="Username" class="input"><br><br>
            <label for="Password">Password:</label>
            <input type="password" id="Password" name="Password" class="input"><br><br>
            <input type="submit" value="Login" class="button" style="margin-left: 20px">
            <a href="register.jsp" style="margin-left: 40px; padding: 13px 10px; font-size: 18px;" class="link">Register</a>
        </form>
    </body>
</html>
