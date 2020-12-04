<%-- 
    Document   : index
    Created on : Jun 30, 2020, 1:22:56 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="index.css">
        <title>JSP Page</title>
    </head>
    <body>          
        <div class="body"></div>
        <div class="grad"></div>
        <div class="header">
            <div>Journey to the <span>West</span></div>
        </div>
        <br/>
        <div class="login">
            <form action="MainController" method="POST">
                <input type="text" name="txtUsername" value="${param.txtUsername}"  placeholder="username" required=""/> <br/> 
                <font color="orange">${requestScope.INVALID.usernameError}</font> <br/>
                <input type="password" name="txtPassword" placeholder="password" required=""/> <br/> 
                <font color="orange">${requestScope.INVALID.passwordError}</font> <br/>
                <input type="submit" value="Login" name="action" class="submit"/>
            </form>
        </div>
    </body>
</html>
