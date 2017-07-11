<%-- 
    Document   : 課題8-3
    Created on : 2017/07/11, 13:42:13
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
        // for文を利用して、0から100を全部足す処理を実現してください。
        
        int total =0;
        for(int i = 1; i<=100; i++){
            total = total + i;
        out.print(total);
        out.print("<br>");
        }
        %>
    </body>
</html>
