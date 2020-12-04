<%-- 
    Document   : update
    Created on : Jul 1, 2020, 3:52:01 PM
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
        <h1>Update Information</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername" value="${requestScope.DTO.userName}${requestScope.UN}" readonly="true"/><br/><br/>
            Password: <input type="pasword" name="txtPassword"/> <br/>
            <font color="tomato">${requestScope.INVALID.passwordError}</font> <br/> <br/>
            Fullname: <input type="text" name="txtFullname" value="${requestScope.DTO.fullname}${requestScope.FN}"/> <br/>
            <font color="tomato">${requestScope.INVALID.fullnameError}</font> <br/> <br/>
            Description: <input type="text" name="txtDescript" value="${requestScope.DTO.descript}${requestScope.DS}"/> <br/>
            <font color="tomato">${requestScope.INVALID.descriptError}</font> <br/> <br/>
            Phone: <input type="text" name="txtPhone" value="${requestScope.DTO.phone}${requestScope.PH}"/> <br/>
            <font color="tomato">${requestScope.INVALID.phoneError}</font> <br/> <br/>
            Email: <input type="text" name="txtEmail" value="${requestScope.DTO.email}${requestScope.EM}"/> <br/>
            <font color="tomato">${requestScope.INVALID.emailError}</font> <br/> <br/>
            Picture: <input type="text" name="txtPicture" value="${requestScope.DTO.picture}${requestScope.PT}"/> <br/>
            <font color="tomato">${requestScope.INVALID.pictureError}</font> <br/> <br/>
            Role: <select name="cbRole" value="${requestScope.RL}">
                <option>caster</option>
                <option>director</option>
            </select> <br/><br/>
            <input type="hidden" name="txtSearch" value=""<%= request.getParameter("txtSearch")%>"/>
            <input type="submit" name="action" value="Update"/>
            <form>
                <br/> <br/> <br/>
                <a href="crewmanagement.jsp">Back to the Crew management here!</a>
            </form>
        </form>
    </body>
</html>
