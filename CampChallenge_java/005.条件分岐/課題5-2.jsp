<%-- 
    Document   : 課題5-3
    Created on : 2017/07/07, 10:24:42
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
           // switch文を利用して、以下の処理を実現してください。
           // 1.値が1なら「one」値が2なら「two」
           // それ以外は「想定外」と表示する処理
           int num = 8;
           switch(num){
                  default:
                      out.print("想定外");
                      break;
                  case 1:
                      out.print("one");
                      break;
                  case 2:
                      out.print("two");
                      break;
           }
        %>
    </body>
</html>
