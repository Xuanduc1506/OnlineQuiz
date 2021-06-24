<%-- 
    Document   : TakeQuiz
    Created on : May 17, 2021, 10:08:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="backGround">
            <div class="body">
                <jsp:include page="Header.jsp"/>
                <div class="content">
                    <div class="detail">
                        <div class="title">Welcome ${account.username}</div><br>
                        <form action="TakeQuiz" method="POST" >
                            <div class="question">Enter the number of question:
                                <div class="totaloption"> <input type="text" name="totalQuestion" required="required" pattern="[0-9]+"></div>
                            </div>
                            <div class="startButton"><input type="submit" value="Start"> </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
