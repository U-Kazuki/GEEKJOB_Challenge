<%-- 
    Document   : 課題５
    Created on : 2017/07/06, 13:28:43
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
          // 変数を宣言し、その変数の中身によって以下の表示を行ってください。
          // 1.値が1なら「1です！」値が2なら「プログラミングキャンプ！」
          // それ以外なら「その他です！」
          int num = 5;
          if(num == 1){
              out.print("1です！");
          } else if(num == 2){
              out.print("プログラミングキャンプ！");
          } else{
              out.print("その他です！");
          }
        %>
    </body>
</html>
