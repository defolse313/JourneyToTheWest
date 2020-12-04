<%-- 
    Document   : caster
    Created on : Jun 30, 2020, 2:26:28 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/admin.css">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(dawn.jpg);  background-size: 100%">
    <center>
        <br/>
        <h1 class="h1"><p style="color: #323232; font-size: 50px" >Hello ${sessionScope.FULLNAME}</p></h1>
        <br/> <br/><br/> <br/><br/> <br/><br/><br/>
        <form action="CasterMainController" method="POST">
            <input type="submit" value="Videotapped Scenes" name="action"/>  <br/><br/><br/><br/><br/>
            <input type="submit" value="Upcoming videotapping" name="action"/>
        </form>
        <br/> <br/> <br/><br/> <br/> <br/>
        <form action="MainController" method="POST">
            <input type="submit" value="Log out" name="action">
        </form>
    </center>
</body>
</html>
