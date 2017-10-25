<%@page import="jums.UserDataDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
        
    <h1>削除確認</h1>
        削除しました。<br>
    <%= jh.home() %>
    </body>
</html>
