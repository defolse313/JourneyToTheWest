<%-- 
    Document   : director
    Created on : Jun 30, 2020, 2:26:17 PM
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
        <h1 class="h1"><p style="color: #323232; font-size: 50px" >Hello ${sessionScope.FULLNAME}</p></h1>
        <br/> <br/><br/> <br/><br/> <br/>
        <form action="MainController" method="POST">
            <input type="submit" value="Scene management" name="action" class="submit"/> <br/> <br/> <br/> <br/> <br/>
            <input type="submit" value="Tool in Scene management" name="action" class="submit"/>
        </form>
        <br/> <br/> <br/><br/> <br/> <br/>
        <form action="MainController" method="POST">
            <input type="submit" value="Log out" name="action">
        </form>
    </center>
</body>
</html>
