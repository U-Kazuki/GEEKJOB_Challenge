<%-- 
    Document   : 課題４
    Created on : 2017/07/06, 11:23:48
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
          // 「groove」「-」「gear」の
          // ３つの文字列を連結して表示してください。
          final String KADAI1 = "groove";
          final String KADAI2 = "gear";          
          String HIKU = "-";
          
          out.print(KADAI1 + HIKU + KADAI2);
          
        %>
    </body>
</html>
