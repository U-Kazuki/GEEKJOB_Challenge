<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="jums.UserDataDAO"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    // カレンダーセッション("cal")を取得して、変数を作成。
    Calendar cal = (Calendar)hs.getAttribute("cal");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="get">
        名前:
        <input type="text" name="name" value="<% out.print(udd.getName()); %>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>    
            <!--　if文でfor文の値と同じならselectする。その結果をselectedする。-->
            <option value="<%=i%>"<% if(i == cal.get(Calendar.YEAR)) {%><%= "selected" %><% } %>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"<% if(i == cal.get(Calendar.MONTH)+1){ %><%= "selected" %><% } %>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<% if(i == cal.get(Calendar.DAY_OF_MONTH)){ %><%= "selected" %><% } %>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(i == udd.getType()){%>checked="checked"<%}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udd.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment() %></textarea><br><br>
        
        <input type = "hidden" name = "ac" value = "<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <form action = "ResultDetail" method = "get">
            <input type = "hidden" name = "id" value = "<%= udd.getUserID() %>">
            <input type = "submit" value = "詳細画面へ戻る">
        </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
