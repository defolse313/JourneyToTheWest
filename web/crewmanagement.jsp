<%-- 
    Document   : crewmanagement
    Created on : Jun 30, 2020, 8:54:40 PM
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

        <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700" rel="stylesheet" />
        <link href="css/search.css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body  style="background-image: url(simple-floral-seamless-pattern-background-vector-4391059.jpg);  background-size: contain">
    <center>
        <h1> <br/><br/><p style="background-color: #57293e; opacity: 0.8; color: #fff"> <font size="100">Film Crew Manager</font></p></h1>
        <br/> <br/> <br/>
        <h2>
            <div class="s010">
                <form action="MainController" method="POST">
                    <div class="inner-form">
                        <div class="basic-search">
                            <div class="input-field">
                                <input type="text" name="txtSearch" value="${requestScope.Search}" id="search" placeholder="Fullname..."/> 
                                <div class="icon-wrap">
                                    <button type="submit" value="Search" name="action">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 -3 30 24" >
                                        <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                                        </svg>
                                    </button>
                                </div>

                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </h2>
        <br/><br/>

        <form action="register.jsp" method="POST">
            <h3> <p style="background-color: #fff; color: #000" >or register a new member? Click now</p></h3>
            <input type="submit" value="Register" class="submit"/> <br/>
        </form>
        <div class="limiter">
            <c:if test="${requestScope.INFO != null}">
                <c:if test="${not empty requestScope.INFO}" var = "searching">
                    <div class="container-table100">
                        <div class="wrap-table100">
                            <div class="table100 ver6 m-b-110">
                                <table data-vertable="ver6">
                                    <thead>
                                        <tr>
                                            <th class="column100 column1" data-column="column1">ORDINAL</th>
                                            <th class="column100 column2" data-column="column2">IMAGE DESCRIPTION</th>
                                            <th class="column100 column3" data-column="column3">USERNAME</th>
                                            <th class="column100 column4" data-column="column4">FULLNAME</th>
                                            <th class="column100 column5" data-column="column5">DESCRIPTION</th> 
                                            <th class="column100 column6" data-column="column6">PHONE</th>
                                            <th class="column100 column7" data-column="column7">EMAIL</th>
                                            <th class="column100 column8" data-column="column8">ROLE</th>
                                            <th class="column100 column1" data-column="column1">EDIT</th>
                                            <th class="column100 column1" data-column="column1">DELETE</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counting">
                                            <tr class="row100">
                                                <td>
                                        <center> ${counting.count} </center></td>
                                        <td class="column100 column1" data-column="column1"> <a href="${dto.picture}"><img src="${dto.picture}" width="100" height="100"/></a></td>
                                        <td class="column100 column2" data-column="column1">${dto.userName}</td>
                                        <td class="column100 column3" data-column="column3">${dto.fullname}</td>
                                        <td class="column100 column4" data-column="column4">${dto.descript}</td>
                                        <td class="column100 column5" data-column="column5">${dto.phone}</td>
                                        <td class="column100 column6" data-column="column6">${dto.email}</td>
                                        <td class="column100 column7" data-column="column7">${dto.role}</td>
                                        <td class="column100 column8" data-column="column8">                                
                                            <form action="MainController" method="POST">
                                                <input type="hidden" name="texUsername" value="${dto.userName}"/>
                                                <input type="hidden" name="texSearch" value="${param.txtSearch}"/>
                                                <input type="submit" value="Edit" name="action"/> 
                                            </form>
                                        </td>
                                        <td class="column100 column9" data-column="column9">                            
                                            <form action="MainController" method="POST">
                                                <input type="hidden" name="textUsername" value="${dto.userName}"/>
                                                <input type="hidden" name="textSearch" value="${param.txtSearch}"/>
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
                <c:if test="${!searching}" >
                    <h2 class="noFound">No results found!</h2>
                </c:if>
            </c:if>
        </div>
        <br/> 
        <font color="tomato">${requestScope.RELATIONSHIP}</font>
        <br/>   
        <a href="admin.jsp"><h3> <p style="background-color: #fff; color: #0080ff" >Back to the overall manager here!</p></h3> </a>
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
