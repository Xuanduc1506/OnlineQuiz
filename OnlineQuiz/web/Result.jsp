<%-- 
    Document   : Result
    Created on : May 31, 2021, 9:27:52 AM
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
                        <c:if test="${mark gt 0.7}">
                            <div class="result">
                                <div class="a">Your score:</div><div class="pass">${mark*10}(${mark*100}%)-Passed</div>
                            </div>
                        </c:if>
                        <c:if test="${mark le 0.7}">
                            <div class="result">
                                <div class="a">Your score:</div><div class="notPass">${mark*10}(${mark*100}%)-Not Pass</div>
                            </div>
                        </c:if>
                        <form action="TakeQuiz" method="POST"> 
                            <input type="hidden" value="${totalQuestion}" name="totalQuestion">
                            Take another test:<input type="submit" value="START">
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
