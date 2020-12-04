<%-- 
    Document   : addtake
    Created on : Jul 9, 2020, 11:19:09 AM
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
        <div class="header1">
            <h1 style="color: #DE2B2B; font-family: 'Dancing Script'; font-size: 70px; font-weight: 700">ADD FILM SHOT</h1>
        </div>
        <div class="login">
            <form action="TakeMainController" method="POST">
                <input type="text" name="txtIdTake" value="${requestScope.IT}" placeholder="Shot Id"> <br/> 
                <font color="tomato">${requestScope.INVALID.idtakeError}${requestScope.DUP}</font> <br/> <br/>
                <input type="text" name="txtTakeName" value="${requestScope.TN}" placeholder="Shot Name"> <br/> 
                <font color="tomato">${requestScope.INVALID.takenameError}</font> <br/> <br/>
                <input type="text" name="txtTakeDescript" value="${requestScope.TD}" placeholder="Shot Description"> <br/> 
                <font color="tomato">${requestScope.INVALID.takedescriptError}</font> <br/> <br/>
                <input type="text" name="txtTakeLocation" value="${requestScope.TL}" placeholder="Shot Location"> <br/>
                <font color="tomato">${requestScope.INVALID.takelocationError}</font> <br/> <br/>
                <input type="text" name="txtShotTimes" value="${requestScope.ST}" placeholder="Shot Times"> <br/>
                <font color="tomato">${requestScope.INVALID.taketimesError}</font> <br/> <br/>
                Shot Start Date: <input type="date" name="txtShotSDate" value="${requestScope.SSD}${requestScope.SS}" placeholder="Start Date"> <br/>
                <font color="tomato">${requestScope.INVALID.startError}</font> <br/> <br/>
                Shot End Date: <input type="date" name="txtShotEDate" value="${requestScope.SED}${requestScope.SE}" placeholder="End Date"> <br/>
                <font color="tomato">${requestScope.INVALID.endError}</font> <br/> <br/>
                <input type="submit" name="action" value="Register"/>
            </form>
            <form>
                <br/> <br/> <br/>
                <a href="takemanagement.jsp"><p style="color: #0080ff; font-size: 30px">Back to the Tool management here!</p></a>
            </form>
        </div>
    </center>
</body>
</html>
