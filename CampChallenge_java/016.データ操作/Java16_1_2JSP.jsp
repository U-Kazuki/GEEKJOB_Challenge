<%-- 
    Document   : Java16_1_2JSP
    Created on : 2017/08/18, 13:14:41
    Author     : Guestnumber
--%>
<!DOCTYPE html>
<html>
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.setContentType("text/html");
// ブラウザ上で表示するための文字コードを記述します。HTML側とコードを合わせる必要あり？
            request.setCharacterEncoding("UTF-8");
// request.getParameterは設定したパラメーターを取得するための要望を行う処理です。
// また、取得する内容は後ろの（）内（HTML側で設定されているデータを参照）のデータが記述されます。
            out.print("【名前】" + request.getParameter("txtname") + "<br>");
// 性別（ラジオボックス）の場合、HTML側で選んだラジオの内容次第でJSP側の表示が変わります。
// その為、紐付けするgetParameterは一つに纏めます。理由は、HTML側で設定したvalueの内容が出るだけだからです。
            out.print("【性別】" + request.getParameter("human") + "<br>");
            out.print("【趣味】" + request.getParameter("wordarea") + "<br>");
        %>
    </body>
</html>
