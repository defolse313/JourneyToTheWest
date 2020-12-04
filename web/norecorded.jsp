<%-- 
    Document   : recorded
    Created on : Jul 20, 2020, 3:38:32 PM
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
    <body style="background-image: url(simple-floral-seamless-pattern-background-vector-4391059.jpg);  background-size: contain">
    <center>
        <h1> <br/><br/><p style="background-color: #57293e; opacity: 0.8; color: #fff"> <font size="100">UPCOMING VIDEOTAPPED SCENES</font></p></h1>
        <br/> <br/> <br/>
        <br/><br/>
        <div class="limiter">
            <c:if test="${requestScope.INFOCASTER1 != null}" >
                <c:if test="${not empty requestScope.INFOCASTER1}" var = "searching">
                    <div class="container-table100">
                        <div class="wrap-table100">
                            <div class="table100 ver6 m-b-110">
                                <table data-vertable="ver6">
                                    <thead>
                                        <tr>
                                            <th class="column100 column1" data-column="column1">USERNAME</th>
                                            <th class="column100 column2" data-column="column2">FULL NAME</th>
                                            <th class="column100 column3" data-column="column3">PICTURE</th>
                                            <th class="column100 column4" data-column="column4">PART</th>
                                            <th class="column100 column5" data-column="column5">SHOT NAME</th>
                                            <th class="column100 column6" data-column="column6">START DATE</th>
                                            <th class="column100 column7" data-column="column7">END DATE</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.INFOCASTER1}" var="dto" varStatus="counting">
                                            <tr class="row100">
                                                <td class="column100 column1" data-column="column1">${dto.username}></td>
                                                <td class="column100 column2" data-column="column2">${dto.username}</td>
                                                <td class="column100 column3" data-column="column3"><a href="${dto.picture}"><img src="${dto.picture}" width="100" height="100"/></a></td>
                                                <td class="column100 column4" data-column="column4">${dto.part}</td>
                                                <td class="column100 column5" data-column="column5">${dto.shotname}</td>
                                                <td class="column100 column6" data-column="column6">${dto.start}</td>
                                                <td class="column100 column7" data-column="column7">${dto.end}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${!searching}">
                    <h2 class="noFound">No results found!</h2>
                </c:if>
            </c:if>
        </div>
        <br/><br/><br/>
        <a href="caster.jsp"><h3> <p style="background-color: #fff; color: #0080ff" >Back to the caster view here!</p></h3> </a>
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
