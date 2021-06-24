<%-- 
    Document   : Test
    Created on : May 19, 2021, 8:26:10 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <!--<script src="js/script.js" type="text/javascript"></script>-->
        <title>JSP Page</title>
    </head>
    <body>
        <div class="backGround">
            <div class="body">
                <jsp:include page="Header.jsp"/>
                <div class="content">
                    <div class="detail">
                        <div class="title">Welcome ${account.username}</div><br>
                        <div id="timer" class="titleCountdown"></div>
                        <div class="question">
                            <span>${q.question}</span>

                            <form id="form" class="option" action="Test" method="Get">
                                <input id="Curentindex" type="hidden" name="Curentindex" value="${q.index}">
                                <input id="index" type="hidden" name="index" value="${q.index}">
                                <!--<input id="check" type="hidden" name="check">-->
                                <c:forEach items="${q.options}" var="o">
                                    <input type="checkbox"
                                           <c:if test="${o.check}">
                                               checked="checked"
                                           </c:if>
                                           value="${q.id}_${o.id}"
                                           name="choosed"/>${o.option}<br>
                                </c:forEach>
                                <c:if test="${q.index gt 0}">
                                    <input class="prevous" type="button" value="PREVIUS" onclick="minus()"/>
                                </c:if>

                                <c:if test="${q.index lt total-1}">
                                    <input class="next" type="button" value="NEXT" onclick="plus()"/>
                                </c:if>

                                <c:if test="${q.index eq total-1}">
                                    <input class="next" type="submit" value="SUBMIT"/>
                                    <!--<a href="Result"><button>SUBMIT</button></a>-->
                                </c:if>



                            </form>                       
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        function countplus() {
            var time = 60 *${total};
            var cookieName = "temp_value";
            var timer = document.getElementById("timer");
            var temp_value = getCookie(cookieName) ? getCookie(cookieName) : time;
            timer.innerHTML = "Time Remaining: " + convertTimer(temp_value--);
            document.cookie = "temp_value=" + (temp_value);

            if (temp_value == 0) {
//        var check=document.getElementById("check");
//        check.value="abc";
                location.href = "Result"
                document.cookie = "temp_value=" + time;
            }
        }
        setInterval(countplus, 1000);

        function convertTimer(s) {
            hou = Math.floor(s / 3600);
            min = Math.floor((s / 3600 - hou) * 60);
            sec = s - hou * 3600 - min * 60;
            return ('0' + hou).slice(-2) + ':' + ('0' + min).slice(-2) + ':' + ('0' + sec).slice(-2);
        }

        function getCookie(cname) {
            var name = cname + "=";
            var decodedCookie = decodeURIComponent(document.cookie);
            var ca = decodedCookie.split(';');
            for (var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') {
                    c = c.substring(1);
                }
                if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                }
            }
            return "";
        }
        function plus() {
            var preIndex = document.getElementById("Curentindex");
            var index = preIndex.value;
            index++;
            preIndex.value = index.toString();
            document.getElementById('form').submit();
        }
        function minus() {
            var preIndex = document.getElementById("Curentindex");
            var index = preIndex.value;
            index--;
            preIndex.value = index.toString();
            document.getElementById('form').submit();
        }
    </script>
</html>

