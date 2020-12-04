<%-- 
    Document   : takeupdate
    Created on : Jul 9, 2020, 11:27:50 PM
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
        <h1>Update Shot</h1>
        <br/>
        <form action="TakeMainController" method="POST">
            Shot Id: <input type="text" name="txtIdTake" value="${requestScope.DTO.idShot}${requestScope.IT}" readonly="true"/><br/><br/><br/>
            Shot name: <input type="text" name="txtTakeName" value="${requestScope.DTO.shotName}${requestScope.TN}"/> <br/>
            <font color="tomato">${requestScope.INVALID.takenameError}</font> <br/> <br/>
            Shot Description: <input type="text" name="txtTakeDescript" value="${requestScope.DTO.shotDescript}${requestScope.TD}"/> <br/>
            <font color="tomato">${requestScope.INVALID.takedescriptError}</font> <br/> <br/>
            Shot Location: <input type="text" name="txtTakeLocation" value="${requestScope.DTO.shotLocation}${requestScope.TL}"/> <br/>
            <font color="tomato">${requestScope.INVALID.takelocationError}</font> <br/> <br/>
            Shot Times: <input type="text" name="txtTakeTimes" value="${requestScope.DTO.shotTimes}${requestScope.ST}"/> <br/>
            <font color="tomato">${requestScope.INVALID.taketimesError}</font> <br/> <br/>
            Shot Start Date: <input type="date" name="txtShotSDate" value="${requestScope.DTO.shotStartDate}${requestScope.SSD}${requestScope.SS}"/> <br/>
            <font color="tomato">${requestScope.INVALID.startError}</font> <br/> <br/>
            Shot Start Date: <input type="date" name="txtShotEDate" value="${requestScope.DTO.shotEndDate}${requestScope.SED}${requestScope.SE}"/> <br/>
            <font color="tomato">${requestScope.INVALID.endError}</font> <br/> <br/>
            <input type="hidden" name="txtSearch" value=""<%= request.getParameter("txtSearch")%>"/>
            <input type="submit" name="action" value="Update"/>
        </form>
        <form>
            <br/> <br/> <br/>
            <a href="takemanagement.jsp">Back to the shot management here!</a>
        </form>
    </center>
</body>
</html>
