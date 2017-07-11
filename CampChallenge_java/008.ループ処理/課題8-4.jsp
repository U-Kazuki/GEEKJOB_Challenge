<%-- 
    Document   : 課題8-4
    Created on : 2017/07/11, 16:20:56
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
        // while文を利用して、以下の処理を実現してください。
        // 1、1000を2で割り続け、100より小さくなったらループを抜ける処理
        int key = 1000;
        int count = 0;
        while(key >= 100){
            key = key / 2;
            out.print(key);
            count++;
            
            out.print("<br>");
        }
         out.print(count + "回ループしました");
        %>
        
    </body>
</html>
