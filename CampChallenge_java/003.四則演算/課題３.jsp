<%-- 
    Document   : 課題３
    Created on : 2017/07/05, 13:28:17
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
    // 定数と変数を宣言し、
    // それぞれに数値を入れて四則演算を行い、
    // 四則演算の結果をそれぞれ表示してください。
           // 定数版
            final int NUMBER = 100;
            int num = 5;
            
            int tasu = NUMBER + num;
                out.print(tasu);
                out.print("<br>");
            int hiku = NUMBER - num;
                out.print(hiku);
                out.print("<br>");
            int waru = NUMBER / num;
                out.print(waru);
                out.print("<br>");
            int kakeru = NUMBER * num;
                out.print(kakeru);
                out.print("<br>");
            int amari = NUMBER % 6;
                out.print(amari);
                out.print("<br>");
                
        %>
        
        <%
            // 変数版
            out.print("<br>");
            int num1 =100;
            num1 += 10;
            out.print(num1);
            out.print("<br>");
            num1 -= 50;
            out.print(num1);
            out.print("<br>");
            num1 /= 3;
            out.print(num1);
            out.print("<br>");
            num1 *= 10;
            out.print(num1);
            out.print("<br>");
            num1 %= 3;
            out.print(num1);
        
        %>
            
            
    </body>
</html>
