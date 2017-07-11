<%-- 
    Document   : 課題8
    Created on : 2017/07/11, 10:23:51
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
        // for文を利用して、8を20回掛ける処理を実現してください。（8の20乗）
        
        long total = 1;
        for(int i = 1; i <= 20; i++){
            total = total * 8;
        
            out.print(total);
            out.print("<br>");
        }    
        %>

    </body>
</html>
