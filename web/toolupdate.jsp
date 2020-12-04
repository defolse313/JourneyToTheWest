<%-- 
    Document   : toolupdate
    Created on : Jul 5, 2020, 12:48:45 PM
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
    <center>
        <br/> <br/> 
        <h1>Update Tool</h1>
        <br/>
        <form action="ToolMainController" method="POST">
            Tool Id: <input type="text" name="txtIdTool" value="${requestScope.DTO.idTool}${requestScope.IT}" readonly="true"/><br/><br/><br/>
            Tool name: <input type="text" name="txtToolName" value="${requestScope.DTO.toolName}${requestScope.TN}"/> <br/>
            <font color="tomato">${requestScope.INVALID.toolnameError}</font> <br/> <br/>
            Description: <input type="text" name="txtToolDescript" value="${requestScope.DTO.toolDescript}${requestScope.TD}"/> <br/>
            <font color="tomato">${requestScope.INVALID.tooldescriptError}</font> <br/> <br/>
            Tool Image: <input type="text" name="txtToolImg" value="${requestScope.DTO.toolImg}${requestScope.TI}"/> <br/>
            <font color="tomato">${requestScope.INVALID.toolimgError}</font> <br/> <br/>
            Status: <input type="text" name="txtToolStatus" value="${requestScope.DTO.status}${requestScope.TS}"/> <br/>
            <font color="tomato">${requestScope.INVALID.toolstatusError}</font> <br/> <br/>
            Quantity: <input type="text" name="txtToolQuantity" value="${requestScope.DTO.quantity}${requestScope.QT}"/> <br/>
            <font color="tomato">${requestScope.INVALID.toolquantityError}</font> <br/> <br/>
            <input type="hidden" name="txtSearch" value=""<%= request.getParameter("txtSearch")%>"/>
            <input type="submit" name="action" value="Update"/>
        </form>

        <form>
            <br/> <br/> <br/>
            <a href="toolmanagement.jsp">Back to the tool management here!</a>
        </form>
    </center>
</body>
</html>
