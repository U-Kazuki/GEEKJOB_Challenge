<%-- 
    Document   : 課題5－2
    Created on : 2017/07/07, 10:24:11
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
          // 1.値が"A"なら「英語」値が"あ"なら「日本語」
          // それ以外は何も表示しない処理
          char num = 'あ';
          switch(num){
                  default:
                      break;
                  case 'A':
                      out.print("英語");
                      break;
                  case 'あ':
                      out.print("日本語");
                      break;
          }
        %>
        
    </body>
</html>
