<%@page import="jums.UserDataDTO"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>


<%
    HttpSession hs = request.getSession();
    UserDataDTO userdata = (UserDataDTO)hs.getAttribute("userdata");
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <!--　登録し終わった時の画面です。変換したりDTOに格納したり面倒なのでresultからではなくconfirmからudb経由で値を確保しました。　-->
        <h1>登録結果</h1><br>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日" %><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で登録しました。<br>
        <form action = "insert.jsp" method = "post">
            <!--　スペアキー　-->
            <input type = "hidden" name = "ac"  value = "<%= hs.getAttribute("ac")%>">
            <input type = "submit" name = "btnSubmit" value = "登録画面へ">
        </form>
        <br>
        <%= JumsHelper.getInstance().home()%>
        
        <!--　登録が終わった後、トップページ又は入力画面に戻った時にセッションを破棄(白紙化)する　-->
        <% hs.invalidate(); %>
        
    </body>
</html>
