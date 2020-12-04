<%-- 
    Document   : tooladd
    Created on : Jul 5, 2020, 1:41:27 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(sun.jpg);  background-size: 100%">
    <center>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="header2">
            <h1 style="color: #DE2B2B; font-family: 'Dancing Script'; font-size: 70px; font-weight: 700">ADD A TOOL</h1>
        </div>
        <div class="login">
            <form action="ToolMainController" method="POST">
                <input type="text" name="txtIdTool" value="${requestScope.IT}" placeholder="Tool Id"> <br/> 
                <font color="tomato">${requestScope.INVALID.idtoolError}${requestScope.DUP}</font> <br/> <br/>
                <input type="text" name="txtToolName" value="${requestScope.TN}" placeholder="Tool Name"> <br/> 
                <font color="tomato">${requestScope.INVALID.toolnameError}</font> <br/> <br/>
                <input type="text" name="txtToolDescript" value="${requestScope.TD}" placeholder="Description"> <br/> 
                <font color="tomato">${requestScope.INVALID.tooldescriptError}</font> <br/> <br/>
                <input type="text" name="txtToolStatus" value="${requestScope.TS}" placeholder="Status"> <br/>
                <font color="tomato">${requestScope.INVALID.toolstatusError}</font> <br/> <br/>
                <input type="text" name="txtToolQuantity" value="${requestScope.QT}" placeholder="Quantity"> <br/>
                <font color="tomato">${requestScope.INVALID.toolquantityError}</font> <br/> <br/>
                <input type="text" name="txtToolImg" value="${requestScope.TI}" placeholder="Picture Link"> <br/>
                <font color="tomato">${requestScope.INVALID.toolimgError}</font> <br/> <br/>
                <input type="submit" name="action" value="Register"/>
            </form>
            <form>
                <br/> <br/> <br/>
                <a href="toolmanagement.jsp"><p style="color: #0080ff; font-size: 30px">Back to the Tool management here!</p></a>
            </form>
        </div>
    </center>
</body>
</html>
