<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <!--　フォームから送られてきた値は既にセッションへの格納を行っております。なのでgetParameterではありません。-->
        <!--　フォームから送られてきたあらゆる値が空文字と等しくなかった場合、true(登録コード)を実行する。
        逆に、送られてきた値に空文字と等しくなる(未入力)場合があれば、false(エラー文)を実行する。　-->
        
        <!--　年月日とコメントにてerror抜け確認　-->
        <% if(!(udb.getName().equals("")) && udb.getYear() != 0 && udb.getMonth() != 0 && udb.getDay() != 0  
                && !(udb.getType().equals("")) && !(udb.getTell().equals("")) && !(udb.getComment().equals(""))){%> 
                
        <h1>登録確認</h1>
        名前:<%= udb.getName() %><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<% if(udb.getType().equals("1")){%> エンジニア <%}%>
             <% if(udb.getType().equals("2")){%> 営業 <%}%>
             <% if(udb.getType().equals("3")){%> その他 <%}%>
        <br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        
        <form action="insertresult" method="POST">
            <!--　スペアキーの記述文。　-->             
            <input type="hidden" name = "ac" value = "<%= hs.getAttribute("ac")%>" >
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %><h1>入力が不完全です</h1>
        <!--　if文false。送られてきた値に『空文字』又は『0』と等しい値があった場合、
        どのコードが等しかったのかを見つけるif文。　-->
        <%if(udb.getName().equals("")){
            out.print("nameの記述がありません。");
        } else if(udb.getYear() == 0){
            out.print("yearの記述がありません。");
        } else if(udb.getMonth() == 0){
            out.print("monthの記述がありません。");
        } else if(udb.getDay() == 0){
            out.print("dayの記述がありません。");
        } else if(udb.getType().equals("")){
            out.print("typeの記述がありません。");
        } else if(udb.getTell().equals("")){
            out.print("tellの記述がありません。");
        } else if(udb.getComment().equals("")){
            out.print("commentの記述がありません。");
        } else {
            out.print("想定外のエラーが発生しました。もう一度ご確認ください。");
        }
        %>
    <% } %>
        <form action="insert.jsp" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
