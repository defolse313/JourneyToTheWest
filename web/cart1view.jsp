<%-- 
    Document   : cart1view
    Created on : Jul 11, 2020, 2:35:11 PM
    Author     : hp
--%>


<%@page import="hieudn.cart1controllers.ScenesPartCart"%>
<%@page import="hieudn.dtos.ScenesPartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(simple-floral-seamless-pattern-background-vector-4391059.jpg);  background-size: 50% ">
    <center>
        <h1><br/><br/><p style="background-color: #57293e; opacity: 0.8; color: #fff"> <font size="100">Cart Collection</font></p></h1>
        <br/><br/><br/>
        <div class="limiter">
            <c:if test="${sessionScope.cart1.getCart().values() != null}" var="khang">
                <c:if test="${not empty sessionScope.cart1.getCart().values()}" var="display">
                    <div class="container-table100">
                        <div class="wrap-table100">
                            <div class="table100 ver6 m-b-110">
                                <table data-vertable="ver6">
                                    <thead>
                                        <tr>
                                            <th class="column100 column1" data-column="column1">ID SCENE PART</th>
                                            <th class="column100 column2" data-column="column2">USERNAME</th>
                                            <th class="column100 column3" data-column="column3">ID SHOT</th>
                                            <th class="column100 column4" data-column="column4">ROLE</th>
                                            <th class="column100 column5" data-column="column5">DESCRIPTION</th>
                                            <th class="column100 column6" data-column="column6">DELETE</th>
                                        </tr>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.cart1.getCart().values()}" var="dto" varStatus="counting"> 
                                            <tr class="row100">
                                                <td class="column100 column1" data-column="column1">${dto.idAccShot}</td>
                                                <td class="column100 column2" data-column="column2">${dto.username}</td>
                                                <td class="column100 column3" data-column="column3">${dto.idShot}</td>
                                                <td class="column100 column4" data-column="column4">${dto.part}</td>
                                                <td class="column100 column5" data-column="column5">${dto.descript}</td>
                                                <td class="column100 column6" data-column="column6">
                                                    <form action="Cart1MainController" method="POST">
                                                        <input type="hidden" name="textIdAccShot" value="${dto.idAccShot}"/>
                                                        <input type="hidden" name="textSearch"/>
                                                        <input type="submit" value="Delete" name="action"/> 
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${!display}">
                    <h2 class="noFound">No results found!</h2>
                </c:if>
            </c:if>
            <c:if test="${!khang}">
                <h2 class="noFound">No results found!</h2>
            </c:if>
        </div>
        <br/> <br/> <br/>
        <form action="Cart1MainController" method="POST">
            <input type="submit" value="Add more cart" name="action" style="font-size: 30px"/>  
            &nbsp; &nbsp;
            <input type="submit" value="Accept to database" name="action" style="font-size: 30px"/>
            <font color="tomato">${requestScope.NULL}</font>
        </form>
    </center>
</body>
</html>
