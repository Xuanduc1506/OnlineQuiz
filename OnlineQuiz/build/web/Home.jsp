<%-- 
    Document   : Home
    Created on : May 17, 2021, 10:00:32 AM
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
                    <div class="detail">
                        <b>Login Form</b><br>
                        <form>
                            <div class="username">User Name: <input type="text" name="username"/></div>
                            <div class="password">Password:  <input type="password" name="password"/></div>
                            <input type="submit" value="Sign in">
                            <a href="">Register</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
