<%-- 
    Document   : Java16_1_3JSP
    Created on : 2017/08/21, 9:17:40
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
//            response.setContentType("text/html;charset=UTF-8");
            response.setContentType("text/html");
            request.setCharacterEncoding("UTF-8");
//            out.print("" + request.getParameter("") + "<br>");
            out.print("【名前】" + request.getParameter("txtname") + "<br>");
            out.print("【性別】" + request.getParameter("human") + "<br>");
            out.print("【趣味】" + request.getParameter("wordarea") + "<br>");
            out.print("【パスワード】" + request.getParameter("pass") + "<br>");
            out.print("【検索】" + request.getParameter("kensaku") + "<br>");
            out.print("【フィールド】" + request.getParameter("clear") + "<br>");
        %>
    </body>
</html>
