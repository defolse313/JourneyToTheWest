<%-- 
    Document   : casterprofile
    Created on : Jul 9, 2020, 10:58:29 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="2" cellspacing="2">
            <thead>
                <tr>
                    <th>ORDINAL</th>
                    <th>PICTURE</th>
                    <th>USERNAME</th>
                    <th>FULLNAME</th>
                    <th>DESCRIPTION</th> 
                    <th>PHONE</th>
                    <th>EMAIL</th>
                    <th>ROLE</th>
                    <th>EDIT</th>
                    <th>DELETE</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><center> ${counting.count} </center></td>
        <td><a href="${dto.picture}"><img src="${dto.picture}" width="100" height="100"/></a></td>
        <td>${dto.userName}</td>
        <td>${dto.fullname}</td>
        <td>${dto.descript}</td>
        <td>${dto.phone}</td>
        <td>${dto.email}</td>
        <td>${dto.role}</td>
        <td>                                
            <form action="MainController" method="POST">
                <input type="hidden" name="texUsername" value="${dto.userName}"/>
                <input type="hidden" name="texSearch" value="${param.txtSearch}"/>
                <input type="submit" value="Edit" name="action"/> 
            </form>
        </td>
        <td>                           
            <form action="MainController" method="POST">
                <input type="hidden" name="textUsername" value="${dto.userName}"/>
                <input type="hidden" name="textSearch" value="${param.txtSearch}"/>
                <input type="submit" value="Delete" name="action"/> 
            </form>
        </td>
    </tr>
</body>
</html>
