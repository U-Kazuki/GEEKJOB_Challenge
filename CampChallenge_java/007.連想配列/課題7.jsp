<%-- 
    Document   : 課題7
    Created on : 2017/07/10, 14:57:36
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
            <%@ page import="java.util.HashMap" %>
            <%
            // 以下の順で、連想配列を作成してください。
            // "1"に"AAA"、"hello"に"world"、"soeda"に"33"、"20"に"20"
            HashMap<String, String> prof =
                            new HashMap<String, String>();
            
           
            prof.put("1","AAA");
            out.print(prof.get("1"));
            out.print("<br>");
            
            prof.put("hello", "world");
            out.print(prof.get("hello"));
            out.print("<br>");
            
            prof.put("soeda", "33");
            out.print(prof.get("soeda"));
            out.print("<br>");
            
            prof.put("20", "20");
            out.print(prof.get("20"));
            
            %>
    </body>
</html>
