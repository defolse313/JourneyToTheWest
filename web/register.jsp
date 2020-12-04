<%-- 
    Document   : register
    Created on : Jul 1, 2020, 11:56:11 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(sun.jpg);  background-size: 100%">
    <center>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="header">
            <h1 style="color: #DE2B2B; font-family: 'Dancing Script'; font-size: 70px; font-weight: 700">Register</h1>
        </div>
        <div class="login">
            <form action="MainController" method="POST">
                <input type="text" name="txtUsername" value="${requestScope.UN}" placeholder="Username"> <br/> 
                <font color="tomato">${requestScope.INVALID.usernameError}${requestScope.DUP}</font> <br/> <br/>
                <input type="password" name="txtPassword" placeholder="Password"> <br/> 
                <font color="tomato">${requestScope.INVALID.passwordError}</font> <br/> <br/>
                <input type="text" name="txtFullname" value="${requestScope.FN}" placeholder="Fullname"> <br/> 
                <font color="tomato">${requestScope.INVALID.fullnameError}</font> <br/> <br/>
                <input type="text" name="txtDescript" value="${requestScope.DS}" placeholder="Description"> <br/> 
                <font color="tomato">${requestScope.INVALID.descriptError}</font> <br/> <br/>
                <input type="text" name="txtPhone" value="${requestScope.PH}" placeholder="Phone"> <br/>
                <font color="tomato">${requestScope.INVALID.phoneError}</font> <br/> <br/>
                <input type="text" name="txtEmail" value="${requestScope.EM}" placeholder="Email"> <br/>
                <font color="tomato">${requestScope.INVALID.emailError}</font> <br/> <br/>
                <input type="text" name="txtPicture" value="${requestScope.PT}" placeholder="Picture Link"> <br/>
                <font color="tomato">${requestScope.INVALID.pictureError}</font> <br/> <br/>
                Role: <select name="cbRole" value="${requestScope.RL}">
                    <option>Director</option> <br/>
                    <option>Caster</option> <br/>
                </select> <br/> <br/>
                <input type="submit" name="action" value="Register"/>
            </form>
            <br/> <br/> <br/>
            <a href="crewmanagement.jsp"><p style="color: #0080ff; font-size: 30px">Back to the Crew management here!</p></a>
        </div>
    </center>
</body>
</html>
