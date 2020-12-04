<%-- 
    Document   : toolcart
    Created on : Jul 16, 2020, 2:24:06 AM
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
        <h1 style="color: black; font-size: 30px">Tool- Scene Details</h1>
        <br/> <br/> <br/><br/> <br/> <br/>
        <form action="Cart2MainController" method="POST">
            <input type="text" name="txtShotTool" value="${requestScope.ID}" placeholder="Id Tool- Scene"/>
            <br/>
            <font color="tomato">${requestScope.INVALID.idtoolshotError}${requestScope.DUP}</font> <br/> <br/>
            <p style="font-size: 20px; color: black">Choose a tool to add: &nbsp; &nbsp;
                <select name="cart21" style="width: 200px">
                    <c:forEach items="${requestScope.TOOL}" var="dto21">
                        <option>${dto21.idTool} - ${dto21.toolName}</option>
                    </c:forEach>
                </select>
                &nbsp; &nbsp;Choose a scene to add: &nbsp; &nbsp;
                <select name="cart22" style="width: 200px">
                    <c:forEach items="${requestScope.TAKE}" var="dto22">
                        <option>${dto22.idShot} - ${dto22.shotName}</option>
                    </c:forEach>
                </select></p>
            <br/> <br/> <br/>
            <input type="text" name="txtCount" value="${requestScope.RL}" placeholder="Number of use"/><br/>
            <font color="tomato">${requestScope.INVALID.numtoolshotError}</font> <br/> <br/>
            <input type="text" name="txtTSDes" value="${requestScope.DS}" placeholder="Description"/></font> <br/> <br/>
            <font color="tomato">${requestScope.INVALID.toolshotdesError}</font> <br/> <br/>
            <br/><br/><br/><br/><br/>
            <input type="submit" value="View the overall scenes added" name="action"> &nbsp; &nbsp; &nbsp;
            <input type="submit" value="Add tool to Collection" name="action"/> &nbsp; &nbsp; &nbsp;
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
