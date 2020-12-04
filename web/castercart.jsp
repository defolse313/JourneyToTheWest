<%-- +
    Document   : castercart
    Created on : Jul 11, 2020, 11:30:55 AM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cart.css">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(simple.jpg);  background-size: 100%">
    <center>
        <br/> <br/><br/> <br/><br/> <br/>
        <h1 style="color: black; font-size: 30px">Caster- Scene Details</h1>
        <br/> <br/> <br/><br/> <br/> <br/>
        <form action="Cart1MainController" method="POST">
            <input type="text" name="txtIdAccShot" value="${requestScope.ID}" placeholder="Id Account- Scene"/>
            <br/>
            <font color="tomato">${requestScope.INVALID.idaccshotError}${requestScope.DUP}</font> <br/> <br/>
            <p style="font-size: 20px; color: black">Choose a caster to add:&nbsp; &nbsp;
                <select name="cart11" style="width: 200px">
                    <c:forEach items="${requestScope.castershot}" var="dto11">
                        <option>${dto11.userName} - ${dto11.fullname}</option>
                    </c:forEach>
                </select>
            &nbsp; &nbsp;&nbsp; &nbsp;Choose a scene to add: &nbsp; &nbsp;
            <select name="cart12" style="width: 200px">
                <c:forEach items="${requestScope.shotcaster}" var="dto12">
                    <option>${dto12.idShot} - ${dto12.shotName}</option>
                </c:forEach>
            </select>
            </p> 
            <br/> <br/> <br/>
            <input type="text" name="txtASRole" value="${requestScope.RL}" placeholder="Part..."/><br/>
            <font color="tomato">${requestScope.INVALID.accshotdesError}</font> <br/> <br/>
            <input type="text" name="txtASDes" value="${requestScope.DS}" placeholder="Description"/></font> <br/> <br/>
            <font color="tomato">${requestScope.INVALID.accshotroleError}</font> <br/> <br/>
            <br/><br/><br/><br/><br/>
            <input type="submit" value="View the overall scenes added" name="action"> &nbsp; &nbsp; &nbsp;
            <input type="submit" value="Add to Collection" name="action"/> &nbsp; &nbsp; &nbsp;
            <input type="submit" value="View the overall carts added" name="action"> <br/><br/><br/>
            <font color="MediumSeaGreen">${requestScope.SUCCESS} </font>
            <font color="Tomato">${requestScope.INVALID.existedError} </font>
            <font color="Tomato">${requestScope.ERROR} </font>
        </form>
        <br/><br/><br/>
        <a href="director.jsp"><h3> <p style=" font-size: 15px; color: #000" >Back to the director overall manager here!</p></h3> </a>
    </center>
</body>
</html>
