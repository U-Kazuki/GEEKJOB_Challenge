<%-- 
    Document   : Java 課題2-1
    Created on : 2017/07/05, 11:28:09
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
        // 課題文
        // 自己紹介が入った変数を用意し、それを表示してください。
            
            String text = "自己紹介<br>";
            text += "私の名前は上原です。";
            out.print(text);
        %>
    </body>
</html>
