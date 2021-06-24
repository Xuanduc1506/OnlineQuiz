<%-- 
    Document   : ManageQuiz
    Created on : Jun 3, 2021, 10:13:48 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/htmls; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="backGround">
            <div class="body">
                <jsp:include page="Header.jsp"/>
                <div class="content">
                    <div class="detail">
                        <div class="titleManage">Number of questions: ${numRecords}</div>
                        <table>
                            <tr>
                                <th id="left" >Quetstion</th>
                                <th id="right">DateCreated</th>
                            </tr>
                            <c:forEach items="${questions}" var="q">
                                <tr>
                                    <td>${q.question}</td>
                                    <td>${q.dateCreated}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <br>
                        <br>
                        <br>
                        <div id="bottomPagger" class="pagger">
                            <c:if test="${totalpage < 1}">
                            <h3>Not Found !!</h3>
                        </c:if>
                        <c:if test="${totalpage > 1}">
                            <c:forEach begin="1" end="${totalpage}" var="i">
                                <a class="${i==pageindex?"active":""}" href="ManageQuiz?page=${i}">${i}</a>
                            </c:forEach>
                        </c:if>
                        </div>
                        



                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
