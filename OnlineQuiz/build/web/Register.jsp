<%-- 
    Document   : Register
    Created on : Jun 1, 2021, 9:25:53 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <div class="title">Register Form</div>
                        <form id="register" action="Register" method="POST">
                            <div class="Register">
                                <div class="titleInput">
                                    Username:<br>
                                    Password:<br>
                                    User type:<br>
                                    Email:<br>
                                </div>
                                <div class="text">
                                    <input type="text" name="username" required="required" pattern="[A-Za-z0-9._%+-]{8,30}"><br>
                                    <input type="password" name="password" required="required" pattern="[A-Za-z0-9]{8,30}"><br>
                                    <select name="type">
                                        <c:forEach items="${roles}" var="r">
                                            <option value="${r.id}">${r.name}</option>
                                        </c:forEach>
                                    </select>
                                    <br>
                                    <input type="text" name="email" required="required" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"><br>
                                    <input type="submit" value="REGISTER">
                                </div>
                            </div>
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
