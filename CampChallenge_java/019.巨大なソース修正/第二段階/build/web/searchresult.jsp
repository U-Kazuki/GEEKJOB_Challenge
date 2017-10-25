<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    // List(インターフェース)ArrayListの亜種。resultDataを取得してList変数uddに格納していく。
    // resultDataは[SearchResult.java]から取得。
    List<UserDataDTO> udd = (ArrayList<UserDataDTO>)hs.getAttribute("resultData");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <tr>
            <% for(UserDataDTO val : udd){ %>
                <!--値渡し【クエストリング】？＝で始めり次の値を次のページへ受け渡す-->
                <td><a href="ResultDetail?id=<%= val.getUserID()%>"><%= val.getName()%></a></td>
                <td><%= val.getBirthday()%></td>
                <!--　JumsHelperにコードが書かれているので、参照先はjhのメソッドexTypenumを使います。[JumsHelper.java]に変換コードがあります。　-->
                <td><%= jh.exTypenum(val.getType()) %></td>
                <td><%= val.getNewDate()%></td>
            </tr>
            <%}%>
        </table>
        <br>
        <%=jh.home()%>
    </body>
</html>
