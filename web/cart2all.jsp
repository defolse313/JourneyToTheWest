<%-- 
    Document   : cart2all
    Created on : Jul 16, 2020, 4:36:54 AM
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1> <br/><br/><p style="background-color: #57293e; opacity: 0.8; color: #fff"> <font size="100">Overall Tool-in-Use</font></p></h1>
        <div class="limiter">
            <c:if test="${requestScope.SEARCH != null}">
                <c:if test="${not empty requestScope.SEARCH}" var = "searching">
                    <div class="container-table100">
                        <div class="wrap-table100">
                            <div class="table100 ver6 m-b-110">
                                <table data-vertable="ver6">
                                    <thead>
                                        <tr>
                                            <th class="column100 column1" data-column="column1">ID TOOL SHOT</th>
                                            <th class="column100 column1" data-column="column1">ID SHOT</th>
                                            <th class="column100 column1" data-column="column1">ID TOOL</th>
                                            <th class="column100 column1" data-column="column1">NUMBER OF USE</th>
                                            <th class="column100 column1" data-column="column1">DESCRIPTION</th>
                                            <th class="column100 column1" data-column="column1">DELETE</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.SEARCH}" var="dto" varStatus="counting">
                                            <tr class="row100">
                                                <td class="column100 column1" data-column="column1">${dto.idShotTool}</td>
                                                <td class="column100 column1" data-column="column1">${dto.idShot}</td>
                                                <td class="column100 column1" data-column="column1">${dto.idTool}</td>
                                                <td class="column100 column1" data-column="column1">${dto.numOfUse}</td>
                                                <td class="column100 column1" data-column="column1">${dto.descript}</td>
                                                <td class="column100 column1" data-column="column1">
                                                    <form action="Cart2MainController" method="POST">
                                                        <input type="hidden" name="textIdShotTool1" value="${dto.idShotTool}"/>
                                                        <input type="hidden" name="textSearch"/>
                                                        <input type="submit" value="Delete this" name="action"/> 
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
                <c:if test="${!searching}" >
                    <h2 class="noFound">No results found!</h2>
                </c:if>
            </c:if>
        </div>
        <br/><br/>
        <a href="Cart2SearchController"><h3> <p style="background-color: #fff; color: #0080ff" >Back to the tool- scene manager here!</p></h3> </a>
        <br/><br/><br/><br/>  
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
    </center>
</body>
</html>
