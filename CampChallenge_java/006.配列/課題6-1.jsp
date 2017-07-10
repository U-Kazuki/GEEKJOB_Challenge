<%-- 
    Document   : 課題６
    Created on : 2017/07/07, 11:14:37
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
        // 以下の順番で、要素が格納された配列を作成してください。
        // "10","100","soeda","hayashi","-20","118","END"
        String[] data ={"10","100","soeda","hayashi","-20","118","END"};
        
        out.print(data[0]);
        out.print(data[1]);
        out.print(data[2]);
        out.print(data[3]);
        out.print(data[4]);
        out.print(data[5]);
        out.print(data[6]);
        %>
    </body>
</html>
