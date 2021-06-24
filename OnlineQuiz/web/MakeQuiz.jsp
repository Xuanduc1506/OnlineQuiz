<%-- 
    Document   : MakeQuiz
    Created on : Jun 2, 2021, 8:57:05 AM
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
                        <form action="MakeQuiz" method="POST">
                            <div class="Register">
                                <div class="titleInput">
                                    Question:<br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    Option1:
                                    <br>
                                    <br>
                                    <br>
                                    Option2:
                                    <br>
                                    <br>
                                    <br>
                                    Option3:
                                    <br>
                                    <br>
                                    <br>
                                    Option4:
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    Answer:
                                </div>
                                <div class="text">
                                    <textarea style="margin: 0px; width: 504px; height: 100px;" name="question"></textarea><br>
                                    <textarea style="margin: 0px; width: 504px; height: 52px;" name="option"></textarea><br>
                                    <textarea style="margin: 0px; width: 504px; height: 52px;" name="option"></textarea><br>
                                    <textarea style="margin: 0px; width: 504px; height: 52px;" name="option"></textarea><br>
                                    <textarea style="margin: 0px; width: 504px; height: 52px;" name="option"></textarea><br>
                                    <input type="radio" value="0" name="correct"> Option1 
                                    <input type="radio" value="1" name="correct"> Option2
                                    <input type="radio" value="2" name="correct"> Option3
                                    <input type="radio" value="3" name="correct"> Option4
                                </div>
                            </div>
                            <input type="submit" value="SAVE">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
