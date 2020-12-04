<%-- 
    Document   : error
    Created on : Jun 30, 2020, 2:27:06 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="error.css">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(fb.jpg);  background-size: 100%">
        <div class="body">
            <div id="notfound">
                <div class="notfound">
                    <div class="notfount-acc">
                        <h1>OOPS!</h1>
                        <h2>${requestScope.ERROR}</h2> 
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
