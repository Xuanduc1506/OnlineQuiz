<%-- 
    Document   : Error
    Created on : Jun 4, 2021, 9:36:40 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="backGround">
            <div class="body">
                <jsp:include page="Header.jsp"/>
                <div class="content">
                    <br>
                    <br>
                    ${message}
                    <br>
                    <br>
                </div>
            </div>
        </div>
    </body>
</html>
