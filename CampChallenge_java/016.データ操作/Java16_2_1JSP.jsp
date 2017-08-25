<%-- 
    Document   : Java16_2_1JSP
    Created on : 2017/08/21, 13:25:21
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
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String total = request.getParameter("total");
        String count = request.getParameter("count");
        String type = request.getParameter("type");
        // Integer.parseIntで文字列→整数に変換します。
        int sougaku = Integer.parseInt(total);
        int kosuu = Integer.parseInt(count);
        int syurui = Integer.parseInt(type);
        
        // 文字変換した際に作成した変数でcase分けを行い、どの商品情報が選ばれたのかを分別します。
        switch(syurui){
        case 1:
            out.print("商品：雑貨を選びました。" + "<br>");
            break;
        case 2:
            out.print("商品：生鮮食品を選びました。" + "<br>");
            break;
        case 3:
            out.print("その他です" + "<br>");
            break;
        }
        
        // 今回の課題で、1個当りの値段を算出しなければいけないので、総額割る個数で表示させます。
        out.print("一個の値段は" + sougaku/kosuu + "です" + "<br>");
        
        // 総額が5000 or 3000以上ならポイントが付くように分岐させます。
        if(5000 <= sougaku){
        // 小数点が邪魔だったのでキャスト変換でdoubleの小数点を切り捨てて、int型に押し込めました。
        double to = sougaku * 0.05;
            out.print("ポイントが" + (int)to + "点つきます");
        } else if(3000 <= sougaku) {
        double to = sougaku * 0.04;
            out.print("ポイントが" + (int)to + "点つきます");
        } else {
            out.print("ポイントは付きません");
        }
        %>
    </body>
</html>
