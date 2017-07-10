<%-- 
    Document   : 課題6-2
    Created on : 2017/07/10, 14:01:49
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
    // 課題「配列の作成」で作成した配列の
    // "sonoda"を"33"に変更してください。
    String[] data ={"10","100","soeda","hayashi","-20","118","END"};
    
    data[2] = "33";
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
