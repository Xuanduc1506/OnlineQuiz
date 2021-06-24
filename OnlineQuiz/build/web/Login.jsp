<%-- 
    Document   : Login
    Created on : May 31, 2021, 8:35:34 PM
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
                        <div class="title">Login Form</div>
                        <form id="Login" action="Login" method="POST">
                            Username: <input type="text" name="username" required="required" pattern="[A-Za-z0-9._%+-]{8,30}" /><br>
                            Password: <input type="password" name="password" required="required" pattern="[A-Za-z0-9]{8,30}" /><br>
                            <button>login</button>
                             <a href="Register">REGISTER</a>
                        </form>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
