<%-- 
    Document   : 課題8-2
    Created on : 2017/07/11, 13:41:45
    Author     : Guestnumber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        // for文を利用して、適当な変数へ文字連結を行い、
        // 中に"A"が30個入った状態にしてください。 
        String name = "A";
        for(int i = 1; i <= 30; i++){
            out.print(name);
            name = name + "A";
            out.print("<br>");
        }
        %>
    </body>
</html>
